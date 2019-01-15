package top.trial.xml;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Assert;
import org.junit.Test;

import top.util.xml.Dom4JUtil;

/**
 * Dom4J����Demo��
 * 
 * @author ������
 *
 */
public class Dom4JDemo {

	// �飺�õ�ĳ������Ľڵ�����
	// ��õ�PythonԪ�ص�����
	@Test
	public void test1() throws Exception {
		// �õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// �õ���Ԫ��
		Element root = document.getRootElement();
		// �õ�LanguageԪ��
		List<Element> list = root.elements("Language");
		Element element = list.get(0);
		// �õ�PythonԪ��
		List<Element> ps = element.elements("Python");
		Element p = ps.get(0);
		// �õ�Ԫ������
		String text = p.getText();
		Assert.assertEquals("PYTHON", text);
	}

	// XPath��ʽ��д��һ����
	@Test
	public void test11() throws Exception {
		// �õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");

		Node python = document.selectSingleNode("//Python");
		String text = python.getText();

		Assert.assertEquals("PYTHON", text);
	}

	// �飺�������нڵ�
	// ��ӡ����Ԫ������
	@Test
	public void test2() throws Exception {
		// �õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// �õ���Ԫ��
		Element root = document.getRootElement();
		// ��ӡ����Ԫ������
		treeWalk(root);
	}

	private void treeWalk(Element root) {
		/*
		 * System.out.println(root.getName()); List<Element> list = root.elements();
		 * for(Element e : list) { treeWalk(e); }
		 */
		System.out.println(root.getName());
		int count = root.nodeCount();
		for (int i = 0; i < count; i++) {
			Node node = root.node(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				treeWalk((Element) node);
			}
		}

	}

	// �ģ��޸�ĳ��Ԫ�ؽڵ����������
	// ��Java������JAVA��Ϊjava
	@Test
	public void test3() throws Exception {
		// �õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// �õ���Ԫ��
		Element root = document.getRootElement();
		// �õ�JavaԪ��
		Element lang = root.elements().get(0);
		Element java = lang.elements().get(0);
		// ������������
		java.setText("java");
		// д��XML�ĵ�
		Writer fw = new FileWriter("WebContent/WEB-INF/example/XMLExample.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");// ָ�����룬UTF-8��Ĭ�ϱ���
		XMLWriter writer = new XMLWriter(fw, format);
		writer.write(document);
		writer.close();

	}

	// ������ָ��Ԫ�ؽڵ���������Ԫ�ؽڵ�
	// ��Tech�ڵ�������<΢����>Docker</΢����>
	@Test
	public void test4() throws Exception {
		// �õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// �õ���Ԫ��
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		Element wfw = tech.addElement("΢����").addText("Docker");

		Writer fw = new FileWriter("WebContent/WEB-INF/example/XMLExample.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");// ָ�����룬UTF-8��Ĭ�ϱ���
		XMLWriter writer = new XMLWriter(fw, format);
		writer.write(document);
		writer.close();

	}

	// ������ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�
	// ��concurrent�ڵ�ǰ����<΢����>Docker</΢����>
	@Test
	public void test5() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		List<Element> children = tech.elements();

		Element wfw = DocumentHelper.createElement("΢����");
		wfw.setText("Docker");
		children.add(2, wfw);

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}

	// ɾ��ɾ��ָ��Ԫ�ؽڵ�
	// ɾ��<΢����>Docker</΢����>
	@Test
	public void test6() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		Element wfw = tech.element("΢����");
		tech.remove(wfw);

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}

	// ����ɾ���ġ��飺����XML�ļ�����
	// TechԪ�ص�����name�Ļ�ȡ
	@Test
	public void test7() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(0);
		tech.setAttributeValue("abc", "def");

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}
}
