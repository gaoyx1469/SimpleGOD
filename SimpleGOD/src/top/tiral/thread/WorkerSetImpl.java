package top.tiral.thread;

import top.tiral.xml.domain.WorkerDomain;

public class WorkerSetImpl implements Runnable {

	private WorkerDomain wd;
	private int num = 0;
	
	public WorkerSetImpl(WorkerDomain wd) {
		this.wd = wd;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(wd) {
				
				if(wd.isFlag()) {
					try {
						wd.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				if(num % 2 == 1) {
					wd.setName("◊Û ÷");
					wd.setAge(18);
				}else {
					wd.setName("”“ ÷");
					wd.setAge(20);
				}
				wd.setFlag(true);
				wd.notify();
				num ++;
			}
			
		}
	}

}
