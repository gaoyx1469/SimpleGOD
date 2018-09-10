package top.tiral.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTestDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//test1();
		
		test2();
	}

	/**
	 * 线程池使用举例
	 */
	private static void test1() {

		ExecutorService es = Executors.newFixedThreadPool(1);
		
		TicketRunnableImpl tri = new TicketRunnableImpl();
		
		es.submit(tri);
		
		es.shutdown();
	}
	
	/**
	 * Callable使用
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	private static void test2() throws InterruptedException, ExecutionException {
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		SumCallableImpl sci1 = new SumCallableImpl(10);
		SumCallableImpl sci2 = new SumCallableImpl(100);
		SumCallableImpl sci3 = new SumCallableImpl(200);
		
		Future<Integer> f1 = es.submit(sci1);
		Future<Integer> f2 = es.submit(sci2);
		Future<Integer> f3 = es.submit(sci3);
		
		es.shutdown();
		
		System.out.println(f1.get()+"--------"+f2.get()+"---------"+f3.get());
		
	}

}
