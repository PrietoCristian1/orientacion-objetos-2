package tp4.ejercicio2.database;

import tp4.ejercicio2.model.Empleado;
import tp4.ejercicio2.model.RegistroDeEmpleado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EnArchivoRegistroDeEmpleado implements RegistroDeEmpleado {
    private static final String FILE_PATH = "C:\\workspace\\orientacion-objetos-2\\src\\main\\java\\tp4\\ejercicio2\\database\\empleados.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/dd");

    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(FILE_PATH));
            for (String linea : lineas) {
                String[] datos = linea.split(", ");
                String apellido = datos[0];
                String nombre = datos[1];
                LocalDate fechaDeNacimiento = LocalDate.parse(datos[2], formatter);
                String email = datos[3];
                Empleado empleado = new Empleado(apellido, nombre, fechaDeNacimiento, email);
                listaEmpleados.add(empleado);
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo obtener los datos de los empleados ...", e);
        }
        return listaEmpleados;
    }

    @Override
    public void registrar(Empleado empleado) {
        String fecha = empleado.fecha().getYear() + "/" + empleado.fecha().getMonthValue() + "/" + empleado.fecha().getDayOfMonth();
        String registro = "\n" + empleado.apellido() + ", " + empleado.nombre() + ", " + fecha + ", " + empleado.email();
        try {
            Files.write(Paths.get(FILE_PATH),
                    registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir ...", e);
        }
    }
}
