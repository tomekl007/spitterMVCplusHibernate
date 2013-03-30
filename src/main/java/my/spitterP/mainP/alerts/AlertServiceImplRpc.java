package my.spitterP.mainP.alerts;

import my.spitterP.mainP.Spittle;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;


//@Component("alertServiceRpc")
public class AlertServiceImplRpc implements AlertService {
  private JavaMailSender mailSender;  
  private String alertEmailAddress;
  
  
  public AlertServiceImplRpc(){
	  this.mailSender=new JavaMailSenderImpl();
	  
	  this.alertEmailAddress="tomekl007@gmail.com";
  }
  
  
  
  public AlertServiceImplRpc(JavaMailSender mailSender, 
                          String alertEmailAddress) {
    this.mailSender = mailSender;
    this.alertEmailAddress = alertEmailAddress;
  }
      
  public void sendSpittleAlert(final Spittle spittle) {
	  
	  System.out.println("before sending spittleAlert e-mail");
    SimpleMailMessage message = new SimpleMailMessage();
    String spitterName = spittle.getSpitter().getFullName(); 
    message.setFrom("noreply@spitter.com"); 
    message.setTo(alertEmailAddress); 
    message.setSubject("New spittle from " + spitterName);
    message.setText(spitterName + " says: " + spittle.getSpittleText());
    mailSender.send(message);
  }  
}
