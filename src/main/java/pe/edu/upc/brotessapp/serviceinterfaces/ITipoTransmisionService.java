package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.TipoTransmision;

import java.util.List;

public interface ITipoTransmisionService {
    public List<TipoTransmision> list();
    public void insert(TipoTransmision Te);
    public TipoTransmision listId(int id);
    public void update(TipoTransmision Te);
    public void delete(int id);

    public List<String[]> ContagiosxTipoTransmision();

}
