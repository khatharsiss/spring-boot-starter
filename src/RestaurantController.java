package com.learn.mongo.app.controller;

import com.learn.mongo.app.model.Menu;
import com.learn.mongo.app.model.Restaurant;
import com.learn.mongo.app.repository.MenuRepository;
import com.learn.mongo.app.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class RestaurantMongoTemplate {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // use page because i do not want all at the same time
    @GetMapping("/getRestaurants")
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        List<Restaurant> results = restaurantRepository.findAll();
        return results;
    }

    // find restaurant by name
    @GetMapping("/getRestaurant")
    @ResponseBody
    public List<Restaurant> getRestaurant(@RequestParam(name = "name") String name) {

        List<Restaurant> results = restaurantRepository.findRestaurantByName(name);
        return results;
    }

}