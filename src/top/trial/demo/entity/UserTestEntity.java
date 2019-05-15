package top.trial.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class UserTestEntity implements Serializable {

	private String sui_id;
	private String sui_name;
	private int sui_age;
	private Date sui_creadate;

	public String getSui_id() {
		return sui_id;
	}

	public void setSui_id(String sui_id) {
		this.sui_id = sui_id;
	}

	public String getSui_name() {
		return sui_name;
	}

	public void setSui_name(String sui_name) {
		this.sui_name = sui_name;
	}

	public int getSui_age() {
		return sui_age;
	}

	public void setSui_age(int sui_age) {
		this.sui_age = sui_age;
	}

	public Date getSui_creadate() {
		return sui_creadate;
	}

	public void setSui_creadate(Date sui_creadate) {
		this.sui_creadate = sui_creadate;
	}

	@Override
	public String toString() {
		return "UserTestEntity [sui_id=" + sui_id + ", sui_name=" + sui_name + ", sui_age=" + sui_age
				+ ", sui_creadate=" + sui_creadate + "]";
	}

}
