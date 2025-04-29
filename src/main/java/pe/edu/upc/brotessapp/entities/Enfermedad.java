package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Enfermedad")
public class Enfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnfermedad;

    @Column(name = "nombre", nullable = false,length = 60)
    private String nombre;

    @Column(name = "descripcionEnfermedad",columnDefinition = "TEXT",nullable = false)
    private String descripcionEnfermedad;

    @ManyToOne
    @JoinColumn(name = "idTipoE")
    private TipoEnfermedad tipoEnfermedad;

    @ManyToOne
    @JoinColumn(name = "idTipoT")
    private TipoTransmision tipoTransmision;
    public Enfermedad() {
    }

    public Enfermedad(int idEnfermedad, String nombre, String descripcionEnfermedad, TipoEnfermedad tipoEnfermedad, TipoTransmision tipoTransmision) {
        this.idEnfermedad = idEnfermedad;
        this.nombre = nombre;
        this.descripcionEnfermedad = descripcionEnfermedad;
        this.tipoEnfermedad = tipoEnfermedad;
        this.tipoTransmision = tipoTransmision;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
    }

    public TipoEnfermedad getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

    public TipoTransmision getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(TipoTransmision tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }
}
