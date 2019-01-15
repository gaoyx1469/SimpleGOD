package top.trial.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import top.util.xml.SAXUtil;

/**
 * ������ʾSAX��ʽ��XML�ļ��Ĳ�ѯ����
 * 
 * @author ������
 *
 */
public class JaxpSaxDemo {
	
	@Test
	public void jaxpSaxTest() throws Exception {
		// ȫ�ֶ�ȡ
		// test1();

		// ��ȡ�������������ݡ�������
		test2();
	}

	private static void test2() throws Exception {

		String url = "WebContent/WEB-INF/example/XMLExample.xml";

		SAXUtil.getXMLReader(url, new ContentHandler() {

			boolean isTech = false;
			int count = 0;

			public void setDocumentLocator(Locator locator) {

			}

			public void startDocument() throws SAXException {

			}

			public void endDocument() throws SAXException {

			}

			public void startPrefixMapping(String prefix, String uri) throws SAXException {

			}

			public void endPrefixMapping(String prefix) throws SAXException {

			}

			public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
				if (isTech) {
					count++;
				}
				if ("Tech".equals(qName)) {
					isTech = true;
				}
			}

			public void endElement(String uri, String localName, String qName) throws SAXException {
				if ("Tech".equals(qName)) {
					isTech = false;
				}
			}

			public void characters(char[] ch, int start, int length) throws SAXException {
				if (count == 3 && isTech) {
					System.out.println(new String(ch, start, length));
				}
			}

			public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

			}

			public void processingInstruction(String target, String data) throws SAXException {

			}

			public void skippedEntity(String name) throws SAXException {

			}

		});
	}

	private static void test1() throws ParserConfigurationException, SAXException, IOException {
		// �õ�����������SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// �õ�������SAXParser
		SAXParser parser = factory.newSAXParser();
		// �õ�XML��ȡ����XMLReader
		XMLReader reader = parser.getXMLReader();
		// ע�����ݴ�������ContentHandler
		reader.setContentHandler(new MyContentHandler());
		// ��ȡXML�ĵ�
		reader.parse("WebContent/WEB-INF/example/XMLExample.xml");
	}

}

class MyContentHandler implements ContentHandler {

	public void setDocumentLocator(Locator locator) {

	}

	// �������ĵ���ʼʱ����
	public void startDocument() throws SAXException {
		System.out.println("�ĵ�������ʼ");
	}

	// �������ĵ�����ʱ����
	public void endDocument() throws SAXException {
		System.out.println("�ĵ���������");
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {

	}

	public void endPrefixMapping(String prefix) throws SAXException {

	}

	// ������Ԫ�ؿ�ʼʱ����
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("������Ԫ�أ�" + qName);
	}

	// ������Ԫ�ؽ���ʱ����
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("����Ԫ�أ�" + qName + "����");
	}

	// �������ı�����ʱ����
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("�ı����ݣ�" + new String(ch, start, length));
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

	}

	public void processingInstruction(String target, String data) throws SAXException {

	}

	public void skippedEntity(String name) throws SAXException {

	}

}