package pe.edu.upc.brotessapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.edu.upc.brotessapp.entities.Usuario;

public class RolDTO {

    private int idRol;

    private String rol;

    @JsonIgnore
    private Usuario usuario;

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
