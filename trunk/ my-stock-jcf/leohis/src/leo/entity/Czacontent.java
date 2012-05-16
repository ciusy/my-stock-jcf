package leo.entity;

/**
 * Czacontent entity. @author MyEclipse Persistence Tools
 */

public class Czacontent implements java.io.Serializable {

	// Fields

	private String itemId;
	private String ischeck;
	private String medicalRecords;
	private String clinicalPhenomenon;
	private String isobjectiveRequest;
	private String elseState;

	// Constructors

	/** default constructor */
	public Czacontent() {
	}

	/** minimal constructor */
	public Czacontent(String itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public Czacontent(String itemId, String ischeck, String medicalRecords,
			String clinicalPhenomenon, String isobjectiveRequest,
			String elseState) {
		this.itemId = itemId;
		this.ischeck = ischeck;
		this.medicalRecords = medicalRecords;
		this.clinicalPhenomenon = clinicalPhenomenon;
		this.isobjectiveRequest = isobjectiveRequest;
		this.elseState = elseState;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

}