package pe.edu.upc.brotessapp.dtos;

public class Q_B2DTO {
    private Integer  anio;
    private Integer  mes;
    private String nameProvincia;
    private int quantityBrotesTotales;

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNameProvincia() {
        return nameProvincia;
    }

    public void setNameProvincia(String nameProvincia) {
        this.nameProvincia = nameProvincia;
    }

    public int getQuantityBrotesTotales() {
        return quantityBrotesTotales;
    }

    public void setQuantityBrotesTotales(int quantityBrotesTotales) {
        this.quantityBrotesTotales = quantityBrotesTotales;
    }
}
