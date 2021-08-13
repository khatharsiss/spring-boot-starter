package com.learn.mongo.app.repository;

import com.learn.mongo.app.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, String> {
  //  Page<Restaurant> findAllByName(@Param("name") String name, Pageable page);}

public interface RestaurantRepository extends MongoRepository<Restaurant,String>{
    Restaurant findRestaurantByName(String name);
}