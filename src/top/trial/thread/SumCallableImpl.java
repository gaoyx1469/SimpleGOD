package top.trial.thread;

import java.util.concurrent.Callable;

public class SumCallableImpl implements Callable<Integer> {

	private int number = 0;

	/*
	 * public SumCallableImpl() {
	 * 
	 * }
	 */

	public SumCallableImpl(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {

		int sum = 0;

		for (int i = 1; i <= number; i++) {
			sum += i;
		}

		return sum;
	}

}
