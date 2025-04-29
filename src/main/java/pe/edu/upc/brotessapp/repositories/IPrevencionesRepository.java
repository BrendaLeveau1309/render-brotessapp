package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Prevenciones;

import java.util.List;


@Repository
public interface IPrevencionesRepository extends JpaRepository<Prevenciones, Integer> {
    //Medidas de prevención registradas por tipo de enfermedad para tener de forma precisa las prevenciones que se toman en cuenta por cada tipo de enfermedad.
    @Query(value = "SELECT e.nombre_TipoE AS tipoEnfermedad, p.descripcion_Prevencion AS descripcionPrevencion\n" +
            "FROM prevenciones p\n" +
            "INNER JOIN tipo_enfermedad e ON p.id_TipoE = e.id_TipoE\n" +
            "ORDER BY e.nombre_TipoE;", nativeQuery = true)
    List<String[]> listarPrevencionesPorEnfermedad();

}
