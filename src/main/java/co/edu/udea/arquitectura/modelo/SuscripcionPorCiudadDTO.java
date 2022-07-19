package co.edu.udea.arquitectura.modelo;

import co.edu.udea.arquitectura.entity.Ciudad;
import co.edu.udea.arquitectura.entity.Suscripcion;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class SuscripcionPorCiudadDTO {


    private Long id;

    @NotNull
    private Long fkSuscripcion;

    @NotNull
    private Long fkCiudad;

    private Suscripcion suscripcion;

    private Ciudad ciudad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkSuscripcion() {
        return fkSuscripcion;
    }

    public void setFkSuscripcion(Long fkSuscripcion) {
        this.fkSuscripcion = fkSuscripcion;
    }

    public Long getFkCiudad() {
        return fkCiudad;
    }

    public void setFkCiudad(Long fkCiudad) {
        this.fkCiudad = fkCiudad;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
