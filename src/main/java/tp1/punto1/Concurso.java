package tp1.punto1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private final ArrayList<Participante> lista;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;

    public Concurso(LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        this.lista = new ArrayList<>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public boolean esPrimerDiaDeInscripcion(){
        LocalDate fechaActual = LocalDate.now();
        return this.fechaInicioInscripcion.equals(fechaActual);
    }
    public boolean estaAbiertoParaInscripcion(){
        LocalDate fechaActual = LocalDate.now();
        return !fechaActual.isBefore(fechaInicioInscripcion) && !fechaActual.isAfter(fechaFinInscripcion);
    }
    public void agregarParticipante(Participante participante){
        this.lista.add(participante);
    }
    public boolean estaInscripto(Participante participante){
        return (this.lista.stream().anyMatch(p -> p.equals(participante)));
    }
}
