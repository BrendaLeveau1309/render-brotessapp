package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.Zona;

import java.util.List;

public interface IZonaService {
    public List<Zona> list();
    public void insert(Zona z);
    public Zona listId(int id);
    public void update(Zona z);
    public void delete(int id);
    public List<Zona> zonasinAsig();
}
