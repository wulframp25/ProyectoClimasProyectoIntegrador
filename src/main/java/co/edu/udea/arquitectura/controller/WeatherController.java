package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.facade.WeatherFacade;
import co.edu.udea.arquitectura.modelo.WeatherDTO;
import co.edu.udea.arquitectura.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherFacade weatherFacade;

    public WeatherController(WeatherFacade weatherFacade) {
        this.weatherFacade = weatherFacade;
    }

    @GetMapping("/{subscriptionId}")
    @ApiOperation(value = "Permite buscar la temperatura de las ciudades a las que se estpa inscrito", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La consulta fue exitosa"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<WeatherDTO>>> getClimates(@PathVariable Long subscriptionId) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, weatherFacade.getClimates(subscriptionId)));
    }

}