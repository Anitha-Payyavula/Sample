import java.io.*;
import java.net.*;
import java.util.*;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

  
/**
 *
 * @author Administrator
 */
public class Email {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        // Establish a TCP connection with the mail server.
System.out.println("Enter the mail server you wish to connect to (example:  edge.nunet.nova.edu):\n");
String hostName = new String();
Scanner emailScanner = new Scanner(System.in);
hostName = emailScanner.next();
Socket emailSocket = new Socket(hostName, 25);
// Create a BufferedReader to read a line at a time. 
InputStream is = emailSocket.getInputStream(); 
InputStreamReader isr = new InputStreamReader(is); 
BufferedReader br = new BufferedReader(isr); 
// Read greeting from the server. 
String response = br.readLine(); 
System.out.println(response); 
if (!response.startsWith("220")) { 
throw new Exception("220 reply not received from server.\n"); 
} 
// Get a reference to the socket's output stream. 
OutputStream os = emailSocket.getOutputStream(); 
// Send HELO command and get server response. 
String command = "HELO pbrooks\r\n"; 
System.out.print(command); 
os.write(command.getBytes("US-ASCII")); 
response = br.readLine(); 
System.out.println(response); 
if (!response.startsWith("250")) { 
throw new Exception("250 reply not received from server.\n"); 
} 
// Send MAIL FROM command.
System.out.println("Please enter your (source) e-mail address (example: me@myexample.com:\n");
String sourceAddress = emailScanner.next();
String mailFromCommand = "MAIL FROM:  <" + sourceAddress + ">\r\n";
System.out.println(mailFromCommand);
os.write(command.getBytes("US-ASCII"));
response = br.readLine();
System.out.println(response);
if (!response.startsWith("250"))
    throw new Exception("250 reply not received from server.\n");
// Send RCPT TO command.
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
   return new PasswordAuthentication(sourceAddress,password);  
}  
});
System.out.println("Please type the destination e-mail address (example:  example@nova.edu):\n");
String destEmailAddress = new String();
destEmailAddress = emailScanner.next();
String fullAddress = new String();
fullAddress = "RCPT TO:  <" + destEmailAddress + ">\r\n";
System.out.println(fullAddress);
os.write(fullAddress.getBytes("US-ASCII"));
response = br.readLine();
System.out.println(response);
if(!response.startsWith("250"))
{
    throw new Exception("250 reply not received from server.\n");
}
  // Send DATA command.  
String dataString = new String();
dataString = "DATA";
System.out.println(dataString);
os.write(dataString.getBytes("US-ASCII"));
response = br.readLine();
if(!response.startsWith("354"))
    throw new Exception("354 reply not received from server.\n");
System.out.println(response);
// Send message data. 
System.out.println("Enter your message, enter '.' on a separate line to end message data entry:\n");
String input = new String();
while(input.charAt(0) != '.')
{
    input = emailScanner.next();
    os.write(input.getBytes("US-ASCII"));
}
    //End with line with a single period.
os.write(input.getBytes("US-ASCII"));
response = br.readLine();
System.out.println(response);
if(!response.startsWith("250"))
throw new Exception("250 reply not received from server\n");
  
// Send QUIT command.
String quitCommand = new String();
quitCommand = "QUIT";
os.write(quitCommand.getBytes("US-ASCII"));
  
  } 
}