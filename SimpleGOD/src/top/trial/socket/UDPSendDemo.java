package top.trial.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDPЭ�鷢������
 * @author ������
 * 
 * 1���������Ͷ�Socket����DatagramSocket
 * 2���������ݣ����
 * 3������Socket�����ͷ�������
 * 4���ͷ���Դ
 */
public class UDPSendDemo {
	public static void main(String[] args) throws IOException {

		// SendUDP("Socket UDP Test");

		// �������Ͷ�Socket����DatagramSocket
		DatagramSocket ds = new DatagramSocket();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			SendUDPSimple(line, ds);
		}
		// �ͷ���Դ
		ds.close();
	}

	/**
	 * UDPЭ�鷢������
	 * 
	 * @param msg
	 * @throws SocketException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void SendUDP(String msg) throws SocketException, UnknownHostException, IOException {

		// �������Ͷ�Socket����DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		// �������ݣ����
		byte[] buf = msg.getBytes();
		// Ŀ��IP��Ŀ��˿�
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.20.72.221"), 10010);
		// ����Socket�����ͷ�������
		ds.send(dp);

		System.out.println("���ͳɹ�");
		// �ͷ���Դ
		ds.close();
	}

	/**
	 * UDPЭ�鷢������
	 * 
	 * @param msg
	 * @throws SocketException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void SendUDPSimple(String msg, DatagramSocket ds)
			throws SocketException, UnknownHostException, IOException {

		// �������ݣ����
		byte[] buf = msg.getBytes();
		// Ŀ��IP��Ŀ��˿�
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.20.72.221"), 10010);
		// ����Socket�����ͷ�������
		ds.send(dp);

		System.out.println("���ͳɹ�");
	}
}
