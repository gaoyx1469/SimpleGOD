package top.trial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.trial.spring.service.AnnotationService;

public class SpringAnnotationBeanTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("springAnnotation.xml");
		AnnotationService as = (AnnotationService) ac.getBean("annotationService");
		as.execute();
	}
}
