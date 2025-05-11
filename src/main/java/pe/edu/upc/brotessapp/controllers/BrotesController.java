package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.BrotesDTO;
import pe.edu.upc.brotessapp.dtos.Q_B2DTO;
import pe.edu.upc.brotessapp.entities.Brotes;
import pe.edu.upc.brotessapp.serviceinterfaces.IBrotesService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brotes")
public class BrotesController {

    @Autowired
    private IBrotesService bS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<BrotesDTO> listar() {

        return bS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,BrotesDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public BrotesDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        BrotesDTO dto = m.map(bS.listId(id), BrotesDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody BrotesDTO dto) {
        ModelMapper m = new ModelMapper();
        Brotes u = m.map(dto, Brotes.class);
        bS.update(u);
    }

    @GetMapping("/fechasInicio")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<BrotesDTO> buscarFechaInicioBrotes(@RequestParam LocalDate fechaInicio) {
        return bS.buscarFechaInicioBrotes(fechaInicio).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y, BrotesDTO.class);
        }).collect(Collectors.toList());
    }


    //CON PARAMETROS
    @GetMapping("/cantidadBrotesTotales")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_B2DTO> cantidadBrotesPorZona(
            @RequestParam("anio") int anio,
            @RequestParam("mes") int mes) {

        List<Q_B2DTO> dtoLista = new ArrayList<>();
        List<String[]> filas = bS.cantidadBrotesTotalesPorZona(anio, mes);

        for (String[] columna : filas) {
            Q_B2DTO dto = new Q_B2DTO();
            dto.setAnio(Integer.parseInt(columna[0]));
            dto.setMes(Integer.parseInt(columna[1]));
            dto.setNameProvincia(columna[2]);
            dto.setQuantityBrotesTotales(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
