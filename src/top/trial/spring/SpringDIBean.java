package top.trial.spring;

import java.util.Date;

/**
 * XML����ע���Bean
 * 
 * @author Gaoyx
 *
 */
public class SpringDIBean {
	private int id;
	private String name;
	private Date date;

	public SpringDIBean(int id) {
		this.id = id;
		System.out.println("�����˴�1�ι��캯��");
	}

	public SpringDIBean(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
		System.out.println("�����˴�3�ι��캯��");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SpringDIBean [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
