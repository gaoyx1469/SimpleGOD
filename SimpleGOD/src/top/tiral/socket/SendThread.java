package top.tiral.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendThread implements Runnable {

	private DatagramSocket dSend;

	public SendThread(DatagramSocket dSend) {
		this.dSend = dSend;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = br.readLine()) != null) {
				SendUDPSimple(line, dSend);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.20.72.221"), 12306);
		// 调用Socket对象发送方法发送
		ds.send(dp);

		System.out.println("发送成功");
	}

}
