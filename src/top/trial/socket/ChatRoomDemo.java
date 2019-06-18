package top.trial.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import org.junit.Test;

/**
 * 多线程模拟聊天室Demo
 * 
 * @author Gaoyx
 *
 */
public class ChatRoomDemo {

	@Test
	public void chatRoomTest() throws IOException {

		// 创建发送Socket
		DatagramSocket dSend = new DatagramSocket();
		// 创建接收Socket
		DatagramSocket dReceive = new DatagramSocket(12306);

		SendThread sendThread = new SendThread(dSend);
		ReceiveThread receiveThread = new ReceiveThread(dReceive);

		Thread threadSend = new Thread(sendThread);
		Thread threadReceive = new Thread(receiveThread);

		threadReceive.start();
		threadSend.start();

	}
}
