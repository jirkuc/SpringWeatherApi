package eu.kolohnat.controller;

import eu.kolohnat.City;
import eu.kolohnat.dto.WeatherDto;
import eu.kolohnat.service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {
    @CrossOrigin
    @RequestMapping({"/weather", "/weather/"})
    public List<WeatherDto> getWeather() {

        List<WeatherDto> weatherDtos = new ArrayList<>();
        WeatherService service = new WeatherService();
        for (City city : City.values()) {
            weatherDtos.add(service.getWeatherForCity(city));
        }
        return weatherDtos;
    }

    @CrossOrigin
    @RequestMapping({"/weather/{city}", "/weather/{city}/"})
//    public String getWeatherForCity(@PathVariable("city") String city) {
//        City cityEnum = City.valueOf(city.toUpperCase());
//        WeatherApiConnector connector = new WeatherApiConnector();
//        return connector.getWeatherForCity(cityEnum);
//    }
    public WeatherDto getWeatherForCity(@PathVariable("city") String city) {
        City cityEnum = City.valueOf(city.toUpperCase());
        WeatherService weatherService = new WeatherService();

        return weatherService.getWeatherForCity(cityEnum);
    }
}
