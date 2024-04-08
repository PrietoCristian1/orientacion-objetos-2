package tp1.punto2.modelo;

import java.time.LocalDateTime;

public class Comprobante {
    private final Pedido pedido;
    private final TarjetaDeCredito tarjetaDeCredito;
    private final double monto;
    private final LocalDateTime fechaDeCobro;

    public Comprobante(Pedido pedido, TarjetaDeCredito tarjetaDeCredito, double monto, LocalDateTime fechaDeCobro) {
        this.fechaDeCobro = fechaDeCobro;
        this.monto = monto;
        this.pedido = pedido;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public double monto() {
        return this.monto;
    }


}
