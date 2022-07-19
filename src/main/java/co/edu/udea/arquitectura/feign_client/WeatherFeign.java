package co.edu.udea.arquitectura.feign_client;

import co.edu.udea.arquitectura.config.FeignWeatherConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-api", url = "${weather.api}", configuration = FeignWeatherConfiguration.class)
public interface WeatherFeign {

    @GetMapping()
    String getInformation(@RequestParam("q") String city,
                          @RequestParam("appid") String clientId);

}
