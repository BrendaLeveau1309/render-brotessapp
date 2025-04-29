package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Contagios;

import java.util.List;

@Repository
public interface IContagiosRepository extends JpaRepository<Contagios, Integer> {

    //Zonas con más contagios para saber en que zonas se registran mas contagios.
    @Query(value = "SELECT z.distrito, COUNT(c.id_contagio) " +
            "FROM contagios c " +
            "INNER JOIN zona z ON c.id_zona = z.id_zona " +
            "GROUP BY z.distrito " +
            "ORDER BY COUNT(c.id_contagio) DESC", nativeQuery = true)
    List<String[]> cantidadContagiosPorZona();

    //Cantidad de Brotes Activos por Zona (sin fecha de finalización)
    @Query(value = "SELECT \n" +
            "    z.provincia,\n" +
            "    z.distrito,\n" +
            "    COUNT(DISTINCT b.id_brote) AS cantidad_brotes_activos\n" +
            "FROM \n" +
            "    brotes b\n" +
            "JOIN \n" +
            "    contagios c ON b.id_contagio = c.id_contagio\n" +
            "JOIN \n" +
            "    zona z ON c.id_zona = z.id_zona\n" +
            "WHERE \n" +
            "    b.fecha_fin IS NULL\n" +
            "GROUP BY \n" +
            "    z.provincia, z.distrito\n" +
            "ORDER BY \n" +
            "    cantidad_brotes_activos DESC;",nativeQuery = true)
    public List<String[]> quantityBrotesByZona();
}
