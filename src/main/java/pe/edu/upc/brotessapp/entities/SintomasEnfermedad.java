package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SintomasEnfermedad")
public class SintomasEnfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSintomasE;

    @Column(name = "nombreSintoma", nullable = false,length = 100)
    private String nombreSintoma;

    public SintomasEnfermedad() {
    }

    public SintomasEnfermedad(int idSintomasE, String nombreSintoma) {
        this.idSintomasE = idSintomasE;
        this.nombreSintoma = nombreSintoma;
    }

    public int getIdSintomasE() {
        return idSintomasE;
    }

    public void setIdSintomasE(int idSintomasE) {
        this.idSintomasE = idSintomasE;
    }

    public String getNombreSintoma() {
        return nombreSintoma;
    }

    public void setNombreSintoma(String nombreSintoma) {
        this.nombreSintoma = nombreSintoma;
    }
}
