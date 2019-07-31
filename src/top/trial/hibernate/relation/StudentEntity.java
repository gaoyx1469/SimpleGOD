package top.trial.hibernate.relation;

import java.io.Serializable;

public class StudentEntity implements Serializable {
	private Long sid;
	private String sname;
	private Integer sage;
	private String sgender;

	public StudentEntity() {
	}

	public StudentEntity(String sname, Integer sage, String sgender) {
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	@Override
	public String toString() {
		return "StudentEntity [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", sgender=" + sgender + "]";
	}
}
