package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.RolDTO;
import pe.edu.upc.brotessapp.entities.Rol;
import pe.edu.upc.brotessapp.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping("/lista")
    //@PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<RolDTO> listarRol() {
        return rS.getRolesPermitidos().stream().map(z-> { //se puede con filter
            ModelMapper m = new ModelMapper();
            return m.map(z, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol z = m.map(dto, Rol.class);
        rS.insert(z);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public RolDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        RolDTO dto = m.map(rS.listId(id), RolDTO.class);
        return dto;
    }

    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol z = m.map(dto, Rol.class);
        rS.update(z);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

}
