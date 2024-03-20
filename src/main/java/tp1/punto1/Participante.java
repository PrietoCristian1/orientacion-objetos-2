package tp1.punto1;

import java.util.Date;

public class Participante {
    private String nombre;
    private String apellido;
    private int puntaje = 0;
    private Date fechaDeInscripcion;

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
