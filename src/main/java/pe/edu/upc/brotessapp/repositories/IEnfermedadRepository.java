package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Enfermedad;

import java.util.List;

@Repository
public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Integer> {

    @Query(value = " SELECT z.provincia, e.nombre AS nombre_enfermedad, \n" +
            " COUNT(e.id_enfermedad) AS cantidad_enfermedades\n" +
            " FROM enfermedad e\n" +
            " JOIN zona z ON e.id_zona = z.id_zona\n" +
            " WHERE LOWER(z.provincia) = LOWER(provincia)\n" +
            " GROUP BY z.provincia, e.nombre;", nativeQuery = true)
    List<String[]> cantidadEnfermedadesPorProvincia(@Param("provincia") String provincia);

    @Query(value = " SELECT e.nombre, tt.transmision, z.provincia, \n" +
            " COUNT(e.id_enfermedad) AS cantidad\n" +
            " FROM enfermedad e\n" +
            " JOIN tipo_transmision tt ON e.id_tipot = tt.id_tipot\n" +
            " JOIN zona z ON e.id_zona = z.id_zona\n" +
            " WHERE LOWER(z.provincia) = LOWER(:provincia)\n" +
            " GROUP BY e.nombre, tt.transmision, z.provincia;", nativeQuery = true)
    List<String[]> cantidadEnfermedadesPorTransmisionEnProvincia(@Param("provincia") String provincia);
}

