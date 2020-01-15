package top.trial.spring;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * Spring演示AOP事务的JavaBean
 * 
 * @author Gaoyx
 *
 */
@Component(value = "springAccountBean")
public class SpringAccountBean {

	private int sat_id;
	private String sat_name;
	private BigDecimal sat_value;

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

	public BigDecimal getSat_value() {
		return sat_value;
	}

	public void setSat_value(BigDecimal sat_value) {
		this.sat_value = sat_value;
	}

	@Override
	public String toString() {
		return "SpringAccountBean [sat_id=" + sat_id + ", sat_name=" + sat_name + ", sat_value=" + sat_value + "]";
	}

}
