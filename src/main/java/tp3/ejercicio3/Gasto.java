package tp3.ejercicio3;

public class Gasto {
    private final int monto;
    private final String nombreDeGasto;

    public Gasto(int monto, String nombreDeGasto) {
        this.monto = monto;
        this.nombreDeGasto = nombreDeGasto;
    }

    public int monto() {
        return this.monto;
    }

    public int gastoDeComida() {
        return monto;
    }

    public String tipoDeGasto() {
        return this.nombreDeGasto;
    }

    public String marcaExcesoComidas() {
        return " ";
    }
}
