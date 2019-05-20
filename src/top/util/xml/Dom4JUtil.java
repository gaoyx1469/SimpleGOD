package top.util.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Dom4J������
 * 
 * @author ������
 *
 */
public class Dom4JUtil {

	/**
	 * DOM4J��ȡXML��DocumentԪ��
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static Document getDocument(String url) throws Exception {
		return (new SAXReader()).read(url);
	}

	/**
	 * DOM4J��ȡXML��Ԫ��
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static Element getRoot(String url) throws Exception {
		return (new SAXReader()).read(url).getRootElement();
	}

	/**
	 * ʹ��ָ�����뽫Documentд��XML�ļ�
	 * 
	 * @param document
	 * @param url
	 * @param encoding
	 * @throws IOException
	 */
	public static void write2File(Document document, String url, String encoding) throws IOException {
		Writer fw = new FileWriter(url);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding(encoding);
		XMLWriter writer = new XMLWriter(fw, format);
		writer.write(document);
		writer.close();
	}

	/**
	 * ʹ��GBK���뽫Documentд��XML�ļ�
	 * 
	 * @param document
	 * @param url
	 * @throws IOException
	 */
	public static void write2FileGBK(Document document, String url) throws IOException {
		write2File(document, url, "GBK");
	}

	/**
	 * ʹ��UTF-8���뽫Documentд��XML�ļ�
	 * 
	 * @param document
	 * @param url
	 * @throws IOException
	 */
	public static void write2FileUTF8(Document document, String url) throws IOException {
		write2File(document, url, "UTF-8");
	}

}
