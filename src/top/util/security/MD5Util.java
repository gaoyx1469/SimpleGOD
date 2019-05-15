package top.util.security;

import java.security.MessageDigest;
import java.util.Base64;
/**
 * MD5工具类，生成MD5码值
 * 
 * @author 高宇翔
 *
 */
public class MD5Util {

	/**
	 * 根据传入字符串，使用MD5算法得到128位散列值，输出其BASE64编码
	 * 
	 * @param message
	 * @return
	 */
	public static String generateMD5(String message) {
		try {

			// 选择md5算法
			MessageDigest md = MessageDigest.getInstance("md5");

			// 生成二进制串
			byte b[] = md.digest(message.getBytes());

			// 采用BASE64编码变换字节序列为明文，原理是把3个字节转换为4个字节
			return Base64.getEncoder().encodeToString(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
