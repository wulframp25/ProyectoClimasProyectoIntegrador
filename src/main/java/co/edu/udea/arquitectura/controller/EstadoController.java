package co.edu.udea.arquitectura.controller;


import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.EstadoFacade;
import co.edu.udea.arquitectura.modelo.EstadoDTO;
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
@RequestMapping("/estado")
public class EstadoController {
    private final EstadoFacade estadoFacade;
    private final Messages messages;

    public EstadoController(EstadoFacade estadoFacade, Messages messages) {
        this.estadoFacade = estadoFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un departamento", response = EstadoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EstadoDTO>> guardarDepartamento(@Valid @RequestBody EstadoDTO departamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("estado.guardar.exito"), estadoFacade.guardarEstado(departamento)));

    }
    @PutMapping
    @ApiOperation(value = "Permite actualizar un departamento", response = EstadoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el departamento exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EstadoDTO>> actualizarDepartamento(@Valid @RequestBody EstadoDTO departamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("estado.actualizatr.exito"), estadoFacade.actualizarEstado(departamento)));
    }

    @DeleteMapping("/{codigoDepartamento}")
    @ApiOperation(value = "Permite eliminar un departamento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El departamento se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarDepartamento(@PathVariable Long codigoDepartamento) {
        try {
            estadoFacade.eliminarEstado(codigoDepartamento);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("estado.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("departamento.eliminar.error"));
        }
    }

    @GetMapping("/{codigoDepartamento}")
    @ApiOperation(value = "Permite buscar un departamento", response = EstadoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El departamento se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EstadoDTO>> consultarPorId(@PathVariable Long codigoDepartamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, estadoFacade.consultarPorId(codigoDepartamento)));
    }


    @GetMapping
    @ApiOperation(value = "Permite buscar todos los estados", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los estados se consultaron correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<EstadoDTO>>> buscarTodos() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, estadoFacade.buscarTodos()));
    }
}
