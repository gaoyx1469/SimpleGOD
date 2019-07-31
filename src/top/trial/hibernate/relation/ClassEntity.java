package top.trial.hibernate.relation;

import java.io.Serializable;
import java.util.Set;

public class ClassEntity implements Serializable {
	private Integer cid;
	private String cname;
	private String cdesc;
	private Set<StudentEntity> cstus;

	public ClassEntity() {
	}

	public ClassEntity(String cname, String cdesc) {
		super();
		this.cname = cname;
		this.cdesc = cdesc;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<StudentEntity> getCstus() {
		return cstus;
	}

	public void setCstus(Set<StudentEntity> cstus) {
		this.cstus = cstus;
	}

	@Override
	public String toString() {
		return "ClassEntity [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc + "]";
	}
}
