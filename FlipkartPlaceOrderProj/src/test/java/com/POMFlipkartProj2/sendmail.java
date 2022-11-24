package com.POMFlipkartProj2;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class sendmail {
	 public static void main(String[] args) throws MessagingException {  

	String[] a=new String[]{"ghi@hotmail.com", "def@yahoo.com", "ghi@gmail.com", "abc@channelier.com", "abc@hotmail.com",
			 "def@hotmail.com", "abc@gmail.com", "abc@yahoo.com", "def@channelier.com","jkl@hotmail.com", "ghi@yahoo.com", "def@gmail.com"};
		
		 
		 
			  
			  String host="mail.gmail.com";  
			  final String user="shrija@gmail.com";//change accordingly  
			  final String password="xxxxx";//change accordingly  
			    
			//  String to="sonoojaiswal1987@gmail.com";//change accordingly  
			  
			   //Get the session object  
			   Properties props = new Properties();  
			   props.put("mail.smtp.host",host);  
			   props.put("mail.smtp.auth", "true");  
			     
			   Session session = Session.getDefaultInstance(props);  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(user,password);  
			      }  
			    };
			    
			    for(int i=0;i<a.length;i++) {
			    	if(a[i].contains("abc")) {
			      MimeMessage message = new MimeMessage(session);  
			      message.setFrom(new InternetAddress(user));  
			      message.addRecipient(Message.RecipientType.TO,new InternetAddress(a[i]));  
			      message.setSubject("javatpoint");  
			      message.setText("This is simple program of sending email using JavaMail API");  
			        
			     //send the message  
			      Transport.send(message);  
			   
			      System.out.println("message sent successfully...");  
			    	}
			    }
			    
			    };  
}
