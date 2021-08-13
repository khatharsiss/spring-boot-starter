package com.learn.mongo.app.service;

import com.learn.mongo.app.model.Menu;
import com.learn.mongo.app.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public void saveMenu() {
        Boolean raiseException = true;
        log.info("1");
        Menu menu = new Menu();
        Menu menu2 = new Menu();
        menu.setId(null);
        menu.setName("11111");
        menu.setScore(878);
        menuRepository.insert(menu);
        log.info("2");
//        if (raiseException == true) {
//            throw new RuntimeException("error getting de db");
//        }
        menu2.setName("holaaaaa");
        menuRepository.insert(menu2);
        log.info("3");
    }

}
