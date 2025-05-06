package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Prevenciones")
public class Prevenciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrevencion;

    @Column(name = "descripcionPrevencion", columnDefinition = "TEXT",nullable = false)
    private String descripcionPrevencion;

    @ManyToOne
    @JoinColumn(name = "idTipoE")
    private TipoEnfermedad tipoEnfermedad;

    public Prevenciones() {
    }

    public Prevenciones(TipoEnfermedad tipoEnfermedad, int idPrevencion, String descripcionPrevencion) {
        this.tipoEnfermedad = tipoEnfermedad;
        this.idPrevencion = idPrevencion;
        this.descripcionPrevencion = descripcionPrevencion;
    }

    public int getIdPrevencion() {
        return idPrevencion;
    }

    public void setIdPrevencion(int idPrevencion) {
        this.idPrevencion = idPrevencion;
    }

    public String getDescripcionPrevencion() {
        return descripcionPrevencion;
    }

    public void setDescripcionPrevencion(String descripcionPrevencion) {
        this.descripcionPrevencion = descripcionPrevencion;
    }

    public TipoEnfermedad getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
