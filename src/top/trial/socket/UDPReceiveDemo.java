package top.trial.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议接受数据
 * @author Gaoyx
 *
 * 1、创建接收端Socket对象DatagramSocket
 * 2、创建数据接收包DatagramPacket
 * 3、调用Socket对象接收方法接收数据包
 * 4、解析数据
 * 5、释放资源
 *
 */
public class UDPReceiveDemo {

	public static void main(String[] args) throws IOException {

		// 创建接收端Socket对象DatagramSocket
		// 参数定义接收端口
		DatagramSocket ds = new DatagramSocket(10010);

		while (true) {
			ReceiveUDPSimple(ds);
		}
		// 释放资源
		// ds.close();
	}

	/**
	 * 创建数据接受包接收数据并打印
	 * 
	 * @param ds
	 * @throws IOException
	 */
	private static void ReceiveUDPSimple(DatagramSocket ds) throws IOException {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// 调用Socket对象接收方法接收数据包
		System.out.println("等待接收");
		ds.receive(dp);
		System.out.println("接收成功");
		// 解析数据
		String data = new String(dp.getData());
		// 发送端信息
		InetAddress ia = dp.getAddress();
		String ip = ia.getHostAddress();
		String name = ia.getHostName();
		System.out.println(name + "[" + ip + "]" + "------" + data);
	}

}
