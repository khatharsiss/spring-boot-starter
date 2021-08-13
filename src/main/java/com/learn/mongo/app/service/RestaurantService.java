package com.learn.mongo.app.service;

import com.learn.mongo.app.model.Restaurant;
import com.learn.mongo.app.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }
    public Restaurant getRestaurant(String name) {
        Restaurant restaurant = restaurantRepository.findRestaurantByName(name);
        return restaurant;
    }

    public Restaurant saveRestaurant(Restaurant rest) {
        restaurantRepository.save(rest);
        return rest;
    }
    // seguridad global mas auth azure test
    // probar un service con el query de mongo
    // probar a hacerlo con lambdas. if present o else...
    // control de las excepciones
    // probar restrauntas funciona bien
    // spring boot tests
    // Generar el resto de modelo
    // Indexes del modelo

    // Probar webflux??

    // ver rendimiento
}
