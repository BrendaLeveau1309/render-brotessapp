package pe.edu.upc.brotessapp.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Zona")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZona;

    @Column(name = "provincia", length = 60,nullable = false)
    private String provincia;

    @Column(name = "distrito", length = 60,nullable = false)
    private String distrito;

    @Column(name = "latitud", precision = 9,scale = 6)
    private BigDecimal latitud;

    @Column(name = "longitud", precision = 9,scale = 6)
    private BigDecimal longitud;

    public Zona() {
    }

    public Zona(int idZona, String provincia, String distrito, BigDecimal latitud, BigDecimal longitud) {
        this.idZona = idZona;
        this.provincia = provincia;
        this.distrito = distrito;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
}
