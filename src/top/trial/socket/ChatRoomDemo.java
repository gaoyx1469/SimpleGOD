package top.trial.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.junit.Test;

/**
 * ���߳�ģ��������Demo
 * 
 * @author ������
 *
 */
public class ChatRoomDemo {

	@Test
	public void chatRoomTest() throws IOException {

		// ��������Socket
		DatagramSocket dSend = new DatagramSocket();
		// ��������Socket
		DatagramSocket dReceive = new DatagramSocket(12306);

		SendThread sendThread = new SendThread(dSend);
		ReceiveThread receiveThread = new ReceiveThread(dReceive);

		Thread threadSend = new Thread(sendThread);
		Thread threadReceive = new Thread(receiveThread);

		threadReceive.start();
		threadSend.start();

	}
}