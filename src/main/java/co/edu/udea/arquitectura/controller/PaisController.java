package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.PaisFacade;
import co.edu.udea.arquitectura.modelo.PaisDTO;
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
@RequestMapping("/pais")
public class PaisController {

    private final PaisFacade paisFacade;
    private final Messages messages;

    public PaisController(PaisFacade paisFacade, Messages messages) {
        this.paisFacade = paisFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un país", response = PaisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<PaisDTO>> guardarPais(@Valid @RequestBody PaisDTO pais) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("pais.guardar.exito"), paisFacade.guardarPais(pais)));

    }
    @PutMapping
    @ApiOperation(value = "Permite actualizar un pais", response = PaisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el pais exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<PaisDTO>> actualizarPais(@Valid @RequestBody PaisDTO pais) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("pais.actualizatr.exito"), paisFacade.actualizarPais(pais)));
    }

    @DeleteMapping("/{codigoPais}")
    @ApiOperation(value = "Permite eliminar un pais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El pais se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarPais(@PathVariable Long codigoPais) {
        try {
            paisFacade.eliminarPais(codigoPais);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("pais.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("pais.eliminar.error"));
        }
    }

    @GetMapping("/{codigoPais}")
    @ApiOperation(value = "Permite buscar un pais", response = PaisDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El pais se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<PaisDTO>> consultarPorId(@PathVariable Long codigoPais) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, paisFacade.consultarPorId(codigoPais)));
    }

    @GetMapping
    @ApiOperation(value = "Permite buscar todos los países", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los países se consultaron correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<PaisDTO>>> buscarTodos() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, paisFacade.buscarTodos()));
    }
}
