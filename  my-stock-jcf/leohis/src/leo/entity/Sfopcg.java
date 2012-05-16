package leo.entity;

import java.sql.Timestamp;

/**
 * Sfopcg entity. @author MyEclipse Persistence Tools
 */

public class Sfopcg implements java.io.Serializable {

	// Fields

	private String opdiagnoseId;
	private String aformId;
	private Long csId;
	private Long cashier;
	private Timestamp cgTime;
	private Boolean printReceiptOrNot;
	private Double mcgBalance;
	private Double treatmentCgBalance;
	private String note;
	private String receiptCode;
	private Integer cgRoomId;
	private Integer pharmacyId;
	private Double cashAmount;
	private Double medicalCardAffordAmount;

	// Constructors

	/** default constructor */
	public Sfopcg() {
	}

	/** minimal constructor */
	public Sfopcg(String opdiagnoseId) {
		this.opdiagnoseId = opdiagnoseId;
	}

	/** full constructor */
	public Sfopcg(String opdiagnoseId, String aformId, Long csId, Long cashier,
			Timestamp cgTime, Boolean printReceiptOrNot, Double mcgBalance,
			Double treatmentCgBalance, String note, String receiptCode,
			Integer cgRoomId, Integer pharmacyId, Double cashAmount,
			Double medicalCardAffordAmount) {
		this.opdiagnoseId = opdiagnoseId;
		this.aformId = aformId;
		this.csId = csId;
		this.cashier = cashier;
		this.cgTime = cgTime;
		this.printReceiptOrNot = printReceiptOrNot;
		this.mcgBalance = mcgBalance;
		this.treatmentCgBalance = treatmentCgBalance;
		this.note = note;
		this.receiptCode = receiptCode;
		this.cgRoomId = cgRoomId;
		this.pharmacyId = pharmacyId;
		this.cashAmount = cashAmount;
		this.medicalCardAffordAmount = medicalCardAffordAmount;
	}

	// Property accessors

	public String getOpdiagnoseId() {
		return this.opdiagnoseId;
	}

	public void setOpdiagnoseId(String opdiagnoseId) {
		this.opdiagnoseId = opdiagnoseId;
	}

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Long getCashier() {
		return this.cashier;
	}

	public void setCashier(Long cashier) {
		this.cashier = cashier;
	}

	public Timestamp getCgTime() {
		return this.cgTime;
	}

	public void setCgTime(Timestamp cgTime) {
		this.cgTime = cgTime;
	}

	public Boolean getPrintReceiptOrNot() {
		return this.printReceiptOrNot;
	}

	public void setPrintReceiptOrNot(Boolean printReceiptOrNot) {
		this.printReceiptOrNot = printReceiptOrNot;
	}

	public Double getMcgBalance() {
		return this.mcgBalance;
	}

	public void setMcgBalance(Double mcgBalance) {
		this.mcgBalance = mcgBalance;
	}

	public Double getTreatmentCgBalance() {
		return this.treatmentCgBalance;
	}

	public void setTreatmentCgBalance(Double treatmentCgBalance) {
		this.treatmentCgBalance = treatmentCgBalance;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReceiptCode() {
		return this.receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public Integer getCgRoomId() {
		return this.cgRoomId;
	}

	public void setCgRoomId(Integer cgRoomId) {
		this.cgRoomId = cgRoomId;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public Double getCashAmount() {
		return this.cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Double getMedicalCardAffordAmount() {
		return this.medicalCardAffordAmount;
	}

	public void setMedicalCardAffordAmount(Double medicalCardAffordAmount) {
		this.medicalCardAffordAmount = medicalCardAffordAmount;
	}

}