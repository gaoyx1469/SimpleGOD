package top.tiral.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCPЭ�鷢������
 * 1.�������Ͷ�Socket����
 * 2.��ȡ�����
 * 3.�ͷ���Դ
 * 
 * 
 * @author ������
 *
 */
public class TCPSendDemo {

	public static void main(String[] args) throws IOException {
		// �������Ͷ�Socket����
		Socket sendSocket = new Socket("172.20.72.221", 10010);
		// ����д������
		String input = "TCP test";
		// ��ȡ�����
		OutputStream os = sendSocket.getOutputStream();
		// д����
		os.write(input.getBytes());
		// ���߷�����д�����
		sendSocket.shutdownOutput();

		// ��ȡ������
		InputStream is = sendSocket.getInputStream();
		// ��ȡ����
		byte[] bs = new byte[1024];
		int length = is.read(bs);// ��ȡ���ݣ������˲���������һֱ��������״̬
		String output = new String(bs);
		// �������
		System.out.println(output);

		// �ͷ���Դ
		sendSocket.close();

	}

}
