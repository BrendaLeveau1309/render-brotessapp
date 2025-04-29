package pe.edu.upc.brotessapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EnfermedadSintomasE")
public class EnfermedadSintomasE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnfermedadSE;

    @ManyToOne
    @JoinColumn(name = "idSintomasE")
    private SintomasEnfermedad sintomasEnfermedad;

    @ManyToOne
    @JoinColumn(name = "idEnfermedad")
    private Enfermedad enfermedad;

    public EnfermedadSintomasE() {
    }

    public EnfermedadSintomasE(int idEnfermedadSE, String nivelGravedad, String frecuencia, SintomasEnfermedad sintomasEnfermedad, Enfermedad enfermedad) {
        this.idEnfermedadSE = idEnfermedadSE;
        this.sintomasEnfermedad = sintomasEnfermedad;
        this.enfermedad = enfermedad;
    }

    public int getIdEnfermedadSE() {
        return idEnfermedadSE;
    }

    public void setIdEnfermedadSE(int idEnfermedadSE) {
        this.idEnfermedadSE = idEnfermedadSE;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public SintomasEnfermedad getSintomasEnfermedad() {
        return sintomasEnfermedad;
    }

    public void setSintomasEnfermedad(SintomasEnfermedad sintomasEnfermedad) {
        this.sintomasEnfermedad = sintomasEnfermedad;
    }

}
