package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Contagios;
import pe.edu.upc.brotessapp.repositories.IContagiosRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IContagiosService;


import java.util.List;

@Service
public class ContagiosServiceImplement implements IContagiosService {
    @Autowired
    private IContagiosRepository cR;

    @Override
    public List<Contagios> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Contagios c) {
        cR.save(c);
    }

    @Override
    public Contagios listId(int id) {
        return cR.findById(id).orElse(new Contagios());
    }

    @Override
    public void update(Contagios c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<String[]> cantidadContagiosPorZona() {
        return cR.cantidadContagiosPorZona();
    }

    @Override
    public List<String[]> cantidadBrotesPorZona() {
        return cR.quantityBrotesByZona();
    }
}
