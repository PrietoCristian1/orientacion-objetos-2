package tp3.ejercicio1;

public class NuevoLanzamiento extends Libro {
    private static final int NUEVO_LANZAMIENTO = 1;

    public NuevoLanzamiento(String nombre) {
        super(nombre, NUEVO_LANZAMIENTO);
    }

    @Override
    public double calcularCosto(int diasAlquilados) {
        return diasAlquilados * 3;
    }

    @Override
    public boolean esNuevoLanzamiento() {
        return true;
    }
}
