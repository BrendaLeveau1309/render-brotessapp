package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Zona;

import java.util.List;

@Repository
public interface IZonaRepository extends JpaRepository<Zona, Integer> {

    @Query(value = "select * from zona z\n" +
            "where z.id_zona\n" +
            "not in (select u.id_zona from usuario u)",nativeQuery = true)
    List<Zona> Zonasinasig();

}
