package top.trial.xml.dao;

import top.trial.xml.domain.Student;

public interface StudentXMLDao {

	/**
	 * ���Student��XML�ļ���
	 * 
	 * @param student
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	boolean creatStudent(Student student);

	/**
	 * ����name���ԣ���XML�ļ���ɾ��Student
	 * 
	 * @param student
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	boolean deleteStudent(String name);

	/**
	 * ����examId��ѯStudent��Ϣ
	 * 
	 * @param examId
	 * @return �ɹ�����Student��ʧ�ܷ���null
	 */
	Student findStudent(String examId);

}