package tp1.punto1.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Concurso {
    private static int contadorConcursos = 0;
    private final ArrayList<Participante> lista;
    private final LocalDateTime fechaInicioInscripcion;
    private final LocalDateTime fechaFinInscripcion;
    private final int id;
    private final RegistroDeInscripcion registro;
    private final MailSender mailSender;
    private final String correo;
    private final String nombreConcurso;
    private final ProveedorDeFechas proveedor;

    public Concurso(LocalDateTime fechaInicioInscripcion, LocalDateTime fechaFinInscripcion, String correo, String nombreConcurso,
                    RegistroDeInscripcion registro, MailSender mailSender, ProveedorDeFechas proveedor) {
        this.lista = new ArrayList<>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.id = ++contadorConcursos;
        this.registro = registro;
        this.mailSender = mailSender;
        this.correo = correo;
        this.nombreConcurso = nombreConcurso;
        this.proveedor = proveedor;
    }

    public boolean esPrimerDiaDeInscripcion(LocalDateTime fecha) {
        return this.fechaInicioInscripcion.toLocalDate().equals(fecha.toLocalDate());
    }

    public boolean estaAbiertoParaInscripcion(LocalDateTime fechaActual) {
        return !fechaActual.isBefore(fechaInicioInscripcion) && !fechaActual.isAfter(fechaFinInscripcion);
    }

    public void agregarParticipante(Participante participante) {
        this.lista.add(participante);
        String fechaIdParticipanteIdConcurso = this.proveedor.fecha().toString() + "," + participante.getDni() + "," + this.id + "\n";
        this.registro.registrar(fechaIdParticipanteIdConcurso);
        this.mailSender.enviarCorreo(this.correo, participante.getCorreo(), "Inscripcion", "Enhorabuena, usted se inscribio a: " + this.nombreConcurso);
    }

    public boolean estaInscripto(Participante participante) {
        return (this.lista.stream().anyMatch(p -> p.equals(participante)));
    }

    public boolean estaInscripto(int numero_documento) {
        return (this.lista.stream().anyMatch(p -> p.esTuDocumento(numero_documento)));
    }
}
