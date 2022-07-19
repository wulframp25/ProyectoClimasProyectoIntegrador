package co.edu.udea.arquitectura.modelo;

import javax.validation.constraints.NotNull;

public class EstadoDTO {

    private Long id;
    @NotNull
    private String nombre;
    private String nombreCorto;
    @NotNull
    private Boolean habilitado;
    @NotNull
    private Long fkPais;
    private PaisDTO pais;

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

    public Long getFkPais() {
        return fkPais;
    }

    public void setFkPais(Long fkPais) {
        this.fkPais = fkPais;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }
}
