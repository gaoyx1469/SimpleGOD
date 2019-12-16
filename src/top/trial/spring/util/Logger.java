package top.trial.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ģ��AOP�ж�service����ǿ֮��־����
 * 
 * @author Gaoyx
 *
 */
public class Logger {
	/**
	 * ��Ϊǰ��֪ͨ
	 */
	public void beginLogging() {
		System.out.println("��־��¼-beginLogging");
	}

	/**
	 * ��Ϊ����֪ͨ
	 */
	public void endLogging() {
		System.out.println("��־��¼-endLogging");
	}

	/**
	 * ��Ϊ�쳣֪ͨ
	 */
	public void exceptionLogging() {
		System.out.println("��־��¼-exceptionLogging");
	}

	/**
	 * ��Ϊ����֪ͨ
	 */
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
