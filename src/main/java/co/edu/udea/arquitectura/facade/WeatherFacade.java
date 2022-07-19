package co.edu.udea.arquitectura.facade;

import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.entity.SuscripcionPorCiudad;
import co.edu.udea.arquitectura.feign_client.WeatherFeign;
import co.edu.udea.arquitectura.modelo.WeatherDTO;
import co.edu.udea.arquitectura.service.SuscripcionPorCiudadService;
import co.edu.udea.arquitectura.util.Messages;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WeatherFacade {

    private final WeatherFeign weatherFeign;
    private final Messages messages;
    private final SuscripcionPorCiudadService suscripcionPorCiudadService;

    public WeatherFacade(WeatherFeign weatherFeign,
                         Messages messages, SuscripcionPorCiudadService suscripcionPorCiudadService) {
        this.weatherFeign = weatherFeign;
        this.messages = messages;
        this.suscripcionPorCiudadService = suscripcionPorCiudadService;
    }

    public List<WeatherDTO> getClimates(Long subscriptionId) {
        List<SuscripcionPorCiudad> suscripcionPorCiudadList = suscripcionPorCiudadService.findByFkSuscripcion(subscriptionId);
        List<WeatherDTO> weatherDTOList = new ArrayList<>();
        if (!suscripcionPorCiudadList.isEmpty()) {
            List<Ciudad> ciudadList = suscripcionPorCiudadList.stream().map(SuscripcionPorCiudad::getCiudad).collect(Collectors.toList());
            ciudadList.forEach(ciudad -> {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    String data = weatherFeign.getInformation(ciudad.getNombre()
                            .concat(",".concat(ciudad.getDepartamento().getPais().getNombreCorto())), "717a45df5874d204d6a4934fde5d1380");
                    JsonNode root = mapper.readTree(String.valueOf(data));
                    WeatherDTO weather = new WeatherDTO();
                    weather.setTheCityExists(true);
                    weather.setCity(ciudad.getNombre());
                    weather.setCloudsNumber(root.get("clouds").get("all").asInt());
                    weather.setHumidity(root.get("main").get("humidity").asInt());
                    double temp = root.get("main").get("temp").asDouble() - 273.15;
                    weather.setTemperature(Math.round(temp * Math.pow(10, 2)) / Math.pow(10, 2));
                    double vel = root.get("wind").get("speed").asDouble() * 3.6;
                    weather.setWindSpeed(Math.round(vel * Math.pow(10, 2)) / Math.pow(10, 2));
                    weatherDTOList.add(weather);
                } catch (Exception e) {
                    WeatherDTO weather = new WeatherDTO();
                    weather.setTheCityExists(false);
                    weather.setCity(ciudad.getNombre());
                    weatherDTOList.add(weather);
                }
            });
        }
        return weatherDTOList;
    }

}