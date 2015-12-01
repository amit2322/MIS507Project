package mainproject;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class EmailNotification {


    public static void sendEmail(String mailRecipient,String subject,String body)
    {
        final String username = "mis507splitbill@gmail.com";
        final String password = "splitbill123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.port", "587");


        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mis507splitbill@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(mailRecipient));
            message.setSubject(subject);
            message.setText(body);

            
            SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

            t.connect("smtp.gmail.com", username, password);
            t.sendMessage(message, message.getAllRecipients());      
            t.close();
        } 

        catch (MessagingException e) 
        {
             throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) 
    {
        sendEmail("prashantkarnad@gmail.com","Your pay details","Dear customer,\n\n Please pay up now!");
    }
}