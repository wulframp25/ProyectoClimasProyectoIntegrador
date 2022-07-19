package co.edu.udea.arquitectura.modelo;

import javax.validation.constraints.NotNull;

public class CiudadDTO {

    private Long id;
    @NotNull
    private String nombre;
    private String nombreCorto;
    @NotNull
    private Boolean habilitado;
    @NotNull
    private Long fkEstado;
    private EstadoDTO departamento;
    private Boolean tieneSuscripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Long getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(Long fkEstado) {
        this.fkEstado = fkEstado;
    }

    public EstadoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(EstadoDTO departamento) {
        this.departamento = departamento;
    }

    public Boolean getTieneSuscripcion() {
        return tieneSuscripcion;
    }

    public void setTieneSuscripcion(Boolean tieneSuscripcion) {
        this.tieneSuscripcion = tieneSuscripcion;
    }
}
