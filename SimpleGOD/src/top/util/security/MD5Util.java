package top.util.security;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * MD5�����࣬����MD5��ֵ
 * 
 * @author ������
 *
 */
public class MD5Util {

	/**
	 * ���ݴ����ַ�����ʹ��MD5�㷨�õ�128λɢ��ֵ�������BASE64����
	 * 
	 * @param message
	 * @return
	 */
	public static String generateMD5(String message) {
		try {

			// ѡ��md5�㷨
			MessageDigest md = MessageDigest.getInstance("md5");

			// ���ɶ����ƴ�
			byte b[] = md.digest(message.getBytes());

			// ����BASE64����任�ֽ�����Ϊ���ģ�ԭ���ǰ�3���ֽ�ת��Ϊ4���ֽ�
			BASE64Encoder base64 = new BASE64Encoder();
			return base64.encode(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
