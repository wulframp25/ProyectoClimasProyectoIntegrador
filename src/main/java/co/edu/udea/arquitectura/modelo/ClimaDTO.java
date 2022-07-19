package co.edu.udea.arquitectura.modelo;

import co.edu.udea.arquitectura.entity.TipoTemperatura;
import co.edu.udea.arquitectura.entity.Usuario;

import javax.validation.constraints.NotNull;

public class ClimaDTO {
    private Long id;
    @NotNull
    private String temperatura;
    @NotNull
    private Long fkTipoTemperatura;

    private TipoTemperatura tipoTemperatura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Long getFkTipoTemperatura() {
        return fkTipoTemperatura;
    }

    public void setFkTipoTemperatura(Long fkTipoTemperatura) {
        this.fkTipoTemperatura = fkTipoTemperatura;
    }

    public TipoTemperatura getTipoTemperatura() {
        return tipoTemperatura;
    }

    public void setTipoTemperatura(TipoTemperatura tipoTemperatura) {
        this.tipoTemperatura = tipoTemperatura;
    }
}
