package tp3.ejercicio1;

public class Infantil extends Libro {
    private static final int INFANTILES = 2;

    public Infantil(String nombre) {
        super(nombre, INFANTILES);
    }

    @Override
    public double calcularCosto(int diasAlquilados) {
        double monto = 1.5;
        if (diasAlquilados > 3)
            monto += (diasAlquilados - 3) * 1.5;
        return monto;
    }

    @Override
    public boolean esNuevoLanzamiento() {
        return false;
    }
}
