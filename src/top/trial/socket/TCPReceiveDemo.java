package top.trial.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议接收数据
 * 1.创建接收端Socket对象
 * 2.监听客户端连接，返回一个对应的Socket对象
 * 3.获取输入流，读取数据，显示在控制台
 * 4.释放资源
 * 
 * @author Gaoyx
 *
 */
public class TCPReceiveDemo {

	public static void main(String[] args) throws IOException {

		// 创建接收端Socket对象
		ServerSocket receiveSocket = new ServerSocket(10010);

		while (true) {
			receiveMessageToConsole(receiveSocket);
		}
	}

	/**
	 * 接收socket
	 * 
	 * @param receiveSocket
	 * @throws IOException
	 */
	private static void receiveMessageToConsole(ServerSocket receiveSocket) throws IOException {
		// 监听客户端连接，返回一个对应的Socket对象
		Socket sendSocket = receiveSocket.accept();// 如无接收，保持阻塞状态

		// 获取输入流，读取数据，显示在控制台
		InputStream input = sendSocket.getInputStream();

		byte[] b = new byte[1024];
		int len = input.read(b);
		String str = new String(b, 0, len);

		InetAddress address = sendSocket.getInetAddress();
		String ip = address.getHostAddress();
		String name = address.getHostName();

		System.out.println(ip + "--" + name + ":" + str);

		// 向客户端反馈信号
		OutputStream output = sendSocket.getOutputStream();
		output.write("数据接收成功".getBytes());

		// 释放资源，服务器端不关
		sendSocket.close();
	}

}
