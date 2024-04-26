package tp4.ejercicio2.model;

public interface Empresa {
    void cargarEmpleado(String apellido, String nombre, String fechaDeNacimiento, String email);

    void cargarEmpleado(Empleado empleado);

    void enviarSaludos();

}
