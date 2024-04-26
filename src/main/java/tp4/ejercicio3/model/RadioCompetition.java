package tp4.ejercicio3.model;

import java.util.List;

public interface RadioCompetition {
    List<Concurso> todosLosConcursos();// carga del archivo de texto concursos.txt los concurso

    void saveInscription(String nombre, String apellido, String dni, String email, String telefono, String concursoSeleccionado); // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
}
