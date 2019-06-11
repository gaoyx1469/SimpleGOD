package top.trial.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ģ�ⵥԪ����ע�⣬�����峬ʱʱ���ֶ�
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface AnnotationUnitDemo {
	long timeout() default Long.MAX_VALUE;
}
