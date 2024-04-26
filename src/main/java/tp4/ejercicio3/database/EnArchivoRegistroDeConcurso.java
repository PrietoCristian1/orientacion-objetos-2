package tp4.ejercicio3.database;

import tp4.ejercicio3.model.Concurso;
import tp4.ejercicio3.model.RegistroDeConcurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EnArchivoRegistroDeConcurso implements RegistroDeConcurso {
    private static final String FILE_PATH = "C:\\workspace\\orientacion-objetos-2\\src\\main\\java\\tp4\\ejercicio3\\database\\concursos.txt";

    @Override
    public List<Concurso> todosLosConcursos(LocalDate fechaReferencia) {

        List<Concurso> listaConcursos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            List<String> lineas = Files.readAllLines(Paths.get(FILE_PATH));
            for (String linea : lineas) {
                String[] datos = linea.split(", ");
                int idConcurso = Integer.parseInt(datos[0]);
                String nombreConcurso = datos[1];
                LocalDate fechaInicio = LocalDate.parse(datos[2], formatter);
                LocalDate fechaFin = LocalDate.parse(datos[3], formatter);
                if (!fechaReferencia.isBefore(fechaInicio) && !fechaReferencia.isAfter(fechaFin)) {
                    Concurso concurso = new Concurso(idConcurso, nombreConcurso, fechaInicio, fechaFin);
                    listaConcursos.add(concurso);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo obtener los datos de los concursos...", e);
        }
        return listaConcursos;
    }

}
