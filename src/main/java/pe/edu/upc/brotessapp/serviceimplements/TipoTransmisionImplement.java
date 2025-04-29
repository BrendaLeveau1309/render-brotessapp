package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.TipoTransmision;
import pe.edu.upc.brotessapp.repositories.ITipoTransmisionRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.ITipoTransmisionService;

import java.util.List;

@Service
public class TipoTransmisionImplement implements ITipoTransmisionService {
    @Autowired
    private ITipoTransmisionRepository tR;

    @Override
    public List<TipoTransmision> list() {
        return tR.findAll();
    }

    @Override
    public void insert(TipoTransmision t) {
        tR.save(t);
    }

    @Override
    public TipoTransmision listId(int id) {
        return tR.findById(id).orElse(new TipoTransmision());
    }

    @Override
    public void update(TipoTransmision t) {
        tR.save(t);
    }

    @Override
    public void delete(int id) {
    tR.deleteById(id);
    }

    @Override
    public List<String[]> ContagiosxTipoTransmision() {
        return tR.quantityContagioTransmision();
    }
}
