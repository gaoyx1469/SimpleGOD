package top.trial.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 此类演示DOM方式对XML文件的直接增删改查操作
 * 
 * @author Gaoyx
 *
 */
public class JaxpDomDemo {

	@Test
	public void jaxpDomTest() throws Exception {
		// 得到解析工厂DocumentBuilderFactory
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// 得到解析器DocumentBuilder
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		// 解析指定的XML文档，得到代表内存DOM树的document对象
		Document document = db.parse("WebContent/WEB-INF/example/XMLExample.xml");

		// test1(document);
		// test2(document);
		// test3(document);
		// test4(document);
		// test5(document);
		// test6(document);
		test7(document);
	}

	// 查：得到某个具体的节点内容
	// 如得到Python元素的内容
	private static void test1(Document document) {
		// 根据标签名Python获取所有的Python元素
		NodeList nl = document.getElementsByTagName("Python");
		// 按照索引取第一个
		Node n = nl.item(0);
		// 打印元素内容
		String text = n.getTextContent();
		System.out.println(text);
	}

	// 查：遍历所有节点
	// 打印所有元素名称
	private static void test2(Node node) {
		// 判断当前节点是否是元素
		short type = node.getNodeType();
		// 如果是，打印名称
		if (type == Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		// 如果不是，跳过
		// 遍历他的孩子
		NodeList nl = node.getChildNodes();
		int l = nl.getLength();
		for (int i = 0; i < l; i++) {
			Node n = nl.item(i);
			test2(n);
		}
	}

	// 改：修改某个元素节点的主体内容
	private static void test3(Document document) throws Exception {
		// 找到该节点
		NodeList nl = document.getElementsByTagName("C");
		Node n = nl.item(0);
		// 设置主体内容
		n.setTextContent("C语言");
		// 把内存中的Dcoument树写回XML文件中
		transToXml(document);
	}

	// 增：向指定元素节点中增加子元素节点
	// 在Tech节点中增加<微服务>Docker</微服务>
	private static void test4(Document document) throws Exception {
		// 父节点
		NodeList nl = document.getElementsByTagName("Tech");
		Node n = nl.item(0);
		// 新建元素
		Element el = document.createElement("微服务");
		el.setTextContent("Docker");
		// 在父节点下增加新建子元素
		n.appendChild(el);
		// 把内存中的Dcoument树写回XML文件中
		transToXml(document);
	}

	// 增：向指定元素节点中增加同级元素节点
	// 在concurrent节点前增加<微服务>Docker</微服务>
	private static void test5(Document document) throws Exception {
		// 参考子节点
		NodeList nl = document.getElementsByTagName("concurrent");
		Node n = nl.item(0);
		// 新建元素
		Element el = document.createElement("微服务");
		el.setTextContent("Docker");
		// 在父节点下增加新建子元素
		n.getParentNode().insertBefore(el, n);
		// 把内存中的Dcoument树写回XML文件中
		transToXml(document);
	}

	// 删：删除指定元素节点
	// 删除<微服务>Docker</微服务>
	private static void test6(Document document) throws Exception {
		// 找到该节点
		Node n = document.getElementsByTagName("微服务").item(0);
		// 删除
		n.getParentNode().removeChild(n);
		// 把内存中的Dcoument树写回XML文件中
		transToXml(document);

	}

	// 增、删、改、查：操作XML文件属性
	// Tech元素的属性name的获取
	private static void test7(Document document) throws Exception {
		// 获取元素节点
		Node n = document.getElementsByTagName("Tech").item(0);
		// 强转为Element,因为Element中才有获取单个属性的方法
		Element e = (Element) n;
		// 获取元素
		String s = e.getAttribute("name");

		System.out.println(s);
	}

	private static void transToXml(Document document)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		// 获得转换工厂类
		TransformerFactory fac = TransformerFactory.newInstance();
		// 获得转换类
		Transformer tran = fac.newTransformer();
		// 执行转换方法
		tran.transform(new DOMSource(document), new StreamResult("WebContent/WEB-INF/example/XMLExample.xml"));
	}
}
