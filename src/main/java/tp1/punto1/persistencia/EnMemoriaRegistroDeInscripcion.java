package tp1.punto1.persistencia;

import tp1.punto1.modelo.RegistroDeInscripcion;

import java.util.ArrayList;

public class EnMemoriaRegistroDeInscripcion implements RegistroDeInscripcion {
    private final ArrayList<String> registros = new ArrayList<>();

    @Override
    public void registrar(String registro) {
        this.registros.add(registro);
    }

    @Override
    public boolean comienzaCon(String comienzo) {
        return this.registros.get(registros.size() - 1).startsWith(comienzo);
    }
}
