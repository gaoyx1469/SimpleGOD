package top.trial.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfoDomain implements Serializable {
	private String sui_id;
	private String sui_name;
	private String sui_nickname;
	private String sui_mobile;
	private String sui_email;
	private int sui_age;
	private String sui_stt;
	private Date sui_creadate;
	private Date sui_modidate;
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
	public String getSui_nickname() {
		return sui_nickname;
	}
	public void setSui_nickname(String sui_nickname) {
		this.sui_nickname = sui_nickname;
	}
	public String getSui_mobile() {
		return sui_mobile;
	}
	public void setSui_mobile(String sui_mobile) {
		this.sui_mobile = sui_mobile;
	}
	public String getSui_email() {
		return sui_email;
	}
	public void setSui_email(String sui_email) {
		this.sui_email = sui_email;
	}
	public int getSui_age() {
		return sui_age;
	}
	public void setSui_age(int sui_age) {
		this.sui_age = sui_age;
	}
	public String getSui_stt() {
		return sui_stt;
	}
	public void setSui_stt(String sui_stt) {
		this.sui_stt = sui_stt;
	}
	public Date getSui_creadate() {
		return sui_creadate;
	}
	public void setSui_creadate(Date sui_creadate) {
		this.sui_creadate = sui_creadate;
	}
	public Date getSui_modidate() {
		return sui_modidate;
	}
	public void setSui_modidate(Date sui_modidate) {
		this.sui_modidate = sui_modidate;
	}
	
	@Override
	public String toString() {
		return "UserInfoDomain [sui_id=" + sui_id + ", sui_name=" + sui_name + ", sui_nickname=" + sui_nickname
				+ ", sui_mobile=" + sui_mobile + ", sui_email=" + sui_email + ", sui_age=" + sui_age + ", sui_stt="
				+ sui_stt + ", sui_creadate=" + sui_creadate + ", sui_modidate=" + sui_modidate + "]";
	}
	
}
