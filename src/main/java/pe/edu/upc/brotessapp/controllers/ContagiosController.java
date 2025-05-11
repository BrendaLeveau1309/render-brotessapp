package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.ContagiosDTO;
import pe.edu.upc.brotessapp.dtos.Q_B1DTO;
import pe.edu.upc.brotessapp.dtos.Q_T2DTO;
import pe.edu.upc.brotessapp.entities.Contagios;
import pe.edu.upc.brotessapp.serviceinterfaces.IContagiosService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contagios")
public class ContagiosController {

    @Autowired
    private IContagiosService cS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ContagiosDTO> listar() {
        return cS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,ContagiosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('PERSONA')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody ContagiosDTO dto) {
        ModelMapper m = new ModelMapper();
        Contagios c = m.map(dto,Contagios.class);
        cS.insert(c);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ContagiosDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ContagiosDTO dto = m.map(cS.listId(id), ContagiosDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ContagiosDTO dto) {
        ModelMapper m = new ModelMapper();
        Contagios c = m.map(dto, Contagios.class);
        cS.update(c);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }

    @GetMapping("/cantidad-contagios-zona")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_T2DTO> cantidadContagiosPorZona() {
        List<String[]> data = cS.cantidadContagiosPorZona();
        return data.stream().map(fila -> {
            Q_T2DTO dto = new Q_T2DTO();
            dto.setDistrito(fila[0]);
            dto.setCantidadContagios(Integer.parseInt(fila[1]));
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidades-BrotesActivos-PorZona")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_B1DTO> cantidad(){
        List<Q_B1DTO> dtoLista=new ArrayList<>();
        List<String[]> fila=cS.cantidadBrotesPorZona();
        for(String[]columna:fila){
            Q_B1DTO dto=new Q_B1DTO();
            dto.setNameProvincia(columna[0]);
            dto.setNameDistrito(columna[1]);
            dto.setQuantityBrotes(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
