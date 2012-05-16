package leo.entity;

import java.sql.Timestamp;

/**
 * SfipdepositRecord entity. @author MyEclipse Persistence Tools
 */

public class SfipdepositRecord implements java.io.Serializable {

	// Fields

	private Long depositId;
	private String ipid;
	private Long csId;
	private Double depositAmountPaid;
	private Timestamp sftime;
	private Long casher;
	private String note;
	private Integer chargeU;
	private Integer ipdeptId;

	// Constructors

	/** default constructor */
	public SfipdepositRecord() {
	}

	/** minimal constructor */
	public SfipdepositRecord(Long depositId) {
		this.depositId = depositId;
	}

	/** full constructor */
	public SfipdepositRecord(Long depositId, String ipid, Long csId,
			Double depositAmountPaid, Timestamp sftime, Long casher,
			String note, Integer chargeU, Integer ipdeptId) {
		this.depositId = depositId;
		this.ipid = ipid;
		this.csId = csId;
		this.depositAmountPaid = depositAmountPaid;
		this.sftime = sftime;
		this.casher = casher;
		this.note = note;
		this.chargeU = chargeU;
		this.ipdeptId = ipdeptId;
	}

	// Property accessors

	public Long getDepositId() {
		return this.depositId;
	}

	public void setDepositId(Long depositId) {
		this.depositId = depositId;
	}

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Double getDepositAmountPaid() {
		return this.depositAmountPaid;
	}

	public void setDepositAmountPaid(Double depositAmountPaid) {
		this.depositAmountPaid = depositAmountPaid;
	}

	public Timestamp getSftime() {
		return this.sftime;
	}

	public void setSftime(Timestamp sftime) {
		this.sftime = sftime;
	}

	public Long getCasher() {
		return this.casher;
	}

	public void setCasher(Long casher) {
		this.casher = casher;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getChargeU() {
		return this.chargeU;
	}

	public void setChargeU(Integer chargeU) {
		this.chargeU = chargeU;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

}