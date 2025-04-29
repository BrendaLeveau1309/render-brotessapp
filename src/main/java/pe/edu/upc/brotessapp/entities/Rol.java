package pe.edu.upc.brotessapp.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "rol",nullable = false, length = 20)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Usuario usuario;

    public Rol() {
    }

    public Rol(int idRol, String rol, Usuario usuario) {
        this.idRol = idRol;
        this.rol = rol;
        this.usuario = usuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

