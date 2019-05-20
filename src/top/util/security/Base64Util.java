package top.util.security;

import java.util.Base64;

/**
 * Base64������
 * @author ������
 *
 */
public class Base64Util {

	/**
	 * Base64����
	 * @param str	�������ַ���
	 * @return
	 */
	public static String base64Encoding(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}
	
	/**
	 * Base64����
	 * @param str	�������ַ���
	 * @return
	 */
	public static String base64Decoding(String str) {
		return new String(Base64.getDecoder().decode(str));
	}
}
