package top.trial.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class sendEmailDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("smtp.163.com", 25);
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));// ���շ������ķ�����Ϣ
		OutputStream out = socket.getOutputStream();// �������������Ϣ
		out.write("ehlo gaoyx\r\n".getBytes());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());

		out.write("auth login\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("Z2FveXgxNDY5\r\n".getBytes());// Base64������û���
		System.out.println(br.readLine());
		out.write("Z2FvMTQxNTkyNg==\r\n".getBytes());// Base64���������
		System.out.println(br.readLine());
		out.write("mail from:<xxxx@163.com>\r\n".getBytes());// �˴�������Ϊ��¼������
		System.out.println(br.readLine());
		out.write("rcpt to:<xxxx@126.com>\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("data\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("from:xxxx@163.com\r\n".getBytes());// �˴������mail from:��һ�£����ܱ�554�����������ʼ�����ʧ��
		out.write("to:xxxx@126.com\r\n".getBytes());
		out.write("cc:yyyy@126.com\r\n".getBytes());// ����
		out.write("subject:ûɶ����\r\n".getBytes());
		out.write("\r\n".getBytes());
		out.write("��������\r\n".getBytes());
		out.write(".\r\n".getBytes());
		System.out.println(br.readLine());
		socket.close();// quit
	}

}
