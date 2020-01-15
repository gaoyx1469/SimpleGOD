package top.trial.spring;

/**
 * Spring IoC 演示Bean
 * 
 * @author gaoyx
 *
 */
public class SpringBean {

	private String beanname;

	public SpringBean() {

	}

	public SpringBean(String beanname) {
		this.beanname = beanname;
	}

	public void service() {
		System.out.println("SpringBean service");
	}

	public String getBeanname() {
		return beanname;
	}

	public void setBeanname(String beanname) {
		this.beanname = beanname;
	}

}
