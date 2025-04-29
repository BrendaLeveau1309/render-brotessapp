package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario u);
    public Usuario listId(int id);
    public void update(Usuario u);
    public void delete(int id);
    public List<String[]> cantidadUsuariosPorZona();

}
