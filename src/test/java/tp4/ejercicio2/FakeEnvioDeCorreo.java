package tp4.ejercicio2;

import tp4.ejercicio2.model.EnviarCorreo;

public class FakeEnvioDeCorreo implements EnviarCorreo {
    private String from;
    private String string;
    private String affair;
    private String content;

    @Override
    public void enviarCorreo(String from, String to, String affair, String content) {
        this.from = from;
        this.string = to;
        this.affair = affair;
        this.content = content;
    }
}
