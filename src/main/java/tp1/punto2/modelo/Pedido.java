package tp1.punto2.modelo;

import java.util.ArrayList;

public class Pedido {
    private final ArrayList<BebidaRecord> listaBebidasSeleccionadas;
    private final ArrayList<PlatoPrincipalRecord> listaPlatosSeleccionados;
    private final double propina;
    private double precioTotalBebidas = 0;
    private double precioTotalPlatos = 0;

    public Pedido(ArrayList<BebidaRecord> listaBebidasSeleccionadas, ArrayList<PlatoPrincipalRecord> listaPlatosSeleccionados,
                  double propina) {
        this.listaBebidasSeleccionadas = listaBebidasSeleccionadas;
        this.listaPlatosSeleccionados = listaPlatosSeleccionados;
        this.propina = propina;
        this.calcularPrecioBebidasYPlatos();
    }

    public double montoTotal() {
        return (this.precioTotalBebidas + this.precioTotalPlatos) * propina;
    }

    public double montoPlatos() {
        return this.precioTotalPlatos;
    }

    public double montoBebidas() {
        return this.precioTotalBebidas;
    }

    private void calcularPrecioBebidasYPlatos() {
        this.listaBebidasSeleccionadas.forEach(bebida -> this.precioTotalBebidas += bebida.precioUnidad() * bebida.cantidad());
        this.listaPlatosSeleccionados.forEach(plato -> this.precioTotalPlatos += plato.precio() * plato.cantidad());
    }
}
