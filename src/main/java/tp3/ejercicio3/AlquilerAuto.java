package tp3.ejercicio3;

public class AlquilerAuto extends Gasto {
    public static final String ALQUILER_AUTO = "Alquiler Auto";

    public AlquilerAuto(int monto) {
        super(monto, ALQUILER_AUTO);
    }

    @Override
    public int gastoDeComida() {
        return 0;
    }
}
