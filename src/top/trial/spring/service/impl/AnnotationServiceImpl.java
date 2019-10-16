package top.trial.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.trial.spring.dao.AnnotationDao;
import top.trial.spring.service.AnnotationService;

/**
 * spring注解演示service层实现类
 * 
 * @author Gaoyx
 *
 */
@Component(value = "annotationService")
public class AnnotationServiceImpl implements AnnotationService {

	@Autowired
	private AnnotationDao annotationDao;

	@Override
	public void execute() {
		annotationDao.accountCRDL();
	}

	public void setAnnotationDao(AnnotationDao annotationDao) {
		this.annotationDao = annotationDao;
	}
}
