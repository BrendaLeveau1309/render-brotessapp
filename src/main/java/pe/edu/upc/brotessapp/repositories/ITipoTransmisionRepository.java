package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.TipoTransmision;

import java.util.List;

@Repository
public interface ITipoTransmisionRepository extends JpaRepository<TipoTransmision, Integer> {

    //QUEARY: Identificar la cantidad de casos de contagios registrados para cada tipo de transmisión

    @Query(value = "SELECT \n" +
            "     t.id_tipot,\n" +
            "    t.transmision AS tipo_transmision,\n" +
            "    COUNT(c.id_contagio) AS cantidad_contagio\n" +
            "FROM \n" +
            "    contagios c\n" +
            "JOIN \n" +
            "    enfermedad e ON c.id_enfermedad = e.id_enfermedad\n" +
            "JOIN \n" +
            "    tipo_transmision t ON e.id_tipot = t.id_tipot\n" +
            "GROUP BY \n" +
            "    t.id_tipot,\n" +
            "    t.transmision\n" +
            "ORDER BY \n" +
            "    cantidad_contagio DESC",nativeQuery = true)
    public List<String[]> quantityContagioTransmision();
}
