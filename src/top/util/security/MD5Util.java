package top.util.security;

import java.security.MessageDigest;
import java.util.Base64;
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
			return Base64.getEncoder().encodeToString(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
