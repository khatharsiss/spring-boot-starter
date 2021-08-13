package com.learn.mongo.app.controller;

import com.learn.mongo.app.model.Menu;
import com.learn.mongo.app.model.Restaurant;
import com.learn.mongo.app.repository.MenuRepository;
import com.learn.mongo.app.repository.RestaurantRepository;
import com.learn.mongo.app.service.MenuService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/saveMenu")
    @ResponseBody
    public void saveMenu() {
        try {
        menuService.saveMenu();
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

    }

    @GetMapping("/saveMenuQuery")
    @ResponseBody

    public String saveMenuQuery() {
        try {
            Boolean raiseException = true;
            log.info("1");
            Menu menu = new Menu();
            menu.setId(null);
            menu.setName("11111");
            menu.setScore(878);
            //menuRepository.insert(menu);
            log.info("2");
            if(raiseException==true){
                throw new RuntimeException("error getting de db");
            }
            //menuRepository.insert(menu);
            log.info("3");

            return "restaurant saved";
        } catch (Exception e) {
            return ExceptionUtils.getStackTrace(e);
        }

    }
}