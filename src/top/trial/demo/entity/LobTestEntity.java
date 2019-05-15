package top.trial.demo.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

public class LobTestEntity implements Serializable {
	private int slt_id;
	private String slt_name;
	private Blob slt_pageimg;
	private Clob slt_content;
	private Date slt_creadate;
	private Date slt_modidate;

	public int getSlt_id() {
		return slt_id;
	}

	public void setSlt_id(int slt_id) {
		this.slt_id = slt_id;
	}

	public String getSlt_name() {
		return slt_name;
	}

	public void setSlt_name(String slt_name) {
		this.slt_name = slt_name;
	}

	public Blob getSlt_pageimg() {
		return slt_pageimg;
	}

	public void setSlt_pageimg(Blob slt_pageimg) {
		this.slt_pageimg = slt_pageimg;
	}

	public Clob getSlt_content() {
		return slt_content;
	}

	public void setSlt_content(Clob slt_content) {
		this.slt_content = slt_content;
	}

	public Date getSlt_creadate() {
		return slt_creadate;
	}

	public void setSlt_creadate(Date slt_creadate) {
		this.slt_creadate = slt_creadate;
	}

	public Date getSlt_modidate() {
		return slt_modidate;
	}

	public void setSlt_modidate(Date slt_modidate) {
		this.slt_modidate = slt_modidate;
	}

	@Override
	public String toString() {
		return "LobTestEntity [slt_id=" + slt_id + ", slt_name=" + slt_name + ", slt_pageimg=" + slt_pageimg
				+ ", slt_content=" + slt_content + ", slt_creadate=" + slt_creadate + ", slt_modidate=" + slt_modidate
				+ "]";
	}

}
