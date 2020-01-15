package top.trial.struts;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户地址Demo动作类，作为其它动作类的属性使用
 * @author Gaoyx
 *
 */
public class AddressAction extends ActionSupport implements Serializable {
	private String province;
	private String city;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
