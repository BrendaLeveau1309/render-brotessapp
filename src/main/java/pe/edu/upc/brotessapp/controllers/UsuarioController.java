package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.Q_T1DTO;
import pe.edu.upc.brotessapp.dtos.UsuarioDTO;
import pe.edu.upc.brotessapp.dtos.UsuarioDTO_registro;
import pe.edu.upc.brotessapp.entities.Usuario;
import pe.edu.upc.brotessapp.serviceinterfaces.IRolService;
import pe.edu.upc.brotessapp.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;
    @Autowired
    private IRolService rS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    //insertar personas - autoridades
    @PostMapping("/registro-usuarios")
    public void insertar(@RequestBody UsuarioDTO_registro dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);

        Integer admid=rS.getidADMIN();
        if(admid!= null && u.getRol().getIdRol()==admid){
            throw new RuntimeException("Rol no permitido para registro");
        }

        u.setEnabled(true);
        uS.insert(u);
    }

    //registrar nuevos usuarios ADMIN
    @PostMapping("/crear-nadmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void crearadmin(@RequestBody UsuarioDTO_registro dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UsuarioDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        UsuarioDTO dto = m.map(uS.listId(id), UsuarioDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UsuarioDTO_registro dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);

        Integer admid=rS.getidADMIN();
        if(admid!= null && u.getRol().getIdRol()==admid){
            throw new RuntimeException("Rol no permitido para registro");
        }

        uS.update(u);
    }
    @GetMapping("/cantidad-usuarios-zona")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_T1DTO> cantidadUsuariosPorZona() {
        List<String[]> data = uS.cantidadUsuariosPorZona();

        return data.stream().map(fila -> {
            Q_T1DTO dto = new Q_T1DTO();
            dto.setDistrito(fila[0]);
            dto.setCantidadUsuarios(Integer.parseInt(fila[1]));
            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }
}
