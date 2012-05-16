package leo.entity;

/**
 * CzdisposeItemDescribe entity. @author MyEclipse Persistence Tools
 */

public class CzdisposeItemDescribe implements java.io.Serializable {

	// Fields

	private Integer itemTypeId;
	private String itemName;
	private Integer functionalModule;
	private Boolean needWriteApply;
	private Double cost;
	private String spell;
	private Integer executeU;
	private String remarks;
	private Integer csu;
	private String disposeItemType;
	private Integer medicalInstId;
	private String report;

	// Constructors

	/** default constructor */
	public CzdisposeItemDescribe() {
	}

	/** full constructor */
	public CzdisposeItemDescribe(String itemName, Integer functionalModule,
			Boolean needWriteApply, Double cost, String spell,
			Integer executeU, String remarks, Integer csu,
			String disposeItemType, Integer medicalInstId, String report) {
		this.itemName = itemName;
		this.functionalModule = functionalModule;
		this.needWriteApply = needWriteApply;
		this.cost = cost;
		this.spell = spell;
		this.executeU = executeU;
		this.remarks = remarks;
		this.csu = csu;
		this.disposeItemType = disposeItemType;
		this.medicalInstId = medicalInstId;
		this.report = report;
	}

	// Property accessors

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getFunctionalModule() {
		return this.functionalModule;
	}

	public void setFunctionalModule(Integer functionalModule) {
		this.functionalModule = functionalModule;
	}

	public Boolean getNeedWriteApply() {
		return this.needWriteApply;
	}

	public void setNeedWriteApply(Boolean needWriteApply) {
		this.needWriteApply = needWriteApply;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getSpell() {
		return this.spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getCsu() {
		return this.csu;
	}

	public void setCsu(Integer csu) {
		this.csu = csu;
	}

	public String getDisposeItemType() {
		return this.disposeItemType;
	}

	public void setDisposeItemType(String disposeItemType) {
		this.disposeItemType = disposeItemType;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

}