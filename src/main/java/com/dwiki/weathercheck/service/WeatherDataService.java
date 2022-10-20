package com.dwiki.weathercheck.service;

import com.dwiki.weathercheck.dto.WeatherDataDto;

/**
 * Interface for WeatherDataService
 *
 * @author Dwiki Kurniawan
 */
public interface WeatherDataService {

    /**
     * @param name city name around the world that you want to check its weather e.g. Sydney, Jakarta, New York, etc.
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    WeatherDataDto checkByCityName(String name);


    /**
     * @param lon longitude value
     * @param lat latitude value
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    WeatherDataDto checkByLongitudeLatitude(Double lon, Double lat);
}
