package top.util.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * Document�����࣬DOM��ʽ����XML
 * @author ������
 *
 */
public class DocumentUtil {
	
	/**
	 * ����URL��ȡXML��Document����
	 * @param url
	 * @return Document����
	 * @throws Exception
	 */
	public static Document getDocument(String url) throws Exception {
		// ��ȡDocumentBuilder
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// ����������
		return db.parse(url);
	}

	/**
	 * ��Document����д��XML�ļ�
	 * 
	 * @param document
	 * @throws Exception
	 */
	public static void write2xml(Document document, String url) throws Exception {
		// ��ȡTransformer
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		// д��XML�ļ�
		tf.transform(new DOMSource(document), new StreamResult(url));
	}

}
