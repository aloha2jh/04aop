package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;


//aspect = advice+pointCut

//advisor(aspect)����
@Aspect 
public class TestAspectJ02 {

	public TestAspectJ02() { 
		System.out.println("testAspectJ 01 ������ȣ��.");
	}
	
	 
	
	@Before("execution(* *.getMessage(..))")  //beforeAdvice�� pointcut������ ����
	public void before(JoinPoint joinPoint) {
		 System.out.println("[aop.adivce.TestAdvice][before]:"+ getClass() +" start ");
		 System.out.println("[before]:"+joinPoint.getTarget().getClass().getName() );
		 
		 if(joinPoint.getArgs().length!=0) {
			 System.out.println("[before]:args[0]"+joinPoint.getArgs()[0]);
		 }
		 System.out.println("[before]:"+getClass()+"before() end" );
		 
	}

	@AfterReturning( pointcut="within(spring.service.aop..*)",returning="returnValue")  //after advice�� pointcut������������. spring.service.aop ����Ŭ�������δ�
	public void afterReturning(JoinPoint joinPoint, Object returnValue ) {
		 System.out.println("[after]"+getClass()+"afterRetuning() start ! ");
		 System.out.println("[after] Ÿ�ٰ�ü:"+ joinPoint.getTarget().getClass().getName() );
		 
		 System.out.println("[after] Ÿ�ٰ�ü�� ȣ��� �޼���"+joinPoint.getSignature().getName() );
		 System.out.println("[after]"+ returnValue ); 
		 System.out.println("[after]"+getClass() +"afterRunning() end !"); 
		  
	}
	
	@Around("execution(* spring.service.aop.*.*(..))") // 
	public Object invoke(ProceedingJoinPoint joinPoint ) throws Throwable {
		System.out.println("[Around before] :"+getClass()+"invoke() start");
		System.out.println("[Around before] Ÿ�� ��ü.."+ 
						joinPoint.getTarget().getClass().getName() );
		
		if(joinPoint.getArgs().length !=0 ) {
			System.out.println("[invoke/ Around before] : ���޾ƱԸ�Ʈ:"+joinPoint.getArgs()[0] );
		}
		
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȣ�� �� return value? :"+obj);
		System.out.println("[Around after] "+getClass()+"invoke() end ");
		
		return obj;
	}
	
	@AfterThrowing( pointcut="execution (public * *(..))", throwing="throwable" )
    public void afterThrowing(JoinPoint joinPoint , Throwable throwable ) {
    	System.out.println("[exception]"+getClass()+ "afterThrowing() start" );
    	System.out.println("[exception] exception�߻�");
    	System.out.println("[exception] exception msg:"+throwable.getMessage() );
    	System.out.println("[exception]"+getClass()+"afterThrowing() end");
    }
	

}
