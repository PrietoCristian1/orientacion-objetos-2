package tp3.ejercicio1;

public abstract class Libro {
    private final String nombre;
    private final int codigoPrecio;

    public Libro(String nombre, int priceCode) {
        this.nombre = nombre;
        this.codigoPrecio = priceCode;
    }

    public int codigoPrecio() {
        return codigoPrecio;
    }

    public String nombre() {
        return nombre;
    }

    public abstract double calcularCosto(int diasAlquilados);

    public abstract boolean esNuevoLanzamiento();
}
