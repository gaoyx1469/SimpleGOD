package top.trial.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import top.trial.xml.dao.impl.StudentDom4JDaoImpl;
import top.trial.xml.domain.Student;

public class Dom4JDemoPlus {
	public static void main(String[] args) {
		StudentDom4JDaoImpl studentDao = new StudentDom4JDaoImpl();

		// Ôö
		// addAStudent(studentDao);

		// ²é
		// Student student = studentDao.findStudent("120003");
		// System.out.println(student);

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * String deleteTip = ""; try { deleteTip = br.readLine(); } catch (IOException
		 * e) { // e.printStackTrace(); throw new RuntimeException(e); }
		 */

		// É¾
		// System.out.println(studentDao.deleteStudent(deleteTip));
	}

	private static void addAStudent(StudentDom4JDaoImpl studentDao) {
		Student student = new Student();

		student.setId("0003");
		student.setExamId("120003");
		student.setName("Candy");
		student.setCity("Íþº£");
		student.setGrade(95.5f);

		System.out.println(studentDao.creatStudent(student));
	}
}
