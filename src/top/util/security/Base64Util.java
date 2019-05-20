package top.util.security;

import java.util.Base64;

/**
 * Base64¹¤¾ßÏä
 * @author ¸ßÓîÏè
 *
 */
public class Base64Util {

	/**
	 * Base64±àÂë
	 * @param str	´ı±àÂë×Ö·û´®
	 * @return
	 */
	public static String base64Encoding(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}
	
	/**
	 * Base64½âÂë
	 * @param str	´ı½âÂë×Ö·û´®
	 * @return
	 */
	public static String base64Decoding(String str) {
		return new String(Base64.getDecoder().decode(str));
	}
}
