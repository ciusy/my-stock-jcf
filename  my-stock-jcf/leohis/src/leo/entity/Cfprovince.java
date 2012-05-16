package leo.entity;

/**
 * Cfprovince entity. @author MyEclipse Persistence Tools
 */

public class Cfprovince implements java.io.Serializable {

	// Fields

	private Integer provId;
	private String provName;

	// Constructors

	/** default constructor */
	public Cfprovince() {
	}

	/** minimal constructor */
	public Cfprovince(Integer provId) {
		this.provId = provId;
	}

	/** full constructor */
	public Cfprovince(Integer provId, String provName) {
		this.provId = provId;
		this.provName = provName;
	}

	// Property accessors

	public Integer getProvId() {
		return this.provId;
	}

	public void setProvId(Integer provId) {
		this.provId = provId;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

}