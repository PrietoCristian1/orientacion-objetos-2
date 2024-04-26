package tp4.ejercicio2;

import org.junit.jupiter.api.Test;
import tp4.ejercicio2.model.DefaultEmpresa;
import tp4.ejercicio2.model.Empleado;

import java.time.LocalDate;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmpresaTest {

    @Test
    public void agregarEmpleadoAEmpresa() {
        String mailEmpresa = "empresa@gmail.com";
        FakeProveedorDeFechas proveedorDeFechas = new FakeProveedorDeFechas();
        FakeRegistrosDeEmpleados registroDeEmpleados = new FakeRegistrosDeEmpleados();
        FakeEnvioDeCorreo envioDeCorreo = new FakeEnvioDeCorreo();
        Empleado empleadoNuevo = new Empleado("Prieto", "Cristian", LocalDate.of(2023, 04, 22), "cprieto@gmail.com");

        DefaultEmpresa empresa = new DefaultEmpresa(registroDeEmpleados, envioDeCorreo, mailEmpresa, proveedorDeFechas);
        empresa.cargarEmpleado(empleadoNuevo);

        assertTrue(registroDeEmpleados.estaRegistrado(empleadoNuevo));
    }

    @Test
    public void noCumpleAniosHoy() {
        String mailEmpresa = "empresa@gmail.com";
        FakeProveedorDeFechas proveedorDeFechas = new FakeProveedorDeFechas();
        FakeRegistrosDeEmpleados registroDeEmpleados = new FakeRegistrosDeEmpleados();
        FakeEnvioDeCorreo envioDeCorreo = new FakeEnvioDeCorreo();
        Empleado empleadoNuevo = new Empleado("Prieto", "Cristian", LocalDate.of(2023, 04, 22), "cprieto@gmail.com");

        DefaultEmpresa empresa = new DefaultEmpresa(registroDeEmpleados, envioDeCorreo, mailEmpresa, proveedorDeFechas);

        assertNotEquals(empleadoNuevo.fecha(), proveedorDeFechas.fecha());
    }

    @Test
    public void cumpleAniosHoy() {
        String mailEmpresa = "empresa@gmail.com";
        FakeProveedorDeFechas proveedorDeFechas = new FakeProveedorDeFechas();
        FakeRegistrosDeEmpleados registroDeEmpleados = new FakeRegistrosDeEmpleados();
        FakeEnvioDeCorreo envioDeCorreo = new FakeEnvioDeCorreo();
        Empleado empleadoNuevo = new Empleado("Prieto", "Cristian", LocalDate.of(1989, 07, 10), "cprieto@gmail.com");

        DefaultEmpresa empresa = new DefaultEmpresa(registroDeEmpleados, envioDeCorreo, mailEmpresa, proveedorDeFechas);

        assertEquals(empleadoNuevo.fecha(), proveedorDeFechas.fecha());
    }
}
