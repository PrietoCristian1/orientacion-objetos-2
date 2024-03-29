package tp1.punto1;


public class Participante {
    private final String nombre;
    private final String apellido;
    private int puntaje = 0;

    public Participante(String nombre, String apellido){
        this.apellido = apellido;
        this.nombre = nombre;
    }
    public void inscribirseAConcurso(Concurso concurso){
        if (concurso.estaAbiertoParaInscripcion()){
            concurso.agregarParticipante(this);
            if (concurso.esPrimerDiaDeInscripcion()){
                this.puntaje += 10;
            }
        }
        else{
            System.out.println("NO es posible inscribirse a este concurso");
        }
    }
    public int mostrarPuntaje(){
        return this.puntaje;
    }

}
