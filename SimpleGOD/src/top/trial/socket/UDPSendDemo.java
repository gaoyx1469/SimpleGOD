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
 * UDP协议发送数据
 * @author 高宇翔
 * 
 * 1、创建发送端Socket对象DatagramSocket
 * 2、创建数据，打包
 * 3、调用Socket对象发送方法发送
 * 4、释放资源
 */
public class UDPSendDemo {
	public static void main(String[] args) throws IOException {

		// SendUDP("Socket UDP Test");

		// 创建发送端Socket对象DatagramSocket
		DatagramSocket ds = new DatagramSocket();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			SendUDPSimple(line, ds);
		}
		// 释放资源
		ds.close();
	}

	/**
	 * UDP协议发送数据
	 * 
	 * @param msg
	 * @throws SocketException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void SendUDP(String msg) throws SocketException, UnknownHostException, IOException {

		// 创建发送端Socket对象DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		// 创建数据，打包
		byte[] buf = msg.getBytes();
		// 目标IP和目标端口
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.20.72.221"), 10010);
		// 调用Socket对象发送方法发送
		ds.send(dp);

		System.out.println("发送成功");
		// 释放资源
		ds.close();
	}

	/**
	 * UDP协议发送数据
	 * 
	 * @param msg
	 * @throws SocketException
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private static void SendUDPSimple(String msg, DatagramSocket ds)
			throws SocketException, UnknownHostException, IOException {

		// 创建数据，打包
		byte[] buf = msg.getBytes();
		// 目标IP和目标端口
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.20.72.221"), 10010);
		// 调用Socket对象发送方法发送
		ds.send(dp);

		System.out.println("发送成功");
	}
}
