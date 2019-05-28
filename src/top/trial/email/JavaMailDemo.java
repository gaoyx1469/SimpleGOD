package top.trial.email;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import top.util.properties.PropertiesUtil;

public class JavaMailDemo {
	public static void main(String[] args)
			throws AddressException, MessagingException, FileNotFoundException, IOException {
		Properties props = PropertiesUtil.getPropertiesByClassloader("javaMail.properties");// 读取环境变量，发送邮件时使用,包含协议、服务器和是否验证用户信息
		Session session = Session.getDefaultInstance(props);// 加载环境变量
		MimeMessage message = new MimeMessage(session);

		// 邮件头
		message.setFrom(new InternetAddress("xxxx@163.com"));// 发件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("yyyy@126.com"));// 收件人
		message.setSubject("JavaMail  主题");

		// 仅有文字的邮件正文
		// textOnly(message);

		// 包含文字和图片的邮件正文
		// textAndPic(message);

		// 包含文字和图片的邮件正文，并且有附件
		comp(message);

		// 邮件写入本地
		// message.writeTo(new FileOutputStream("D:\\1.eml"));

		// 邮件发送
		Transport ts = session.getTransport();
		ts.connect("username", "password");
		;
		ts.sendMessage(message, message.getAllRecipients());

		ts.close();
	}

	// 包含文字和图片的邮件正文，并且有附件
	private static void comp(MimeMessage message) throws MessagingException, UnsupportedEncodingException {

		// 文字部分
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("邮件正文<img src='cid:pic'/>到此结束<img src='cid:pic2'>", "text/html;charset=UTF-8");// 指定编码为UTF-8

		// 图片部分
		MimeBodyPart picPart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("D:/workSpace/素材库/icon/green-leaves-3.png"));// 借助JAF框架，读取图片，不需要再设置MIME类型了
		picPart.setDataHandler(dh);
		picPart.setContentID("pic");

		// 第二图片部分
		MimeBodyPart picPart2 = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("D:/workSpace/素材库/icon/puzzle-piece@3x.png"));// 借助JAF框架，读取图片，不需要再设置MIME类型了
		picPart2.setDataHandler(dh);
		picPart2.setContentID("pic2");

		// 胶水部分，全部粘住
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(textPart);
		multipart.addBodyPart(picPart);
		multipart.addBodyPart(picPart2);
		multipart.setSubType("related");// 指定含内嵌资源

		// 组装到新的BodyPart,文本加图片-->正文
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(multipart);

		// 附件部分
		MimeBodyPart attPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("C:\\Users\\admin\\Desktop\\sss\\导出PDF.rar"));// 借助JAF框架，读取ZIP，不需要再设置MIME类型了
		String fileName = dh.getName();
		attPart.setDataHandler(dh);
		attPart.setFileName(fileName);// 手工设置附件名，否则可能乱码或不显示，如还乱码，则将fileName换为MimeUtility.encodeText(fileName)

		// 正文与附件胶水部分
		MimeMultipart compMultipart = new MimeMultipart();
		compMultipart.addBodyPart(bodyPart);
		compMultipart.addBodyPart(attPart);
		compMultipart.setSubType("mixed");// 指定含附件

		message.setContent(compMultipart);
		message.saveChanges();

	}

	// 包含文字和图片的邮件正文
	private static void textAndPic(MimeMessage message) throws MessagingException {

		// 文字部分
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("邮件正文<img src='cid:pic'/>到此结束", "text/html;charset=UTF-8");// 指定编码为UTF-8

		// 图片部分
		MimeBodyPart picPart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("D:/workSpace/素材库/icon/green-leaves-3.png"));// 借助JAF框架，读取图片，不需要再设置MIME类型了
		picPart.setDataHandler(dh);
		picPart.setContentID("pic");

		// 胶水部分
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(textPart);
		multipart.addBodyPart(picPart);
		multipart.setSubType("related");

		// 最后组装
		message.setContent(multipart);
	}

	// 仅有文字的邮件正文
	private static void textOnly(MimeMessage message) throws MessagingException {
		// 邮件正文
		message.setText("这是JavaMail正文", "UTF-8");
	}
}
