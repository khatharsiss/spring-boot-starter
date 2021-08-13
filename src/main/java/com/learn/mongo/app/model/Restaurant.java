package com.learn.mongo.app.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Document
public class Restaurant {

    @Id
    private String id;

    @Size(min = 3)
    @Indexed(unique = true)
    private String name;

    @TextIndexed
    private Address address;

    @Indexed
    private Float averageScore;

    private Float reviewScoreAmabilidad;

    private Float reviewScoreCalidad;

    private Float reviewScorePrecio;

    @Indexed
    private Float averagePrice;

    private Float paymentMethod;

    @TextScore
    private Float textScore;

    @Field("menu")
    @DBRef
    private List<Menu> restaurantMenu;

    @DBRef
    private List<Offer> offers;

    @DBRef
    private List<User> users;

    @DBRef
    private List<Review> reviews;
}