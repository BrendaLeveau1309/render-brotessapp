package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.TipoEnfermedad;

import java.util.List;

public interface ITipoEnfermedadService {
    public List<TipoEnfermedad> list();
    public void insert(TipoEnfermedad Te);
    public TipoEnfermedad listId(int id);
    public void update(TipoEnfermedad Te);
    public void delete(int id);
}
