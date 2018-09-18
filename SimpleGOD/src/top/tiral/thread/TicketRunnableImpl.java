package top.tiral.thread;

/**
 * ��Ʊ����ʵ�־���
 * @author ������
 *
 */
public class TicketRunnableImpl implements Runnable {

	private int ticketNum = 100;
	
	//������
	private Object obj = new Object();
	
	@Override
	public void run() {
		
		//������Ҳ������ȡ��һ��������Ȼ��ʹ��synchronized����
		//Ҳ����ʹ��Lock�ӿڵ�lock��unlock����Χ��
		synchronized (obj) {
			while(ticketNum > 0) {
				System.out.println(Thread.currentThread().getName()+":"+ticketNum);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ticketNum -- ;
			}
		}
		
	}

}
