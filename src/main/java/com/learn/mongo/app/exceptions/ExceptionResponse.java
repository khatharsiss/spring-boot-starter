package com.learn.mongo.app.exceptions;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;



public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details){
        super();
        this.details = details;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Date getTimestamp(){return timestamp;}
    public String getDetails(){return details;}
    public String getMessage(){return message;}
}
