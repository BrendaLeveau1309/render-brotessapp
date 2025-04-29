package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Brotes")
public class Brotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBrote;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @OneToOne
    @JoinColumn(name = "idContagio")
    private Contagios contagios;

    public Brotes() {
    }

    public Brotes(int idBrote, LocalDate fechaInicio, LocalDate fechaFin, Contagios contagios) {
        this.idBrote = idBrote;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.contagios = contagios;
    }

    public int getIdBrote() {
        return idBrote;
    }

    public void setIdBrote(int idBrote) {
        this.idBrote = idBrote;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Contagios getContagios() {
        return contagios;
    }

    public void setContagios(Contagios contagios) {
        this.contagios = contagios;
    }
}
