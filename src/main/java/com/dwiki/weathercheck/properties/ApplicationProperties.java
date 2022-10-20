package com.dwiki.weathercheck.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Properties Class
 *
 * @author Dwiki Kurniawan
 */
//@ConfigurationProperties
@Configuration
@Getter
@Setter
public class ApplicationProperties {

    @Value("${weather.uri}")
    private String weatherUri;
    @Value("${weather.app.id}")
    private String weatherAppId;
}