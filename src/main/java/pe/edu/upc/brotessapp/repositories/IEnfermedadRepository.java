package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Enfermedad;

import java.util.List;

@Repository
public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Integer> {

    @Query(value = " SELECT z.provincia, COUNT(e.id_enfermedad) " +
            " FROM enfermedad e " +
            " JOIN zona z ON e.id_zona = z.id_zona " +
            " GROUP BY z.provincia", nativeQuery = true)
    List<String[]> cantidadEnfermedadesPorProvincia();
    @Query(value = " SELECT e.nombre, tt.transmision, z.provincia, COUNT(e.id_enfermedad) " +
            " FROM enfermedad e " +
            " JOIN tipo_transmision tt ON e.id_tipot = tt.id_tipot " +
            " JOIN zona z ON e.id_zona = z.id_zona " +
            " WHERE z.provincia = :provincia " +
            " GROUP BY e.nombre, tt.transmision, z.provincia", nativeQuery = true)
    List<String[]> cantidadEnfermedadesPorTransmisionEnProvincia(@Param("provincia") String provincia);

}
