package tp3.ejercicio1;

public class Regular extends Libro {
    private static final int REGULARES = 0;

    public Regular(String nombre) {
        super(nombre, REGULARES);
    }

    @Override
    public double calcularCosto(int diasAlquilados) {
        double monto = 2;
        if (diasAlquilados > 2)
            monto += (diasAlquilados - 2) * 1.5;
        return monto;
    }

    @Override
    public boolean esNuevoLanzamiento() {
        return false;
    }
}
