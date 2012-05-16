package leo.entity;

import java.sql.Timestamp;

/**
 * SfleaveHospBalance entity. @author MyEclipse Persistence Tools
 */

public class SfleaveHospBalance implements java.io.Serializable {

	// Fields

	private String ipid;
	private Double iptotalAmount;
	private Double depositAmount;
	private Double consumeAmount;
	private Double ruralCooper;
	private Double medicalInsurance;
	private Double toRefund;
	private Timestamp balanceTime;
	private Boolean ruralCooperBalance;
	private Boolean medicalInsuranceBalance;
	private Boolean printBillOrNot;
	private Long casher;
	private Integer cashierId;
	private Integer ipdeptId;

	// Constructors

	/** default constructor */
	public SfleaveHospBalance() {
	}

	/** minimal constructor */
	public SfleaveHospBalance(String ipid) {
		this.ipid = ipid;
	}

	/** full constructor */
	public SfleaveHospBalance(String ipid, Double iptotalAmount,
			Double depositAmount, Double consumeAmount, Double ruralCooper,
			Double medicalInsurance, Double toRefund, Timestamp balanceTime,
			Boolean ruralCooperBalance, Boolean medicalInsuranceBalance,
			Boolean printBillOrNot, Long casher, Integer cashierId,
			Integer ipdeptId) {
		this.ipid = ipid;
		this.iptotalAmount = iptotalAmount;
		this.depositAmount = depositAmount;
		this.consumeAmount = consumeAmount;
		this.ruralCooper = ruralCooper;
		this.medicalInsurance = medicalInsurance;
		this.toRefund = toRefund;
		this.balanceTime = balanceTime;
		this.ruralCooperBalance = ruralCooperBalance;
		this.medicalInsuranceBalance = medicalInsuranceBalance;
		this.printBillOrNot = printBillOrNot;
		this.casher = casher;
		this.cashierId = cashierId;
		this.ipdeptId = ipdeptId;
	}

	// Property accessors

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Double getIptotalAmount() {
		return this.iptotalAmount;
	}

	public void setIptotalAmount(Double iptotalAmount) {
		this.iptotalAmount = iptotalAmount;
	}

	public Double getDepositAmount() {
		return this.depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getConsumeAmount() {
		return this.consumeAmount;
	}

	public void setConsumeAmount(Double consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	public Double getRuralCooper() {
		return this.ruralCooper;
	}

	public void setRuralCooper(Double ruralCooper) {
		this.ruralCooper = ruralCooper;
	}

	public Double getMedicalInsurance() {
		return this.medicalInsurance;
	}

	public void setMedicalInsurance(Double medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public Double getToRefund() {
		return this.toRefund;
	}

	public void setToRefund(Double toRefund) {
		this.toRefund = toRefund;
	}

	public Timestamp getBalanceTime() {
		return this.balanceTime;
	}

	public void setBalanceTime(Timestamp balanceTime) {
		this.balanceTime = balanceTime;
	}

	public Boolean getRuralCooperBalance() {
		return this.ruralCooperBalance;
	}

	public void setRuralCooperBalance(Boolean ruralCooperBalance) {
		this.ruralCooperBalance = ruralCooperBalance;
	}

	public Boolean getMedicalInsuranceBalance() {
		return this.medicalInsuranceBalance;
	}

	public void setMedicalInsuranceBalance(Boolean medicalInsuranceBalance) {
		this.medicalInsuranceBalance = medicalInsuranceBalance;
	}

	public Boolean getPrintBillOrNot() {
		return this.printBillOrNot;
	}

	public void setPrintBillOrNot(Boolean printBillOrNot) {
		this.printBillOrNot = printBillOrNot;
	}

	public Long getCasher() {
		return this.casher;
	}

	public void setCasher(Long casher) {
		this.casher = casher;
	}

	public Integer getCashierId() {
		return this.cashierId;
	}

	public void setCashierId(Integer cashierId) {
		this.cashierId = cashierId;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

}