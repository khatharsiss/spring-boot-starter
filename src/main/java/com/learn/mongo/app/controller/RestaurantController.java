package com.learn.mongo.app.controller;

import com.learn.mongo.app.exceptions.RestaurantNotFoundException;
import com.learn.mongo.app.model.Menu;
import com.learn.mongo.app.model.Restaurant;
import com.learn.mongo.app.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private RestaurantService restaurantService;

    @PreAuthorize("hasRole('ROLE_devGroup')")
    @GetMapping("/getRestaurants")
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        try {
            return restaurantService.getRestaurants();
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
            return new ArrayList<>();
        }
    }


    @PreAuthorize("hasRole('ROLE_devGroup')")
    @PostMapping("/saveRestaurants")
    public ResponseEntity<Object> saveRestaurants(@Valid @RequestBody Restaurant rest) {

            Restaurant savedRestaurant = restaurantService.saveRestaurant(rest);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedRestaurant.getId())
                    .toUri();
            return ResponseEntity.created(location).build();


    }
    @PreAuthorize("hasRole('ROLE_devGroup')")
    @GetMapping("/getRestaurant/name/{name}")
    @ResponseBody
    public Restaurant getRestaurant(@PathVariable String name) {
        Restaurant restaurant = restaurantService.getRestaurant(name);
        log.info(String.valueOf(restaurant));
        if (restaurant==null){
            throw new RestaurantNotFoundException("Restaurant not found. Name: " + name);
        }
        else {
            return restaurant;
        }
    }
    @PreAuthorize("hasRole('ROLE_devGroup')")
    @GetMapping("/saveRestaurant")
    @ResponseBody
    public void saveRestauranthhhhh() {
        try {
            Restaurant testRest = new Restaurant();
            List<Menu> testMenuList = new ArrayList<>();
            Menu testMenu = new Menu();
            testMenu.setName("menu13");
            testMenu.setId("fgdfgdfgdfgd");
            testMenuList.add(testMenu);


            testRest.setName("testeo12");
            testRest.setRestaurantMenu(testMenuList);
            restaurantService.saveRestaurant(testRest);

        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

    }
}
