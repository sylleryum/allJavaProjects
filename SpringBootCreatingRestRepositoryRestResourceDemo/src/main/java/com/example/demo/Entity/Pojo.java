package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "thepojo")
public class Pojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="pojoname")
    private String name;
    @Column(name="theage")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
