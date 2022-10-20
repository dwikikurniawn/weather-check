package com.dwiki.weathercheck.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity Class for Weather
 *
 * @author Dwiki Kurniawan
 */
@Getter
@Setter
public class Weather {
    private int id;
    private String main;
    private String description;
}
