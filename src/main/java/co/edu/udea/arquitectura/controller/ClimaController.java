package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.ClimaFacade;
import co.edu.udea.arquitectura.modelo.CiudadDTO;
import co.edu.udea.arquitectura.modelo.ClimaDTO;
import co.edu.udea.arquitectura.util.Messages;
import co.edu.udea.arquitectura.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/clima")

public class ClimaController {
    private final ClimaFacade climaFacade;
    private final Messages messages;

    public ClimaController(ClimaFacade climaFacade, Messages messages) {
        this.climaFacade = climaFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value="Permite crear un Clima", response= ClimaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó el clima exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ClimaDTO>> guardarClima(@Valid @RequestBody ClimaDTO clima){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("clima.guardar.exito"), climaFacade.guardarClima(clima)));
    }

    @PutMapping
    @ApiOperation(value="Permite actualizar el Clima", response= ClimaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el clima con exito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ClimaDTO>> actualizarClima(@Valid @RequestBody ClimaDTO clima){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("clima.actualizar.exito"), climaFacade.actualizarClima(clima)));
    }

    @DeleteMapping("/{codigoClima}")
    @ApiOperation(value = "Permite eliminar el clima")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El clima se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>>eliminarClima(@PathVariable Long codigoClima){
        try{
            climaFacade.eliminarClima(codigoClima);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("clima.eliminar.exito")));
        } catch(DataIntegrityViolationException e){
            throw new DataNotFoundException(messages.get("clima.eliminar.error"));
        }
    }

    @GetMapping("/{codigoClima}")
    @ApiOperation(value = "Permite buscar un Clima", response = CiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El Clima se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<ClimaDTO>> consultarPorId(@PathVariable Long codigoClima) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, climaFacade.consultarPorId(codigoClima)));
    }
}
