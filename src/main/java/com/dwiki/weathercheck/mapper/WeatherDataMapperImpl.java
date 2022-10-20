package com.dwiki.weathercheck.mapper;

import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.entity.WeatherData;
import org.springframework.stereotype.Component;

/**
 * Implementation class for interface WeatherDataMapper
 *
 * @author Dwiki Kurniawan
 */
@Component
public class WeatherDataMapperImpl implements WeatherDataMapper {

    /**
     * @param weatherData entity WeatherData that want to map to WeatherDataDto
     * @return WeatherDataDto
     */
    @Override
    public WeatherDataDto toDto(WeatherData weatherData) {
        WeatherDataDto weatherDataDto = new WeatherDataDto();
        weatherDataDto.setCity(weatherData.getName());
        weatherDataDto.setWeather(weatherData.getWeather().get(0).getMain());
        weatherDataDto.setDescription(weatherData.getWeather().get(0).getDescription());
        weatherDataDto.setLatitude(weatherData.getCoord().getLat());
        weatherDataDto.setLongitude(weatherData.getCoord().getLon());
        return weatherDataDto;
    }
}
