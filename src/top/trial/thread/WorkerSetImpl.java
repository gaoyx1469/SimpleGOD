package top.trial.thread;

import top.trial.xml.domain.WorkerDomain;

public class WorkerSetImpl implements Runnable {

	private WorkerDomain wd;
	private int num = 0;

	public WorkerSetImpl(WorkerDomain wd) {
		this.wd = wd;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (wd) {// 两个线程都使用wd作为锁，保证数据安全

				if (wd.isFlag()) {
					try {
						// System.out.println("implwait1");
						wd.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (num % 2 == 1) {
					wd.setName("左手");
					wd.setAge(18);
				} else {
					wd.setName("右手");
					wd.setAge(20);
				}
				wd.setFlag(true);
				// System.out.println("implnotify1");
				wd.notify();
				num++;
			}

		}
	}

}
