package co.edu.udea.arquitectura.modelo;

import javax.validation.constraints.NotNull;

public class SuscripcionDTO {

    private Long id;
    private String estado;
    @NotNull
    private Long fkUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Long fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
