package com.example.event_management_system.Client;

import com.example.event_management_system.DTOs.Distance;
import com.example.event_management_system.DTOs.RequestEvent;
import com.example.event_management_system.DTOs.ResponseEvent;
import com.example.event_management_system.DTOs.Weather;
import com.example.event_management_system.Entities.Event;
import com.example.event_management_system.Helper.DateHelper;
import org.springframework.web.client.RestTemplate;


public class RestClient {
    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ResponseEvent processEvent(Event event, RequestEvent requestEvent, ResponseEvent responseEvent) {

        synchronized (event) {
            Thread weatherThread = new Thread(() -> {
                String weatherUrl = "https://gg-backend-assignment.azurewebsites.net/api/Weather?code=KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==&city=Port%20"+event.getCity_name()+"&date="+DateHelper.DateToString(responseEvent.getDate());
                Weather weather = restTemplate.getForEntity(weatherUrl, Weather.class).getBody();
                if (weather == null) {
                    responseEvent.setWeather("No weather data available");
                } else {
                    responseEvent.setWeather(weather.getWeather());
                }

            });
            Thread distanceThread = new Thread(() -> {
                String distanceUrl = "https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==&latitude1="+requestEvent.getLatitude()+"&longitude1="+requestEvent.getLongitude()+"&latitude2="+event.getLatitude()+"&longitude2="+event.getLongitude();
                Distance distance = restTemplate.getForEntity(distanceUrl, Distance.class).getBody();
                if (distance == null) {
                    responseEvent.setDistance_km("No distance data available");
                } else {
                    responseEvent.setDistance_km(distance.getDistance_km());
                }
            });
            weatherThread.start();
            distanceThread.start();
            try {
                weatherThread.join();
                distanceThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return responseEvent;
    }
}