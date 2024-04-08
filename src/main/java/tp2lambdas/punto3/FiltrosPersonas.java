package tp2lambdas.punto3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FiltrosPersonas {

    //filtra la lista de personas devolviendo otra lista con
    //solo aquellas cuyo nombre comienza con E
    public List<Persona> nombresQueEmpiezanConE(List<Persona> p) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (persona.nombre().startsWith("E")) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (persona.nombre().length() % 2 == 0) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    //Solucion
    public List<Persona> filtrarPersonas(List<Persona> personas, Predicate<Persona> criterio) {
        return personas.stream()
                .filter(criterio)
                .toList();
    }
}
