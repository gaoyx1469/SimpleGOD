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
 * 此类演示SAX方式对XML文件的查询操作
 * 
 * @author Gaoyx
 *
 */
public class JaxpSaxDemo {
	
	@Test
	public void jaxpSaxTest() throws Exception {
		// 全局读取
		// test1();

		// 读取第三个技术内容“并发”
		test2();
	}

	private static void test2() throws Exception {

		String url = "WebContent/WEB-INF/example/XMLExample.xml";

		SAXUtil.getXMLReader(url, new ContentHandler() {

			boolean isTech = false;
			int count = 0;

			@Override
			public void setDocumentLocator(Locator locator) {

			}

			@Override
			public void startDocument() throws SAXException {

			}

			@Override
			public void endDocument() throws SAXException {

			}

			@Override
			public void startPrefixMapping(String prefix, String uri) throws SAXException {

			}

			@Override
			public void endPrefixMapping(String prefix) throws SAXException {

			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
				if (isTech) {
					count++;
				}
				if ("Tech".equals(qName)) {
					isTech = true;
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if ("Tech".equals(qName)) {
					isTech = false;
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (count == 3 && isTech) {
					System.out.println(new String(ch, start, length));
				}
			}

			@Override
			public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

			}

			@Override
			public void processingInstruction(String target, String data) throws SAXException {

			}

			@Override
			public void skippedEntity(String name) throws SAXException {

			}

		});
	}

	private static void test1() throws ParserConfigurationException, SAXException, IOException {
		// 得到解析器工厂SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 得到解析器SAXParser
		SAXParser parser = factory.newSAXParser();
		// 得到XML读取器：XMLReader
		XMLReader reader = parser.getXMLReader();
		// 注册内容处理器：ContentHandler
		reader.setContentHandler(new MyContentHandler());
		// 读取XML文档
		reader.parse("WebContent/WEB-INF/example/XMLExample.xml");
	}

}

class MyContentHandler implements ContentHandler {

	@Override
	public void setDocumentLocator(Locator locator) {

	}

	// 解析到文档开始时调用
	@Override
	public void startDocument() throws SAXException {
		System.out.println("文档解析开始");
	}

	// 解析到文档结束时调用
	@Override
	public void endDocument() throws SAXException {
		System.out.println("文档解析结束");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {

	}

	// 解析到元素开始时调用
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("解析到元素：" + qName);
	}

	// 解析到元素结束时调用
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("解析元素：" + qName + "结束");
	}

	// 解析到文本内容时调用
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("文本內容：" + new String(ch, start, length));
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {

	}

	@Override
	public void skippedEntity(String name) throws SAXException {

	}

}