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

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Prevenciones() {
    }

    public Prevenciones(int idPrevencion, String descripcionPrevencion, TipoEnfermedad tipoEnfermedad, Usuario usuario) {
        this.idPrevencion = idPrevencion;
        this.descripcionPrevencion = descripcionPrevencion;
        this.tipoEnfermedad = tipoEnfermedad;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
