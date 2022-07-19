package co.edu.udea.arquitectura.entity;

import javax.persistence.*;


@Entity
@Table(name="clima")
public class Clima {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String temperatura;

    @Column(name = "fk_tipoTemperatura", nullable = false)
    private Long fkTipoTemperatura;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_tipoTemperatura", insertable=false, updatable=false)
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
