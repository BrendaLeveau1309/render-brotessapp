package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol r);
    public Rol listId(int id);
    public void update(Rol r);
//    public void delete(int id);
    public List<Rol> getRolesPermitidos();
    public Integer getidADMIN();
}
