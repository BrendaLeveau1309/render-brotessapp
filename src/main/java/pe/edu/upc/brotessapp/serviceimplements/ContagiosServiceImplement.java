package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.dtos.BrotesAutoDTO;
import pe.edu.upc.brotessapp.dtos.ContagiosDTO;
import pe.edu.upc.brotessapp.entities.Contagios;
import pe.edu.upc.brotessapp.repositories.IContagiosRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IBrotesService;
import pe.edu.upc.brotessapp.serviceinterfaces.IContagiosService;


import java.util.ArrayList;
import java.util.List;

@Service
public class ContagiosServiceImplement implements IContagiosService {
    @Autowired
    private IContagiosRepository cR;
    @Autowired
    private IBrotesService bS;

    @Override
    public List<Contagios> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Contagios c) {
        cR.save(c);
        //creacion brotes

        List<String[]> fila=cR.findUltimoContagioID();
        BrotesAutoDTO dto = new BrotesAutoDTO();
        for (String[]columna : fila) { //se va a recorrer
            dto.setIdContagio(Integer.parseInt(columna[0]));
            dto.setIdEnfermedad(Integer.parseInt(columna[1]));
            dto.setProvincia(columna[2]);
            dto.setDistrito(columna[3]);
        }
            System.out.println("Último contagio registrado: " + dto.getIdContagio());
            bS.generarBrotes(dto.getIdEnfermedad(), dto.getProvincia(), dto.getDistrito());

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
