package top.util.xml;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

/**
 * SAX��ʽ����XML������
 * 
 * @author ������
 *
 */
public class SAXUtil {
	/**
	 * ��ȡXML��XMLReader����,�����¼�������,�������URL
	 * 
	 * @param url
	 * @param ch
	 * @throws Exception
	 */
	public static void getXMLReader(String url,ContentHandler ch) throws Exception{
		
		XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		reader.setContentHandler(ch);
		reader.parse(url);
	}
}
