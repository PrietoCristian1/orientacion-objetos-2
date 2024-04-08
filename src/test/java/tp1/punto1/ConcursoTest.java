package tp1.punto1;

import org.junit.jupiter.api.Test;
import tp1.punto1.exceptions.InscripcionDuplicadoException;
import tp1.punto1.exceptions.InscripcionFueraDeRangoException;
import tp1.punto1.modelo.Concurso;
import tp1.punto1.modelo.Participante;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConcursoTest {

    @Test
    public void inscripcionAConcurso() {
        //Informacion del concurso
        String mailConcurso = "concursoajedrez@gmail.com";
        String nombreConcurso = "Torneo de Ajedrez";
        //Se crea el proveedor de fecha y se crean a partir de el, el rango que tendra el concurso
        FakeProveedorDeFechas proveedor = new FakeProveedorDeFechas();
        LocalDateTime fechaInicioInscripcion = proveedor.fecha().minusDays(3L);
        LocalDateTime fechaFinInscripcion = proveedor.fecha().plusDays(3L);

        FakeRegistroDeInscripcion registroFake = new FakeRegistroDeInscripcion();
        Participante juancito = new Participante("Juan", "Gonzalez", 44488123, "juancito123@gmail.com");
        Concurso concursoAjedrez = new Concurso(fechaInicioInscripcion, fechaFinInscripcion, mailConcurso, nombreConcurso,
                registroFake, new FakeEnvioDeCorreo(), proveedor);
        try {
            juancito.inscribirseAConcurso(concursoAjedrez);
        } catch (InscripcionFueraDeRangoException | InscripcionDuplicadoException e) {
            throw new RuntimeException(e);
        }

        assertTrue(concursoAjedrez.estaInscripto(juancito));
        assertTrue(registroFake.comienzaCon("2024-10-15T20:25:45"));
    }

    @Test
    public void inscripcionAConcursoPrimerDia() {
        //Informacion del concurso
        String mailConcurso = "concursofutbol@gmail.com";
        String nombreConcurso = "Torneo de Futbol";
        //Se crea el proveedor de fecha y se crean a partir de el, el rango que tendra el concurso
        FakeProveedorDeFechas proveedor = new FakeProveedorDeFechas();
        LocalDateTime fechaInicioInscripcion = proveedor.fecha();
        LocalDateTime fechaFinInscripcion = proveedor.fecha().plusDays(3L);

        FakeRegistroDeInscripcion registroFake = new FakeRegistroDeInscripcion();
        Participante federico = new Participante("Federico", "Gonzalez", 22254780, "federicog@gmail.com");
        Concurso concursoDeFutbol = new Concurso(fechaInicioInscripcion, fechaFinInscripcion, mailConcurso, nombreConcurso,
                registroFake, new FakeEnvioDeCorreo(), proveedor);
        try {
            federico.inscribirseAConcurso(concursoDeFutbol);
        } catch (InscripcionFueraDeRangoException | InscripcionDuplicadoException e) {
            throw new RuntimeException(e);
        }

        assertTrue(concursoDeFutbol.estaInscripto(federico));
        assertTrue(registroFake.comienzaCon("2024-10-15T20:25:45"));
        assertTrue(concursoDeFutbol.esPrimerDiaDeInscripcion(new FakeProveedorDeFechas().fecha()));
    }

    @Test
    public void inscripcionFueraDeRango() {
        //Informacion del concurso
        String mailConcurso = "concursocounterstrike@gmail.com";
        String nombreConcurso = "Torneo de Counter Strike";
        //Se crea el proveedor de fecha y se crean a partir de el, el rango que tendra el concurso
        FakeProveedorDeFechas proveedor = new FakeProveedorDeFechas();
        LocalDateTime fechaInicioInscripcion = proveedor.fecha().plusDays(7L);
        LocalDateTime fechaFinInscripcion = proveedor.fecha().plusDays(14L);

        FakeRegistroDeInscripcion registroFake = new FakeRegistroDeInscripcion();
        Participante alan = new Participante("Alan", "Pereira", 34560122, "pereiraalan@gmail.com");
        Concurso concursoDeFutbol = new Concurso(fechaInicioInscripcion, fechaFinInscripcion, mailConcurso, nombreConcurso,
                registroFake, new FakeEnvioDeCorreo(), proveedor);

        assertThrows(InscripcionFueraDeRangoException.class, () -> alan.inscribirseAConcurso(concursoDeFutbol));
    }


}
