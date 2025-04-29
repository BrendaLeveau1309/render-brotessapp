package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.Q_W2DTO;
import pe.edu.upc.brotessapp.dtos.TipoTransmisionDTO;
import pe.edu.upc.brotessapp.entities.TipoTransmision;
import pe.edu.upc.brotessapp.serviceinterfaces.ITipoTransmisionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiposT")
public class TipoTransmisionController {

    @Autowired
    private ITipoTransmisionService tS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<TipoTransmisionDTO> listartiposE() {
        return tS.list().stream().map(t-> {//expresion lambda para cada elemento - transformacion
            ModelMapper m = new ModelMapper();
            return m.map(t, TipoTransmisionDTO.class);
        }).collect(Collectors.toList()); //al final hace que toda la coleccion se tome como un tolist
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoTransmisionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransmision t = m.map(dto, TipoTransmision.class);
        tS.insert(t);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public TipoTransmisionDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        TipoTransmisionDTO dto = m.map(tS.listId(id), TipoTransmisionDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoTransmisionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransmision z = m.map(dto, TipoTransmision.class);
        tS.update(z);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }


    @GetMapping("/CantidadContagios_TipoTransmision")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_W2DTO> cantidad(){
        List<Q_W2DTO> dtoLista=new ArrayList<>();
        List<String[]> fila=tS.ContagiosxTipoTransmision(); //todo lo que me devuelve el queary se almacena aqui
        for (String[]columna : fila) { //se va a recorrer
            Q_W2DTO dto=new Q_W2DTO();
            dto.setId_tipotransmision(Integer.parseInt(columna[0])); //int id de la transmision
            dto.setNombre_transmision(columna[1]); //nombre tipo transmision
            dto.setCantidad_contagios(Integer.parseInt(columna[2])); //cantidad de contagios encontrado
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
