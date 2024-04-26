package tp4.ejercicio2.model;

import java.time.LocalDate;

public class ProveedorDeFechasReal implements ProveedorDeFechas {
    @Override
    public LocalDate fecha() {
        return LocalDate.of(1989, 07, 10);
    }
}