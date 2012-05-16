package leo.entity;

import java.sql.Timestamp;

/**
 * CsmedicalCard entity. @author MyEclipse Persistence Tools
 */

public class CsmedicalCard implements java.io.Serializable {

	// Fields

	private Long csId;
	private String medicalCardNum;
	private Boolean startUsingOrNot;
	private Timestamp startDate;
	private Double balance;

	// Constructors

	/** default constructor */
	public CsmedicalCard() {
	}

	/** minimal constructor */
	public CsmedicalCard(Long csId) {
		this.csId = csId;
	}

	/** full constructor */
	public CsmedicalCard(Long csId, String medicalCardNum,
			Boolean startUsingOrNot, Timestamp startDate, Double balance) {
		this.csId = csId;
		this.medicalCardNum = medicalCardNum;
		this.startUsingOrNot = startUsingOrNot;
		this.startDate = startDate;
		this.balance = balance;
	}

	// Property accessors

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getMedicalCardNum() {
		return this.medicalCardNum;
	}

	public void setMedicalCardNum(String medicalCardNum) {
		this.medicalCardNum = medicalCardNum;
	}

	public Boolean getStartUsingOrNot() {
		return this.startUsingOrNot;
	}

	public void setStartUsingOrNot(Boolean startUsingOrNot) {
		this.startUsingOrNot = startUsingOrNot;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}