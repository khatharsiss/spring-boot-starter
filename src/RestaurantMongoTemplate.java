package com.learn.mongo.app.controller;

import com.learn.mongo.app.model.Menu;
import com.learn.mongo.app.model.Restaurant;
import com.learn.mongo.app.repository.MenuRepository;
import com.learn.mongo.app.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;
    //private MenuRepository menuRepository;
    //private MongoTemplate mongoTemplate;

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

        //Query query = new Query();
        //query.addCriteria(Criteria.where("name").is("Balamo"));

        //mongoTemplate.find(query,Restaurant.class);
        List<Restaurant> results = restaurantRepository.findRestaurantByName(name);
        return results;
    }

    // find restaurant by name
    @PostMapping("/saveRestaurant")
    @ResponseBody
    @Transactional
    public String saveRestaurant(@RequestBody Restaurant rest) {

        restaurantRepository.save(rest);
        menuRepository.save(rest.getRestaurantMenu());
        return "restaurant saved";
    }
    // find restaurant by name
    //@Transactional
    @GetMapping("/saveRestaurantGet")
    @ResponseBody
    public String saveRestaurantGet() {
        try {
            log.info("1");
            menuRepository.insert(new Menu("5454", "hi", 17));
            log.info("2");
            //throw new RuntimeException("error getting de db")
            menuRepository.insert(new Menu("54fdfd54", "hgggggi", 157));
            log.info("3");

            return "restaurant saved";
        } catch (Exception e) {
            return ExceptionUtils.getStackTrace(e);
        }

    }
}