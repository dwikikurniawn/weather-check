package com.dwiki.weathercheck.mapper;

import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.entity.WeatherData;

/**
 * Interface for WeatherDataMapper
 *
 * @author Dwiki Kurniawan
 */
public interface WeatherDataMapper {

    WeatherDataDto toDto(WeatherData weatherData);
}
