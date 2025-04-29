package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.TipoEnfermedadDTO;
import pe.edu.upc.brotessapp.entities.TipoEnfermedad;
import pe.edu.upc.brotessapp.serviceinterfaces.ITipoEnfermedadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiposE")
public class TipoEnfermedadController {

    @Autowired
    private ITipoEnfermedadService tS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<TipoEnfermedadDTO> listartiposE() {
        return tS.list().stream().map(t-> {
            ModelMapper m = new ModelMapper();
            return m.map(t, TipoEnfermedadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoEnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoEnfermedad t = m.map(dto, TipoEnfermedad.class);
        tS.insert(t);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public TipoEnfermedadDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        TipoEnfermedadDTO dto = m.map(tS.listId(id), TipoEnfermedadDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoEnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoEnfermedad z = m.map(dto, TipoEnfermedad.class);
        tS.update(z);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }



}
