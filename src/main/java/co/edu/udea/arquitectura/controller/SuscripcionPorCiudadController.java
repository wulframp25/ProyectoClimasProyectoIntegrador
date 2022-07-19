package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.SuscripcionPorCiudadFacade;
import co.edu.udea.arquitectura.modelo.PaisDTO;
import co.edu.udea.arquitectura.modelo.SuscripcionPorCiudadDTO;
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
@RequestMapping("/suscripcionpc")
public class SuscripcionPorCiudadController {

    private final SuscripcionPorCiudadFacade suscripcionPorCiudadFacade;
    private final Messages messages;

    public SuscripcionPorCiudadController(SuscripcionPorCiudadFacade suscripcionPorCiudadFacade, Messages messages) {
        this.suscripcionPorCiudadFacade = suscripcionPorCiudadFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear una Suscripcion", response = SuscripcionPorCiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionPorCiudadDTO>> guardarSuscripcion(@Valid @RequestBody SuscripcionPorCiudadDTO suscripcion) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.guardar.exito"), suscripcionPorCiudadFacade.guardarSuscripcion(suscripcion)));
    }

    @PutMapping
    @ApiOperation(value = "Permite actualizar una suscripcion", response = SuscripcionPorCiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionPorCiudadDTO>> actualizarSuscripcion(@Valid @RequestBody SuscripcionPorCiudadDTO suscripcion) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.actualizar.exito"), suscripcionPorCiudadFacade.actualizarSuscripcion(suscripcion)));
    }

    @DeleteMapping("/{codigoSuscripcion}/{idCiudad}")
    @ApiOperation(value = "Permite eliminar una suscripcion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarSuscripcion(@PathVariable Long codigoSuscripcion, @PathVariable Long idCiudad) {
        try {
            suscripcionPorCiudadFacade.eliminarSuscripcion(codigoSuscripcion, idCiudad);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("suscripcion.eliminar.error"));
        }
    }

    @GetMapping("/{codigoSuscripcion}")
    @ApiOperation(value = "Permite buscar una suscripcion", response = SuscripcionPorCiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionPorCiudadDTO>> consultarPorId(@PathVariable Long codigoSuscripcion) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, suscripcionPorCiudadFacade.consultarPorId(codigoSuscripcion)));
    }
}
