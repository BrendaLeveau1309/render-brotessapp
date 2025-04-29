package pe.edu.upc.brotessapp.dtos;

import pe.edu.upc.brotessapp.entities.Brotes;

import java.time.LocalDate;

public class NotificacionDTO {
    private int idNotificacion;

    private String titulo;
    private String contenido;
    private String estado;
    private LocalDate fechaEnvio;
    private Brotes brotes;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Brotes getBrotes() {
        return brotes;
    }

    public void setBrotes(Brotes brotes) {
        this.brotes = brotes;
    }
}
