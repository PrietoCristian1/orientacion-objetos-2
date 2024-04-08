package tp1.punto1;

import tp1.punto1.modelo.MailSender;

public class FakeEnvioDeCorreo implements MailSender {
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
