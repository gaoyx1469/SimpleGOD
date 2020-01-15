package top.util.security;

import java.util.Base64;

/**
 * Base64工具箱
 * @author Gaoyx
 *
 */
public class Base64Util {

	/**
	 * Base64编码
	 * @param str	待编码字符串
	 * @return
	 */
	public static String base64Encoding(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}
	
	/**
	 * Base64解码
	 * @param str	待解码字符串
	 * @return
	 */
	public static String base64Decoding(String str) {
		return new String(Base64.getDecoder().decode(str));
	}
}
