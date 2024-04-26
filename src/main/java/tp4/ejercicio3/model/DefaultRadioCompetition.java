package tp4.ejercicio3.model;

import tp4.ejercicio2.model.ProveedorDeFechas;

import java.util.List;

public class DefaultRadioCompetition implements RadioCompetition {

    public static final String EL_NOMBRE_NO_PUEDE_SER_VACIO = "El nombre no puede ser vacio";
    public static final String EL_APELLIDO_NO_PUEDE_SER_VACIO = "El apellido no puede ser vacio";
    public static final String EL_MAIL_DEBE_SER_VALIDO = "El email debe ser valido";
    public static final String TELEFONO_INVALIDO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static final String DEBE_SELECCIONAR_UN_CONCURSO = "Debe seleccionar un concurso";
    private final RegistroDeConcurso registroDeConcurso;
    private final ProveedorDeFechas proveedorDeFechas;
    private final RegistroDeParticipante registroDeParticipante;

    public DefaultRadioCompetition(RegistroDeConcurso registroDeConcurso, ProveedorDeFechas proveedorDeFechas, RegistroDeParticipante registroDeParticipante) {
        this.registroDeConcurso = registroDeConcurso;
        this.proveedorDeFechas = proveedorDeFechas;
        this.registroDeParticipante = registroDeParticipante;
    }

    @Override
    public List<Concurso> todosLosConcursos() {
        return registroDeConcurso.todosLosConcursos(proveedorDeFechas.fecha());
    }

    @Override
    public void saveInscription(String nombre, String apellido, String dni, String email, String telefono, String concursoSeleccionado) throws RuntimeException {
        if (validations(nombre, apellido, dni, email, telefono, concursoSeleccionado)) {
            registroDeParticipante.saveInscription(nombre, apellido, email, telefono, concursoSeleccionado);
        }
    }

    private boolean validations(String nombre, String apellido, String dni, String email, String telefono, String concursoSelecionado) {
        if (nombre.isEmpty()) {
            throw new RuntimeException(EL_NOMBRE_NO_PUEDE_SER_VACIO);
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException(EL_APELLIDO_NO_PUEDE_SER_VACIO);
        }
        if (!checkEmail(email)) {
            throw new RuntimeException(EL_MAIL_DEBE_SER_VALIDO);
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException(TELEFONO_INVALIDO);
        }
        if (concursoSelecionado.isEmpty()) {
            throw new RuntimeException(DEBE_SELECCIONAR_UN_CONCURSO);
        }
        return true;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]\\@(\\w+\\.)+\\w+\\w$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
