package leo.entity;

/**
 * Cfcity entity. @author MyEclipse Persistence Tools
 */

public class Cfcity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private Integer provNameId;
	private String cityName;

	// Constructors

	/** default constructor */
	public Cfcity() {
	}

	/** minimal constructor */
	public Cfcity(Integer cityId) {
		this.cityId = cityId;
	}

	/** full constructor */
	public Cfcity(Integer cityId, Integer provNameId, String cityName) {
		this.cityId = cityId;
		this.provNameId = provNameId;
		this.cityName = cityName;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvNameId() {
		return this.provNameId;
	}

	public void setProvNameId(Integer provNameId) {
		this.provNameId = provNameId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}