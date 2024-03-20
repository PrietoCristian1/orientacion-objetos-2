package tp1.punto1;

import org.junit.jupiter.api.Test;
import tp1.punto1.Concurso;
import tp1.punto1.Participante;

import java.time.LocalDate;

import static junit.framework.Assert.*;

public class ConcursoTest {

    @Test
    public void inscripcionAConcurso(){
        LocalDate fechaInicioConcurso = LocalDate.of(2024, 3, 15);
        LocalDate fechaFinConcurso = LocalDate.of(2024, 4, 30);
        Participante participante1 = new Participante("Cristian", "ElMio");
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso);
        participante1.inscribirseAConcurso(concurso1);

        assertTrue(concurso1.estaInscripto(participante1));
    }

    @Test
    public void inscripcionAConcursoPrimerDia(){

        LocalDate fechaInicioConcurso = LocalDate.now();
        LocalDate fechaFinConcurso = LocalDate.of(2024, 4, 30);
        Participante participante1 = new Participante("Cristian", "ElMio");
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso);
        participante1.inscribirseAConcurso(concurso1);

        assertEquals(10, participante1.mostrarPuntaje());
    }

    @Test
    public void inscripcionFueraDeRango(){
        LocalDate fechaInicioConcurso = LocalDate.of(2023, 3, 20);
        LocalDate fechaFinConcurso = LocalDate.of(2023, 4, 30);
        Participante participante1 = new Participante("Cristian", "ElMio");
        Concurso concurso1 = new Concurso(fechaInicioConcurso, fechaFinConcurso);
        participante1.inscribirseAConcurso(concurso1);

        assertFalse(concurso1.estaInscripto(participante1));
    }
}
