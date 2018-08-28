package top.tiral.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import top.tiral.xml.dao.StudentDOMDao;
import top.tiral.xml.domain.Student;

/**
 * 此类演示对XML文件的实用级示例操作
 * 
 * @author 高宇翔
 *
 */
public class JaxpDomDemoPlus {

	public static void main(String[] args) {
		StudentDOMDao studentDao = new StudentDOMDao();

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

	private static void addAStudent(StudentDOMDao studentDao) {
		Student student = new Student();

		student.setId("0003");
		student.setExamId("120003");
		student.setName("Candy");
		student.setCity("威海");
		student.setGrade(95.5f);

		System.out.println(studentDao.creatStudent(student));
	}

}
