package tp1.punto2;

import org.junit.jupiter.api.Test;
import tp1.punto2.modelo.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsumoTest {

    public static final double PROPINA_1 = 1.02;
    public static final double PROPINA_2 = 1.05;
    public static final double PROPINA_3 = 1.03;

    @Test
    public void costoTarjetaVisa() {
        FakeRegistroDeCosto registro = new FakeRegistroDeCosto();
        TarjetaDeCredito tarjetaVisa = new Visa("Visa");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido(PROPINA_1);
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaVisa);

        assertEquals(7080.0, comprobante.monto());
        assertTrue(registro.comienzaCon("2024-10-15T20:25:45"));
    }

    @Test
    public void costoTarjetaMastercard() {
        FakeRegistroDeCosto registro = new FakeRegistroDeCosto();
        TarjetaDeCredito tarjetaMastercard = new Mastercard("Mastercard");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido(PROPINA_2);
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaMastercard);

        assertEquals(7250.0, comprobante.monto());
        assertTrue(registro.comienzaCon("2024-10-15T20:25:45"));
    }

    @Test
    public void costoTarjetaComarcaPlus() {
        FakeRegistroDeCosto registro = new FakeRegistroDeCosto();
        TarjetaDeCredito tarjetaComarcaPlus = new ComarcaPlus("Comarca Plus");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido(PROPINA_3);
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaComarcaPlus);

        assertEquals(7065.8, comprobante.monto());
        assertTrue(registro.comienzaCon("2024-10-15T20:25:45"));
    }

    @Test
    public void costoTarjetaViedma() {
        FakeRegistroDeCosto registro = new FakeRegistroDeCosto();
        TarjetaDeCredito tarjetaViedma = new TarjetaDeCredito("Viedma");
        DispositivoElectronico dispositivoElectronico = new DispositivoElectronico(registro);
        Pedido pedido = this.generarPedido(PROPINA_1);
        Comprobante comprobante = dispositivoElectronico.realizarPago(pedido, tarjetaViedma);

        assertEquals(7140.0, comprobante.monto());
        assertTrue(registro.comienzaCon("2024-10-15T20:25:45"));
    }

    private Pedido generarPedido(double propina) {
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
        return new Pedido(listaBebidas, listaPlatos, propina);
    }
}
