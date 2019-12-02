package top.trial.spring.dao.impl;

import org.springframework.stereotype.Repository;

import top.trial.spring.dao.AnnotationDao;

/**
 * spring注解演示dao层实现类
 * 
 * @author Gaoyx
 *
 */
@Repository(value = "annotationDao")
public class AnnotationDaoImpl implements AnnotationDao {

	@Override
	public void accountCRDL() {
		System.out.println("调用了Dao的账户操作方法");
	}

}
