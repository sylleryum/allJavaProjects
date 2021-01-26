package com.example.demo;

import com.example.demo.Entity.FiveD.FiveDaysWeather;
import com.example.demo.Entity.FiveD.ForecastRetriever;
import com.example.demo.Helper.FiveDaysForecastCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Test
    public void contextLoads() {

        //&lang=pt&units=metric&appid=72eb2|eb054f14d2c526edad0ac213d7d
        //wind.speed
        //main.temp
        //main.humity (%)
        //main.description

        //sys.sunrise + 000 (em utc time)
        //sys.sunset + 000 (em utc time)

        //1 dia = 86400000

//        5 m/h fraco
//        5-25 m/h = moderada
//        25-50 m/h = forte
//        50 m/h = muito forte
        ////////
//        RestTemplate restTemplate = new RestTemplate();
//        System.out.println("==========");
//        ResponseEntity<FiveDaysWeather> response = restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/forecast?id=3023519&lang=pt&units=metric&appid=72eb2eb054f14d2c526edad0ac213d7d",
//                FiveDaysWeather.class);
//
//        FiveDaysWeather fiveDaysWeather = response.getBody();
//
//        ForecastRetriever forecastRetriever = FiveDaysForecastCalculator.getAll(fiveDaysWeather);




    }



}
