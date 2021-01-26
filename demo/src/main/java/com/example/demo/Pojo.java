package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pojo {
    private String name;
    private int age = 1;
    @Autowired
    @Qualifier("test")
    private InsertInPojo iip;

    public Pojo() {
        System.out.println("running: "+age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("pojo");
        iip.message();
    }
}
