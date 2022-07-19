package co.edu.udea.arquitectura.modelo;

import javax.validation.constraints.NotNull;

public class PaisDTO {

    private Long id;
    @NotNull
    private String codigoLlamada;
    @NotNull
    private String nombre;
    @NotNull
    private String nombreCorto;
    @NotNull
    private Boolean habilitado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoLlamada() {
        return codigoLlamada;
    }

    public void setCodigoLlamada(String codigoLlamada) {
        this.codigoLlamada = codigoLlamada;
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
}
