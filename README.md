# Weather Check Application
This is a [Spring Boot](http://projects.spring.io/spring-boot/) Application for checking the weather on a city around the world.

## Getting Started
### Ingredient
For building and running the application you need:
- [JDK 1.8++](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3++](https://maven.apache.org)
- An account in [OpenWeatherMap](https://openweathermap.org/)

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.dwiki.weathercheck.WeatherCheckApplication` class from your IDE.
Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
After the application run, you can access the API on `localhost:8082/{API-path}`. You also can choose specific port where you want to run this application by setting up the value on `application.properties` at property `server.port`
### NOTE
- You may need update the App-Id from [OpenWeatherMap](https://openweathermap.org/) on `application.properties` at property `weather.app.id` when the previous App-Id expires.