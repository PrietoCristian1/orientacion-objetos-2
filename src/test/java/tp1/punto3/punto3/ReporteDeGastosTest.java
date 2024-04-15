package tp1.punto3.punto3;

import org.junit.jupiter.api.Test;
import tp3.ejercicio3.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class ReporteDeGastosTest {
    @Test
    public void gastoTotal() {
        Cena gasto1 = new Cena(1000);
        Desayuno gasto2 = new Desayuno(1500);
        AlquilerAuto gasto3 = new AlquilerAuto(5000);
        ArrayList<Gasto> lista = new ArrayList<>();
        lista.add(gasto1);
        lista.add(gasto2);
        lista.add(gasto3);
        ReporteDeGastos reporteDeGastos = new ReporteDeGastos(lista);
        assertEquals(7500, reporteDeGastos.total());
    }

    @Test
    public void gastoComidas() {
        Cena gasto1 = new Cena(1000);
        Desayuno gasto2 = new Desayuno(1500);
        AlquilerAuto gasto3 = new AlquilerAuto(5000);
        ArrayList<Gasto> lista = new ArrayList<>();
        lista.add(gasto1);
        lista.add(gasto2);
        lista.add(gasto3);
        ReporteDeGastos reporteDeGastos = new ReporteDeGastos(lista);
        assertEquals(2500, reporteDeGastos.gastoDeComidas());
    }

}
