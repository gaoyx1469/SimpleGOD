package top.trial.spring;

/**
 * Spring IoC ÑÝÊ¾Bean
 * 
 * @author gaoyx
 *
 */
public class SpringBean {

	private String beanname;

	public void SpringBean() {

	}

	public void SpringBean(String beanname) {
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
