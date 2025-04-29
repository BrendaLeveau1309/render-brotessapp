package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;


@Repository
public interface IEnfermedadSintomasERepository extends JpaRepository<EnfermedadSintomasE, Integer> {
    //Síntomas más comunes por enfermedad, para tener una lista con los sintomas que hay por enfermedad.
    @Query(value = "SELECT e.nombre AS nombreenfermedad, s.nombre_sintoma AS nombresintoma\n" +
            "FROM enfermedad_sintomase ese\n" +
            "INNER JOIN enfermedad e ON ese.id_enfermedad = e.id_enfermedad\n" +
            "INNER JOIN sintomas_enfermedad s ON ese.id_sintomase = s.id_sintomase\n" +
            "ORDER BY e.nombre;", nativeQuery = true)
    List<String[]> listarSintomasPorEnfermedad();

}
