package top.tiral.xml.dao.impl;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import top.tiral.xml.dao.StudentXMLDao;
import top.tiral.xml.domain.Student;
import top.util.xml.Dom4JUtil;

/**
 * Student ����ʵ���ࣨDom4j��ʽ��
 * 
 * @author ������
 *
 */
public class StudentDom4JDaoImpl implements StudentXMLDao {

	private final String url = "WebContent/WEB-INF/example/XMLExampleStu.xml";

	/**
	 * ���Student��XML�ļ���
	 * 
	 * @param student
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	@Override
	public boolean creatStudent(Student student) {
		boolean result = false;

		try {
			// ��ȡdocument��root
			Document document = Dom4JUtil.getDocument(url);
			Element root = document.getRootElement();

			// �½�studentԪ��
			Element stuE = root.addElement("student").addAttribute("examId", student.getExamId()).addAttribute("id",
					student.getId());

			// ΪstudentԪ���½���Ԫ��
			stuE.addElement("name").setText(student.getName());
			stuE.addElement("city").setText(student.getCity());
			stuE.addElement("grade").setText(String.valueOf(student.getGrade()));

			// д��XML
			Dom4JUtil.write2FileGBK(document, url);

			result = true;

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * ����name���ԣ���XML�ļ���ɾ��Student(����û������)
	 * 
	 * @param student
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	@Override
	public boolean deleteStudent(String name) {
		boolean result = false;

		try {
			// �õ�document
			Document document = Dom4JUtil.getDocument(url);

			// ԭ��
			/*
			 * //�õ�root Element root = document.getRootElement(); //�õ�ȫ��studentԪ��
			 * List<Element> stus = root.elements(); //����studentԪ�� for (Element stu : stus)
			 * { //�ҵ�Ҫɾ����studentԪ�� if ((stu.element("name").getText()).equals(name)) {
			 * //ɾ��Ԫ�� root.remove(stu); result = true; break; } }
			 */
			// Xpath��
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
	 * ����examId��ѯStudent��Ϣ
	 * 
	 * @param examId
	 * @return �ɹ�����Student��ʧ�ܷ���null
	 */
	@Override
	public Student findStudent(String examId) {

		Student student = null;
		try {
			Document document = Dom4JUtil.getDocument(url);

			// ԭ��
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
			// Xpath��
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
	 * ����id�޸�Student��grade
	 * 
	 * @param id
	 * @param grade
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean updateGrade(String id, float grade) {
		return false;
	}
}
