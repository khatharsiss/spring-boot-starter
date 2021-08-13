package com.learn.mongo.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Data
@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @TextIndexed
    private String firstname;

    @TextIndexed
    private String lastname;

    @TextScore
    private Float textScore;

    private Address homeAddress;

    //getter and setter omitted
}