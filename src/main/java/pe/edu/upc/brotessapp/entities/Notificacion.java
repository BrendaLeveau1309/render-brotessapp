package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "titulo", nullable = false,length =50)
    private String titulo;
    @Column(name = "contenido", nullable = false,length =200)
    private String contenido;
    @Column(name = "estado", nullable = false,length =20)
    private String estado;
    @Column(name = "fechaEnvio", nullable = false)
    private LocalDate fechaEnvio;

    @OneToOne
    @JoinColumn(name = "idBrote")
    private Brotes brotes;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String titulo, String contenido, String estado, LocalDate fechaEnvio, Brotes brotes) {
        this.idNotificacion = idNotificacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.brotes = brotes;
    }

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
