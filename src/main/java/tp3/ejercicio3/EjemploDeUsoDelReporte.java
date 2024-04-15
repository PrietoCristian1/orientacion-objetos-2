package tp3.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var desayuno = new Desayuno(1000);
        var gasto2 = new AlquilerAuto(5000);
        var gasto3 = new Cena(4500);
        ArrayList<Gasto> lista = new ArrayList<>();
        lista.add(desayuno);
        lista.add(gasto3);
        lista.add(gasto2);
        var reporte = new ReporteDeGastos(lista);
        System.out.println(reporte.imprimir(List.of(desayuno, gasto2, gasto3)));
    }
}
