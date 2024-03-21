package tp1.punto2;

public class ComarcaPlus extends TarjetaDeCredito{

    public ComarcaPlus(String nombre){
        super(nombre);
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.montoTotal() - (pedido.montoTotal() * 0.02);
    }
}
