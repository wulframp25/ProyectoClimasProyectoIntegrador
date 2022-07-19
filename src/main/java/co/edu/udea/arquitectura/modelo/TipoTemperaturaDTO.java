package co.edu.udea.arquitectura.modelo;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TipoTemperaturaDTO {


    private Long id;

    @NotNull
    private String nombre;

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
}
