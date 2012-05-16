package leo.entity;

/**
 * OsmedicalInstInfo entity. @author MyEclipse Persistence Tools
 */

public class OsmedicalInstInfo implements java.io.Serializable {

	// Fields

	private Integer medicalInstId;
	private String medicalInstName;
	private String medicalInstManager;
	private String province;
	private String city;
	private String prefecture;
	private String town;
	private String medicalInstContracts;

	// Constructors

	/** default constructor */
	public OsmedicalInstInfo() {
	}

	/** minimal constructor */
	public OsmedicalInstInfo(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	/** full constructor */
	public OsmedicalInstInfo(Integer medicalInstId, String medicalInstName,
			String medicalInstManager, String province, String city,
			String prefecture, String town, String medicalInstContracts) {
		this.medicalInstId = medicalInstId;
		this.medicalInstName = medicalInstName;
		this.medicalInstManager = medicalInstManager;
		this.province = province;
		this.city = city;
		this.prefecture = prefecture;
		this.town = town;
		this.medicalInstContracts = medicalInstContracts;
	}

	// Property accessors

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public String getMedicalInstName() {
		return this.medicalInstName;
	}

	public void setMedicalInstName(String medicalInstName) {
		this.medicalInstName = medicalInstName;
	}

	public String getMedicalInstManager() {
		return this.medicalInstManager;
	}

	public void setMedicalInstManager(String medicalInstManager) {
		this.medicalInstManager = medicalInstManager;
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

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getMedicalInstContracts() {
		return this.medicalInstContracts;
	}

	public void setMedicalInstContracts(String medicalInstContracts) {
		this.medicalInstContracts = medicalInstContracts;
	}

}