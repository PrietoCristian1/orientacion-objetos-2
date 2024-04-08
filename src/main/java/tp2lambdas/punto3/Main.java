package tp2lambdas.punto3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //¿No son practicamente iguales los metodos nombresQueEmpiezanConE y nombresCuyaCantidadDeLetrasEsPar ? ¿Hay código duplicado?
    //¿Cómo implementaría un único metodo que permita resolver ambos requerimientos (nombres que
    //comiencen con E y nombres cuya cantidad de letras es Par), sin tener código duplicado?.
    public static void main(String[] args) {
        List<Persona> listaDePersonas = new ArrayList<>();
        Persona p1 = new Persona("juan", "Gonzales");
        Persona p2 = new Persona("Carlos", "Preito");
        Persona p3 = new Persona("Ezequiel", "Pereira");
        Persona p4 = new Persona("Auron", "Ramirez");
        Persona p5 = new Persona("Elias", "Pieto");
        listaDePersonas.add(p1);
        listaDePersonas.add(p2);
        listaDePersonas.add(p3);
        listaDePersonas.add(p4);
        listaDePersonas.add(p5);


        FiltrosPersonas filtro = new FiltrosPersonas();
        // Filtrar personas cuyo nombre comience con "E"
        List<Persona> nombresConE = filtro.filtrarPersonas(listaDePersonas, persona -> persona.nombre().toLowerCase().startsWith("e"));
        System.out.println("Personas cuyos nombres empiezan con E: " + nombresConE);

        // Filtrar personas cuya cantidad de letras en el nombre es par
        List<Persona> nombresConCantidadPar = filtro.filtrarPersonas(listaDePersonas, persona -> persona.nombre().length() % 2 == 0);
        System.out.println("Personas cuyos nombres tienen cantidad par de letras: " + nombresConCantidadPar);
    }


}
