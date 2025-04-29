package pe.edu.upc.brotessapp.dtos;

import pe.edu.upc.brotessapp.entities.Contagios;

import java.time.LocalDate;

public class BrotesDTO {
    private int idBrote;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Contagios contagios;

    public int getIdBrote() {
        return idBrote;
    }

    public void setIdBrote(int idBrote) {
        this.idBrote = idBrote;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Contagios getContagios() {
        return contagios;
    }

    public void setContagios(Contagios contagios) {
        this.contagios = contagios;
    }
}
