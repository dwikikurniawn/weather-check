package com.dwiki.weathercheck.client;

import com.dwiki.weathercheck.entity.WeatherData;
import com.dwiki.weathercheck.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * This class for get Weather Data from 3rd party weather API
 *
 * @author Dwiki Kurniawan
 */
@Repository
@AllArgsConstructor
public class WeatherClientImpl {
    private final ApplicationProperties applicationProperties;

    /**
     * @param city city name around the world that you want to check its weather e.g. Sydney, Jakarta, New York, etc.
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    public WeatherData checkByCity(String city) {
        String uri = applicationProperties.getWeatherUri() + "?q=" + city + "&appid=" + applicationProperties.getWeatherAppId();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, WeatherData.class);
    }

    /**
     * @param lon longitude value
     * @param lat latitude value
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    public WeatherData checkByLongitudeLatitude(double lon, double lat) {
        String uri = applicationProperties.getWeatherUri() + "?lat=" + lat + "&lon=" + lon + "&appid=" + applicationProperties.getWeatherAppId();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, WeatherData.class);
    }
}
