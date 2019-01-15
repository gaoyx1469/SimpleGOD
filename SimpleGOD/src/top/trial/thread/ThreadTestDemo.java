package top.trial.thread;

import top.trial.xml.domain.WorkerDomain;

/**
 * 线程简单演示操作类
 * 
 * @author 高宇翔
 *
 */
public class ThreadTestDemo {

	public static void main(String[] args) {

		// test1();
		// test2();
		test3();
	}

	/**
	 * 3窗口卖100张票问题(未加锁) 出现负数票及同一张票多次卖出的问题，加锁后解决
	 */
	private static void test1() {

		TicketRunnableImpl ticket = new TicketRunnableImpl();

		Thread thread1 = new Thread(ticket, "窗口1");
		Thread thread2 = new Thread(ticket, "窗口2");
		Thread thread3 = new Thread(ticket, "窗口3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

	/**
	 * 死锁问题举例
	 */
	private static void test2() {

		DieLockRunnableImpl dieLockT = new DieLockRunnableImpl(true);
		DieLockRunnableImpl dieLockF = new DieLockRunnableImpl(false);

		Thread thread1 = new Thread(dieLockT, "线程1");
		Thread thread2 = new Thread(dieLockF, "线程2");

		thread1.start();
		thread2.start();
	}

	/**
	 * 等待唤醒实例
	 */
	private static void test3() {

		WorkerDomain wd = new WorkerDomain();
		WorkerSetImpl wsi = new WorkerSetImpl(wd);
		WaitAndNotifyImpl wani = new WaitAndNotifyImpl(wd);

		Thread thread1 = new Thread(wsi, "线程1");
		Thread thread2 = new Thread(wani, "线程2");

		thread1.start();
		thread2.start();

	}

}
