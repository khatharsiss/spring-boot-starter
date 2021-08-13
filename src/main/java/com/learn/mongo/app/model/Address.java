package com.learn.mongo.app.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Address {

    @Id
    private String id;

    private String street;

    @Field("zip_code")
    private String zipCode;

    private String city;

    private String country;

    //getter and setter omitted
}