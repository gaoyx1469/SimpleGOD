package top.trial.spring.dao.impl;

import org.springframework.stereotype.Repository;

import top.trial.spring.dao.AnnotationDao;

/**
 * springע����ʾdao��ʵ����
 * 
 * @author Gaoyx
 *
 */
@Repository(value = "annotationDao")
public class AnnotationDaoImpl implements AnnotationDao {

	@Override
	public void accountCRDL() {
		System.out.println("������Dao���˻���������");
	}

}
