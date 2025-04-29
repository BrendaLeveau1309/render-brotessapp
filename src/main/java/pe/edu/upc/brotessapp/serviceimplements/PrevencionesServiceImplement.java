package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Prevenciones;
import pe.edu.upc.brotessapp.repositories.IPrevencionesRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IPrevencionesService;

import java.util.List;

@Service
public class PrevencionesServiceImplement implements IPrevencionesService {
    @Autowired
    private IPrevencionesRepository pR;

    @Override
    public List<Prevenciones> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Prevenciones u) {
        pR.save(u);
    }

    @Override
    public Prevenciones listId(int id) {
        return pR.findById(id).orElse(new Prevenciones());
    }

    @Override
    public void update(Prevenciones u) {
        pR.save(u);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public List<String[]> listarPrevencionesPorEnfermedad() {
        return pR.listarPrevencionesPorEnfermedad();
    }
}
