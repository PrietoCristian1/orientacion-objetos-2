package tp4.ejercicio3.model;

import java.time.LocalDate;
import java.util.List;

public interface RegistroDeConcurso {
    List<Concurso> todosLosConcursos(LocalDate fechaReferencia);
}
