package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.SintomasEnfermedadDTO;
import pe.edu.upc.brotessapp.entities.SintomasEnfermedad;
import pe.edu.upc.brotessapp.serviceinterfaces.ISintomasEnfermedadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sintomasE")
public class SintomasEnfermedadController {

    @Autowired
    private ISintomasEnfermedadService sS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<SintomasEnfermedadDTO> listarsintomasE() {
        return sS.list().stream().map(s-> {//expresion lambda para cada elemento - transformacion
            ModelMapper m = new ModelMapper();
            return m.map(s, SintomasEnfermedadDTO.class);
        }).collect(Collectors.toList()); //al final hace que toda la coleccion se tome como un tolist
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody SintomasEnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        SintomasEnfermedad s = m.map(dto, SintomasEnfermedad.class);
        sS.insert(s);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public SintomasEnfermedadDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        SintomasEnfermedadDTO dto = m.map(sS.listId(id), SintomasEnfermedadDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody SintomasEnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        SintomasEnfermedad s = m.map(dto, SintomasEnfermedad.class);
        sS.update(s);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        sS.delete(id);
    }


}
