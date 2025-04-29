package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoTransmision")
public class TipoTransmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoT;

    @Column(name = "transmision", nullable = false,length = 60)
    private String transmision;

    public TipoTransmision() {
    }

    public int getIdTipoT() {
        return idTipoT;
    }

    public void setIdTipoT(int idTipoT) {
        this.idTipoT = idTipoT;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}
