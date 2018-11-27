package top.tiral.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveThread implements Runnable {
	
	private DatagramSocket dReceive;

	public ReceiveThread(DatagramSocket dReceive) {
		this.dReceive = dReceive;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				ReceiveUDPSimple(dReceive);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * �������ݽ��ܰ��������ݲ���ӡ
	 * @param ds
	 * @throws IOException
	 */
	private static void ReceiveUDPSimple(DatagramSocket ds) throws IOException {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		//����Socket������շ����������ݰ�
		System.out.println("�ȴ�����");
		ds.receive(dp);
		System.out.println("���ճɹ�");
		//��������
		String data = new String(dp.getData());
		//���Ͷ���Ϣ
		InetAddress ia = dp.getAddress();
		String ip = ia.getHostAddress();
		String name = ia.getHostName();
		System.out.println(name + "[" + ip + "]" + "------" + data);
	}


}
