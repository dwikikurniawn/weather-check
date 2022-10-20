package com.dwiki.weathercheck.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO Class for Weather Data
 *
 * @author Dwiki Kurniawan
 */
@Getter
@Setter
public class WeatherDataDto {
    private String city;
    private String weather;
    private String description;
    private double longitude;
    private double latitude;
}
