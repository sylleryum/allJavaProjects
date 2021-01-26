package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Helper.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        //&lang=pt&units=metric&appid=72eb2eb054f14d2c526edad0ac213d7d
        //wind.speed
        //main.temp
        //main.humity (%)
        //main.description

        //sys.sunrise + 000 (em utc time)
        //sys.sunset + 000 (em utc time)



        RestTemplate restTemplate = new RestTemplate();
        System.out.println("==========");
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?id=2346401&lang=pt&units=metric&appid=72eb2eb054f14d2c526edad0ac213d7d",
                CurrentWeather.class);

        System.out.println("convertido "+response.getBody());
//        try {
//            ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            Weather[] weathers = mapper.readValue(response.getBody(), Weather[].class);
//            System.out.println("=== "+weathers);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("deu ruim");
//        }




    }

}
