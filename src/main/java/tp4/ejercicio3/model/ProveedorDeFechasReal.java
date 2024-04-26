package tp4.ejercicio3.model;

import tp4.ejercicio2.model.ProveedorDeFechas;

import java.time.LocalDate;

public class ProveedorDeFechasReal implements ProveedorDeFechas {
    @Override
    public LocalDate fecha() {
        return LocalDate.of(1989, 07, 10);
    }
}