package tp1.punto2.modelo;

import tp1.punto1.modelo.ProveedorDeFechas;

import java.time.LocalDateTime;

public class ProveedorDeFechasReal implements ProveedorDeFechas {
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.of(2024, 10, 15, 20, 25, 45);
    }
}