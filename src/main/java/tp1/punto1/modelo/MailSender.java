package tp1.punto1.modelo;

public interface MailSender {
    void enviarCorreo(String from, String to, String affair, String content);
}
