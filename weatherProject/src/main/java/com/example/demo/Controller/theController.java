package com.example.demo.Controller;

import com.example.demo.Entity.FiveD.FiveDaysWeather;
import com.example.demo.Entity.FiveD.ForecastRetriever;
import com.example.demo.Entity.Now.CurrentWeather;
import com.example.demo.Helper.Converter;
import com.example.demo.Helper.FiveDaysForecastCalculator;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class theController {

    @Autowired
    WeatherService weatherService;

    //&lang=pt&units=metric&appid=72eb2eb054f14d2c526edad0ac213d7d
    //line 1 main.temp
    //line 1 main.description

    //line 2, row 1 wind.speed
    //main.humity (%)
    //sys.sunrise + 000 (em utc time)
    //sys.sunset + 000 (em utc time)
    @RequestMapping(value = {"/{cityId}", ""})
    public String home(Model model, @PathVariable(required = false) Optional<Integer> cityId){

//        if(cityId.isPresent()){
//            int test = cityId.get();
//            System.out.println("test "+test);
//        }
        //initialize
        CurrentWeather currentWeather;
        FiveDaysWeather fiveDaysWeather;
        if (cityId.isPresent()){
            currentWeather = weatherService.getCurrentWeather(cityId.get());
            fiveDaysWeather = weatherService.GetFiveDaysForecast(cityId.get());
        } else{
            currentWeather = weatherService.getCurrentWeather(3467791);
            fiveDaysWeather = weatherService.GetFiveDaysForecast(3467791);
        }

        //current
        long sunset = currentWeather.getSys().getSunset();
        long sunrise = currentWeather.getSys().getSunrise();
        Converter.convertMiliToDate((long)sunrise);
        model.addAttribute(currentWeather);
        model.addAttribute("sunrise",Converter.convertMiliToHour((long)currentWeather.getSys().getSunrise()));
        model.addAttribute("sunset",Converter.convertMiliToHour((long)currentWeather.getSys().getSunset()));

        //5 days
        ForecastRetriever forecastRetriever = FiveDaysForecastCalculator.getAll(fiveDaysWeather);

        StringBuilder stringBuilder = new StringBuilder();
        List<StringBuilder> lSB = new ArrayList<>();
        //System.out.println("== "+forecastRetriever.getRainsTime());
        //System.out.println("****** "+forecastRetriever);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for(int i=0;i<forecastRetriever.getDay().size();i++){
            boolean dayComma = false;
            stringBuilder.append("Day: "+forecastRetriever.getDay().get(i));
            stringBuilder.append("<br>");
            stringBuilder.append("Temp Min: "+ forecastRetriever.getTempMinMax().get(i).get(0)+" ºC - Temp Max: "+forecastRetriever.getTempMinMax().get(i).get(1)+" ºC");
            stringBuilder.append("<br>");
            if ((forecastRetriever.getRainsTime().size()-1 >= i) && !forecastRetriever.getRainsTime().get(i).isEmpty()){
                stringBuilder.append("Rain volume: "+decimalFormat.format(forecastRetriever.getRainVolume().get(i))+"mm");
                stringBuilder.append("<br>");
                stringBuilder.append("Rains during the day: ");
                for (Map.Entry<Long, Long> entries : forecastRetriever.getRainsTime().get(i).entrySet()) {
                    if (entries.getKey()==entries.getValue()){
                        //TODO fazer converter de mes e hora
                        stringBuilder.append(Converter.getHour(entries.getKey())+"; ");
                    }else {
                        if (dayComma==true){
                            stringBuilder.append("; ");
                        }
                        stringBuilder.append(+Converter.getHour(entries.getKey())+"h - "+Converter.getHour(entries.getValue())+"h");
                        dayComma = true;
                    }
                }
                stringBuilder.append("<br>");
            }
            if(forecastRetriever.getWind().size()-1 >=i){
                stringBuilder.append("Average wind speed: "+decimalFormat.format(forecastRetriever.getWind().get(i))+"m/s");
                stringBuilder.append("<br>");
                stringBuilder.append("Average humidity: "+decimalFormat.format(forecastRetriever.getHumidity().get(i))+"%");
            }
            lSB.add(stringBuilder);
            stringBuilder=new StringBuilder();
        }

        System.out.println("===");
        System.out.println(lSB.get(4));
        System.out.println("===");
        System.out.println(forecastRetriever);
        List<String> test = new ArrayList<>();
        test.add("0");
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        model.addAttribute("lSB", lSB);

        return "home";
    }
}
