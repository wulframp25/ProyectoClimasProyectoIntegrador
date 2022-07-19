package co.edu.udea.arquitectura.entity;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "nombre_corto", length = 5)
    private String nombreCorto;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado;

    @Column(name = "fk_pais", nullable = false)
    private Long fkPais;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_pais", insertable = false, updatable = false)
    private co.edu.udea.arquitectura.entity.Pais pais;

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

    public co.edu.udea.arquitectura.entity.Pais getPais() {
        return pais;
    }

    public void setPais(co.edu.udea.arquitectura.entity.Pais pais) {
        this.pais = pais;
    }
}
