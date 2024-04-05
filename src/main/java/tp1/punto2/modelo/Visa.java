package tp1.punto2.modelo;

public class Visa extends TarjetaDeCredito {

    public Visa(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.montoTotal() - (pedido.montoBebidas() * 0.03);
    }
}
