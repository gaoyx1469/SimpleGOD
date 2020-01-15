package top.trial.xml.dao.impl;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import top.trial.xml.dao.StudentXMLDao;
import top.trial.xml.domain.Student;
import top.util.xml.Dom4JUtil;

/**
 * Student 操作实现类（Dom4j方式）
 * 
 * @author Gaoyx
 *
 */
public class StudentDom4JDaoImpl implements StudentXMLDao {

	private final String url = "WebContent/WEB-INF/example/XMLExampleStu.xml";

	/**
	 * 添加Student到XML文件中
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	@Override
	public boolean creatStudent(Student student) {
		boolean result = false;

		try {
			// 获取document和root
			Document document = Dom4JUtil.getDocument(url);
			Element root = document.getRootElement();

			// 新建student元素
			Element stuE = root.addElement("student").addAttribute("examId", student.getExamId()).addAttribute("id",
					student.getId());

			// 为student元素新建子元素
			stuE.addElement("name").setText(student.getName());
			stuE.addElement("city").setText(student.getCity());
			stuE.addElement("grade").setText(String.valueOf(student.getGrade()));

			// 写回XML
			Dom4JUtil.write2FileGBK(document, url);

			result = true;

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * 根据name属性，从XML文件中删除Student(假设没有重名)
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	@Override
	public boolean deleteStudent(String name) {
		boolean result = false;

		try {
			// 得到document
			Document document = Dom4JUtil.getDocument(url);

			// 原版
			/*
			 * //得到root Element root = document.getRootElement(); //得到全部student元素
			 * List<Element> stus = root.elements(); //遍历student元素 for (Element stu : stus)
			 * { //找到要删除的student元素 if ((stu.element("name").getText()).equals(name)) {
			 * //删除元素 root.remove(stu); result = true; break; } }
			 */
			// Xpath版
			List<Node> nodes = document.selectNodes("//student");
			for (Node n : nodes) {
				if (n.getText().equals(name)) {
					n.getParent().getParent().remove(n.getParent());
					result = true;
					break;
				}
			}
			Dom4JUtil.write2FileGBK(document, url);
		} catch (Exception e) {
			// e.printStackTrace();
			new RuntimeException(e);
		}

		return result;
	}

	/**
	 * 根据examId查询Student信息
	 * 
	 * @param examId
	 * @return 成功返回Student；失败返回null
	 */
	@Override
	public Student findStudent(String examId) {

		Student student = null;
		try {
			Document document = Dom4JUtil.getDocument(url);

			// 原版
			/*
			 * Element root = document.getRootElement();
			 * 
			 * List<Element> stus = root.elements(); for (Element stu : stus) { if
			 * (stu.attributeValue("examId").equals(examId)) { student = new Student();
			 * student.setExamId(examId); student.setId(stu.attributeValue("id"));
			 * student.setName(stu.elementText("name"));
			 * student.setCity(stu.elementText("city"));
			 * student.setGrade(Float.parseFloat(stu.elementText("grade"))); break; } }
			 */
			// Xpath版
			Node node = document.selectSingleNode("//student[@examId='" + examId + "']");
			if (node != null) {
				Element element = (Element) node;
				student = new Student();
				student.setExamId(examId);
				student.setId(element.valueOf("@id"));
				student.setName(element.elementText("name"));
				student.setCity(element.elementText("city"));
				student.setGrade(Float.parseFloat(element.elementText("grade")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	/**
	 * 根据id修改Student的grade
	 * 
	 * @param id
	 * @param grade
	 * @return 成功返回true；失败返回false
	 */
	public boolean updateGrade(String id, float grade) {
		return false;
	}
}
