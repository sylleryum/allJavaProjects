package com.example.demo.service;

import com.example.demo.Entity.FiveD.FiveDaysWeather;
import com.example.demo.Entity.Now.CurrentWeather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String LANG = "&lang=pt";
    private static final String METRIC_UNIT = "&units=metric";
    private static final String API_KEY = "&appid=72eb2eb054f14d2c526edad0ac213d7d";
//    5 m/h fraco /3h = 15
//    5-25 m/h = moderada /3h = 15 - 75
//    25-50 m/h = forte /3h = 75 - 150
//    50 m/h = muito forte /3h = 150+

    /**
     get current weather for given location defined by ID
     @param locationId = ID from given location
     @return CurrentWeather from the passed param
     */
    public CurrentWeather getCurrentWeather(long locationId){
        /////LOCATION SETADO MANUALMENTE
        //locationId = 3467791;
        //cb 3467791
        System.out.println("locaiton id "+locationId);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?id="+locationId+METRIC_UNIT+LANG+API_KEY, CurrentWeather.class);
        System.out.println("city got "+response.getBody().getName());
        return response.getBody();
    }

    /**
     get 5 days forecast for given location defined by ID
     @param locationId = ID from given location
     @return CurrentWeather from the passed param
     */
    public FiveDaysWeather GetFiveDaysForecast(long locationId){
        /////LOCATION SETADO MANUALMENTE
        //locationId = 3467791;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FiveDaysWeather> response = restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/forecast?id="+locationId+METRIC_UNIT+LANG+API_KEY, FiveDaysWeather.class);
        return response.getBody();
    }

}