package co.edu.udea.arquitectura.entity;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

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

    @Column(name = "fk_estado", nullable = false)
    private Long fkEstado;

    // relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_estado", insertable = false, updatable = false)
    private Estado estado;

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

    public void setFkEstado(Long fkDepartamento) {
        this.fkEstado = fkDepartamento;
    }

    public Estado getDepartamento() {
        return estado;
    }

    public void setDepartamento(Estado estado) {
        this.estado = estado;
    }
}
