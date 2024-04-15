package tp3.ejercicio3;

public class Desayuno extends Gasto {
    public static final String DESAYUNO = "Desayuno";

    public Desayuno(int monto) {
        super(monto, DESAYUNO);
    }

    @Override
    public String marcaExcesoComidas() {
        String res = " ";
        if (this.monto() > 1000)
            res = "X";
        return res;
    }
}
