package tp4.ejercicio1.model;

public class DefaultConcurso implements Concurso {

    public static final String COMPLETE_EL_CAMPO_NOMBRE = "Complete el campo: 'Nombre' ";
    public static final String INGRESE_UN_TELEFONO = "Debe ingresar un numero de telefono para registrarse";
    public static final String FORMATO_INVALIDO_TELEFONO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static final String REGION_DESCONOCIDA = "Region desconocida. Las conocidas son: China, US, Europa";
    private final RegistroDeParticipantes registroDeParticipantes;

    public DefaultConcurso(RegistroDeParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    @Override
    public void cargarParticipante(String nombre, String telefono, String region) throws RuntimeException {
        if (nombre.isEmpty()) {
            throw new RuntimeException(COMPLETE_EL_CAMPO_NOMBRE);
        }
        if (telefono.isEmpty()) {
            throw new RuntimeException(INGRESE_UN_TELEFONO);
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException(FORMATO_INVALIDO_TELEFONO);
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException(REGION_DESCONOCIDA);
        }
        registroDeParticipantes.cargarParticipante(nombre, telefono, region);
    }

    public boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
