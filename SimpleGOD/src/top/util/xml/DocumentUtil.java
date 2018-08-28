package top.util.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * Document工具类，DOM方式操作XML
 * @author 高宇翔
 *
 */
public class DocumentUtil {
	
	/**
	 * 根据URL获取XML的Document对象
	 * @param url
	 * @return Document对象
	 * @throws Exception
	 */
	public static Document getDocument(String url) throws Exception {
		// 获取DocumentBuilder
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// 解析并返回
		return db.parse(url);
	}

	/**
	 * 将Document对象写回XML文件
	 * 
	 * @param document
	 * @throws Exception
	 */
	public static void write2xml(Document document, String url) throws Exception {
		// 获取Transformer
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		// 写入XML文件
		tf.transform(new DOMSource(document), new StreamResult(url));
	}

}
