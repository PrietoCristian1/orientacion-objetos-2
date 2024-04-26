package tp4.ejercicio2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DefaultEmpresa implements Empresa {

    public static final String COMPLETE_EL_CAMPO_APELLIDO = "Por favor rellene el campo de apellido";
    public static final String COMPLETE_EL_CAMPO_NOMBRE = "Por favor complete el campo nombre";
    public static final String COMPLETE_EL_CAMPO_EMAIL = "Por favor complete el campo email";
    public static final String FORMATO_INVALIDO_FECHA = "Formato invalido de fecha. Ingrese la fecha de la siguiente manera: YYYY-MM-DD";
    public static final String CONTENIDO_MENSAJE = "Espero que lo pases bien";
    public static final String ASUNTO = "Feliz Cumpleanios";
    private final RegistroDeEmpleado registroDeEmpleado;
    private final EnviarCorreo enviarCorreo;
    private final String correoEmpresa;
    private final ProveedorDeFechas proveedorDeFechas;
    private final ArrayList<Empleado> lista;

    public DefaultEmpresa(RegistroDeEmpleado registroDeEmpleado, EnviarCorreo enviarCorreo, String correoEmpresa, ProveedorDeFechas proveedorDeFechas) {
        this.lista = new ArrayList<>();
        this.registroDeEmpleado = registroDeEmpleado;
        this.enviarCorreo = enviarCorreo;
        this.correoEmpresa = correoEmpresa;
        this.proveedorDeFechas = proveedorDeFechas;
    }

    @Override
    public void cargarEmpleado(String apellido, String nombre, String fechaDeNacimiento, String email) {
        if (nombre.isEmpty()) {
            throw new RuntimeException(COMPLETE_EL_CAMPO_NOMBRE);
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException(COMPLETE_EL_CAMPO_APELLIDO);
        }
        if (!validarFechaDeNacimiento(fechaDeNacimiento)) {
            throw new RuntimeException(FORMATO_INVALIDO_FECHA);
        }
        if (email.isEmpty()) {
            throw new RuntimeException(COMPLETE_EL_CAMPO_EMAIL);
        }
        Empleado nuevoEmpleado = new Empleado(apellido, nombre, convertirStringALocalDate(fechaDeNacimiento), email);
        this.lista.add(nuevoEmpleado);
        registroDeEmpleado.registrar(nuevoEmpleado);
    }

    @Override
    public void cargarEmpleado(Empleado empleado) {
        this.lista.add(empleado);
        registroDeEmpleado.registrar(empleado);
    }

    @Override
    public void enviarSaludos() {
        List<Empleado> listaEmpleados = registroDeEmpleado.obtenerEmpleados();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.fecha().equals(this.proveedorDeFechas.fecha())) {
                enviarCorreo.enviarCorreo(this.correoEmpresa, empleado.email(), ASUNTO, CONTENIDO_MENSAJE);
            }
        }
    }

    public boolean estaRegistrado(Empleado empleado) {
        return (this.lista.stream().anyMatch(p -> p.equals(empleado)));
    }


    private boolean validarFechaDeNacimiento(String fechaDeNacimiento) {
        String regex = "\\d{4}/\\d{2}/\\d{2}";
        return fechaDeNacimiento.matches(regex);
    }

    private LocalDate convertirStringALocalDate(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
    }

}
