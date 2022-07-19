package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.SuscripcionFacade;
import co.edu.udea.arquitectura.modelo.CiudadDTO;
import co.edu.udea.arquitectura.modelo.SuscripcionDTO;
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
@RequestMapping("/suscripcion")
public class SuscripcionController {

    private final SuscripcionFacade suscripcionFacade;
    private final Messages messages;

    public SuscripcionController(SuscripcionFacade suscripcionFacade, Messages messages) {
        this.suscripcionFacade = suscripcionFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value="Permite crear una suscripcion", response= SuscripcionDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó la suscripcion exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionDTO>> guardarSuscripcion(@Valid @RequestBody SuscripcionDTO suscripcion){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.guardar.exito"), suscripcionFacade.guardarSuscripcion(suscripcion)));
    }

    @PutMapping
    @ApiOperation(value="Permite actualizar la suscripcion", response= SuscripcionDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó la suscripcion con exito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionDTO>> actualizarSuscripcion(@Valid @RequestBody SuscripcionDTO suscripcion){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.actualizar.exito"), suscripcionFacade.actualizarSuscripcion(suscripcion)));
    }

    @DeleteMapping("/{codigoSuscripcion}")
    @ApiOperation(value = "Permite eliminar la suscripcion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La suscripcion se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>>eliminarSuscripcion(@PathVariable Long codigoSuscripcion){
        try{
            suscripcionFacade.eliminarSuscripcion(codigoSuscripcion);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.eliminar.exito")));
        } catch(DataIntegrityViolationException e){
            throw new DataNotFoundException(messages.get("suscripcion.eliminar.error"));
        }
    }

    @GetMapping("/{codigoSuscripcion}")
    @ApiOperation(value = "Permite buscar una suscripcion", response = CiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la suscripcion se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionDTO>> consultarPorId(@PathVariable Long codigoSuscripcion) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, suscripcionFacade.consultarPorId(codigoSuscripcion)));
    }
}
