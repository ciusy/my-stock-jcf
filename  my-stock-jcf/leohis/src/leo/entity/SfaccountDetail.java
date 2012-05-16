package leo.entity;

import java.sql.Timestamp;

/**
 * SfaccountDetail entity. @author MyEclipse Persistence Tools
 */

public class SfaccountDetail implements java.io.Serializable {

	// Fields

	private Long accountNameId;
	private Integer townId;
	private Integer pharmacyOrCgRoomId;
	private String accountId;
	private Double amount;
	private Timestamp date;
	private String cgType;
	private Integer medicalInstitutionId;

	// Constructors

	/** default constructor */
	public SfaccountDetail() {
	}

	// Property accessors

	public Long getAccountNameId() {
		return this.accountNameId;
	}

	public void setAccountNameId(Long accountNameId) {
		this.accountNameId = accountNameId;
	}

	public Integer getTownId() {
		return this.townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public Integer getPharmacyOrCgRoomId() {
		return this.pharmacyOrCgRoomId;
	}

	public void setPharmacyOrCgRoomId(Integer pharmacyOrCgRoomId) {
		this.pharmacyOrCgRoomId = pharmacyOrCgRoomId;
	}


	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getCgType() {
		return this.cgType;
	}

	public void setCgType(String cgType) {
		this.cgType = cgType;
	}

	public Integer getMedicalInstitutionId() {
		return this.medicalInstitutionId;
	}

	public void setMedicalInstitutionId(Integer medicalInstitutionId) {
		this.medicalInstitutionId = medicalInstitutionId;
	}

}