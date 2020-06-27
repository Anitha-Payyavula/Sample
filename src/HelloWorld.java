import java.io.*;  
import java.sql.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class HelloWorld extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String to[]=new String[30];
String n=request.getParameter("name");  
to[0]=request.getParameter("email");  
String subject=request.getParameter("subject");  
String msg=request.getParameter("message"); 
          
try{  
	DeadLockEmail x=new DeadLockEmail();
	x.sent(to,subject,msg);
   
  
	out.print(n);
	out.print("You are successfully sent the email...");  

}  catch (Exception e2) {
	System.out.println(e2);
	}  

out.close();  
}  

}  