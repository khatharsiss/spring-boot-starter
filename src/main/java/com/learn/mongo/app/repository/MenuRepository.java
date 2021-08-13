package com.learn.mongo.app.repository;

import com.learn.mongo.app.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuRepository extends MongoRepository<Menu,String>{
    //List<Menu> findMenuByName(String name);

}