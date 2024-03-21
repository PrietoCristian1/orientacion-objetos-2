package tp1.punto2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DispositivoElectronico {

    public Comprobante realizarPago(Pedido pedido, TarjetaDeCredito tarjetaDeCredito){
        Double monto = pedido.aplicarPropina(tarjetaDeCredito.calcularDescuento(pedido));
        return new Comprobante(pedido, tarjetaDeCredito, monto, new Date());
    }
}
