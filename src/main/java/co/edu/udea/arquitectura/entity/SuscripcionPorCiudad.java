package co.edu.udea.arquitectura.entity;

import javax.persistence.*;

@Entity
@Table(name="subscripcion_por_ciudad")
public class SuscripcionPorCiudad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "fk_suscripcion", nullable = false, length = 100)
    private Long fkSuscripcion;

    @Column(name = "fk_ciudad", nullable = false, length = 100)
    private Long fkCiudad;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_suscripcion", insertable = false, updatable = false)
    private Suscripcion suscripcion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_ciudad", insertable = false, updatable = false)
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
