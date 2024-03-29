package mycode;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
public class EmailSender{
private EmailSender() {
}
    public  void send(String msg,String to) {
        // Recipient's email ID needs to be mentioned.
        // Sender's email ID needs to be mentioned
        String from = "khaledabulibdeh@gmail.com";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("khaledabulibdeh@gmail.com", "6*1*2001*");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Result");
            
            // Now set the actual message
            message.setText(msg);
        } catch (MessagingException mex) {
            JOptionPane.showMessageDialog(null, "exception");
        }
    }
}