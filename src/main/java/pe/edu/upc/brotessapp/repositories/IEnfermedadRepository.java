package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Enfermedad;

@Repository
public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Integer> {


}
