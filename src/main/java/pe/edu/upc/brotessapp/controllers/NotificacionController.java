package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.NotificacionDTO;
import pe.edu.upc.brotessapp.dtos.Q_W1DTO;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.serviceinterfaces.INotificacionService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion u = m.map(dto,Notificacion.class);
        nS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public NotificacionDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listId(id), NotificacionDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion u = m.map(dto, Notificacion.class);
        nS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        nS.delete(id);
    }


    @GetMapping("/CantidadUsuarios_Notificados")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_W1DTO> cantidad(){
        List<Q_W1DTO> dtoLista=new ArrayList<>();
        List<String[]> fila=nS.UsuariosxNotificacion(); //todo lo que me devuelve el queary se almacena aqui
        for (String[]columna : fila) { //se va a recorrer
            Q_W1DTO dto=new Q_W1DTO();
            dto.setId_notificacion(Integer.parseInt(columna[0])); //int id de la noti
            dto.setTitulo_Notificacion(columna[1]); //titulo dew la noti
            dto.setCantidad_UsuariosNotificados(Integer.parseInt(columna[2])); //cantidad usuarios
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
