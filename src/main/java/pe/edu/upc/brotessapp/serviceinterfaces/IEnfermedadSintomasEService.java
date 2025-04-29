package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;

public interface IEnfermedadSintomasEService {
    public List<EnfermedadSintomasE> list();
    public void insert(EnfermedadSintomasE x);
    public EnfermedadSintomasE listId(int id);
    public void update(EnfermedadSintomasE x);
    public void delete(int id);
    public List<String[]> listarSintomasPorEnfermedad();

}
