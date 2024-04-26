package tp4.ejercicio2;

import tp4.ejercicio2.model.Empleado;
import tp4.ejercicio2.model.RegistroDeEmpleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeRegistrosDeEmpleados implements RegistroDeEmpleado {
    private final List<Empleado> listaEmpleados;

    public FakeRegistrosDeEmpleados() {
        this.listaEmpleados = new ArrayList<>();
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return this.listaEmpleados;
    }

    @Override
    public void registrar(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public boolean estaRegistrado(Empleado empleado) {
        return (this.listaEmpleados.stream().anyMatch(p -> p.equals(empleado)));
    }

    public Optional<Empleado> obtenerEmpleado(Empleado empleado) {
        for (Empleado e : this.listaEmpleados) {
            if (empleado.nombre().equals(e.nombre()) && empleado.apellido().equals(e.apellido())) {
                return Optional.of(empleado);
            }
        }
        return Optional.empty();
    }
}
