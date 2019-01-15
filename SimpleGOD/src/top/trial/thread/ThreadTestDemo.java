package top.trial.thread;

import top.trial.xml.domain.WorkerDomain;

/**
 * �̼߳���ʾ������
 * 
 * @author ������
 *
 */
public class ThreadTestDemo {

	public static void main(String[] args) {

		// test1();
		// test2();
		test3();
	}

	/**
	 * 3������100��Ʊ����(δ����) ���ָ���Ʊ��ͬһ��Ʊ������������⣬��������
	 */
	private static void test1() {

		TicketRunnableImpl ticket = new TicketRunnableImpl();

		Thread thread1 = new Thread(ticket, "����1");
		Thread thread2 = new Thread(ticket, "����2");
		Thread thread3 = new Thread(ticket, "����3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

	/**
	 * �����������
	 */
	private static void test2() {

		DieLockRunnableImpl dieLockT = new DieLockRunnableImpl(true);
		DieLockRunnableImpl dieLockF = new DieLockRunnableImpl(false);

		Thread thread1 = new Thread(dieLockT, "�߳�1");
		Thread thread2 = new Thread(dieLockF, "�߳�2");

		thread1.start();
		thread2.start();
	}

	/**
	 * �ȴ�����ʵ��
	 */
	private static void test3() {

		WorkerDomain wd = new WorkerDomain();
		WorkerSetImpl wsi = new WorkerSetImpl(wd);
		WaitAndNotifyImpl wani = new WaitAndNotifyImpl(wd);

		Thread thread1 = new Thread(wsi, "�߳�1");
		Thread thread2 = new Thread(wani, "�߳�2");

		thread1.start();
		thread2.start();

	}

}
