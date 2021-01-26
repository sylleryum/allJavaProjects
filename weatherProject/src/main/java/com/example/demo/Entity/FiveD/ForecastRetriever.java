package com.example.demo.Entity.FiveD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ForecastRetriever {
    private String city;
    private List<String> description;
    private List<List<Double>> tempMinMax;
    private List<Map<Long, Long>> rainsTime;
    private List<Double> rainVolume;
    private List<String> day;
    private List<Double> wind;
    private List<Double> humidity;

    public ForecastRetriever(){
        description = new ArrayList<>();
        tempMinMax = new ArrayList<>();
        rainsTime = new ArrayList<Map<Long, Long>>();
        day = new ArrayList<>();
        wind = new ArrayList<>();
        humidity = new ArrayList<>();
        rainVolume = new ArrayList<>();
    }


    public List<Double> getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(List<Double> rainVolume) {
        this.rainVolume = rainVolume;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<List<Double>> getTempMinMax() {
        return tempMinMax;
    }

    public void setTempMinMax(List<List<Double>> tempMinMax) {
        this.tempMinMax = tempMinMax;
    }

    public List<Map<Long, Long>> getRainsTime() {
        return rainsTime;
    }

    public void setRainsTime(List<Map<Long, Long>> rainsTime) {
        this.rainsTime = rainsTime;
    }

    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }

    public List<Double> getWind() {
        return wind;
    }

    public void setWind(List<Double> wind) {
        this.wind = wind;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "ForecastRetriever{" +
                "city='" + city + '\'' +
                ", description=" + description +
                ", tempMinMax=" + tempMinMax +
                ", rainsTime=" + rainsTime +
                ", rainVolume=" + rainVolume +
                ", day=" + day +
                ", wind=" + wind +
                ", humidity=" + humidity +
                '}';
    }
}
