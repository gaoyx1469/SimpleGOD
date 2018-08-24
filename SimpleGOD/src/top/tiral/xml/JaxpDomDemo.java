package top.tiral.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ������ʾ��XML�ļ���ֱ����ɾ�Ĳ����
 * @author ������
 *
 */
public class JaxpDomDemo {

	public static void main(String[] args) throws Exception {
		// �õ���������DocumentBuilderFactory
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// �õ�������DocumentBuilder
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		// ����ָ����XML�ĵ����õ������ڴ�DOM����document����
		Document document = db.parse("WebContent/WEB-INF/example/XMLExample.xml");

		// test1(document);
		// test2(document);
		// test3(document);
		// test4(document);
		// test5(document);
		// test6(document);
		test7(document);
	}

	// �飺�õ�ĳ������Ľڵ�����
	// ��õ�PythonԪ�ص�����
	private static void test1(Document document) {
		// ���ݱ�ǩ��Python��ȡ���е�PythonԪ��
		NodeList nl = document.getElementsByTagName("Python");
		// ��������ȡ��һ��
		Node n = nl.item(0);
		// ��ӡԪ������
		String text = n.getTextContent();
		System.out.println(text);
	}

	// �飺�������нڵ�
	// ��ӡ����Ԫ������
	private static void test2(Node node) {
		// �жϵ�ǰ�ڵ��Ƿ���Ԫ��
		short type = node.getNodeType();
		// ����ǣ���ӡ����
		if (type == Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		// ������ǣ�����
		// �������ĺ���
		NodeList nl = node.getChildNodes();
		int l = nl.getLength();
		for (int i = 0; i < l; i++) {
			Node n = nl.item(i);
			test2(n);
		}
	}

	// �ģ��޸�ĳ��Ԫ�ؽڵ����������
	private static void test3(Document document) throws Exception {
		// �ҵ��ýڵ�
		NodeList nl = document.getElementsByTagName("C");
		Node n = nl.item(0);
		// ������������
		n.setTextContent("C����");
		// ���ڴ��е�Dcoument��д��XML�ļ���
		transToXml(document);
	}

	// ������ָ��Ԫ�ؽڵ���������Ԫ�ؽڵ�
	// ��Tech�ڵ�������<΢����>Docker</΢����>
	private static void test4(Document document) throws Exception {
		// ���ڵ�
		NodeList nl = document.getElementsByTagName("Tech");
		Node n = nl.item(0);
		// �½�Ԫ��
		Element el = document.createElement("΢����");
		el.setTextContent("Docker");
		// �ڸ��ڵ��������½���Ԫ��
		n.appendChild(el);
		// ���ڴ��е�Dcoument��д��XML�ļ���
		transToXml(document);
	}

	// ������ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�
	// ��concurrent�ڵ�ǰ����<΢����>Docker</΢����>
	private static void test5(Document document) throws Exception {
		// �ο��ӽڵ�
		NodeList nl = document.getElementsByTagName("concurrent");
		Node n = nl.item(0);
		// �½�Ԫ��
		Element el = document.createElement("΢����");
		el.setTextContent("Docker");
		// �ڸ��ڵ��������½���Ԫ��
		n.getParentNode().insertBefore(el, n);
		// ���ڴ��е�Dcoument��д��XML�ļ���
		transToXml(document);
	}

	// ɾ��ɾ��ָ��Ԫ�ؽڵ�
	// ɾ��<΢����>Docker</΢����>
	private static void test6(Document document) throws Exception {
		// �ҵ��ýڵ�
		Node n = document.getElementsByTagName("΢����").item(0);
		// ɾ��
		n.getParentNode().removeChild(n);
		// ���ڴ��е�Dcoument��д��XML�ļ���
		transToXml(document);

	}

	// ����ɾ���ġ��飺����XML�ļ�����
	// TechԪ�ص�����name�Ļ�ȡ
	private static void test7(Document document) throws Exception {
		//��ȡԪ�ؽڵ�
		Node n = document.getElementsByTagName("Tech").item(0);
		//ǿתΪElement,��ΪElement�в��л�ȡ�������Եķ���
		Element e = (Element) n;
		//��ȡԪ��
		String s = e.getAttribute("name");
		
		System.out.println(s);
	}

	private static void transToXml(Document document)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		// ���ת��������
		TransformerFactory fac = TransformerFactory.newInstance();
		// ���ת����
		Transformer tran = fac.newTransformer();
		// ִ��ת������
		tran.transform(new DOMSource(document), new StreamResult("WebContent/WEB-INF/example/XMLExample.xml"));
	}
}
