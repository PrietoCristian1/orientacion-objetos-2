package tp1.punto1.modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Concurso {
    private static int contadorConcursos = 0;
    private final ArrayList<Participante> lista;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;
    private int id;
    private RegistroDeInscripcion registro;

    public Concurso(LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, RegistroDeInscripcion registro) {
        this.lista = new ArrayList<>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.id = ++contadorConcursos;
        this.registro = registro;
    }

    public boolean esPrimerDiaDeInscripcion() {
        LocalDate fechaActual = LocalDate.now();
        return this.fechaInicioInscripcion.equals(fechaActual);
    }

    public boolean estaAbiertoParaInscripcion() {
        LocalDate fechaActual = LocalDate.now();
        return !fechaActual.isBefore(fechaInicioInscripcion) && !fechaActual.isAfter(fechaFinInscripcion);
    }

    public void agregarParticipante(Participante participante) {
        this.lista.add(participante);
        String fechaIdParticipanteIdConcurso = generarFechaInscripcion2() + "," + participante.getDni() + "," + this.id + "\n";
        this.registro.registrar(fechaIdParticipanteIdConcurso);
    }

    public boolean estaInscripto(Participante participante) {
        return (this.lista.stream().anyMatch(p -> p.equals(participante)));
    }

    public boolean estaInscripto(int numero_documento) {
        return (this.lista.stream().anyMatch(p -> p.esTuDocumento(numero_documento)));
    }

    public int mostrarId() {
        return this.id;
    }

    private String generarFechaInscripcion() {
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formateador.format(fechaActual);
    }

    private String generarFechaInscripcion2() {
        return "04/04/2024 22:02";
    }
}
