package top.tiral.xml.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import top.tiral.xml.domain.Student;
import top.util.xml.DocumentUtil;

/**
 * Student 操作实现类（DOM方式）
 * 
 * @author 高宇翔
 *
 */
public class StudentDOMDao {

	private final String url = "WebContent/WEB-INF/example/XMLExampleStu.xml";

	/**
	 * 添加Student到XML文件中
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	public boolean creatStudent(Student student) {
		boolean result = false;
		try {
			// 获取Document
			Document document = DocumentUtil.getDocument(url);
			// 创建name、city、grade元素并设置主体内容
			Element eName = document.createElement("name");
			eName.setTextContent(student.getName());

			Element eCity = document.createElement("city");
			eCity.setTextContent(student.getCity());

			Element eGrade = document.createElement("grade");
			eGrade.setTextContent(student.getGrade() + "");
			// 创建student元素并设置属性
			Element eStudent = document.createElement("student");
			eStudent.setAttribute("id", student.getId());
			eStudent.setAttribute("examId", student.getExamId());
			// 将name、city、grade元素下挂到student下
			eStudent.appendChild(eName);
			eStudent.appendChild(eCity);
			eStudent.appendChild(eGrade);
			// 获取exam元素
			Node nExam = document.getElementsByTagName("exam").item(0);
			// 将student元素下挂到exam元素下
			nExam.appendChild(eStudent);
			// 写回XML
			DocumentUtil.write2xml(document, url);
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * 根据name属性，从XML文件中删除Student
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	public boolean deleteStudent(String name) {
		boolean result = false;

		try {
			// 获取document
			Document document = DocumentUtil.getDocument(url);
			// 获取name的NodeList
			NodeList nodeList = document.getElementsByTagName("name");
			// 遍历得到name匹配的Node
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getTextContent().equals(name)) {
					// 删除该Node
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
					result = true;
				}
			}
			// 写回XML
			DocumentUtil.write2xml(document, url);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * 根据examId查询Student信息
	 * 
	 * @param examId
	 * @return 成功返回Student；失败返回null
	 */
	public Student findStudent(String examId) {

		Student student = null;
		Element element = null;
		String sId = "";
		String sExamId = "";
		String sName = "";
		String sCity = "";
		float sGrade = 0.0f;
		try {
			// 获取Document
			Document document = DocumentUtil.getDocument(url);
			// 获取Student的NodeList
			NodeList nodeList = document.getElementsByTagName("student");
			// 遍历得到examId匹配的Node
			for (int i = 0; i < nodeList.getLength(); i++) {

				if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// 强转Element，获取Attribute内容
					element = (Element) nodeList.item(i);
					sExamId = element.getAttribute("examId");
					if (sExamId.equals(examId)) {
						// 获取子元素及元素内容
						sId = element.getAttribute("id");
						sName = element.getElementsByTagName("name").item(0).getTextContent();
						sCity = element.getElementsByTagName("city").item(0).getTextContent();
						sGrade = Float.parseFloat(element.getElementsByTagName("grade").item(0).getTextContent());

						student = new Student();
						student.setId(sId);
						student.setExamId(sExamId);
						student.setName(sName);
						student.setCity(sCity);
						student.setGrade(sGrade);
					}
				}
			}

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return student;
	}

}
