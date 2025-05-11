package pe.edu.upc.brotessapp.dtos;

public class Q_D1DTO {
    private String provincia;
    private String nombreEnfermedad;
    private long cantidadEnfermedades;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public long getCantidadEnfermedades() {
        return cantidadEnfermedades;
    }

    public void setCantidadEnfermedades(long cantidadEnfermedades) {
        this.cantidadEnfermedades = cantidadEnfermedades;
    }
}
