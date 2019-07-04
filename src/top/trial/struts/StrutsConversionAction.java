package top.trial.struts;

import java.io.Serializable;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 测试表单数据的获取Action
 * @author Gaoyx
 *
 */
public class StrutsConversionAction extends ActionSupport implements Serializable {

	private String name;
	private String[] hobby;
	private Date birthday;
	private AddressAction address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public AddressAction getAddress() {
		return address;
	}

	public void setAddress(AddressAction address) {
		this.address = address;
	}

	public String show() {
		System.out.println(name);
		System.out.println(hobby.length);
		System.out.println(birthday);
		System.out.println(address.getProvince());
		System.out.println(address.getCity());
		return SUCCESS;
	}
}
