package spring.service.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.aop.Message;
import spring.service.aop.proxy.MessageImplProxy;

 
public class MessageTestAppUseSpringAOP01 {
	
	///Main Method
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/messageservice01.xml"); 
		Message message = (Message)context.getBean("message");
		
		message.setMessage("Haaaai");
		
		System.out.println("[�׽�Ʈ��]: ���Ϲ����޽��� :"+message.getMessage()   );
		
	}
}//end of class