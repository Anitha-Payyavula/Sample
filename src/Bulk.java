import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Bulk {

	public static void main(String[] args) {
		// create a list of emails
		List<String> emails = new ArrayList<String>();
		emails.add("anitha.payyavula24@gmail.com");
		emails.add("anitha.payyavula1997@gmail.com");
		
		
		// email subject
		String subject = "Test Email";
		
		// message which is to be sent
		String message = "Test Email Message";
		
		// send the email to multiple recipients
		sendBulkEmail(subject, emails, message);
	}

	public static void sendBulkEmail(final String subject, final List<String> emailToAddresses,
			final String emailBodyText) {

		// from email address
		final String username = "";

		// make sure you put your correct password
		final String password = "Neeraj@1231";

		Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  

		// we authentcate using your email and password and on successful
		// we create the session
	    Session session = Session.getDefaultInstance(props,  
	    	    new javax.mail.Authenticator() {
	    	       protected PasswordAuthentication getPasswordAuthentication() {  
	    	       return new PasswordAuthentication(username,password);  
	    	   }  
	    	   });
		String emails = null;

		try {
			// we create new message
			Message message = new MimeMessage(session);

			// set the from 'email address'
			message.setFrom(new InternetAddress(username));

			// set email subject
			message.setSubject(subject);

			// set email message
			// this will send html mail to the intended recipients
			// if you do not want to send html mail then you do not need to wrap the message
			// inside html tags
			
			message.setContent("hiiii", "text/html");

			// form all emails in a comma separated string
			StringBuilder sb = new StringBuilder();

			int i = 0;
			for (String email : emailToAddresses) {
				sb.append(email);
				i++;
				if (emailToAddresses.size() > i) {
					sb.append(", ");
				}
			}

			emails = sb.toString();

			// set 'to email address'
			// you can set also CC or TO for recipient type
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sb.toString()));

			System.out.println("Sending Email to " + emails + " from " + username + " with Subject - " + subject);

			// send the email
			Transport.send(message);

			System.out.println("Email successfully sent to " + emails);
		} catch (MessagingException e) {
			System.out.println("Email sending failed to " + emails);
			System.out.println(e);
		}
	}

}