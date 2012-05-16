package leo.entity;

/**
 * CsconsumerInfo entity. @author MyEclipse Persistence Tools
 */

public class CsconsumerInfo implements java.io.Serializable {

	// Fields

	private Long csId;
	private String nationality;
	private String culture;
	private String professional;
	private String account;
	private String province;
	private String city;
	private String county;
	private String town;
	private String village;
	private String zipCode;
	private String marriedTime;

	// Constructors

	/** default constructor */
	public CsconsumerInfo() {
	}

	/** minimal constructor */
	public CsconsumerInfo(Long csId) {
		this.csId = csId;
	}

	/** full constructor */
	public CsconsumerInfo(Long csId, String nationality, String culture,
			String professional, String account, String province, String city,
			String county, String town, String village, String zipCode,
			String marriedTime) {
		this.csId = csId;
		this.nationality = nationality;
		this.culture = culture;
		this.professional = professional;
		this.account = account;
		this.province = province;
		this.city = city;
		this.county = county;
		this.town = town;
		this.village = village;
		this.zipCode = zipCode;
		this.marriedTime = marriedTime;
	}

	// Property accessors

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCulture() {
		return this.culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMarriedTime() {
		return this.marriedTime;
	}

	public void setMarriedTime(String marriedTime) {
		this.marriedTime = marriedTime;
	}

}