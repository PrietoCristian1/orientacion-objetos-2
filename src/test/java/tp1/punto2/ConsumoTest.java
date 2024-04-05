package tp1.punto2;

import org.junit.jupiter.api.Test;
import tp1.punto2.modelo.*;
import tp1.punto2.persistencia.EnBaseDeDatosRegistroDeCosto;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsumoTest {

    @Test
    public void costoTarjetaVisa() {
        EnBaseDeDatosRegistroDeCosto registro = new EnBaseDeDatosRegistroDeCosto();
        TarjetaDeCredito tarjetaVisa = new Visa("Visa");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido();
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaVisa);
        double montoMinimoEsperado = tarjetaVisa.calcularDescuento(pedido) * 1.02;
        double montoMaximoEsperado = tarjetaVisa.calcularDescuento(pedido) * 1.05;
        assertTrue(comprobante.monto() >= montoMinimoEsperado && comprobante.monto() <= montoMaximoEsperado);
        assertEquals("03/04/2024 19:55" + "||" + comprobante.monto(), registro.contenido());
    }

    @Test
    public void costoTarjetaMastercard() {
        EnBaseDeDatosRegistroDeCosto registro = new EnBaseDeDatosRegistroDeCosto();
        TarjetaDeCredito tarjetaMastercard = new Mastercard("Mastercard");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido();
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaMastercard);
        double montoMinimoEsperado = tarjetaMastercard.calcularDescuento(pedido) * 1.02;
        double montoMaximoEsperado = tarjetaMastercard.calcularDescuento(pedido) * 1.05;
        assertTrue(comprobante.monto() >= montoMinimoEsperado && comprobante.monto() <= montoMaximoEsperado);
        assertEquals("03/04/2024 19:55" + "||" + comprobante.monto(), registro.contenido());
    }

    @Test
    public void costoTarjetaComarcaPlus() {
        EnBaseDeDatosRegistroDeCosto registro = new EnBaseDeDatosRegistroDeCosto();
        TarjetaDeCredito tarjetaComarcaPlus = new ComarcaPlus("Comarca Plus");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido();
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaComarcaPlus);
        double montoMinimoEsperado = tarjetaComarcaPlus.calcularDescuento(pedido) * 1.02;
        double montoMaximoEsperado = tarjetaComarcaPlus.calcularDescuento(pedido) * 1.05;
        assertTrue(comprobante.monto() >= montoMinimoEsperado && comprobante.monto() <= montoMaximoEsperado);
        assertEquals("03/04/2024 19:55" + "||" + comprobante.monto(), registro.contenido());
    }

    @Test
    public void costoTarjetaViedma() {
        EnBaseDeDatosRegistroDeCosto registro = new EnBaseDeDatosRegistroDeCosto();
        TarjetaDeCredito tarjetaViedma = new TarjetaDeCredito("Viedma");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido();
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaViedma);
        double montoMinimoEsperado = tarjetaViedma.calcularDescuento(pedido) * 1.02;
        double montoMaximoEsperado = tarjetaViedma.calcularDescuento(pedido) * 1.05;
        assertTrue(comprobante.monto() >= montoMinimoEsperado && comprobante.monto() <= montoMaximoEsperado);
        assertEquals("03/04/2024 19:55" + "||" + comprobante.monto(), registro.contenido());
    }

    private Pedido generarPedido() {
        // Creacion de la lista de bebidas
        var bebida1 = new BebidaRecord("Quilmes", 3.0, 100);
        var bebida2 = new BebidaRecord("Manaos", 4.0, 200);
        var bebida3 = new BebidaRecord("Brahma", 3.0, 300);
        ArrayList<BebidaRecord> listaBebidas = new ArrayList<>();
        listaBebidas.add(bebida1);
        listaBebidas.add(bebida2);
        listaBebidas.add(bebida3);

        //Creacion de la lista de platosSeleccionados
        var plato1 = new PlatoPrincipalRecord("Milanesa", 5.0, 500);
        var plato2 = new PlatoPrincipalRecord("Hamburguesa", 4.0, 400);
        var plato3 = new PlatoPrincipalRecord("Pizza", 2.0, 450);
        ArrayList<PlatoPrincipalRecord> listaPlatos = new ArrayList<>();
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);
        listaPlatos.add(plato3);
        return new Pedido(listaBebidas, listaPlatos);
    }
}
