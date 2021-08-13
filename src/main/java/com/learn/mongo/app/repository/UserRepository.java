package com.learn.mongo.app.repository;

import com.learn.mongo.app.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, String> {

    Page<User> findAllByUsername(@Param("username") String username, Pageable page);
}