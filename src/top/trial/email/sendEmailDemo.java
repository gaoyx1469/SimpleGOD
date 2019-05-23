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
		BufferedReader br = new BufferedReader(new InputStreamReader(in));// 接收服务器的反馈信息
		OutputStream out = socket.getOutputStream();// 向服务器发送信息
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
		out.write("Z2FveXgxNDY5\r\n".getBytes());// Base64编码的用户名
		System.out.println(br.readLine());
		out.write("Z2FvMTQxNTkyNg==\r\n".getBytes());// Base64编码的密码
		System.out.println(br.readLine());
		out.write("mail from:<xxxx@163.com>\r\n".getBytes());// 此处邮箱需为登录的邮箱
		System.out.println(br.readLine());
		out.write("rcpt to:<xxxx@126.com>\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("data\r\n".getBytes());
		System.out.println(br.readLine());
		out.write("from:xxxx@163.com\r\n".getBytes());// 此处如果与mail from:不一致，可能报554，当作垃圾邮件发送失败
		out.write("to:xxxx@126.com\r\n".getBytes());
		out.write("cc:yyyy@126.com\r\n".getBytes());// 抄送
		out.write("subject:没啥主题\r\n".getBytes());
		out.write("\r\n".getBytes());
		out.write("这是正文\r\n".getBytes());
		out.write(".\r\n".getBytes());
		System.out.println(br.readLine());
		socket.close();// quit
	}

}
