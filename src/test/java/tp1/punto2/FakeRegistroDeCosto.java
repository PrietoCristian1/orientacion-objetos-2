package tp1.punto2;

import tp1.punto2.modelo.RegistroDeCosto;

public class FakeRegistroDeCosto implements RegistroDeCosto {
    private String content;

    @Override
    public void registrar(String registro) {
        this.content = registro;
    }

    @Override
    public boolean comienzaCon(String comienzo) {
        return this.content.startsWith(comienzo);
    }
}
