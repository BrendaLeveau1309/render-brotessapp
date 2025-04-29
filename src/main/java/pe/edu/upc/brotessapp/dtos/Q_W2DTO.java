package pe.edu.upc.brotessapp.dtos;

public class Q_W2DTO {
    private int id_tipotransmision;
    private String nombre_transmision;
    private int cantidad_contagios;

    public int getId_tipotransmision() {
        return id_tipotransmision;
    }

    public void setId_tipotransmision(int id_tipotransmision) {
        this.id_tipotransmision = id_tipotransmision;
    }

    public String getNombre_transmision() {
        return nombre_transmision;
    }

    public void setNombre_transmision(String nombre_transmision) {
        this.nombre_transmision = nombre_transmision;
    }

    public int getCantidad_contagios() {
        return cantidad_contagios;
    }

    public void setCantidad_contagios(int cantidad_contagios) {
        this.cantidad_contagios = cantidad_contagios;
    }
}
