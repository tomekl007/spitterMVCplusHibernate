package my.spitterP.mainP.alerts;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import my.spitterP.mainP.Spittle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;



public class AlertServiceImpl implements AlertService {
  public void sendSpittleAlert(final Spittle spittle) {
	  System.out.println("before sending message jms template : " + jmsTemplate);
    jmsTemplate.send(
      "spittle.alert.queue",
      new MessageCreator() {      
        public Message createMessage(Session session)
                throws JMSException {
        	System.out.println("message send!");
          return session.createObjectMessage(spittle);
        }
      }
    );
  }
  
  @Autowired
  JmsTemplate jmsTemplate;
}
