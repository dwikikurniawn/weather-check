package com.dwiki.weathercheck.controller;

import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.entity.Coordinate;
import com.dwiki.weathercheck.entity.Weather;
import com.dwiki.weathercheck.entity.WeatherData;
import com.dwiki.weathercheck.service.WeatherDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WeatherController.class)
@AutoConfigureMockMvc(addFilters = false)
class WeatherDataControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherDataService weatherDataService;

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
    void checkWeatherByCity() throws Exception {
        WeatherDataDto weatherDataDto = createWeatherDataDto();
        String city = "Dummy City";
        String endpoint = "/weather?city=" + city;

        when(weatherDataService.checkByCityName(city)).thenReturn(weatherDataDto);
        mockMvc.perform(get(endpoint)).andExpect(status().is2xxSuccessful());
    }

    @Test
    void checkWeatherByLongitudeLatitude() throws Exception {
        WeatherDataDto weatherDataDto = createWeatherDataDto();
        double lon = 12345.123;
        double lat = -12345.123;
        String endpoint = "/weather/coordinate?lon=" + lon + "&lat=" + lat;

        when(weatherDataService.checkByLongitudeLatitude(lon, lat)).thenReturn(weatherDataDto);
        mockMvc.perform(get(endpoint)).andExpect(status().is2xxSuccessful());
    }
}
