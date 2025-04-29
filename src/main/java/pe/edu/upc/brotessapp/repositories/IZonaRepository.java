package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Zona;

@Repository
public interface IZonaRepository extends JpaRepository<Zona, Integer> {

    //@Query("Select z from Zona z where z.provincia like %:n%")

}
