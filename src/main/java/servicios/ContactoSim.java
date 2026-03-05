package servicios;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ContactoSim implements InterfazContactoSim {

    private final Map<Integer, DatosSolicitud> solicitudes = new HashMap<>();

    private final List<Entidad> entidades = List.of(
            new Entidad(1, "Entidad A"),
            new Entidad(2, "Entidad B"),
            new Entidad(3, "Entidad C")
    );

    @Override
    public int solicitarSimulation(DatosSolicitud sol) {
        int token = new Random().nextInt(100000);
        solicitudes.put(token, sol);
        return token;
    }

    @Override
    public DatosSimulation descargarDatos(int ticket) {
        if (!solicitudes.containsKey(ticket)) {
            return null;
        }
        return new DatosSimulation();
    }

    @Override
    public List<Entidad> getEntities() {
        return entidades;
    }

    @Override
    public boolean isValidEntityId(int id) {
        boolean isValid = false;
        int i = 0;
        while (!isValid && i < entidades.size()) {
            if (entidades.get(i).getId() == id) {
                isValid = true;
            }
            i++;
        }
        return isValid;
    }
}
