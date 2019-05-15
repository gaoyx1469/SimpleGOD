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
 * Dom4J测试Demo类
 * 
 * @author 高宇翔
 *
 */
public class Dom4JDemo {

	// 查：得到某个具体的节点内容
	// 如得到Python元素的内容
	@Test
	public void test1() throws Exception {
		// 得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// 得到根元素
		Element root = document.getRootElement();
		// 得到Language元素
		List<Element> list = root.elements("Language");
		Element element = list.get(0);
		// 得到Python元素
		List<Element> ps = element.elements("Python");
		Element p = ps.get(0);
		// 得到元素内容
		String text = p.getText();
		Assert.assertEquals("PYTHON", text);
	}

	// XPath方式重写上一方法
	@Test
	public void test11() throws Exception {
		// 得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");

		Node python = document.selectSingleNode("//Python");
		String text = python.getText();

		Assert.assertEquals("PYTHON", text);
	}

	// 查：遍历所有节点
	// 打印所有元素名称
	@Test
	public void test2() throws Exception {
		// 得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// 得到根元素
		Element root = document.getRootElement();
		// 打印所有元素名称
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

	// 改：修改某个元素节点的主体内容
	// 将Java的内容JAVA改为java
	@Test
	public void test3() throws Exception {
		// 得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// 得到根元素
		Element root = document.getRootElement();
		// 得到Java元素
		Element lang = root.elements().get(0);
		Element java = lang.elements().get(0);
		// 设置主体内容
		java.setText("java");
		// 写回XML文档
		Writer fw = new FileWriter("WebContent/WEB-INF/example/XMLExample.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");// 指定编码，UTF-8是默认编码
		XMLWriter writer = new XMLWriter(fw, format);
		writer.write(document);
		writer.close();

	}

	// 增：向指定元素节点中增加子元素节点
	// 在Tech节点中增加<微服务>Docker</微服务>
	@Test
	public void test4() throws Exception {
		// 得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("WebContent/WEB-INF/example/XMLExample.xml");
		// 得到根元素
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		Element wfw = tech.addElement("微服务").addText("Docker");

		Writer fw = new FileWriter("WebContent/WEB-INF/example/XMLExample.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");// 指定编码，UTF-8是默认编码
		XMLWriter writer = new XMLWriter(fw, format);
		writer.write(document);
		writer.close();

	}

	// 增：向指定元素节点中增加同级元素节点
	// 在concurrent节点前增加<微服务>Docker</微服务>
	@Test
	public void test5() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		List<Element> children = tech.elements();

		Element wfw = DocumentHelper.createElement("微服务");
		wfw.setText("Docker");
		children.add(2, wfw);

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}

	// 删：删除指定元素节点
	// 删除<微服务>Docker</微服务>
	@Test
	public void test6() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(1);
		Element wfw = tech.element("微服务");
		tech.remove(wfw);

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}

	// 增、删、改、查：操作XML文件属性
	// Tech元素的属性name的获取
	@Test
	public void test7() throws Exception {
		Document document = Dom4JUtil.getDocument("WebContent/WEB-INF/example/XMLExample.xml");
		Element root = document.getRootElement();

		Element tech = root.elements().get(0);
		tech.setAttributeValue("abc", "def");

		Dom4JUtil.write2FileGBK(document, "WebContent/WEB-INF/example/XMLExample.xml");
	}
}
