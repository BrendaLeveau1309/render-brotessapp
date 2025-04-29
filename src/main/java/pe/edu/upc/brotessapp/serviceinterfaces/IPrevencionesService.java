package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.Prevenciones;

import java.util.List;

public interface IPrevencionesService {
    public List<Prevenciones> list();
    public void insert(Prevenciones p);
    public Prevenciones listId(int id);
    public void update(Prevenciones p);
    public void delete(int id);
    public List<String[]> listarPrevencionesPorEnfermedad();

}
