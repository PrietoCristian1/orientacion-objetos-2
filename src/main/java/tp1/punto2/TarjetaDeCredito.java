package tp1.punto2;


public class TarjetaDeCredito {
    private final String nombreTarjeta;

    public TarjetaDeCredito(String nombreTarjeta){
        this.nombreTarjeta = nombreTarjeta;
    }
    public double calcularDescuento(Pedido pedido){
        return pedido.montoTotal();
    }

}
