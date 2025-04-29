package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Enfermedad;
import pe.edu.upc.brotessapp.repositories.IEnfermedadRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IEnfermedadService;


import java.util.List;

@Service
public class EnfermedadServiceImplement implements IEnfermedadService {
    @Autowired
    private IEnfermedadRepository eR;

    @Override
    public List<Enfermedad> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Enfermedad u) {
        eR.save(u);
    }

    @Override
    public Enfermedad listId(int id) {
        return eR.findById(id).orElse(new Enfermedad());
    }

    @Override
    public void update(Enfermedad u) {
        eR.save(u);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
