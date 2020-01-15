package top.util.xml;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

/**
 * SAX方式操作XML工具类
 * 
 * @author Gaoyx
 *
 */
public class SAXUtil {
	/**
	 * 获取XML的XMLReader对象,载入事件处理器,处理传入的URL
	 * 
	 * @param url
	 * @param ch
	 * @throws Exception
	 */
	public static void getXMLReader(String url, ContentHandler ch) throws Exception {

		XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		reader.setContentHandler(ch);
		reader.parse(url);
	}

}
