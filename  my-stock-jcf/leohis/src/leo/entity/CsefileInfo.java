package leo.entity;

/**
 * CsefileInfo entity. @author MyEclipse Persistence Tools
 */

public class CsefileInfo implements java.io.Serializable {

	// Fields

	private Long csId;
	private String allergicM;
	private String medicalHistory;
	private String medicalHistoryBefore;
	private String familyMedicalHistory;
	private String bloodType;
	private String currentMedicalHistory;

	// Constructors

	/** default constructor */
	public CsefileInfo() {
	}

	/** minimal constructor */
	public CsefileInfo(Long csId) {
		this.csId = csId;
	}

	/** full constructor */
	public CsefileInfo(Long csId, String allergicM, String medicalHistory,
			String medicalHistoryBefore, String familyMedicalHistory,
			String bloodType, String currentMedicalHistory) {
		this.csId = csId;
		this.allergicM = allergicM;
		this.medicalHistory = medicalHistory;
		this.medicalHistoryBefore = medicalHistoryBefore;
		this.familyMedicalHistory = familyMedicalHistory;
		this.bloodType = bloodType;
		this.currentMedicalHistory = currentMedicalHistory;
	}

	// Property accessors

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getAllergicM() {
		return this.allergicM;
	}

	public void setAllergicM(String allergicM) {
		this.allergicM = allergicM;
	}

	public String getMedicalHistory() {
		return this.medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getMedicalHistoryBefore() {
		return this.medicalHistoryBefore;
	}

	public void setMedicalHistoryBefore(String medicalHistoryBefore) {
		this.medicalHistoryBefore = medicalHistoryBefore;
	}

	public String getFamilyMedicalHistory() {
		return this.familyMedicalHistory;
	}

	public void setFamilyMedicalHistory(String familyMedicalHistory) {
		this.familyMedicalHistory = familyMedicalHistory;
	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getCurrentMedicalHistory() {
		return this.currentMedicalHistory;
	}

	public void setCurrentMedicalHistory(String currentMedicalHistory) {
		this.currentMedicalHistory = currentMedicalHistory;
	}

}