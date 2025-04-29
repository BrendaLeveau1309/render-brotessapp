package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.TipoEnfermedad;

@Repository
public interface ITipoEnfermedadRepository extends JpaRepository<TipoEnfermedad, Integer> {

}
