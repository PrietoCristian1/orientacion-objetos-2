package tp4.ejercicio2;

import tp4.ejercicio2.model.ProveedorDeFechas;

import java.time.LocalDate;

public class FakeProveedorDeFechas implements ProveedorDeFechas {
    @Override
    public LocalDate fecha() {
        return LocalDate.of(1989, 07, 10);
    }
}
