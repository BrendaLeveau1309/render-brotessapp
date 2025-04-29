package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.repositories.INotificacionRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.INotificacionService;


import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository nR;

    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificacion u) {
        nR.save(u);
    }

    @Override
    public Notificacion listId(int id) {
        return nR.findById(id).orElse(new Notificacion());
    }

    @Override
    public void update(Notificacion u) {
        nR.save(u);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public List<String[]> UsuariosxNotificacion() {
        return nR.quantityUserbyNotif();
    }
}
