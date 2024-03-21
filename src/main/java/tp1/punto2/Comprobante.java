package tp1.punto2;

import org.apache.tools.ant.taskdefs.Tar;

import java.util.Date;

public class Comprobante {
    private Pedido pedido;
    private TarjetaDeCredito tarjetaDeCredito;
    private Double monto = 0.0;
    private Date fechaDeCobro;

    public Comprobante(Pedido pedido, TarjetaDeCredito tarjetaDeCredito, Double monto, Date fechaDeCobro){
        this.fechaDeCobro = fechaDeCobro;
        this.monto = monto;
        this.pedido = pedido;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public Double monto(){
        return this.monto;
    }
}
