package tp1.punto1;

import tp1.punto1.modelo.RegistroDeInscripcion;

public class FakeRegistroDeInscripcion implements RegistroDeInscripcion {
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
