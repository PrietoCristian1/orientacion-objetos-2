package tp1.punto2;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {
    private final ArrayList<BebidaRecord> listaBebidasSeleccionadas;
    private final ArrayList<PlatoPrincipalRecord> listaPlatosSeleccionados;
    private double precioTotalBebidas = 0;
    private double precioTotalPlatos = 0;

    public Pedido(ArrayList<BebidaRecord> listaBebidasSeleccionadas, ArrayList<PlatoPrincipalRecord> listaPlatosSeleccionados){
        this.listaBebidasSeleccionadas = listaBebidasSeleccionadas;
        this.listaPlatosSeleccionados = listaPlatosSeleccionados;
        this.calcularPrecioBebidasYPlatos();
    }

    public double montoTotal(){
        return this.precioTotalBebidas + this.precioTotalPlatos;
    }
    public double montoPlatos(){
        return this.precioTotalPlatos;
    }
    public double montoBebidas(){
        return this.precioTotalBebidas;
    }
    public double aplicarPropina(Double costo){
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        double propina = switch (randomNum) {
            case 0 -> 1.02;
            case 1 -> 1.03;
            default -> 1.05;
        };
        return costo * propina;
    }
    private void calcularPrecioBebidasYPlatos(){
        this.listaBebidasSeleccionadas.forEach(bebida -> this.precioTotalBebidas += bebida.precioUnidad() * bebida.cantidad());
        this.listaPlatosSeleccionados.forEach(plato -> this.precioTotalPlatos += plato.precio() * plato.cantidad());
    }
}
