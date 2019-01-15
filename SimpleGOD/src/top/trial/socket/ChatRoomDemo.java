package top.trial.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 多线程模拟聊天室Demo
 * 
 * @author 高宇翔
 *
 */
public class ChatRoomDemo {
	public static void main(String[] args) throws IOException {

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
