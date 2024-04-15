package tp3.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteDeGastos {
    private final ArrayList<Gasto> listaDeGastos;
    private int gastosDeComida = 0;
    private int total = 0;

    public ReporteDeGastos(ArrayList<Gasto> listaDeGastos) {
        this.listaDeGastos = listaDeGastos;
        this.gastosDeComida = calcularGastosComida();
        this.total = calcularTotal();
    }


    public String imprimir(List<Gasto> gastos) throws NullPointerException {
        StringBuilder informacionGastos = new StringBuilder("Expenses " + LocalDate.now() + "\n");
        for (Gasto gasto : gastos) {
            String nombreGasto = gasto.tipoDeGasto();
            String marcaExcesoComidas = gasto.marcaExcesoComidas();
            informacionGastos.append(nombreGasto).append("\t").append(gasto.monto()).append("\t").append(marcaExcesoComidas);
            informacionGastos.append("\n");
        }
        informacionGastos.append("\n");
        informacionGastos.append("Gastos de comida: ").append(this.gastosDeComida);
        informacionGastos.append("\n").append("Total de gastos: ").append(this.total);
        return informacionGastos.toString();
    }

    private int calcularGastosComida() {
        return this.listaDeGastos.stream()
                .mapToInt(Gasto::gastoDeComida)
                .sum();
    }

    private int calcularTotal() {
        return this.listaDeGastos.stream()
                .mapToInt(Gasto::monto)
                .sum();
    }

    public int total() {
        return this.total;
    }

    public int gastoDeComidas() {
        return this.gastosDeComida;
    }
}
