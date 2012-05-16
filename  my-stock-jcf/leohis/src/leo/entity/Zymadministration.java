package leo.entity;

/**
 * Zymadministration entity. @author MyEclipse Persistence Tools
 */

public class Zymadministration implements java.io.Serializable {

	// Fields

	private String adminName;
	private Integer totalConvert;

	// Constructors

	/** default constructor */
	public Zymadministration() {
	}

	/** minimal constructor */
	public Zymadministration(String adminName) {
		this.adminName = adminName;
	}

	/** full constructor */
	public Zymadministration(String adminName, Integer totalConvert) {
		this.adminName = adminName;
		this.totalConvert = totalConvert;
	}

	// Property accessors

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getTotalConvert() {
		return this.totalConvert;
	}

	public void setTotalConvert(Integer totalConvert) {
		this.totalConvert = totalConvert;
	}

}