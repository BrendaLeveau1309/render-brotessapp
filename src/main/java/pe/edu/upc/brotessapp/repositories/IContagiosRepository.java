package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //automat-b
    @Query(value = "SELECT * FROM contagios \n" +
            "WHERE id_enfermedad = :idEnfermedad \n" +
            "AND id_zona = (SELECT id_zona FROM zona WHERE provincia = :provincia AND distrito = :distrito LIMIT 1) \n" +
            "ORDER BY fecha_contagio ASC\n" +
            "LIMIT 1;", nativeQuery = true)
    public Contagios PrimerContagioenzona(@Param("idEnfermedad") int idEnfermedad, @Param("provincia") String provincia, @Param("distrito") String distrito);

    @Query(value = "SELECT c.id_contagio, c.id_enfermedad, z.provincia, z.distrito " +
            "FROM contagios c " +
            "JOIN zona z ON c.id_zona = z.id_zona " +
            "ORDER BY c.id_contagio DESC LIMIT 1", nativeQuery = true)
    public List<String[]> findUltimoContagioID();


}
