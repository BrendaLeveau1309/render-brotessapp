package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.entities.Usuario;

import java.util.List;


@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

    //Identificar la cantidad de personas que reciben cada notificación (el número de usuarios que abarca la zona de los contagios)
    @Query(value = "SELECT \n" +
            "    n.id_notificacion,\n" +
            "    n.titulo,\n" +
            "    COUNT(u.id_usuario) AS cantidad_usuarios_notificaos\n" +
            "FROM \n" +
            "    notificacion n\n" +
            "JOIN \n" +
            "    brotes b ON n.id_brote = b.id_brote\n" +
            "JOIN \n" +
            "    contagios c ON b.id_contagio = c.id_contagio\n" +
            "JOIN \n" +
            "    zona z_contagio ON c.id_zona = z_contagio.id_zona\n" +
            "JOIN \n" +
            "    usuario u \n" +
            "    ON z_contagio.provincia = (SELECT provincia FROM zona WHERE id_zona = u.id_zona)\n" +
            "    AND z_contagio.distrito = (SELECT distrito FROM zona WHERE id_zona = u.id_zona)\n" +
            "GROUP BY \n" +
            "    n.id_notificacion, n.titulo; ", nativeQuery = true)
    public List<String[]> quantityUserbyNotif();

    //identificar las notis para un usuario
    @Query(value = "select n.id_notificacion, n.fecha_envio, n.estado, n.titulo, n.contenido\n" +
            "from notificacion n\n" +
            "join brotes b on n.id_brote = b.id_brote\n" +
            "join contagios c on b.id_contagio = c.id_contagio\n" +
            "join zona z_contagio on c.id_zona = z_contagio.id_zona\n" +
            "join usuario u on \n" +
            "    z_contagio.provincia = (select provincia from zona where id_zona = u.id_zona)\n" +
            "    and z_contagio.distrito = (select distrito from zona where id_zona = u.id_zona)\n" +
            "where u.username = :username",nativeQuery = true)
    public List<String[]> notifByUsername(@Param("username") String username);

}
