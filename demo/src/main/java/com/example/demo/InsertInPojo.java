package com.example.demo;

import org.springframework.stereotype.Component;

@Component("test")
public class InsertInPojo {
    private String theString;

    public void message(){
        System.out.println("InsertInPojo");
    }
}
