package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.PrevencionesDTO;
import pe.edu.upc.brotessapp.dtos.Q_M2DTO;
import pe.edu.upc.brotessapp.entities.Prevenciones;
import pe.edu.upc.brotessapp.serviceinterfaces.IPrevencionesService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prevenciones")
public class PrevencionesController {

    @Autowired
    private IPrevencionesService pS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<PrevencionesDTO> listar() {
        return pS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,PrevencionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody PrevencionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Prevenciones u = m.map(dto,Prevenciones.class);
        pS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public PrevencionesDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PrevencionesDTO dto = m.map(pS.listId(id), PrevencionesDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody PrevencionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Prevenciones u = m.map(dto, Prevenciones.class);
        pS.update(u);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/listarPrevencionesPorEnfermedad")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_M2DTO> listarPrevencionesPorEnfermedad() {
        return pS.listarPrevencionesPorEnfermedad().stream().map(x -> {
            Q_M2DTO dto = new Q_M2DTO();
            dto.setNombreEnfermedad(x[0]);  // El primer índice corresponde al nombre de la enfermedad
            dto.setDescripcionPrevencion(x[1]);  // El segundo índice corresponde a la descripción de la prevención
            return dto;
        }).collect(Collectors.toList());
    }
}
