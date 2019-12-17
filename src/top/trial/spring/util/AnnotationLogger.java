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
 * ģ��AOP�ж�service����ǿ֮��־����
 * 
 * @author Gaoyx
 *
 */

@Component("logger")
@Aspect // ����ǰ�����Ƴ�һ������
public class AnnotationLogger {

	@Pointcut("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	private void pointCut() {
	}

	/**
	 * ��Ϊǰ��֪ͨ
	 */
	@Before("execution(* *..*.*(..))")
	public void beginLogging() {
		System.out.println("��־��¼-beginLogging");
	}

	/**
	 * ��Ϊ����֪ͨ
	 */
	@AfterReturning("pointCut()")
	public void endLogging() {
		System.out.println("��־��¼-endLogging");
	}

	/**
	 * ��Ϊ�쳣֪ͨ
	 */
	@AfterThrowing("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public void exceptionLogging() {
		System.out.println("��־��¼-exceptionLogging");
	}

	/**
	 * ��Ϊ����֪ͨ
	 */
	@After("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public void finalLogging() {
		System.out.println("��־��¼-finalLogging");
	}

	/**
	 * ��Ϊ����֪ͨ�����������Ա���Բ�ʹ�����ã�����ʹ�ô���ķ�ʽΪ����㷽����Ӹ���֪ͨ��
	 * 
	 * ʹ������㷽����ִ�У�����֪ͨ����˳������ǰ��֪֮ͨ��ͬʱ��ߵ�����֪ͨ�ͺ���֪ͨ��˳��ʹ������֪ͨ���ں���֪ͨ��
	 * 
	 * ����㷽����ִ�еķ�������̬��������У���Ҫ������������㷽��
	 * 
	 * Ϊ��������㷽������ҪΪ����֪ͨ�������Ӳ���������ΪProceedingJoinPoint
	 * 
	 */
	@Around("execution(* top.trial..AccountOperationAopAnnotationServiceImpl.*(..))")
	public Object aroundLogging(ProceedingJoinPoint pjp) {

		System.out.println("��־��¼-aroundLogging---ǰ��");

		Object rtValue = null;
		Object[] args = pjp.getArgs();
		try {
			pjp.proceed(args);
			System.out.println("��־��¼-aroundLogging---����");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("��־��¼-aroundLogging---�쳣");
		} finally {
			System.out.println("��־��¼-aroundLogging---����");
		}
		return rtValue;

	}
}
