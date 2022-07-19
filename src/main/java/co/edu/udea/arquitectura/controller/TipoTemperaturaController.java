package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.TipoTemperaturaFacade;
import co.edu.udea.arquitectura.modelo.PaisDTO;
import co.edu.udea.arquitectura.modelo.TipoTemperaturaDTO;
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
@RequestMapping("/tipoTemperatura")
public class TipoTemperaturaController {

    private final TipoTemperaturaFacade tipoTemperaturaFacade;
    private final Messages messages;

    public TipoTemperaturaController(TipoTemperaturaFacade tipoTemperaturaFacade, Messages messages) {
        this.tipoTemperaturaFacade = tipoTemperaturaFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un tipo de temperatura", response = TipoTemperaturaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<TipoTemperaturaDTO>> guardarTipo(@Valid @RequestBody TipoTemperaturaDTO tipo) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("tipo.guardar.exito"), tipoTemperaturaFacade.guardarTipo(tipo)));

    }

    @PutMapping
    @ApiOperation(value = "Permite actualizar un tipo de temperatura", response = TipoTemperaturaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el tipo de temperatura exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<TipoTemperaturaDTO>> actualizarTipo(@Valid @RequestBody TipoTemperaturaDTO tipo) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("tipo.actualizar.exito"), tipoTemperaturaFacade.actualizarTipo(tipo)));
    }

    @DeleteMapping("/{codigoTipo}")
    @ApiOperation(value = "Permite eliminar un tipo de temperatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El tipo de temperatura se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarTipo(@PathVariable Long codigoTipo) {
        try {
            tipoTemperaturaFacade.eliminarTipo(codigoTipo);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("tipo.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("tipo.eliminar.error"));
        }
    }

    @GetMapping("/{codigoTipo}")
    @ApiOperation(value = "Permite buscar un tipo de temperatura", response = TipoTemperaturaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El tipo de temperatura se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<TipoTemperaturaDTO>> consultarPorId(@PathVariable Long codigoTipo) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, tipoTemperaturaFacade.consultarPorId(codigoTipo)));
    }
}
