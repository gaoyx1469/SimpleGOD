package top.tiral.xml.dao.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import top.tiral.xml.dao.StudentXMLDao;
import top.tiral.xml.domain.Student;
import top.util.xml.DocumentUtil;

/**
 * Student ����ʵ���ࣨDOM��ʽ��
 * 
 * @author ������
 *
 */
public class StudentDOMDaoImpl implements StudentXMLDao {

	private final String url = "WebContent/WEB-INF/example/XMLExampleStu.xml";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * top.tiral.xml.dao.StudentXMLDao#creatStudent(top.tiral.xml.domain.Student)
	 */
	@Override
	public boolean creatStudent(Student student) {
		boolean result = false;
		try {
			// ��ȡDocument
			Document document = DocumentUtil.getDocument(url);
			// ����name��city��gradeԪ�ز�������������
			Element eName = document.createElement("name");
			eName.setTextContent(student.getName());

			Element eCity = document.createElement("city");
			eCity.setTextContent(student.getCity());

			Element eGrade = document.createElement("grade");
			eGrade.setTextContent(student.getGrade() + "");
			// ����studentԪ�ز���������
			Element eStudent = document.createElement("student");
			eStudent.setAttribute("id", student.getId());
			eStudent.setAttribute("examId", student.getExamId());
			// ��name��city��gradeԪ���¹ҵ�student��
			eStudent.appendChild(eName);
			eStudent.appendChild(eCity);
			eStudent.appendChild(eGrade);
			// ��ȡexamԪ��
			Node nExam = document.getElementsByTagName("exam").item(0);
			// ��studentԪ���¹ҵ�examԪ����
			nExam.appendChild(eStudent);
			// д��XML
			DocumentUtil.write2xml(document, url);
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see top.tiral.xml.dao.StudentXMLDao#deleteStudent(java.lang.String)
	 */
	@Override
	public boolean deleteStudent(String name) {
		boolean result = false;

		try {
			// ��ȡdocument
			Document document = DocumentUtil.getDocument(url);
			// ��ȡname��NodeList
			NodeList nodeList = document.getElementsByTagName("name");
			// �����õ�nameƥ���Node
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getTextContent().equals(name)) {
					// ɾ����Node
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
					result = true;
				}
			}
			// д��XML
			DocumentUtil.write2xml(document, url);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see top.tiral.xml.dao.StudentXMLDao#findStudent(java.lang.String)
	 */
	@Override
	public Student findStudent(String examId) {

		Student student = null;
		Element element = null;
		String sId = "";
		String sExamId = "";
		String sName = "";
		String sCity = "";
		float sGrade = 0.0f;
		try {
			// ��ȡDocument
			Document document = DocumentUtil.getDocument(url);
			// ��ȡStudent��NodeList
			NodeList nodeList = document.getElementsByTagName("student");
			// �����õ�examIdƥ���Node
			for (int i = 0; i < nodeList.getLength(); i++) {

				if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// ǿתElement����ȡAttribute����
					element = (Element) nodeList.item(i);
					sExamId = element.getAttribute("examId");
					if (sExamId.equals(examId)) {
						// ��ȡ��Ԫ�ؼ�Ԫ������
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
