

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DeadLockEmail {
	public static void sent(String[] to, String subject, String msg) {
		System.out.println("anitha");
		
	   
	    final String from ="anitha.payyavula97@gmail.com";
	    final  String password ="Neeraj@1231";


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });
	    try {
	   //session.setDebug(true);  
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   
	   InternetAddress[] recipientAddress = new InternetAddress[to.length];
	   int counter = 0;
	   for (String recipient : to) {
	       recipientAddress[counter] = new InternetAddress(recipient.trim());
	       counter++;
	   } 
	   message.setRecipients(Message.RecipientType.BCC, recipientAddress);

	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	   
	}
	public static void main(String[] args) {
		RestSample s=new RestSample();
		try {
		    String x=s.MyGETRequest();
		    if(x!="") {
		    JSONParser parse = new JSONParser();
			
			
				JSONObject jobj = (JSONObject)parse.parse(x);
				JSONArray jsonarr_1 = (JSONArray) jobj.get("to");
				String[] myarray = new String[jsonarr_1.size()];
				for(int i=0;i<jsonarr_1.size();i++)
				{
					
					System.out.println(jsonarr_1.get(i));
					myarray[i]=(String) jsonarr_1.get(i);
					
					
				}
				sent(myarray,(String)jobj.get("subject"),(String)jobj.get("body"));
				
		    }

	}
		catch(Exception e) {
			
	}
}}
	


