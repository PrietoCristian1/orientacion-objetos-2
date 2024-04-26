package tp4.ejercicio2.model;

import java.time.LocalDate;

public record Empleado(String apellido, String nombre, LocalDate fecha, String email) {
}
