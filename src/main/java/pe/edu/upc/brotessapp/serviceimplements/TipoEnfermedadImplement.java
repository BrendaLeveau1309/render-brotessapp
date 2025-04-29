package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.TipoEnfermedad;
import pe.edu.upc.brotessapp.repositories.ITipoEnfermedadRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.ITipoEnfermedadService;

import java.util.List;

@Service
public class TipoEnfermedadImplement implements ITipoEnfermedadService {
    @Autowired
    private ITipoEnfermedadRepository tR;

    @Override
    public List<TipoEnfermedad> list() {
        return tR.findAll();
    }

    @Override
    public void insert(TipoEnfermedad t) {
        tR.save(t);
    }

    @Override
    public TipoEnfermedad listId(int id) {
        return tR.findById(id).orElse(new TipoEnfermedad());
    }

    @Override
    public void update(TipoEnfermedad t) {
        tR.save(t);
    }

    @Override
    public void delete(int id) {
    tR.deleteById(id);
    }
}
