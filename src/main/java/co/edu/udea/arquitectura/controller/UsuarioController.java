package co.edu.udea.arquitectura.controller;

import co.edu.udea.arquitectura.exception.DataNotFoundException;
import co.edu.udea.arquitectura.facade.UsuarioFacade;
import co.edu.udea.arquitectura.modelo.UsuarioDTO;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;
    private final Messages messages;

    public UsuarioController(UsuarioFacade usuarioFacade, Messages messages) {
        this.usuarioFacade = usuarioFacade;
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "Permite crear un usuario", response = UsuarioDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó el usuario exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UsuarioDTO>> guardarUsuario(@Valid @RequestBody UsuarioDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("usuario.guardar.exito"), usuarioFacade.guardarUsuario(user)));
    }

    @PutMapping
    @ApiOperation(value = "Permite actualizar un usuario", response = UsuarioDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizó el usuario exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UsuarioDTO>> actualizarUsuario(@Valid @RequestBody UsuarioDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("usuario.actualizatr.exito"), usuarioFacade.actualizarUsuario(user)));
    }

    @DeleteMapping("/{codigoUsuario}")
    @ApiOperation(value = "Permite eliminar un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El usuario se eliminó exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> eliminarUsuario(@PathVariable Long codigoUsuario) {
        try {
            usuarioFacade.eliminarUsuario(codigoUsuario);
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("usuario.eliminar.exito")));
        } catch (DataIntegrityViolationException e) {
            throw new DataNotFoundException(messages.get("usuario.eliminar.error"));
        }
    }

    @GetMapping("/{codigoUsuario}")
    @ApiOperation(value = "Permite buscar un usuario", response = UsuarioDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El usuario se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UsuarioDTO>> consultarPorId(@PathVariable Long codigoUsuario) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, usuarioFacade.consultarPorId(codigoUsuario)));
    }

    @GetMapping("iniciar-sesion/{correo}/{contrasena}")
    @ApiOperation(value = "Permite buscar un usuario por correo y contraseña", response = UsuarioDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El usuario se consultó correctamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UsuarioDTO>> buscarUsuarioPorCorreo(@PathVariable String correo, @PathVariable String contrasena) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, usuarioFacade.buscarUsuarioPorCorreo(correo, contrasena)));
    }

}