package tp1.punto2.modelo;

import java.time.LocalDateTime;

public class DispositivoElectronico {

    public static final String SEPARADOR = "||";
    public static final String SALTO_DE_LINEA = "\n";
    private final RegistroDeCosto registro;

    public DispositivoElectronico(RegistroDeCosto registro) {
        this.registro = registro;
    }

    public Comprobante realizarPago(Pedido pedido, TarjetaDeCredito tarjetaDeCredito) {
        LocalDateTime fechaDePago = new ProveedorDeFechasReal().fecha();
        double monto = tarjetaDeCredito.calcularDescuento(pedido);
        String fechaYCostoDeComida = fechaDePago + SEPARADOR + monto + SALTO_DE_LINEA;
        this.registro.registrar(fechaYCostoDeComida);
        return new Comprobante(pedido, tarjetaDeCredito, monto, fechaDePago);
    }
}
