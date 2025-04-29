package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.brotessapp.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    //Contar usuarios por zona(distrito) para tener una lista amplia y actualizada de cuantos usuarios estan registrados por cada zona.
    @Query(value = "SELECT z.distrito, COUNT(u.id_usuario) AS cantidad_usuarios\n" +
            "FROM zona z\n" +
            "JOIN usuario u ON z.id_zona = u.id_zona\n" +
            "GROUP BY z.distrito;", nativeQuery = true)
    List<String[]> cantidadUsuariosPorZona();
}
