package tp1.punto1;

import org.junit.jupiter.api.Test;
import tp1.punto1.modelo.Concurso;
import tp1.punto1.modelo.Participante;
import tp1.punto1.persistencia.EnBaseDeDatosRegistroDeInscripcion;

import java.time.LocalDate;

import static junit.framework.Assert.*;

public class ConcursoTest {

    @Test
    public void inscripcionAConcurso() {
        EnBaseDeDatosRegistroDeInscripcion registro = new EnBaseDeDatosRegistroDeInscripcion();
        LocalDate fechaInicioConcurso = LocalDate.of(2024, 3, 15);
        LocalDate fechaFinConcurso = LocalDate.of(2024, 4, 30);
        Participante participante1 = new Participante("Cristian", "Apellido", 18130760);
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso, registro);
        participante1.inscribirseAConcurso(concurso1);

        assertTrue(concurso1.estaInscripto(participante1));
        assertEquals("04/04/2024 22:02,18130760,3", registro.contenido());
    }

    @Test
    public void inscripcionAConcursoPrimerDia() {
        EnBaseDeDatosRegistroDeInscripcion registro = new EnBaseDeDatosRegistroDeInscripcion();
        LocalDate fechaInicioConcurso = LocalDate.now();
        LocalDate fechaFinConcurso = LocalDate.of(2024, 4, 30);
        Participante participante1 = new Participante("Alan", "Apellido2", 44425020);
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso, registro);
        participante1.inscribirseAConcurso(concurso1);
        assertEquals(10, participante1.mostrarPuntaje());
    }

    @Test
    public void inscripcionFueraDeRango() {
        EnBaseDeDatosRegistroDeInscripcion registro = new EnBaseDeDatosRegistroDeInscripcion();
        LocalDate fechaInicioConcurso = LocalDate.of(2023, 3, 20);
        LocalDate fechaFinConcurso = LocalDate.of(2023, 4, 30);
        Participante participante1 = new Participante("Agustin", "Apellido3", 12151150);
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso, registro);
        participante1.inscribirseAConcurso(concurso1);

        assertFalse(concurso1.estaInscripto(participante1));

    }


}
