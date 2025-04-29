package pe.edu.upc.brotessapp.serviceinterfaces;


import pe.edu.upc.brotessapp.entities.Enfermedad;

import java.util.List;

public interface IEnfermedadService {
    public List<Enfermedad> list();
    public void insert(Enfermedad e);
    public Enfermedad listId(int id);
    public void update(Enfermedad e);
    public void delete(int id);
}
