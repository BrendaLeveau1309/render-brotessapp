package pe.edu.upc.brotessapp.dtos;

import pe.edu.upc.brotessapp.entities.TipoEnfermedad;
import pe.edu.upc.brotessapp.entities.Usuario;

public class PrevencionesDTO {
    private int idPrevencion;


    private String descripcionPrevencion;

    private TipoEnfermedad tipoEnfermedad;

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
