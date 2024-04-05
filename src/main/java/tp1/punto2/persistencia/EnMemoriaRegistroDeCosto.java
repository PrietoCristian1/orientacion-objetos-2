package tp1.punto2.persistencia;

import tp1.punto2.modelo.RegistroDeCosto;

import java.util.ArrayList;

public class EnMemoriaRegistroDeCosto implements RegistroDeCosto {
    private final ArrayList<String> registros = new ArrayList<>();

    @Override
    public void registrar(String registro) {
        this.registros.add(registro);
    }

    @Override
    public String contenido() {
        return this.registros.get(registros.size() - 1).trim();
    }
}
