package pe.edu.upc.brotessapp.dtos;

import jakarta.persistence.Column;

public class TipoTransmisionDTO {
    private int idTipoT;
    private String transmision;

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
