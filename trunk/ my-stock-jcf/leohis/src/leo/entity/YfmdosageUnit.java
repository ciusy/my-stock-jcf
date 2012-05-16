package leo.entity;

/**
 * YfmdosageUnit entity. @author MyEclipse Persistence Tools
 */

public class YfmdosageUnit implements java.io.Serializable {

	// Fields

	private String dosageUnit;

	// Constructors

	/** default constructor */
	public YfmdosageUnit() {
	}

	/** full constructor */
	public YfmdosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	// Property accessors

	public String getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

}