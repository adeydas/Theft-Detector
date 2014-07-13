package ws.abhis.apps.TheftDetector;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	
	//Code from http://www.tutorialspoint.com/javamail_api/javamail_api_send_email_with_attachment.htm
	public static void sendEmail(ConfigType c, String extIp, String intIp) {
		// Recipient's email ID needs to be mentioned.
	      String to = c.getSmtpTo();

	      // Sender's email ID needs to be mentioned
	      String from = c.getSmtpFrom();

	      final String username = c.getSmtpUser();//change accordingly
	      final String password = c.getSmtpPass();//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = c.getSmtpHost();

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", c.getSmtpAuth());
	      props.put("mail.smtp.starttls.enable", c.isTlsEnable());
	      props.put("mail.smtp.host", c.getSmtpHost());
	      props.put("mail.smtp.port", c.getSmtpPort());

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Device stolen");

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         
	         String messageBody = "External IP: " + extIp + "\n"
	        		 + "Internal IP: " + intIp;
	         
	         // Now set the actual message
	         messageBodyPart.setText(messageBody);

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "latest.png";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	}
}
