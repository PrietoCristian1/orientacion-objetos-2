package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }


    public Object[] calcularDeudaYPuntosObtenidos() {
        Object[] resultado = new Object[2];
        resultado[0] = calcularDeuda();
        resultado[1] = calcularPuntosObtenidos();
        return resultado;
    }

    private double calcularPuntosObtenidos() {
        int puntosAlquilerFrecuente = 0;
        for (Alquiler alquiler : alquileres) {
            puntosAlquilerFrecuente++;
            if ((alquiler.copia().libro().esNuevoLanzamiento())
                    && alquiler.diasAlquilados() > 1) {
                puntosAlquilerFrecuente++;
            }
        }
        return puntosAlquilerFrecuente;
    }

    private double calcularDeuda() {
        return alquileres.stream()
                .mapToDouble((p) -> p.copia().libro().calcularCosto(p.diasAlquilados()))
                .sum();
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}
