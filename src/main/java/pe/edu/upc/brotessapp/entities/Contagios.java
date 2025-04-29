package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Contagios")
public class Contagios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContagio;

    @Column(name = "fechaContagio", nullable = false)
    private LocalDate fechaContagio;

    @Column(name = "horaContagio",nullable = false)
    private LocalTime horaContagio;


    @ManyToOne
    @JoinColumn(name = "idEnfermedad")
    private Enfermedad enfermedad;

    @ManyToOne
    @JoinColumn(name = "idZona")
    private Zona zona;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Contagios() {
    }

    public Contagios(int idContagio, LocalDate fechaContagio, LocalTime horaContagio, Enfermedad enfermedad, Zona zona, Usuario usuario) {
        this.idContagio = idContagio;
        this.fechaContagio = fechaContagio;
        this.horaContagio = horaContagio;
        this.enfermedad = enfermedad;
        this.zona = zona;
        this.usuario = usuario;
    }

    public int getIdContagio() {
        return idContagio;
    }

    public void setIdContagio(int idContagio) {
        this.idContagio = idContagio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
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
}
