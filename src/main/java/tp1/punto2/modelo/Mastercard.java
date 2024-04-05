package tp1.punto2.modelo;

public class Mastercard extends TarjetaDeCredito {
    public Mastercard(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.montoTotal() - (pedido.montoPlatos() * 0.02);
    }
}
