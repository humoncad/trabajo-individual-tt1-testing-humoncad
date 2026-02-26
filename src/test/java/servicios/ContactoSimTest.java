package servicios;

import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ContactoSimTest {

    private ContactoSim contactoSim;

    @BeforeEach
    void setUp() {
        contactoSim = new ContactoSim();
    }

    @Test
    void solicitarSimulation() {

        Map<Integer, Integer> datosMap = new HashMap<>();
        datosMap.put(1, 10);

        int token = contactoSim.solicitarSimulation(new DatosSolicitud(datosMap));

        assertTrue(token >= 0);
    }

    @Test
    void descargarDatos() {
        DatosSimulation resultado = contactoSim.descargarDatos(999999);

        assertNull(resultado);
    }

    @Test
    void getEntities() {
        List<Entidad> entidades = contactoSim.getEntities();

        assertNotNull(entidades);
        assertEquals(3, entidades.size());
    }

    @Test
    void isValidEntityId() {
        assertTrue(contactoSim.isValidEntityId());
    }
}