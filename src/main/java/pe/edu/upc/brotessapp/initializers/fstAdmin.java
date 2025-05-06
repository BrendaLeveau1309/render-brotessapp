package pe.edu.upc.brotessapp.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.upc.brotessapp.entities.Rol;
import pe.edu.upc.brotessapp.entities.Usuario;
import pe.edu.upc.brotessapp.entities.Zona;
import pe.edu.upc.brotessapp.repositories.IRolRepository;
import pe.edu.upc.brotessapp.repositories.IUsuarioRepository;
import pe.edu.upc.brotessapp.repositories.IZonaRepository;

@Component
public class fstAdmin implements CommandLineRunner {
    @Autowired
    private IUsuarioRepository uR;
    @Autowired
    private IRolRepository rR;
    @Autowired
    private IZonaRepository zR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... zxc){ //creacion de admin al crear por primera vez la app
        //rol admin
        Rol admin = rR.findByRol("ADMIN");
        Zona zadmin = new Zona();
        if(admin == null){
            admin = new Rol();
            admin.setRol("ADMIN");
            rR.save(admin);

            //zona nueva para admin
            zadmin.setDistrito("adminnvbnpvboiui89076");
            zadmin.setProvincia("admincvmbnmpoicxz4235");
            zR.save(zadmin);
        }

        //usuario admin
        if(!uR.existsByUsername("ADMIN1")){
            Usuario u = new Usuario();
            u.setUsername("ADMIN1");
            u.setPassword(passwordEncoder.encode("ADMIN"));
            u.setRol(admin);
            u.setApellido("admin");
            u.setNombre("adminn");
            u.setEnabled(true);
            u.setZona(zadmin);
            uR.save(u);
        }

        //Demas roles
        Rol per = rR.findByRol("PERSONA");
        if(per == null){
            per = new Rol();
            per.setRol("PERSONA");
            rR.save(per);
        }
        Rol auto = rR.findByRol("AUTORIDAD");
        if(auto == null){
            auto = new Rol();
            auto.setRol("AUTORIDAD");
            rR.save(auto);
        }

    }

}
