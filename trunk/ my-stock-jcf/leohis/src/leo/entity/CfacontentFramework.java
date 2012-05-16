package leo.entity;

/**
 * CfacontentFramework entity. @author MyEclipse Persistence Tools
 */

public class CfacontentFramework implements java.io.Serializable {

	// Fields

	private Integer formworkId;
	private String formName;
	private Integer itemTypeId;
	private String ischeck;
	private String medicalRecords;
	private String clinicalPhenomenon;
	private String isobjectiveRequest;
	private String elseState;
	private Integer affiliation;

	// Constructors

	/** default constructor */
	public CfacontentFramework() {
	}

	/** minimal constructor */
	public CfacontentFramework(Integer formworkId) {
		this.formworkId = formworkId;
	}

	/** full constructor */
	public CfacontentFramework(Integer formworkId, String formName,
			Integer itemTypeId, String ischeck, String medicalRecords,
			String clinicalPhenomenon, String isobjectiveRequest,
			String elseState, Integer affiliation) {
		this.formworkId = formworkId;
		this.formName = formName;
		this.itemTypeId = itemTypeId;
		this.ischeck = ischeck;
		this.medicalRecords = medicalRecords;
		this.clinicalPhenomenon = clinicalPhenomenon;
		this.isobjectiveRequest = isobjectiveRequest;
		this.elseState = elseState;
		this.affiliation = affiliation;
	}
	
	public CfacontentFramework(String formName,
			Integer itemTypeId, String ischeck, String medicalRecords,
			String clinicalPhenomenon, String isobjectiveRequest,
			String elseState, Integer affiliation){
		
		this.formName = formName;
		this.itemTypeId = itemTypeId;
		this.ischeck = ischeck;
		this.medicalRecords = medicalRecords;
		this.clinicalPhenomenon = clinicalPhenomenon;
		this.isobjectiveRequest = isobjectiveRequest;
		this.elseState = elseState;
		this.affiliation = affiliation;
	}

	// Property accessors

	public Integer getFormworkId() {
		return this.formworkId;
	}

	public void setFormworkId(Integer formworkId) {
		this.formworkId = formworkId;
	}

	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getIscheck() {
		return this.ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

	public String getMedicalRecords() {
		return this.medicalRecords;
	}

	public void setMedicalRecords(String medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public String getClinicalPhenomenon() {
		return this.clinicalPhenomenon;
	}

	public void setClinicalPhenomenon(String clinicalPhenomenon) {
		this.clinicalPhenomenon = clinicalPhenomenon;
	}

	public String getIsobjectiveRequest() {
		return this.isobjectiveRequest;
	}

	public void setIsobjectiveRequest(String isobjectiveRequest) {
		this.isobjectiveRequest = isobjectiveRequest;
	}

	public String getElseState() {
		return this.elseState;
	}

	public void setElseState(String elseState) {
		this.elseState = elseState;
	}

	public Integer getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(Integer affiliation) {
		this.affiliation = affiliation;
	}

}