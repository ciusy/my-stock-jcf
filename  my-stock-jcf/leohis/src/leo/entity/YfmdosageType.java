package leo.entity;

/**
 * YfmdosageType entity. @author MyEclipse Persistence Tools
 */

public class YfmdosageType implements java.io.Serializable {

	// Fields

	private String dosageType;

	// Constructors

	/** default constructor */
	public YfmdosageType() {
	}

	/** full constructor */
	public YfmdosageType(String dosageType) {
		this.dosageType = dosageType;
	}

	// Property accessors

	public String getDosageType() {
		return this.dosageType;
	}

	public void setDosageType(String dosageType) {
		this.dosageType = dosageType;
	}

}