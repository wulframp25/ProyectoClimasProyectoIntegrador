package co.edu.udea.arquitectura.modelo;

import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.util.enums.TipoUsuario;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;
    @NotNull
    private String nombreCompleto;
    @NotNull
    private String correo;
    @NotNull
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String celular;
    private Long fkCiudadCliente;
    private Ciudad ciudadCliente;
    private Long idSuscripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getFkCiudadCliente() {
        return fkCiudadCliente;
    }

    public void setFkCiudadCliente(Long fkCiudadCliente) {
        this.fkCiudadCliente = fkCiudadCliente;
    }

    public Ciudad getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(Ciudad ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public Long getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Long idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }
}
