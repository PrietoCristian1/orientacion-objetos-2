package tp1;

import tp1.punto1.exceptions.InscripcionDuplicadoException;
import tp1.punto1.exceptions.InscripcionFueraDeRangoException;
import tp1.punto1.mailservice.JakartaEmail;
import tp1.punto1.modelo.Concurso;
import tp1.punto1.modelo.Participante;
import tp1.punto1.modelo.ProveedorDeFechasReal;
import tp1.punto1.persistencia.EnMemoriaRegistroDeInscripcion;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Participante juancito = new Participante("Juan", "Gonzalez", 44488123, "juancito123@gmail.com");
        Participante federico = new Participante("Federico", "Gonzalez", 22254780, "federicog@gmail.com");
        LocalDateTime fechaInicioDeInscripcion = LocalDateTime.now();
        LocalDateTime fechaFinDeInscripcion = LocalDateTime.now().plusMonths(1L);
        Concurso concursoDeCiclismo = new Concurso(fechaInicioDeInscripcion, fechaFinDeInscripcion,
                "concursodeajedrez@gmail.com", "Torneo de Ajedrez", new EnMemoriaRegistroDeInscripcion(), new JakartaEmail(), new ProveedorDeFechasReal());

        try {
            juancito.inscribirseAConcurso(concursoDeCiclismo);
            federico.inscribirseAConcurso(concursoDeCiclismo);
        } catch (InscripcionFueraDeRangoException | InscripcionDuplicadoException e) {
            throw new RuntimeException(e);
        }
    }
}
