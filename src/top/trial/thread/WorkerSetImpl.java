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
			synchronized (wd) {

				if (wd.isFlag()) {
					try {
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
				wd.notify();
				num++;
			}

		}
	}

}
