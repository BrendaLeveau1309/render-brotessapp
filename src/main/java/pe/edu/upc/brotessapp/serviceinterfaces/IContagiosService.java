package pe.edu.upc.brotessapp.serviceinterfaces;


import pe.edu.upc.brotessapp.entities.Contagios;

import java.util.List;

public interface IContagiosService {
    public List<Contagios> list();
    public void insert(Contagios c);
    public Contagios listId(int id);
    public void update(Contagios c);
    public void delete(int id);

    public List<String[]> cantidadContagiosPorZona();
    public List<String[]> cantidadBrotesPorZona();

}
