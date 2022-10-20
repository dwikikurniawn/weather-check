package com.dwiki.weathercheck.service;

import com.dwiki.weathercheck.client.WeatherClientImpl;
import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.entity.WeatherData;
import com.dwiki.weathercheck.mapper.WeatherDataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation class of interface WeatherDataService
 *
 * @author Dwiki Kurniawan
 */
@Service
@Slf4j
@AllArgsConstructor
public class WeatherDataServiceImpl implements WeatherDataService {

    private final WeatherClientImpl weatherRepository;
    private final WeatherDataMapper weatherDataMapper;

    /**
     * @param cityName city name around the world that you want to check its weather e.g. Sydney, Jakarta, New York, etc.
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    @Override
    public WeatherDataDto checkByCityName(String cityName) {
        log.debug("checkByCityName() cityName: {}", cityName);
        WeatherData weatherData = weatherRepository.checkByCity(cityName);
        return weatherDataMapper.toDto(weatherData);
    }

    /**
     * @param lon longitude value
     * @param lat latitude value
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */

    @Override
    public WeatherDataDto checkByLongitudeLatitude(Double lon, Double lat) {
        log.debug("checkByLongitudeLatitude() lon: {}, lat:{}", lon, lat);
        WeatherData weatherData = weatherRepository.checkByLongitudeLatitude(lon, lat);
        return weatherDataMapper.toDto(weatherData);
    }
}