package com.dwiki.weathercheck.client;

import com.dwiki.weathercheck.entity.WeatherData;

/**
 * This interface for get Weather Data from 3rd party weather API
 *
 * @author Dwiki Kurniawan
 */
public interface WeatherClient {
    /**
     * @param city city name around the world that you want to check its weather e.g. Sydney, Jakarta, New York, etc.
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    WeatherData checkByCity(String city);

    /**
     * @param lon longitude value
     * @param lat latitude value
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    WeatherData checkByLongitudeLatitude(Double lon, Double lat);
}
