package pe.edu.upc.brotessapp.dtos;

public class BrotesAutoDTO {
    private int idContagio;
    private int idEnfermedad;
    private String provincia;
    private String distrito;

    public int getIdContagio() {
        return idContagio;
    }

    public void setIdContagio(int idContagio) {
        this.idContagio = idContagio;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
