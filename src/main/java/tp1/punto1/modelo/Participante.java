package tp1.punto1.modelo;


public class Participante {
    private final String nombre;
    private final String apellido;
    private final int dni;
    private int puntaje = 0;

    public Participante(String nombre, String apellido, int dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    public void inscribirseAConcurso(Concurso concurso) {
        if (concurso.estaAbiertoParaInscripcion() && !concurso.estaInscripto(this.dni)) {
            concurso.agregarParticipante(this);
            if (concurso.esPrimerDiaDeInscripcion()) {
                this.puntaje += 10;
            }
        } else {
            System.out.println("NO es posible inscribirse a este concurso");
        }
    }

    public int mostrarPuntaje() {
        return this.puntaje;
    }

    public boolean esTuDocumento(int numero_documento) {
        return this.dni == numero_documento;
    }
    
    public int getDni() {
        return this.dni;
    }
}
