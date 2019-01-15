package top.trial.thread;

import top.trial.xml.domain.WorkerDomain;

public class WaitAndNotifyImpl implements Runnable {

	private WorkerDomain wd;

	public WaitAndNotifyImpl(WorkerDomain wd) {
		this.wd = wd;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (wd) {
				if (!wd.isFlag()) {
					try {
						wd.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				wd.notify();
				wd.setFlag(false);
				System.out.println(wd.toString());
			}
		}

	}

}
