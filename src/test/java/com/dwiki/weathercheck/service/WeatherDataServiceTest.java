package com.dwiki.weathercheck.service;

import com.dwiki.weathercheck.client.WeatherClientImpl;
import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.entity.Coordinate;
import com.dwiki.weathercheck.entity.Weather;
import com.dwiki.weathercheck.entity.WeatherData;
import com.dwiki.weathercheck.mapper.WeatherDataMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherDataServiceTest {

    @InjectMocks
    WeatherDataServiceImpl weatherDataService;
    @Mock
    WeatherClientImpl weatherRepository;
    @Mock
    WeatherDataMapper weatherDataMapper;

    private WeatherDataDto createWeatherDataDto() {
        WeatherDataDto weatherDataDto = new WeatherDataDto();
        weatherDataDto.setCity("Dummy City");
        weatherDataDto.setWeather("Dummy weather");
        weatherDataDto.setLongitude(12345.123);
        weatherDataDto.setLatitude(-12345.123);
        weatherDataDto.setDescription("Dummy Description");
        return weatherDataDto;
    }

    private WeatherData createWeatherData() {
        WeatherData weatherData = new WeatherData();
        Coordinate coordinat = new Coordinate();
        coordinat.setLat(12345.123);
        coordinat.setLon(-12345.123);
        Weather weather = new Weather();
        weather.setId(1);
        weather.setMain("Dummy Weather");
        weather.setDescription("Dummy Description");
        List<Weather> weathers = List.of(weather);
        weatherData.setWeather(weathers);
        weatherData.setCoord(coordinat);
        weatherData.setName("Dummy City");
        return weatherData;
    }

    @Test
    void checkByCityNameTest() {
        WeatherData weatherData = createWeatherData();
        WeatherDataDto weatherDataDto = createWeatherDataDto();
        String city = "Dummy City";

        when(weatherRepository.checkByCity(city)).thenReturn(weatherData);
        when(weatherDataMapper.toDto(weatherData)).thenReturn(weatherDataDto);

        WeatherDataDto actual = weatherDataService.checkByCityName(city);
        assertEquals(weatherDataDto, actual);
    }

    @Test
    void checkByCityLongitudeLatitude() {
        WeatherData weatherData = createWeatherData();
        WeatherDataDto weatherDataDto = createWeatherDataDto();
        double lon = 12345.123;
        double lat = -12345.123;

        when(weatherRepository.checkByLongitudeLatitude(lon, lat)).thenReturn(weatherData);
        when(weatherDataMapper.toDto(weatherData)).thenReturn(weatherDataDto);

        WeatherDataDto actual = weatherDataService.checkByLongitudeLatitude(lon, lat);
        assertEquals(weatherDataDto, actual);
    }
}