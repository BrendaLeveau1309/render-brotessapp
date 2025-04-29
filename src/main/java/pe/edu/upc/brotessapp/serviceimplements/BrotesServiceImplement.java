package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Brotes;
import pe.edu.upc.brotessapp.repositories.IBrotesRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IBrotesService;


import java.time.LocalDate;
import java.util.List;

@Service
public class BrotesServiceImplement implements IBrotesService {
    @Autowired
    private IBrotesRepository bR;

    @Override
    public List<Brotes> list() {
        return bR.findAll();
    }

    @Override
    public void insert(Brotes u) {
        bR.save(u);
    }

    @Override
    public Brotes listId(int id) {
        return bR.findById(id).orElse(new Brotes());
    }

    @Override
    public void update(Brotes u) {
        bR.save(u);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public List<Brotes> buscarFechaInicioBrotes(LocalDate fechaInicio) {
        return bR.findByFechaInicio(fechaInicio);
    }

    @Override
    public List<String[]> cantidadBrotesTotalesPorZona(int anio, int mes) {
        return bR.cantidadBrotesTotalesPorZona(anio, mes);
    }
}
