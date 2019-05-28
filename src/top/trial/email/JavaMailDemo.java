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
		Properties props = PropertiesUtil.getPropertiesByClassloader("javaMail.properties");// ��ȡ���������������ʼ�ʱʹ��,����Э�顢���������Ƿ���֤�û���Ϣ
		Session session = Session.getDefaultInstance(props);// ���ػ�������
		MimeMessage message = new MimeMessage(session);

		// �ʼ�ͷ
		message.setFrom(new InternetAddress("xxxx@163.com"));// ������
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("yyyy@126.com"));// �ռ���
		message.setSubject("JavaMail  ����");

		// �������ֵ��ʼ�����
		// textOnly(message);

		// �������ֺ�ͼƬ���ʼ�����
		// textAndPic(message);

		// �������ֺ�ͼƬ���ʼ����ģ������и���
		comp(message);

		// �ʼ�д�뱾��
		// message.writeTo(new FileOutputStream("D:\\1.eml"));

		// �ʼ�����
		Transport ts = session.getTransport();
		ts.connect("username", "password");
		;
		ts.sendMessage(message, message.getAllRecipients());

		ts.close();
	}

	// �������ֺ�ͼƬ���ʼ����ģ������и���
	private static void comp(MimeMessage message) throws MessagingException, UnsupportedEncodingException {

		// ���ֲ���
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("�ʼ�����<img src='cid:pic'/>���˽���<img src='cid:pic2'>", "text/html;charset=UTF-8");// ָ������ΪUTF-8

		// ͼƬ����
		MimeBodyPart picPart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("D:/workSpace/�زĿ�/icon/green-leaves-3.png"));// ����JAF��ܣ���ȡͼƬ������Ҫ������MIME������
		picPart.setDataHandler(dh);
		picPart.setContentID("pic");

		// �ڶ�ͼƬ����
		MimeBodyPart picPart2 = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("D:/workSpace/�زĿ�/icon/puzzle-piece@3x.png"));// ����JAF��ܣ���ȡͼƬ������Ҫ������MIME������
		picPart2.setDataHandler(dh);
		picPart2.setContentID("pic2");

		// ��ˮ���֣�ȫ��ճס
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(textPart);
		multipart.addBodyPart(picPart);
		multipart.addBodyPart(picPart2);
		multipart.setSubType("related");// ָ������Ƕ��Դ

		// ��װ���µ�BodyPart,�ı���ͼƬ-->����
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(multipart);

		// ��������
		MimeBodyPart attPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("C:\\Users\\admin\\Desktop\\sss\\����PDF.rar"));// ����JAF��ܣ���ȡZIP������Ҫ������MIME������
		String fileName = dh.getName();
		attPart.setDataHandler(dh);
		attPart.setFileName(fileName);// �ֹ����ø���������������������ʾ���绹���룬��fileName��ΪMimeUtility.encodeText(fileName)

		// �����븽����ˮ����
		MimeMultipart compMultipart = new MimeMultipart();
		compMultipart.addBodyPart(bodyPart);
		compMultipart.addBodyPart(attPart);
		compMultipart.setSubType("mixed");// ָ��������

		message.setContent(compMultipart);
		message.saveChanges();

	}

	// �������ֺ�ͼƬ���ʼ�����
	private static void textAndPic(MimeMessage message) throws MessagingException {

		// ���ֲ���
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("�ʼ�����<img src='cid:pic'/>���˽���", "text/html;charset=UTF-8");// ָ������ΪUTF-8

		// ͼƬ����
		MimeBodyPart picPart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("D:/workSpace/�زĿ�/icon/green-leaves-3.png"));// ����JAF��ܣ���ȡͼƬ������Ҫ������MIME������
		picPart.setDataHandler(dh);
		picPart.setContentID("pic");

		// ��ˮ����
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(textPart);
		multipart.addBodyPart(picPart);
		multipart.setSubType("related");

		// �����װ
		message.setContent(multipart);
	}

	// �������ֵ��ʼ�����
	private static void textOnly(MimeMessage message) throws MessagingException {
		// �ʼ�����
		message.setText("����JavaMail����", "UTF-8");
	}
}
