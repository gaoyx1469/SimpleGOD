package top.trial.xml.dao;

import top.trial.xml.domain.Student;

public interface StudentXMLDao {

	/**
	 * 添加Student到XML文件中
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	boolean creatStudent(Student student);

	/**
	 * 根据name属性，从XML文件中删除Student
	 * 
	 * @param student
	 * @return 成功返回true；失败返回false
	 */
	boolean deleteStudent(String name);

	/**
	 * 根据examId查询Student信息
	 * 
	 * @param examId
	 * @return 成功返回Student；失败返回null
	 */
	Student findStudent(String examId);

}