package leo.entity;

import java.sql.Timestamp;

/**
 * HusGeneralDoc entity. @author MyEclipse Persistence Tools
 */

public class HusGeneralDoc implements java.io.Serializable {

	// Fields

	private String recordId;
	private String workPressure;
	private String friendsNervous;
	private String economicPressures;
	private Boolean ppregnancy;
	private String psychosocialFactor;
	private Timestamp enquireDate;
	private String doctor;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public HusGeneralDoc() {
	}

	/** minimal constructor */
	public HusGeneralDoc(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusGeneralDoc(String recordId, String workPressure,
			String friendsNervous, String economicPressures,
			Boolean ppregnancy, String psychosocialFactor,
			Timestamp enquireDate, String doctor, Integer medicalInstId,
			Long stuffId) {
		this.recordId = recordId;
		this.workPressure = workPressure;
		this.friendsNervous = friendsNervous;
		this.economicPressures = economicPressures;
		this.ppregnancy = ppregnancy;
		this.psychosocialFactor = psychosocialFactor;
		this.enquireDate = enquireDate;
		this.doctor = doctor;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getWorkPressure() {
		return this.workPressure;
	}

	public void setWorkPressure(String workPressure) {
		this.workPressure = workPressure;
	}

	public String getFriendsNervous() {
		return this.friendsNervous;
	}

	public void setFriendsNervous(String friendsNervous) {
		this.friendsNervous = friendsNervous;
	}

	public String getEconomicPressures() {
		return this.economicPressures;
	}

	public void setEconomicPressures(String economicPressures) {
		this.economicPressures = economicPressures;
	}

	public Boolean getPpregnancy() {
		return this.ppregnancy;
	}

	public void setPpregnancy(Boolean ppregnancy) {
		this.ppregnancy = ppregnancy;
	}

	public String getPsychosocialFactor() {
		return this.psychosocialFactor;
	}

	public void setPsychosocialFactor(String psychosocialFactor) {
		this.psychosocialFactor = psychosocialFactor;
	}

	public Timestamp getEnquireDate() {
		return this.enquireDate;
	}

	public void setEnquireDate(Timestamp enquireDate) {
		this.enquireDate = enquireDate;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public Long getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

}