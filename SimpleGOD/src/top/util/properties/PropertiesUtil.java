package top.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * properties�ļ�����������
 * 
 * @author ������
 *
 */
public class PropertiesUtil {

	/**
	 * ����URI�����ResourceBundle;URI��classespathΪ��Ŀ¼����/��.����Ŀ¼�ṹ�ָ��Կ�
	 * 
	 * @param uri
	 * @return
	 */
	public static ResourceBundle getPropertiesResourceBundle(String uri) {
		return ResourceBundle.getBundle(uri);
	}

	/**
	 * ����URI�����������������ֵ;URI��classespathΪ��Ŀ¼����/��.����Ŀ¼�ṹ�ָ��Կ�
	 * 
	 * @param uri
	 * @param name
	 * @return
	 */
	public static String getPropertiesValue(String uri, String name) {
		return ResourceBundle.getBundle(uri).getString(name);
	}

	/**
	 * ����URI�����Properties;URI��classespathΪ��Ŀ¼����/����Ŀ¼�ṹ�ָ��Կ�
	 * 
	 * @param uri
	 * @return
	 * @throws IOException
	 */
	public static Properties getPropertiesByClassloader(String uri) throws IOException {

		// ����������
		ClassLoader cl = PropertiesUtil.class.getClassLoader();

		// ��������ļ���������
		InputStream in = cl.getResourceAsStream(uri);

		// ���Properties����
		Properties props = new Properties();

		// ����������
		props.load(in);
		return props;
	}

	/**
	 * ����URI�����������������ֵ;URI��classespathΪ��Ŀ¼����/����Ŀ¼�ṹ�ָ��Կ�
	 * 
	 * @param uri
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public static String getPropertiesValueByClassloader(String uri, String name) throws IOException {
		// ����������
		ClassLoader cl = PropertiesUtil.class.getClassLoader();

		// ��������ļ���������
		InputStream in = cl.getResourceAsStream(uri);

		// ���Properties����
		Properties props = new Properties();

		// ����������
		props.load(in);

		return props.getProperty(name);
	}
}
