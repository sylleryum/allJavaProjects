package com.example.demo.Helper;

import com.example.demo.Entity.FiveD.FiveDaysWeather;
import com.example.demo.Entity.FiveD.ForecastRetriever;
import com.example.demo.Entity.FiveD.List;
import com.example.demo.Entity.Now.Rain;

import java.util.*;


public class FiveDaysForecastCalculator {

//    /**
//     * Gets five days of minimum and maximum temperature for each day
//     @param fiveDaysWeather
//     @return a Map, first element is an int with the day of the month, second a map win Min and Max
//     */
//    public static java.util.List<Map<Integer, Map<Double,Double>>> getMinMax (FiveDaysWeather fiveDaysWeather){
//        int i = 0;
//        double tempMin0 = 9999;
//        double tempMax0 = 0;
//        double tempMin1 = 9999;
//        double tempMax1 = 0;
//        double tempMin2 = 9999;
//        double tempMax2 = 0;
//        double tempMin3 = 9999;
//        double tempMax3 = 0;
//        double tempMin4 = 9999;
//        double tempMax4 = 0;
//        double tempMin5 = 9999;
//        double tempMax5 = 0;
//        int da0 = 999;
//        int da1 = 999;
//        int da2 = 999;
//        int da3 = 999;
//        int da4 = 999;
//        int da5 = 999;
//        int d0 = 0;
//        int d5 = 0;
//
//        for (List list:fiveDaysWeather.getList()) {
//
//            if (Converter.getDay(list.getDt())==(Converter.getDay(fiveDaysWeather.getList().get(0).getDt()))){
//                //dia 0
//                d0+=1;
//                da0 = Converter.getDay(list.getDt());
//                if (tempMin0>list.getMain().getTempMin()){
//                    tempMin0=list.getMain().getTempMin();
//                }
//                if (tempMax0<list.getMain().getTempMax()){
//                    tempMax0=list.getMain().getTempMax();
//                }
////                System.out.println("dia 0 "+list.getMain().getTemp());
////                System.out.println("dia 0 "+list.getWind().getSpeed());
////                System.out.println(d0 +" dia 0 "+list.getDtTxt());
//
//            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+86400000))){
//                //dia 1
//                da1 = Converter.getDay(list.getDt());
//                if (tempMin1>list.getMain().getTempMin()){
//                    tempMin1=list.getMain().getTempMin();
//                }
//                if (tempMax1<list.getMain().getTempMax()){
//                    tempMax1=list.getMain().getTempMax();
//                }
////                System.out.println("dia 1 "+list.getMain().getTemp());
////                System.out.println("dia 1 "+list.getWind().getSpeed());
////                System.out.println("dia 1 "+list.getDtTxt());
//            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+172800000))){
//                //dia 2
//                da2 = Converter.getDay(list.getDt());
//                if (tempMin2>list.getMain().getTempMin()){
//                    tempMin2=list.getMain().getTempMin();
//                }
//                if (tempMax2<list.getMain().getTempMax()){
//                    tempMax2=list.getMain().getTempMax();
//                }
////                System.out.println("dia 2 "+list.getMain().getTemp());
////                System.out.println("dia 2 "+list.getWind().getSpeed());
////                System.out.println("dia 2 "+list.getDtTxt());
//            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+259200000))){
//                //dia 3
//                da3 = Converter.getDay(list.getDt());
//                if (tempMin3>list.getMain().getTempMin()){
//                    tempMin3=list.getMain().getTempMin();
//                }
//                if (tempMax3<list.getMain().getTempMax()){
//                    tempMax3=list.getMain().getTempMax();
//                }
////                System.out.println("dia 3 "+list.getMain().getTemp());
////                System.out.println("dia 3 "+list.getWind().getSpeed());
////                System.out.println("dia 3 "+list.getDtTxt());
//            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+345600000))){
//                //dia 4
//                da4 = Converter.getDay(list.getDt());
//                if (tempMin4>list.getMain().getTempMin()){
//                    tempMin4=list.getMain().getTempMin();
//                }
//                if (tempMax4<list.getMain().getTempMax()){
//                    tempMax4=list.getMain().getTempMax();
//                }
////                System.out.println("dia 4 "+list.getMain().getTemp());
////                System.out.println("dia 4 "+list.getWind().getSpeed());
////                System.out.println("dia 4 "+list.getDtTxt());
//            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+432000000))){
//                //dia 5
//                d5+=1;
//                da5 = Converter.getDay(list.getDt());
//                if (tempMin5>list.getMain().getTempMin()){
//                    tempMin5=list.getMain().getTempMin();
//                }
//                if (tempMax5<list.getMain().getTempMax()){
//                    tempMax5=list.getMain().getTempMax();
//                }
////                System.out.println("dia 5 "+list.getMain().getTemp());
////                System.out.println("dia 5 "+list.getWind().getSpeed());
////                System.out.println(d5 +" dia 5 "+list.getDtTxt());
//            }
//        }
//
//        System.out.println(da0 +" min "+tempMin0);
//        System.out.println(da0 +" max "+tempMax0);
//        System.out.println(da1 +" min "+tempMin1);
//        System.out.println(da1 +" max "+tempMax1);
//        System.out.println(da2 +" min "+tempMin2);
//        System.out.println(da2 +" max "+tempMax2);
//        System.out.println(da3 +" min "+tempMin3);
//        System.out.println(da3 +" max "+tempMax3);
//        System.out.println(da4 +" min "+tempMin4);
//        System.out.println(da4 +" max "+tempMax4);
//        System.out.println(da5 +" min "+tempMin5);
//        System.out.println(da5 +" max "+tempMax5);
//
//
//        java.util.List<Map<Integer, Map<Double,Double>>> listReturn = new LinkedList<>();
//
//        Map<Integer,Map<Double,Double>> outer0 = new HashMap<>();
//        Map<Double, Double> minMax0 = new HashMap<>();
//        minMax0.put(tempMin0, tempMax0);
//        outer0.put(da0, minMax0);
//        listReturn.add(outer0);
//
//        Map<Integer,Map<Double,Double>> outer1 = new HashMap<>();
//        Map<Double, Double> minMax1 = new HashMap<>();
//        minMax1.put(tempMin1, tempMax1);
//        outer1.put(da1, minMax1);
//        listReturn.add(outer1);
//
//        Map<Integer,Map<Double,Double>> outer2 = new HashMap<>();
//        Map<Double, Double> minMax2 = new HashMap<>();
//        minMax2.put(tempMin2, tempMax2);
//        outer2.put(da2, minMax2);
//        listReturn.add(outer2);
//
//        Map<Integer,Map<Double,Double>> outer3 = new HashMap<>();
//        Map<Double, Double> minMax3 = new HashMap<>();
//        minMax3.put(tempMin3, tempMax3);
//        outer3.put(da3, minMax3);
//        listReturn.add(outer3);
//
//        Map<Integer,Map<Double,Double>> outer4 = new HashMap<>();
//        Map<Double, Double> minMax4 = new HashMap<>();
//        minMax4.put(tempMin4, tempMax4);
//        outer4.put(da4, minMax4);
//        listReturn.add(outer4);
//
//        Map<Integer,Map<Double,Double>> outer5 = new HashMap<>();
//        Map<Double, Double> minMax5 = new HashMap<>();
//        minMax5.put(tempMin5, tempMax5);
//        outer5.put(da5, minMax5);
//        listReturn.add(outer5);
//
//        return listReturn;
//    }

    private static boolean hVerao;

    private static int d0 = 0;
    private static int d5 = 0;
    private static double theWind = 0;
    private static double theHumidity = 0 ;
    private static double rainVolume=0;
    private static long inicioChuva0=0;
    private static long lastChuva0=0;
    private static LinkedHashMap<Long,Long> mapChuvas0 = new LinkedHashMap<>();

    private static long theLastHour;
    private static boolean isLast=false;

    /**
     * Clear the static variables
     */
    private static void clearDayVar(){
        d0 = 0;
        d5 = 0;
        theWind = 0;
        theHumidity = 0 ;
        rainVolume=0;
        inicioChuva0=0;
        lastChuva0=0;
        mapChuvas0 = new LinkedHashMap<>();
    }

    /**
     @return ForecastRetriever
     */
    @SuppressWarnings("Duplicates")
    public static ForecastRetriever getAll (FiveDaysWeather fiveDaysWeather){
        theLastHour = fiveDaysWeather.getList().get(fiveDaysWeather.getList().size()-1).getDt();
        //System.out.println("start "+theLastHour);
        clearDayVar();

        //checa se é horario de verão
        //System.out.println("=== "+(fiveDaysWeather.getList().size()-1));
        checkDaylightTime(fiveDaysWeather);


        ForecastRetriever forecastRetriever = new ForecastRetriever();
        for (List list:fiveDaysWeather.getList()) {
            //System.out.println("day "+Converter.getDay(list.getDt()));
            if (Converter.getDay(list.getDt())==(Converter.getDay(fiveDaysWeather.getList().get(0).getDt()))){
                //TODO dia 0
                d0+=1;

                ////add dia
                forecastRetriever = addDay(forecastRetriever, 1, list.getDt());

                ////add tempMin tempMax
                System.out.println("okkkkkkkk"+fiveDaysWeather);
                forecastRetriever = addTempMinMax(forecastRetriever, 0, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());

                ////last run
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),21, d0, forecastRetriever);
                //System.out.println("fim dia 0");
            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+86400000))){
                //TODO dia 1

                ////add dia
                forecastRetriever = addDay(forecastRetriever, 2, list.getDt());

                ////add tempMin tempMax
                forecastRetriever = addTempMinMax(forecastRetriever, 1, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());


                ////last run
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),21,8, forecastRetriever);
                //System.out.println("fim dia 1");
            }
            else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+172800000))){
                //TODO dia 2
                ////add dia
                forecastRetriever = addDay(forecastRetriever, 3, list.getDt());

                ////add tempMin tempMax
                forecastRetriever = addTempMinMax(forecastRetriever, 2, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());

                ////last run
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),21,8, forecastRetriever);
                //System.out.println("fim dia 2");
            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+259200000))){
                //TODO dia 3

                ////add dia
                forecastRetriever = addDay(forecastRetriever, 4, list.getDt());

                ////add tempMin tempMax
                forecastRetriever = addTempMinMax(forecastRetriever, 3, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());

                ////last run
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),21,8, forecastRetriever);
                //System.out.println("fim dia 3 "+Converter.getHour(list.getDt())+" "+list.getDt());
            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+345600000))){
                //TODO dia 4

                ////add dia
                forecastRetriever = addDay(forecastRetriever, 5, list.getDt());

                ////add tempMin tempMax
                forecastRetriever = addTempMinMax(forecastRetriever, 4, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());

                ////last run
                if (list.getDt()==fiveDaysWeather.getList().get(fiveDaysWeather.getList().size()-1).getDt()){
                    isLast=true;
                }
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),21,8, forecastRetriever);
                //System.out.println("fim dia 4 ");
            } else if (Converter.getDay(list.getDt())==(Converter.getDay((fiveDaysWeather.getList().get(0).getDt())+432000000))){
                //TODO dia 5
                d5+=1;

                ////add dia
                forecastRetriever = addDay(forecastRetriever, 6, list.getDt());

                ////add tempMin tempMax
                forecastRetriever = addTempMinMax(forecastRetriever, 5, list.getMain().getTempMin(), list.getMain().getTempMax());

                ////add wind
                theWind += list.getWind().getSpeed();

                ////add humidity
                theHumidity += list.getMain().getHumidity();

                ////add rain times
                checkRain(list.getRain(), list.getDt());

                ////last run
                forecastRetriever = lastRun(Converter.getHour(list.getDt()),Converter.getHour(fiveDaysWeather.getList().get(fiveDaysWeather.getList().size()-1).getDt()),d5, forecastRetriever);
                //System.out.println("fim dia 5");
            }
        }

        forecastRetriever.setCity(fiveDaysWeather.getCity().getName());
        //System.out.println(" é finito ");
        /////resultado
        //System.out.println(forecastRetriever);

        //TODO add ultima hora WHAT A FUNKING GAMBIARRA
        forecastRetriever.getDay().set(forecastRetriever.getDay().size()-1, forecastRetriever.getDay().get(forecastRetriever.getDay().size()-1)+" (Até "+Converter.getHour(theLastHour)+"h) ");
        return forecastRetriever;
    }

    /**
     * Check for daylight time, if applicable, set hVerao to true
     * @param fiveDaysWeather
     */
    private static void checkDaylightTime(FiveDaysWeather fiveDaysWeather) {
        for (int j=(fiveDaysWeather.getList().size()-1); j >= 0; j--){
            //System.out.println("-- dt: "+fiveDaysWeather.getList().get(j).getDt());
            if (Converter.getDay(fiveDaysWeather.getList().get(j).getDt()) != Converter.getDay(fiveDaysWeather.getList().get(fiveDaysWeather.getList().size()-1).getDt())){
                if (Converter.getHour(fiveDaysWeather.getList().get(j).getDt())==22){
                 hVerao = true;
                }
                break;
            }
            //System.out.println("999 "+Converter.getDay(fiveDaysWeather.getList().get(j).getDt()));
        }
    }

    /**
     * Add day and creates the getTempMinMax to the forecastRetriever passed
     * @param forecastRetriever
     * @param daySize day+1 (day 0 = daySize 1)
     * @param day what is the day to be inserted in the forecastRetriever
     * @return forecastRetriever with day and TempMinMax created
     */
    private static ForecastRetriever addDay(ForecastRetriever forecastRetriever, int daySize, long day){
        if(forecastRetriever.getDay().size()<daySize){
            forecastRetriever.getDay().add(Converter.getDayMw(day));
            //System.out.println("////day of month: "+Converter.getDay(day)+ " day of week "+Converter.getDayMw(day));
            forecastRetriever.getTempMinMax().add(new ArrayList<Double>(){{add(999D);add(0D);}});
        }

        return forecastRetriever;
    }

    /**
     * Add tempMin and tempMax to the forecastRetriever passed
     * @param forecastRetriever
     * @param day from 0 to 5
     * @param tempMin temperature from the list.getMain().getTempMin()
     * @param tempMax temperature from the list.getMain().getTempMax()
     * @return forecastRetriever with the tempMin and tempMax
     */
    private static ForecastRetriever addTempMinMax(ForecastRetriever forecastRetriever, int day, double tempMin, double tempMax){
        if (forecastRetriever.getTempMinMax().get(day).get(0)>tempMin){
            forecastRetriever.getTempMinMax().get(day).set(0, tempMin);

        }
        if (forecastRetriever.getTempMinMax().get(day).get(1)<tempMax){
            forecastRetriever.getTempMinMax().get(day).set(1, tempMax);
        }

        return forecastRetriever;
    }

    /**
     * Add rainVolume and check RainsTime
     * @param rainClass list.getRain()
     * @param dayLong list.getDt()
     */
    private static void checkRain(Rain rainClass, long dayLong){
        if (rainClass!=null && rainClass.get3h()!=null){
            ////add rain volume
            rainVolume+=rainClass.get3h();

            //primeira chuva
            if(lastChuva0==0){
                inicioChuva0=(dayLong);
                //fimChuva0=(list.getDt());
                lastChuva0=(dayLong);

                //chuva continua na 3h seguinte
            } else if ((dayLong-lastChuva0)==10800000) {
                //fimChuva0 = (list.getDt());
                lastChuva0 = (dayLong);

                //se chove mais de uma vez no dia sem ser em sequencia
            } else if ((dayLong-lastChuva0)>10800000){
                mapChuvas0.put(inicioChuva0, lastChuva0);
                inicioChuva0=dayLong;
                lastChuva0=dayLong;
                //fimChuva0=0;
            }
        }
    }

    /**
     * add to forecastRetriever rainsTime, wind, humidity, rainVolume and clear the static variables
     * @param currentHour
     * @param lastHour
     * @param amountHours
     * @param forecastRetriever
     * @return
     */
    private static ForecastRetriever lastRun (int currentHour, int lastHour, int amountHours, ForecastRetriever forecastRetriever){
        //System.out.println("dias "+forecastRetriever.getDay());

        //Converter.getHour(fiveDaysWeather.getList().get(fiveDaysWeather.getList().size()-1)

        //horario de verao?
        //System.out.println("lastRun "+hVerao);
        if (hVerao==true && lastHour == 21){
            lastHour = 22;
        }
//        if (lastHour==21){
//            lastHour = 22;
//        }
        if(currentHour==lastHour){
            if (inicioChuva0!=0){
                mapChuvas0.put(inicioChuva0, lastChuva0);
            }
            forecastRetriever.getRainsTime().add(mapChuvas0);
            forecastRetriever.getWind().add((theWind/amountHours));
            forecastRetriever.getHumidity().add(theHumidity/amountHours);
            forecastRetriever.getRainVolume().add(rainVolume);
            clearDayVar();
        } else if(isLast==true){
            isLast=false;
            if (inicioChuva0!=0){
                mapChuvas0.put(inicioChuva0, lastChuva0);
            }
            forecastRetriever.getRainsTime().add(mapChuvas0);
            forecastRetriever.getWind().add((theWind/7));
            forecastRetriever.getHumidity().add(theHumidity/7);
            forecastRetriever.getRainVolume().add(rainVolume);
            clearDayVar();
        }
        return forecastRetriever;
    }

}
