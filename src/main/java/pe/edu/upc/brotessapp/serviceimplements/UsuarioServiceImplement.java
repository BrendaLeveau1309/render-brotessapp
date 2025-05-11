package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Usuario;
import pe.edu.upc.brotessapp.repositories.IUsuarioRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService { //modificacion para que se lamacene la contra como hash
    @Autowired
    private IUsuarioRepository uR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario u) {

        u.setPassword(passwordEncoder.encode(u.getPassword())); //contra encriptada guardada
        uR.save(u);
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    @Override
    public void update(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        uR.save(u);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<String[]> cantidadUsuariosPorZona() {
        return uR.cantidadUsuariosPorZona();
    }

}
