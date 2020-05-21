package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {
		
	
	
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("---------------------------------");
		System.out.println("[before Log]"+getClass()+".before() start");
		System.out.println("[before Log] targetObj Call Method:"+method);
		
		if(args.length != 0) {
			System.out.println("[before Log]: 아규먼트들."+args[0]);
		}
		
		System.out.println("[before Log]"+getClass()+".before() end");
		
	}

 
	
}
