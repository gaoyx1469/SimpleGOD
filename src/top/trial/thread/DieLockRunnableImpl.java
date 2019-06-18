package top.trial.thread;

/**
 * 死锁问题示例类
 * 
 * @author Gaoyx
 *
 */
public class DieLockRunnableImpl implements Runnable {

	private boolean flag;

	public DieLockRunnableImpl(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			synchronized (LockPool.objA) {
				System.out.println("if objA");
				synchronized (LockPool.objB) {
					System.out.println("if objB");
				}
			}
		} else {
			synchronized (LockPool.objB) {
				System.out.println("else objB");
				synchronized (LockPool.objA) {
					System.out.println("else objA");
				}
			}
		}
	}

}
