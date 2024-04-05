package tp1.punto1.persistencia;

import tp1.punto1.modelo.RegistroDeInscripcion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EnDiscoRegistroDeInscripcion implements RegistroDeInscripcion {

    public static final String FILE_PATH = "C:\\workspace\\orientacion-objetos-2\\src\\main\\java\\tp1\\punto1Participantes.txt";

    @Override
    public void registrar(String registro) {
        try {
            Files.write(Paths.get(FILE_PATH),
                    registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir ...", e);
        }
    }

    @Override
    public String contenido() {
        try {
            //Lee todas las lineas del archivo en una lista
            List<String> lineas = Files.readAllLines(Paths.get(FILE_PATH));
            if (!lineas.isEmpty()) {
                return lineas.get(lineas.size() - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
        return "";
    }
}
