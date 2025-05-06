package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    public Rol findByRol(String rol);

    @Query(value = "select * from rol r where r.rol <> 'ADMIN'",nativeQuery = true)
    List<Rol> getRolAble();
    @Query(value = "select r.id_rol from rol r where r.rol = 'ADMIN'",nativeQuery = true)
    public Integer getidADMIN();


}
