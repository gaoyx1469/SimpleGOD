package top.trial.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 模拟AOP中对service的增强之日志部分
 * 
 * @author Gaoyx
 *
 */

@Component("logger")
@Aspect // 将当前类配制成一个切面
public class AnnotationLogger {

	@Pointcut("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	private void pointCut() {
	}

	/**
	 * 作为前置通知
	 */
	@Before("execution(* *..*.*(..))")
	public void beginLogging() {
		System.out.println("日志记录-beginLogging");
	}

	/**
	 * 作为后置通知
	 */
	@AfterReturning("pointCut()")
	public void endLogging() {
		System.out.println("日志记录-endLogging");
	}

	/**
	 * 作为异常通知
	 */
	@AfterThrowing("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public void exceptionLogging() {
		System.out.println("日志记录-exceptionLogging");
	}

	/**
	 * 作为最终通知
	 */
	@After("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public void finalLogging() {
		System.out.println("日志记录-finalLogging");
	}

	/**
	 * 作为环绕通知，是允许程序员可以不使用配置，而是使用代码的方式为切入点方法添加各种通知。
	 * 
	 * 使得切入点方法不执行，环绕通知运行顺序是在前置通知之后，同时会颠倒最终通知和后置通知的顺序，使得最终通知早于后置通知。
	 * 
	 * 切入点方法不执行的分析：动态代理代码中，需要主动调用切入点方法
	 * 
	 * 为调用切入点方法，需要为环绕通知方法增加参数，类型为ProceedingJoinPoint
	 * 
	 */
	@Around("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public Object aroundLogging(ProceedingJoinPoint pjp) {

		System.out.println("日志记录-aroundLogging---前置");

		Object rtValue = null;
		Object[] args = pjp.getArgs();
		try {
			pjp.proceed(args);
			System.out.println("日志记录-aroundLogging---后置");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("日志记录-aroundLogging---异常");
		} finally {
			System.out.println("日志记录-aroundLogging---最终");
		}
		return rtValue;

	}
}
