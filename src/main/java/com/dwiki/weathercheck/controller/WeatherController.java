package com.dwiki.weathercheck.controller;

import com.dwiki.weathercheck.dto.WeatherDataDto;
import com.dwiki.weathercheck.service.WeatherDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller class consist APIs to check weather of a city around the world
 *
 * @author Dwiki Kurniawan
 */
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/weather")
public class WeatherController {

    private final WeatherDataService weatherDataService;

    /**
     * @param city city name around the world that you want to check its weather e.g. Sydney, Jakarta, New York, etc.
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    @GetMapping()
    public ResponseEntity<WeatherDataDto> checkWeatherByCity(@RequestParam String city) {
        return ResponseEntity.ok(weatherDataService.checkByCityName(city));
    }

    /**
     * @param lon longitude value
     * @param lat latitude value
     * @return Weather data of a city with information: city name, the weather, description of the weather,longitude, and longitude of the city.
     */
    @GetMapping("/coordinate")
    public ResponseEntity<WeatherDataDto> checkWeatherByLongitudeLatitude(@RequestParam Double lon, @RequestParam Double lat) {
        return ResponseEntity.ok(weatherDataService.checkByLongitudeLatitude(lon, lat));
    }
}