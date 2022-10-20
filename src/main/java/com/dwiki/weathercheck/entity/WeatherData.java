package com.dwiki.weathercheck.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity Class for WeatherData
 *
 * @author Dwiki Kurniawan
 */
@Getter
@Setter
public class WeatherData {

    private String name;
    private List<Weather> weather;
    private Coordinate coord;
}
