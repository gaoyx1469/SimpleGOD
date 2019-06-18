package top.trial.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPЭ���������
 * @author Gaoyx
 *
 * 1���������ն�Socket����DatagramSocket
 * 2���������ݽ��հ�DatagramPacket
 * 3������Socket������շ����������ݰ�
 * 4����������
 * 5���ͷ���Դ
 *
 */
public class UDPReceiveDemo {

	public static void main(String[] args) throws IOException {

		// �������ն�Socket����DatagramSocket
		// ����������ն˿�
		DatagramSocket ds = new DatagramSocket(10010);

		while (true) {
			ReceiveUDPSimple(ds);
		}
		// �ͷ���Դ
		// ds.close();
	}

	/**
	 * �������ݽ��ܰ��������ݲ���ӡ
	 * 
	 * @param ds
	 * @throws IOException
	 */
	private static void ReceiveUDPSimple(DatagramSocket ds) throws IOException {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// ����Socket������շ����������ݰ�
		System.out.println("�ȴ�����");
		ds.receive(dp);
		System.out.println("���ճɹ�");
		// ��������
		String data = new String(dp.getData());
		// ���Ͷ���Ϣ
		InetAddress ia = dp.getAddress();
		String ip = ia.getHostAddress();
		String name = ia.getHostName();
		System.out.println(name + "[" + ip + "]" + "------" + data);
	}

}
