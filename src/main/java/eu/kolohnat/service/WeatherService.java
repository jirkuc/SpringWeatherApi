package eu.kolohnat.service;

import eu.kolohnat.City;
import eu.kolohnat.connector.WeatherApiConnector;
import eu.kolohnat.dto.WeatherApiDto;
import eu.kolohnat.dto.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public WeatherDto getWeatherForCity(City cityEnum) {
        WeatherApiConnector connector = new WeatherApiConnector();

//        WeatherApiDto currentWeather = connector.getWeatherForCity(cityEnum);
//        WeatherDto weatherDto = transformDto(currentWeather);
//        return weatherDto;

        return transformDto(connector.getWeatherForCity(cityEnum));
    }

    private WeatherDto transformDto(WeatherApiDto apiDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setWeather_description(apiDto.getCurrent().getCondition().getText());
        weatherDto.setIcon(apiDto.getCurrent().getCondition().getIcon());
        weatherDto.setLocation(apiDto.getLocation().getName());
        weatherDto.setTimestamp(apiDto.getCurrent().getLast_updated());
        weatherDto.setTemp_celsius(apiDto.getCurrent().getTemp_c());
        weatherDto.setWind_direction(apiDto.getCurrent().getWind_dir());
        weatherDto.setRel_humidity(apiDto.getCurrent().getHumidity());
        weatherDto.setWind_speed_m_per_s(apiDto.getCurrent().getWind_kph() / 3.6);

        return weatherDto;
    }
}
