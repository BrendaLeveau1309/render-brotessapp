package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.ZonaDTO;
import pe.edu.upc.brotessapp.entities.Zona;
import pe.edu.upc.brotessapp.serviceinterfaces.IZonaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zonas")
public class ZonaController {

    @Autowired
    private IZonaService zS;

    @GetMapping("/lista-todo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ZonaDTO> listarZonas() {
        return zS.list().stream().map(z-> {
            ModelMapper m = new ModelMapper();
            return m.map(z, ZonaDTO.class);
        }).collect(Collectors.toList());
    }

    //solo zonas sin asignar para registro
    @GetMapping("/lista-sa")
    public List<ZonaDTO> listarZonassinAsignar() {
        return zS.zonasinAsig().stream().map(z-> {
            ModelMapper m = new ModelMapper();
            return m.map(z, ZonaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
   // @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody ZonaDTO dto) {
        ModelMapper m = new ModelMapper();
        Zona z = m.map(dto, Zona.class);
        zS.insert(z);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ZonaDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        ZonaDTO dto = m.map(zS.listId(id), ZonaDTO.class);
        return dto;
    }

    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ZonaDTO dto) {
        ModelMapper m = new ModelMapper();
        Zona z = m.map(dto, Zona.class);
        zS.update(z);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        zS.delete(id);
    }

}
