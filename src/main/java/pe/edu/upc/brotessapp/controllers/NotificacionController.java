package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.NotificacionDTO;
import pe.edu.upc.brotessapp.dtos.NotificacionPerDTO;
import pe.edu.upc.brotessapp.dtos.Q_W1DTO;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.entities.Usuario;
import pe.edu.upc.brotessapp.serviceinterfaces.INotificacionService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @GetMapping("/lista-todo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

//    @PostMapping("/inserta")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public void insertar(@RequestBody NotificacionDTO dto) {
//        ModelMapper m = new ModelMapper();
//        Notificacion u = m.map(dto,Notificacion.class);
//        nS.insert(u);
//    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public NotificacionDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listId(id), NotificacionDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion u = m.map(dto, Notificacion.class);
        nS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        nS.delete(id);
    }


    @GetMapping("/CantidadUsuarios_Notificados")
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/lista-cadapersona") //para usuario
    @PreAuthorize("hasAuthority('PERSONA')")
    public List<NotificacionPerDTO> listar(@AuthenticationPrincipal UserDetails userD) {
        List<NotificacionPerDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=nS.notifByUsername(userD.getUsername());
        for (String[] columna : fila) {
            NotificacionPerDTO dto=new NotificacionPerDTO();
            dto.setIdNotificacion(Integer.parseInt(columna[0]));
            dto.setFechaEnvio(LocalDate.parse(columna[1]));
            dto.setEstado(columna[2]);
            dto.setTitulo(columna[3]);
            dto.setContenido(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
