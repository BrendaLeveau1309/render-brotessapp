package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoEnfermedad")
public class TipoEnfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoE;

    @Column(name = "nombreTipoE", nullable = false,length = 60)
    private String nombreTipoE;


    public TipoEnfermedad() {
    }

    public TipoEnfermedad(int idTipoE, String nombreTipoE, String descripcionTipoE) {
        this.idTipoE = idTipoE;
        this.nombreTipoE = nombreTipoE;
    }

    public int getIdTipoE() {
        return idTipoE;
    }

    public void setIdTipoE(int idTipoE) {
        this.idTipoE = idTipoE;
    }

    public String getNombreTipoE() {
        return nombreTipoE;
    }

    public void setNombreTipoE(String nombreTipoE) {
        this.nombreTipoE = nombreTipoE;
    }

}
