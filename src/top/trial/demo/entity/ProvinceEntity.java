package top.trial.demo.entity;

import java.util.List;

/**
 * 省份实体
 * 
 * @author Gaoyx
 *
 */
public class ProvinceEntity {
	private String name;
	private List<CityEntity> cities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CityEntity> getCities() {
		return cities;
	}

	public void setCities(List<CityEntity> cities) {
		this.cities = cities;
	}
}
