/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.util;


import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;
import org.liber.api.model.TransactionEntity;
/**
 *
 * @author prashant
 */
public class SendEmail {
     
    private String to;     
    private String from;          
    private String subject;
    private String body;
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    final String username = "sanXXXXXXXXX@gmail.com";
    final String password =  "XXXXXXXXXXXX";
    
    public SendEmail(String to, String from, String subject, String body){
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
    }
    
    
    public void sendMail(){
      Properties properties = System.getProperties();      
      properties.setProperty("mail.smtp.host", "smtp.gmail.com");      
      properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
      properties.setProperty("mail.smtp.socketFactory.fallback", "false");
      properties.setProperty("mail.smtp.port", "465");
      properties.setProperty("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.debug", "true");
      properties.put("mail.store.protocol", "pop3");
      properties.put("mail.transport.protocol", "smtp");
      Session session = Session.getDefaultInstance(properties, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

      try {         
         MimeMessage message = new MimeMessage(session);        
         message.setFrom(new InternetAddress(from));      
         message.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(to,false));
         message.setSubject(subject);
         message.setText(body);
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
    
    }
    
    
    
}
