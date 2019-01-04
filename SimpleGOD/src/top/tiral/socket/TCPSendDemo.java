package top.tiral.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP协议发送数据
 * 1.创建发送端Socket对象
 * 2.获取输出流
 * 3.释放资源
 * 
 * 
 * @author 高宇翔
 *
 */
public class TCPSendDemo {

	public static void main(String[] args) throws IOException {
		// 创建发送端Socket对象
		Socket sendSocket = new Socket("172.20.72.221", 10010);
		// 创建写入数据
		String input = "TCP test";
		// 获取输出流
		OutputStream os = sendSocket.getOutputStream();
		// 写数据
		os.write(input.getBytes());
		// 告诉服务器写入完毕
		sendSocket.shutdownOutput();

		// 获取输入流
		InputStream is = sendSocket.getInputStream();
		// 读取数据
		byte[] bs = new byte[1024];
		int length = is.read(bs);// 读取数据，如服务端不反馈，则一直处于阻塞状态
		String output = new String(bs);
		// 输出数据
		System.out.println(output);

		// 释放资源
		sendSocket.close();

	}

}
