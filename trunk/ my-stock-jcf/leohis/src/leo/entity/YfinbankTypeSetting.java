package leo.entity;

/**
 * YfinbankTypeSetting entity. @author MyEclipse Persistence Tools
 */

public class YfinbankTypeSetting implements java.io.Serializable {

	// Fields

	private Integer inbankTypeId;
	private String typeName;
	private String inbankApproveLogic;
	private String note;
	private Integer pharmacyId;

	// Constructors

	/** default constructor */
	public YfinbankTypeSetting() {
	}

	/** minimal constructor */
	public YfinbankTypeSetting(Integer inbankTypeId) {
		this.inbankTypeId = inbankTypeId;
	}

	/** full constructor */
	public YfinbankTypeSetting(Integer inbankTypeId, String typeName,
			String inbankApproveLogic, String note, Integer pharmacyId) {
		this.inbankTypeId = inbankTypeId;
		this.typeName = typeName;
		this.inbankApproveLogic = inbankApproveLogic;
		this.note = note;
		this.pharmacyId = pharmacyId;
	}

	// Property accessors

	public Integer getInbankTypeId() {
		return this.inbankTypeId;
	}

	public void setInbankTypeId(Integer inbankTypeId) {
		this.inbankTypeId = inbankTypeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getInbankApproveLogic() {
		return this.inbankApproveLogic;
	}

	public void setInbankApproveLogic(String inbankApproveLogic) {
		this.inbankApproveLogic = inbankApproveLogic;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

}