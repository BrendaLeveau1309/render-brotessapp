package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre", nullable = false,length =40)
    private String nombre;
    @Column(name = "apellido", nullable = false,length =40)
    private String apellido;
    private Boolean enabled;
    @Column(name = "username", nullable = false,length =200, unique = true)
    private String username;
    @Column(name = "password", nullable = false,length =200)
    private String password;

    @OneToOne
    @JoinColumn(name = "idZona")
    private Zona zona;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, Boolean enabled, String username, String password, Zona zona, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.zona = zona;
        this.roles = roles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void getPassword(String password) {
        this.password = password;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
