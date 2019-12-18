package top.trial.spring;

public class AccountEntity {
	private int sat_id;
	private String sat_name;
	private Double sat_value;

	public int getSat_id() {
		return sat_id;
	}

	public void setSat_id(int sat_id) {
		this.sat_id = sat_id;
	}

	public String getSat_name() {
		return sat_name;
	}

	public void setSat_name(String sat_name) {
		this.sat_name = sat_name;
	}

	public Double getSat_value() {
		return sat_value;
	}

	public void setSat_value(Double sat_value) {
		this.sat_value = sat_value;
	}

	@Override
	public String toString() {
		return "AccountEntity [sat_id=" + sat_id + ", sat_name=" + sat_name + ", sat_value=" + sat_value + "]";
	}

}
