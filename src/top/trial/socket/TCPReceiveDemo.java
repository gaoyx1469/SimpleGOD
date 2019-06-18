package top.trial.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCPЭ���������
 * 1.�������ն�Socket����
 * 2.�����ͻ������ӣ�����һ����Ӧ��Socket����
 * 3.��ȡ����������ȡ���ݣ���ʾ�ڿ���̨
 * 4.�ͷ���Դ
 * 
 * @author Gaoyx
 *
 */
public class TCPReceiveDemo {

	public static void main(String[] args) throws IOException {

		// �������ն�Socket����
		ServerSocket receiveSocket = new ServerSocket(10010);

		while (true) {
			receiveMessageToConsole(receiveSocket);
		}
	}

	/**
	 * ����socket
	 * 
	 * @param receiveSocket
	 * @throws IOException
	 */
	private static void receiveMessageToConsole(ServerSocket receiveSocket) throws IOException {
		// �����ͻ������ӣ�����һ����Ӧ��Socket����
		Socket sendSocket = receiveSocket.accept();// ���޽��գ���������״̬

		// ��ȡ����������ȡ���ݣ���ʾ�ڿ���̨
		InputStream input = sendSocket.getInputStream();

		byte[] b = new byte[1024];
		int len = input.read(b);
		String str = new String(b, 0, len);

		InetAddress address = sendSocket.getInetAddress();
		String ip = address.getHostAddress();
		String name = address.getHostName();

		System.out.println(ip + "--" + name + ":" + str);

		// ��ͻ��˷����ź�
		OutputStream output = sendSocket.getOutputStream();
		output.write("���ݽ��ճɹ�".getBytes());

		// �ͷ���Դ���������˲���
		sendSocket.close();
	}

}
