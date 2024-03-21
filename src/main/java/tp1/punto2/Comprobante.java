package tp1.punto2;

import java.util.Date;

public class Comprobante {
    private final Pedido pedido;
    private final TarjetaDeCredito tarjetaDeCredito;
    private final Double monto;
    private final Date fechaDeCobro;

    public Comprobante(Pedido pedido, TarjetaDeCredito tarjetaDeCredito, Double monto, Date fechaDeCobro){
        this.fechaDeCobro = fechaDeCobro;
        this.monto = monto;
        this.pedido = pedido;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public Double monto(){
        return this.monto;
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "pedido=" + pedido +
                ", tarjetaDeCredito=" + tarjetaDeCredito +
                ", monto=" + monto +
                ", fechaDeCobro=" + fechaDeCobro +
                '}';
    }
}
