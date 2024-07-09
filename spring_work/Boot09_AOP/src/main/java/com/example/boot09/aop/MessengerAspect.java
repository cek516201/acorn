package com.example.boot09.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 * void -> return type이 void
	 * send* -> send로 시작하는 메소드명
	 * (..) -> 매개변수는 없어도 되고 여러개여도 되고, type은 상관이 없다
	 * */
	
	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		for (Object tmp : args) {
			if(tmp instanceof String) {
				String msg = (String)tmp;
				System.out.println("aspect에서 읽어낸 내용 : " + msg);
				if(msg.contains("똥깨")) {
					System.out.println("똥깨는 금지된 단어입니다");
					return;
				}
			}
		}
		
		// 이 메소드를 호출하는 시점에 실제로 aspect가 적용된 메소드가 수행된다(호출하지 않으면 수행 안됨)
		joinPoint.proceed();
		
		// aspect가 적용된 메소드가 리턴된 이후에 할 작업은 proceed() 호출 이후에 한다
		System.out.println("aspect가 적용된 메소드가 리턴했습니다");
	}
	
	/*
	 * return type은 String이고 (java.lang 생략 가능)
	 * get으로 시작은 메소드이고
	 * 메소드에 전달되는 인자는 없다
	 * com.example.boot09.util 패키지에 존재하는 모든 클래스의 메소드 중에서 get으로 시작하는 메소드
	 * */
	@Around("execution(String com.example.boot09.util.*.get*())")
	public Object checkReturn(ProceedingJoinPoint joinPoint) throws Throwable{
		Object obj = joinPoint.proceed();
		String a = (String)obj;
		
		return a + "요";
	}
}