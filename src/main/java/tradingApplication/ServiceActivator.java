package tradingApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.PollableChannel;

import com.sapient.model.Block;

public class ServiceActivator {





    private JmsTemplate jmsTemplate;
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceActivator springIntExample = (ServiceActivator) context.getBean("springIntExample");
        //springIntExample.sendEmployee();
    }
    
   
    
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void processEmployee(String msg) {
        System.out.println(msg);
    }
    public void processBlock(Block bl) {
        System.out.println(bl);
        
    }
    
}
