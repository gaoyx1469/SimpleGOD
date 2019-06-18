package top.trial.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;

import top.trial.xml.dao.StudentXMLDao;
import top.trial.xml.dao.impl.StudentDOMDaoImpl;
import top.trial.xml.domain.Student;

/**
 * 此类演示对XML文件的实用级示例操作
 * 
 * @author Gaoyx
 *
 */
public class JaxpDomDemoPlus {
	
	@Test
	public void jaxpDomDemoTest() {
		StudentXMLDao studentDao = new StudentDOMDaoImpl();

		// 增
		// addAStudent(studentDao);

		// 查
		// Student student = studentDao.findStudent("120003");
		// System.out.println(student);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String deleteTip = "";
		try {
			deleteTip = br.readLine();
		} catch (IOException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

		// 删
		System.out.println(studentDao.deleteStudent(deleteTip));
	}

	private static void addAStudent(StudentXMLDao studentDao) {
		Student student = new Student();

		student.setId("0003");
		student.setExamId("120003");
		student.setName("Candy");
		student.setCity("威海");
		student.setGrade(95.5f);

		System.out.println(studentDao.creatStudent(student));
	}

}
