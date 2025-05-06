package pe.edu.upc.brotessapp.serviceinterfaces;


import pe.edu.upc.brotessapp.entities.Brotes;

import java.time.LocalDate;
import java.util.List;

public interface IBrotesService {
    public List<Brotes> list();
//    public void insert(Brotes x);
    public Brotes listId(int id);
    public void update(Brotes x);
    public void delete(int id);

    public List<Brotes> buscarFechaInicioBrotes(LocalDate fechaInicio);
    public List<String[]> cantidadBrotesTotalesPorZona(int anio, int mes);
    public void generarBrotes(int idEnfermedad, String provincia, String distrito);
}
