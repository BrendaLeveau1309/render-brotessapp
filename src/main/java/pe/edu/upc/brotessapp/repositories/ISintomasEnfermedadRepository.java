package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.SintomasEnfermedad;

import java.util.List;

@Repository
public interface ISintomasEnfermedadRepository extends JpaRepository<SintomasEnfermedad, Integer> {

}
