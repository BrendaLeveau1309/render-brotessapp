package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.SintomasEnfermedad;
import pe.edu.upc.brotessapp.repositories.ISintomasEnfermedadRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.ISintomasEnfermedadService;
import java.util.List;

@Service
public class SintomasEnfermedadImplement implements ISintomasEnfermedadService {
    @Autowired
    private ISintomasEnfermedadRepository sR;

    @Override
    public List<SintomasEnfermedad> list() {
        return sR.findAll();
    }

    @Override
    public void insert(SintomasEnfermedad s) {
        sR.save(s);
    }

    @Override
    public SintomasEnfermedad listId(int id) {
        return sR.findById(id).orElse(new SintomasEnfermedad());
    }

    @Override
    public void update(SintomasEnfermedad s) {
        sR.save(s);
    }

    @Override
    public void delete(int id) {
    sR.deleteById(id);
    }
}
