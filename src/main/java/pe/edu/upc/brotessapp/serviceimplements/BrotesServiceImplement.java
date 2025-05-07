package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.Brotes;
import pe.edu.upc.brotessapp.entities.Contagios;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.repositories.IBrotesRepository;
import pe.edu.upc.brotessapp.repositories.IContagiosRepository;
import pe.edu.upc.brotessapp.repositories.INotificacionRepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IBrotesService;



import java.time.LocalDate;
import java.util.List;

@Service
public class BrotesServiceImplement implements IBrotesService {
    @Autowired
    private IBrotesRepository bR;
    @Autowired
    private IContagiosRepository cR;
    @Autowired
    private INotificacionRepository nR;

    @Override
    public List<Brotes> list() {
        return bR.findAll();
    }

//    @Override
//    public void insert(Brotes u) {
//        bR.save(u);
//    }

    @Override
    public Brotes listId(int id) {
        return bR.findById(id).orElse(new Brotes());
    }

    @Override
    public void update(Brotes u) {
        bR.save(u);
    }

//    @Override
//    public void delete(int id) {
//        bR.deleteById(id);
//    }

    @Override
    public List<Brotes> buscarFechaInicioBrotes(LocalDate fechaInicio) {
        return bR.findByFechaInicio(fechaInicio);
    }

    @Override
    public List<String[]> cantidadBrotesTotalesPorZona(int anio, int mes) {
        return bR.cantidadBrotesTotalesPorZona(anio, mes);
    }

    //automatico brotes y notificaciones
    @Override
    public void generarBrotes(int idEnfermedad, String provincia, String distrito) {
        System.out.println("Valoresss " + idEnfermedad + " " + provincia + " " + distrito);
        int cContagios = bR.contagiosporzonayenfermedad(idEnfermedad, provincia, distrito);
        int bExiste = bR.existeBroteEnZona(idEnfermedad, provincia, distrito);
        System.out.println("Contagios por zona: " + cContagios);
        System.out.println("Brote existe: " + bExiste);
        if (cContagios >= 5 && bExiste == 0) { //genera el brote al ser las dos verdaderas
            Contagios pContagio = cR.PrimerContagioenzona(idEnfermedad, provincia, distrito);
            Brotes nuevoB = new Brotes();
            nuevoB.setFechaInicio(pContagio.getFechaContagio());
            nuevoB.setFechaFin(null);
            nuevoB.setContagios(pContagio);
            bR.save(nuevoB);

            //Generacion de noti apartir del brote
            Notificacion nuevaN = new Notificacion();
            nuevaN.setFechaEnvio(LocalDate.now());
            nuevaN.setBrotes(nuevoB);
            nuevaN.setEstado("Activo");
            nuevaN.setTitulo("Nueva Alerta de Brote: " + pContagio.getEnfermedad().getNombre());
            nuevaN.setContenido("Se ha detectado un nuevo Brote de " + pContagio.getEnfermedad().getNombre()+ " encontrado en la provincia de "+provincia+", distrito de "+distrito+". Se le recomienda mantenerse Alerta y reportar síntomas si los tuviese.");
            nR.save(nuevaN);
        }
    }

}
