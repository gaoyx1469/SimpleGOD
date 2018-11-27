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
	 * 创建数据接受包接收数据并打印
	 * @param ds
	 * @throws IOException
	 */
	private static void ReceiveUDPSimple(DatagramSocket ds) throws IOException {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		//调用Socket对象接收方法接收数据包
		System.out.println("等待接收");
		ds.receive(dp);
		System.out.println("接收成功");
		//解析数据
		String data = new String(dp.getData());
		//发送端信息
		InetAddress ia = dp.getAddress();
		String ip = ia.getHostAddress();
		String name = ia.getHostName();
		System.out.println(name + "[" + ip + "]" + "------" + data);
	}


}
