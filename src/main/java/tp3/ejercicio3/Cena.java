package tp3.ejercicio3;

public class Cena extends Gasto {
    public static final String CENA = "Cena";

    public Cena(int monto) {
        super(monto, CENA);
    }

    @Override
    public String marcaExcesoComidas() {
        String res = " ";
        if (this.monto() > 5000)
            res = "X";
        return res;
    }
}
