package tp1.punto1.mailservice;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import tp1.punto1.modelo.MailSender;

import java.util.Properties;

public class JakartaEmail implements MailSender {
    //provide Mailtrap's password
    public static final String PASSWORD = "9a1e5662c1b79c";
    //provide Mailtrap's username
    public static final String USERNAME = "8f658158cf7400";
    //provide Mailtrap's host address
    public static final String HOST = "sandbox.smtp.mailtrap.io";

    private static Session iniciarSesionMailtrap(Properties props) {
        //create the Session object
        return Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
    }

    private static Properties configurarMailtrapSMTP() {
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");
        return props;
    }

    public void enviarCorreo(String from, String to, String affair, String content) {
        Properties props = configurarMailtrapSMTP();
        Session session = iniciarSesionMailtrap(props);
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(from));
            //set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //set email subject field
            message.setSubject(affair);
            //set the content of the email message
            message.setText(content);
            //send the email message
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}