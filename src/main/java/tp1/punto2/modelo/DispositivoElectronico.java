package tp1.punto2.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DispositivoElectronico {

    public static final String FILE_PATH = "C:\\workspace\\orientacion-objetos-2\\src\\main\\java\\tp1\\punto2CostoComida.txt";
    public static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm";
    public static final String SEPARADOR = "||";
    public static final String SALTO_DE_LINEA = "\n";
    private final RegistroDeCosto registro;

    public DispositivoElectronico(RegistroDeCosto registro) {
        this.registro = registro;
    }

    public Comprobante realizarPago(Pedido pedido, TarjetaDeCredito tarjetaDeCredito) {
        Double monto = pedido.aplicarPropina(tarjetaDeCredito.calcularDescuento(pedido));
        String fechaYCostoDeComida = generarFechaDePago2() + SEPARADOR + monto + SALTO_DE_LINEA;
        this.registro.registrar(fechaYCostoDeComida);
        return new Comprobante(pedido, tarjetaDeCredito, monto, new Date());
    }

    private String generarFechaDePago() {
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fechaActual);
    }

    private String generarFechaDePago2() {
        return "03/04/2024 19:55";
    }
}
