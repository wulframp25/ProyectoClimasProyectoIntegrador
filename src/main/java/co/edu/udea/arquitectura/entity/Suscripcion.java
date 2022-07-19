package co.edu.udea.arquitectura.entity;


import javax.persistence.*;

@Entity
@Table(name="suscripcion")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fk_usuario", nullable = false)
    private Long fkUsuario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_usuario", insertable=false, updatable=false)
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
