package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.EnfermedadDTO;
import pe.edu.upc.brotessapp.dtos.Q_D1DTO;
import pe.edu.upc.brotessapp.dtos.Q_D2DTO;
import pe.edu.upc.brotessapp.entities.Enfermedad;
import pe.edu.upc.brotessapp.serviceinterfaces.IEnfermedadService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermedades")
public class EnfermedadController {

    @Autowired
    private IEnfermedadService eS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<EnfermedadDTO> listar() {
        return eS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,EnfermedadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad e = m.map(dto,Enfermedad.class);
        eS.insert(e);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public EnfermedadDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        EnfermedadDTO dto = m.map(eS.listId(id), EnfermedadDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad u = m.map(dto, Enfermedad.class);
        eS.update(u);
    }
    //Q1D
    @GetMapping("/cantidad-enfermedades-provincia")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_D1DTO> cantidadEnfermedadesPorProvincia() {
        List<String[]> data = eS.cantidadEnfermedadesPorProvincia();
        List<Q_D1DTO> dtoList = new ArrayList<>();

        for (String[] fila : data) {
            Q_D1DTO dto = new Q_D1DTO();
            dto.setProvincia(fila[0]);
            dto.setCantidad(Integer.parseInt(fila[1]));
            dtoList.add(dto);
        }

        return dtoList;
    }
    //Q2D
    @GetMapping("/cantidad-transmision-provincia/{provincia}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_D2DTO> cantidadPorTransmisionProvincia(@PathVariable String provincia) {
        List<String[]> data = eS.cantidadEnfermedadesPorTransmisionEnProvincia(provincia);
        List<Q_D2DTO> dtoList = new ArrayList<>();

        for (String[] fila : data) {
            Q_D2DTO dto = new Q_D2DTO();
            dto.setNombreEnfermedad(fila[0]);
            dto.setTransmision(fila[1]);
            dto.setProvincia(fila[2]);
            dto.setCantidad(Integer.parseInt(fila[3]));
            dtoList.add(dto);
        }

        return dtoList;
    }

}
