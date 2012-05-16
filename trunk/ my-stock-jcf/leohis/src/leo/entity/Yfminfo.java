package leo.entity;

/**
 * Yfminfo entity. @author MyEclipse Persistence Tools
 */

public class Yfminfo implements java.io.Serializable {

	// Fields

	private Integer minfoId;
	private Integer supplierId;
	private String mname;
	private String mtype;
	private String mspec;
	private String mdosageType;
	private Double mdosage;
	private String dosageUnit;
	private String wayTo;
	private String chinaDrugApprovalNum;
	private String spell;
	private String mbankUnit;
	private String pharmacyUnit;
	private Integer bankToPharConvRate;
	private String ruralCooperType;
	private String medicalInsuranceType;
	private Boolean deleteOrNot;
	private String manufacturer;
	private Integer medicalInstitutionId;

	// Constructors

	/** default constructor */
	public Yfminfo() {
	}

	/** minimal constructor */
	public Yfminfo(Integer minfoId) {
		this.minfoId = minfoId;
	}

	/** full constructor */
	public Yfminfo(Integer minfoId, Integer supplierId, String mname,
			String mtype, String mspec, String mdosageType, Double mdosage,
			String dosageUnit, String wayTo, String chinaDrugApprovalNum,
			String spell, String mbankUnit, String pharmacyUnit,
			Integer bankToPharConvRate, String ruralCooperType,
			String medicalInsuranceType, Boolean deleteOrNot,
			String manufacturer, Integer medicalInstitutionId) {
		this.minfoId = minfoId;
		this.supplierId = supplierId;
		this.mname = mname;
		this.mtype = mtype;
		this.mspec = mspec;
		this.mdosageType = mdosageType;
		this.mdosage = mdosage;
		this.dosageUnit = dosageUnit;
		this.wayTo = wayTo;
		this.chinaDrugApprovalNum = chinaDrugApprovalNum;
		this.spell = spell;
		this.mbankUnit = mbankUnit;
		this.pharmacyUnit = pharmacyUnit;
		this.bankToPharConvRate = bankToPharConvRate;
		this.ruralCooperType = ruralCooperType;
		this.medicalInsuranceType = medicalInsuranceType;
		this.deleteOrNot = deleteOrNot;
		this.manufacturer = manufacturer;
		this.medicalInstitutionId = medicalInstitutionId;
	}

	// Property accessors

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtype() {
		return this.mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getMspec() {
		return this.mspec;
	}

	public void setMspec(String mspec) {
		this.mspec = mspec;
	}

	public String getMdosageType() {
		return this.mdosageType;
	}

	public void setMdosageType(String mdosageType) {
		this.mdosageType = mdosageType;
	}

	public Double getMdosage() {
		return this.mdosage;
	}

	public void setMdosage(Double mdosage) {
		this.mdosage = mdosage;
	}

	public String getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public String getWayTo() {
		return this.wayTo;
	}

	public void setWayTo(String wayTo) {
		this.wayTo = wayTo;
	}

	public String getChinaDrugApprovalNum() {
		return this.chinaDrugApprovalNum;
	}

	public void setChinaDrugApprovalNum(String chinaDrugApprovalNum) {
		this.chinaDrugApprovalNum = chinaDrugApprovalNum;
	}

	public String getSpell() {
		return this.spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getMbankUnit() {
		return this.mbankUnit;
	}

	public void setMbankUnit(String mbankUnit) {
		this.mbankUnit = mbankUnit;
	}

	public String getPharmacyUnit() {
		return this.pharmacyUnit;
	}

	public void setPharmacyUnit(String pharmacyUnit) {
		this.pharmacyUnit = pharmacyUnit;
	}

	public Integer getBankToPharConvRate() {
		return this.bankToPharConvRate;
	}

	public void setBankToPharConvRate(Integer bankToPharConvRate) {
		this.bankToPharConvRate = bankToPharConvRate;
	}

	public String getRuralCooperType() {
		return this.ruralCooperType;
	}

	public void setRuralCooperType(String ruralCooperType) {
		this.ruralCooperType = ruralCooperType;
	}

	public String getMedicalInsuranceType() {
		return this.medicalInsuranceType;
	}

	public void setMedicalInsuranceType(String medicalInsuranceType) {
		this.medicalInsuranceType = medicalInsuranceType;
	}

	public Boolean getDeleteOrNot() {
		return this.deleteOrNot;
	}

	public void setDeleteOrNot(Boolean deleteOrNot) {
		this.deleteOrNot = deleteOrNot;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getMedicalInstitutionId() {
		return this.medicalInstitutionId;
	}

	public void setMedicalInstitutionId(Integer medicalInstitutionId) {
		this.medicalInstitutionId = medicalInstitutionId;
	}

}