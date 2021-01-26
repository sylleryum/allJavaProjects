package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(DemoApplication.class, args);

        Pojo pojo = cac.getBean(Pojo.class);
        pojo.show();

    }

}
