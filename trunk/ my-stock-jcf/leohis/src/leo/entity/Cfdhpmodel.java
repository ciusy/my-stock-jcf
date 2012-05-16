package leo.entity;

/**
 * Cfdhpmodel entity. @author MyEclipse Persistence Tools
 */

public class Cfdhpmodel implements java.io.Serializable {

	// Fields

	private Long modelId;
	private String modelName;
	private String suffererTell;
	private Long ower;
	private String diagnosis;
	private Integer department;
	private Long fatherId;
	private String note;

	// Constructors

	/** default constructor */
	public Cfdhpmodel() {
	}

	/** minimal constructor */
	public Cfdhpmodel(Long modelId) {
		this.modelId = modelId;
	}

	/** full constructor */
	public Cfdhpmodel(Long modelId, String modelName, String suffererTell,
			Long ower, String diagnosis, Integer department, Long fatherId,
			String note) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.suffererTell = suffererTell;
		this.ower = ower;
		this.diagnosis = diagnosis;
		this.department = department;
		this.fatherId = fatherId;
		this.note = note;
	}

	// Property accessors

	public Long getModelId() {
		return this.modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSuffererTell() {
		return this.suffererTell;
	}

	public void setSuffererTell(String suffererTell) {
		this.suffererTell = suffererTell;
	}

	public Long getOwer() {
		return this.ower;
	}

	public void setOwer(Long ower) {
		this.ower = ower;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}