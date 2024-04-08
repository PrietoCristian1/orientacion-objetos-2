package tp1.punto1.modelo;


import tp1.punto1.exceptions.InscripcionDuplicadoException;
import tp1.punto1.exceptions.InscripcionFueraDeRangoException;

public class Participante {
    private final String nombre;
    private final String apellido;
    private final int dni;
    private final String correo;
    private int puntaje = 0;

    public Participante(String nombre, String apellido, int dni, String correo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
    }

    public void inscribirseAConcurso(Concurso concurso) throws InscripcionFueraDeRangoException, InscripcionDuplicadoException {
        if (!concurso.estaAbiertoParaInscripcion(new ProveedorDeFechasReal().fecha())) {
            throw new InscripcionFueraDeRangoException("No es posible inscribirse al concurso fuera de rango");
        }
        if (concurso.estaInscripto(this.dni)) {
            throw new InscripcionDuplicadoException("El participante ya esta inscripto");
        }
        concurso.agregarParticipante(this);
        if (concurso.esPrimerDiaDeInscripcion(new ProveedorDeFechasReal().fecha())) {
            this.puntaje += 10;
        }
    }


    public boolean esTuDocumento(int numero_documento) {
        return this.dni == numero_documento;
    }

    public int getDni() {
        return this.dni;
    }

    public String getCorreo() {
        return this.correo;
    }
}
