package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Zona;
import pe.edu.upc.brotessapp.repositories.IZonaRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IZonaService;

import java.util.List;

@Service
public class ZonaServiceImplement implements IZonaService {
    @Autowired
    private IZonaRepository zR;

    @Override
    public List<Zona> list() {
        return zR.findAll();
    }

    @Override
    public void insert(Zona z) {
        zR.save(z);
    }

    @Override
    public Zona listId(int id) {
        return zR.findById(id).orElse(new Zona());
    }

    @Override
    public void update(Zona z) {
        zR.save(z);
    }

    @Override
    public void delete(int id) {
    zR.deleteById(id);
    }

    @Override
    public List<Zona> zonasinAsig() {
        return zR.Zonasinasig();
    }

}
