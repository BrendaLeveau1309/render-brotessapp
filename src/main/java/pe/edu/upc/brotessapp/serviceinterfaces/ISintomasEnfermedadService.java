package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.SintomasEnfermedad;
import java.util.List;

public interface ISintomasEnfermedadService {
    public List<SintomasEnfermedad> list();
    public void insert(SintomasEnfermedad Se);
    public SintomasEnfermedad listId(int id);
    public void update(SintomasEnfermedad Se);
    public void delete(int id);
}
