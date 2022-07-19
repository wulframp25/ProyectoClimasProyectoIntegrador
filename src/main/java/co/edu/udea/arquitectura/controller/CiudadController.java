package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.CiudadFacade;
import co.edu.udea.arquitectura.modelo.CiudadDTO;
import co.edu.udea.arquitectura.util.Messages;
import co.edu.udea.arquitectura.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadFacade ciudadFacade;
    private final Messages messages;

    public CiudadController(CiudadFacade ciudadFacade, Messages messages){
        this.ciudadFacade=ciudadFacade;
        this.messages=messages;
    }

    @PostMapping
    @ApiOperation(value="Permite crear una ciudad", response=CiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó la ciudad exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<CiudadDTO>>guardarCiudad(@Valid @RequestBody CiudadDTO ciudad){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("ciudad.guardar.exito"), ciudadFacade.guardarCiudad(ciudad)));
    }

    @PutMapping
    @ApiOperation(value="Permite actualizar la ciudad", response= CiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó la ciudad con exito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<CiudadDTO>> actualizarCiudad(@Valid @RequestBody CiudadDTO ciudad){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("ciudad.actualizar.exito"), ciudadFacade.actualizarCiudad(ciudad)));
    }

    @DeleteMapping("/{codigoCiudad}")
    @ApiOperation(value = "Permite eliminar la ciudad")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La ciudad se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>>eliminarCiudad(@PathVariable Long codigoCiudad){
        try{
            ciudadFacade.eliminarCiudad(codigoCiudad);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("ciudad.eliminar.exito")));
        } catch(DataIntegrityViolationException e){
            throw new DataNotFoundException(messages.get("ciudad.eliminar.error"));
        }
    }

    @GetMapping("/{codigoCiudad}")
    @ApiOperation(value = "Permite buscar una ciudad", response = CiudadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la ciudad se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<CiudadDTO>> consultarPorId(@PathVariable Long codigoCiudad) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, ciudadFacade.consultarPorId(codigoCiudad)));
    }

    @GetMapping("/consulta-suscripcion/{idUsuario}")
    @ApiOperation(value = "Permite buscar todas las ciudades", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Las ciudades se consultaron correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<CiudadDTO>>> buscarTodas(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, ciudadFacade.buscarTodas(idUsuario)));
    }
}
