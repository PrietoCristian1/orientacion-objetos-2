package tp4.ejercicio3.database;

import tp4.ejercicio3.model.RegistroDeParticipante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EnArchivoRegistroDeParticipante implements RegistroDeParticipante {
    private static final String FILE_PATH = "C:\\workspace\\orientacion-objetos-2\\src\\main\\java\\tp4\\ejercicio3\\database\\inscriptos.txt";

    @Override
    public void saveInscription(String nombre, String apellido, String email, String telefono, String concursoSeleccionado) {
        String registro = "\n" + apellido + ", " + nombre + ", " + telefono + ", " + email + ", " + concursoSeleccionado;
        try {
            Files.write(Paths.get(FILE_PATH),
                    registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir ...", e);
        }
    }
}
