package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice, 
									AfterReturningAdvice, 
									ThrowsAdvice, 
									MethodInterceptor {

	public TestAdvice() { 
	}
	
	@Override
	public void before(Method method, Object[] args, Object target ) throws Throwable {
		 System.out.println("[aop.adivce.TestAdvice][before]:"+ getClass() +" start ");
		 System.out.println("[before]:"+method );
		 
		 if(args.length!=0) {
			 System.out.println("[before]:args[0]"+args[0]);
		 }
		  
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] agrs, Object target) throws Throwable {
		 System.out.println("[after]"+getClass()+"afterRetuning() start ! ");
		 System.out.println("[after] method:"+method);
		 System.out.println("[after] (타겟객체의 호출후) ?? returnValue"+returnValue);
		 System.out.println("[after]"+getClass() +"afterRunning() end !"); 
		 
		 
	}
	
	@Override
	public Object invoke(MethodInvocation invocation ) throws Throwable {
		System.out.println("[invoke/ Around before] :"+getClass()+"invoke() start");
		System.out.println("[invoke/ Around before] : invocation.getMethod:"+ invocation.getMethod() );
		
		if(invocation.getArguments().length !=0 ) {
			System.out.println("[invoke/ Around before] : 전달아규먼트:"+invocation.getArguments()[0] );
		}
		
		Object obj = invocation.proceed();
		
		System.out.println("[Around after] 타겟 객체의 호출 후 return value? :"+obj);
		System.out.println("[Around after] "+getClass()+"invoke() end ");
		
		return obj;
	}

    public void afterThrowing(Throwable throwable ) {
    	System.out.println("[exception]"+getClass()+ "afterThrowing() start" );
    	System.out.println("[exception] exception발생");
    	System.out.println("[exception] exception msg:"+throwable.getMessage() );
    	System.out.println("[exception]"+getClass()+"afterThrowing() end");
    }
	

}
