package tp4.ejercicio2.model;

import java.util.List;

public interface RegistroDeEmpleado {
    List<Empleado> obtenerEmpleados();

    void registrar(Empleado empleado);
}
