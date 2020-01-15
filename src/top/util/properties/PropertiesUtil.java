package top.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * properties文件操作工具类
 * 
 * @author Gaoyx
 *
 */
public class PropertiesUtil {

	/**
	 * 传入URI，获得ResourceBundle;URI以classespath为根目录，以/或.进行目录结构分隔皆可，不需要跟扩展名
	 * 
	 * @param uri
	 * @return
	 */
	public static ResourceBundle getPropertiesResourceBundle(String uri) {
		return ResourceBundle.getBundle(uri);
	}

	/**
	 * 传入URI和属性名，获得属性值;URI以classespath为根目录，以/或.进行目录结构分隔皆可，不需要跟扩展名
	 * 
	 * @param uri
	 * @param name
	 * @return
	 */
	public static String getPropertiesValue(String uri, String name) {
		return ResourceBundle.getBundle(uri).getString(name);
	}

	/**
	 * 传入URI，获得ResourceBundle;URI以classespath为根目录，以/或.进行目录结构分隔皆可，不需要跟扩展名
	 * 
	 * @param uri
	 * @param locale	Locale可以使用类的常量，以实现国际化。WEB环境下，可以取request请求的getLocale方法获取。
	 * @return
	 */
	public static ResourceBundle getPropertiesResourceBundleByLocale(String uri, Locale locale) {
		return ResourceBundle.getBundle(uri, locale);
	}

	/**
	 * 传入URI和属性名，获得属性值;URI以classespath为根目录，以/或.进行目录结构分隔皆可，不需要跟扩展名
	 * 
	 * @param uri
	 * @param name
	 * @param locale	Locale可以使用类的常量，以实现国际化。WEB环境下，可以取request请求的getLocale方法获取。
	 * @return
	 */
	public static String getPropertiesValueByLocale(String uri, String name, Locale locale) {
		return ResourceBundle.getBundle(uri, locale).getString(name);
	}
	
	/**
	 * 传入URI，获得Properties;URI以classespath为根目录，不需以/开头，以/进行目录结构分隔皆可，需要跟扩展名
	 * 
	 * @param uri
	 * @return
	 * @throws IOException
	 */
	public static Properties getPropertiesByClassloader(String uri) throws IOException {

		// 获得类加载器
		ClassLoader cl = PropertiesUtil.class.getClassLoader();

		// 获得配置文件的输入流
		InputStream in = cl.getResourceAsStream(uri);

		// 获得Properties对象
		Properties props = new Properties();

		// 加载输入流
		props.load(in);
		return props;
	}

	/**
	 * 传入URI和属性名，获得属性值;URI以classespath为根目录，不需以/开头，以/进行目录结构分隔皆可，需要跟扩展名
	 * 
	 * @param uri
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public static String getPropertiesValueByClassloader(String uri, String name) throws IOException {
		// 获得类加载器
		ClassLoader cl = PropertiesUtil.class.getClassLoader();

		// 获得配置文件的输入流
		InputStream in = cl.getResourceAsStream(uri);

		// 获得Properties对象
		Properties props = new Properties();

		// 加载输入流
		props.load(in);

		return props.getProperty(name);
	}
}
