<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home</title>

    <style>
        .thetable {
            border: 1px solid black;
            width: 90%;
            margin: auto;
            height: 600px;
            text-align: center;
        }

        .now {
            width: 40%;
        }
    </style>
</head>

<body>


<table border="1" class="thetable">
    <tbody>
    <tr>
        <td rowspan="7" class="now">
            <table width="100%">
                <tr>
                    <td align="center" colspan="2" style="font-size: 28px;font-family: Arial">
                        <div style="font-weight: bold"> ${currentWeather.getName()}<br></div>
                        ${currentWeather.getMain().getTemp()}&nbspºC <br>
                        <img src="${currentWeather.getWeather().get(0).getIcon()}"><br>
                        ${currentWeather.getWeather().get(0).getDescription()} <br>
                    </td>
                </tr>
                <tr>
                    <td>Wind:</td>
                    <td>${currentWeather.getWind().getSpeed()}m/s</td>
                </tr>
                <tr>
                    <td>Humidity:</td>
                    <td>${currentWeather.getMain().getHumidity()}%</td>
                </tr>
                <tr>
                    <td>Sunrise:</td>
                    <td>${sunrise}</td>
                </tr>
                <tr>
                    <td>Sunset:</td>
                    <td>${sunset}</td>
                </tr>
            </table>
        </td>
    </tr>
    <c:forEach var="entries" items="${lSB}">
        <tr>
            <td>
               ${entries}
            </td>
        </tr>
    </c:forEach>


    </tbody>
</table>

</body>
</html>