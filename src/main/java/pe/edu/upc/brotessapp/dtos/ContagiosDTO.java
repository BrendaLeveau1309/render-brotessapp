package pe.edu.upc.brotessapp.dtos;

import pe.edu.upc.brotessapp.entities.Enfermedad;
import pe.edu.upc.brotessapp.entities.Usuario;
import pe.edu.upc.brotessapp.entities.Zona;

import java.time.LocalDate;
import java.time.LocalTime;

public class ContagiosDTO {
    private int idContagio;

    private LocalDate fechaContagio;

    private LocalTime horaContagio;

    private Enfermedad enfermedad;

    private Zona zona;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdContagio() {
        return idContagio;
    }

    public void setIdContagio(int idContagio) {
        this.idContagio = idContagio;
    }

    public LocalDate getFechaContagio() {
        return fechaContagio;
    }

    public void setFechaContagio(LocalDate fechaContagio) {
        this.fechaContagio = fechaContagio;
    }

    public LocalTime getHoraContagio() {
        return horaContagio;
    }

    public void setHoraContagio(LocalTime horaContagio) {
        this.horaContagio = horaContagio;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
