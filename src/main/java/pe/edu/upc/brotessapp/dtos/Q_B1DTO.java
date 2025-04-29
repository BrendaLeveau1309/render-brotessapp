package pe.edu.upc.brotessapp.dtos;

public class Q_B1DTO {
    private String nameProvincia;
    private String nameDistrito;
    private int quantityBrotes;

    public String getNameProvincia() {
        return nameProvincia;
    }

    public void setNameProvincia(String nameProvincia) {
        this.nameProvincia = nameProvincia;
    }

    public String getNameDistrito() {
        return nameDistrito;
    }

    public void setNameDistrito(String nameDistrito) {
        this.nameDistrito = nameDistrito;
    }

    public int getQuantityBrotes() {
        return quantityBrotes;
    }

    public void setQuantityBrotes(int quantityBrotes) {
        this.quantityBrotes = quantityBrotes;
    }
}
