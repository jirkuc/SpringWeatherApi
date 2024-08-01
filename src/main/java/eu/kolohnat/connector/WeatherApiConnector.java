package eu.kolohnat.connector;

import eu.kolohnat.City;
import eu.kolohnat.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    private static String baseUrl = "https://api.weatherapi.com/";
    private static String urlParameters = "v1/current.json?key=";
    private static String apiKey = "api Key generated by weatherapi.com";
    private static String lang = "&lang=cs";
    private static String url = baseUrl + urlParameters + apiKey + lang + "&q=";

    public WeatherApiDto getWeatherForCity(City city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }

}
