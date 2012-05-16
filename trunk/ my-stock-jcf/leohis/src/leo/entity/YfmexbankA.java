package leo.entity;

import java.sql.Timestamp;

/**
 * YfmexbankA entity. @author MyEclipse Persistence Tools
 */

public class YfmexbankA implements java.io.Serializable {

	// Fields

	private String aformId;
	private Integer exbankTypeId;
	private Long personToGetM;
	private Integer au;
	private Timestamp atime;
	private Timestamp approveTime;
	private Timestamp exbankTime;
	private String exbankStatus;
	private String note;
	private Integer costTypeId;
	private Integer pharmacyId;
	private String inAformId;
	private Long estaffId;
	private String opnum;
	private String opDnId;
	private Long establish;

	// Constructors

	/** default constructor */
	public YfmexbankA() {
	}

	/** minimal constructor */
	public YfmexbankA(String aformId) {
		this.aformId = aformId;
	}

	/** full constructor */
	public YfmexbankA(String aformId, Integer exbankTypeId, Long personToGetM,
			Integer au, Timestamp atime, Timestamp approveTime,
			Timestamp exbankTime, String exbankStatus, String note,
			Integer costTypeId, Integer pharmacyId, String inAformId,
			Long estaffId, String opnum, String opDnId, Long establish) {
		this.aformId = aformId;
		this.exbankTypeId = exbankTypeId;
		this.personToGetM = personToGetM;
		this.au = au;
		this.atime = atime;
		this.approveTime = approveTime;
		this.exbankTime = exbankTime;
		this.exbankStatus = exbankStatus;
		this.note = note;
		this.costTypeId = costTypeId;
		this.pharmacyId = pharmacyId;
		this.inAformId = inAformId;
		this.estaffId = estaffId;
		this.opnum = opnum;
		this.opDnId = opDnId;
		this.establish = establish;
	}

	// Property accessors

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
	}

	public Integer getExbankTypeId() {
		return this.exbankTypeId;
	}

	public void setExbankTypeId(Integer exbankTypeId) {
		this.exbankTypeId = exbankTypeId;
	}

	public Long getPersonToGetM() {
		return this.personToGetM;
	}

	public void setPersonToGetM(Long personToGetM) {
		this.personToGetM = personToGetM;
	}

	public Integer getAu() {
		return this.au;
	}

	public void setAu(Integer au) {
		this.au = au;
	}

	public Timestamp getAtime() {
		return this.atime;
	}

	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}

	public Timestamp getApproveTime() {
		return this.approveTime;
	}

	public void setApproveTime(Timestamp approveTime) {
		this.approveTime = approveTime;
	}

	public Timestamp getExbankTime() {
		return this.exbankTime;
	}

	public void setExbankTime(Timestamp exbankTime) {
		this.exbankTime = exbankTime;
	}

	public String getExbankStatus() {
		return this.exbankStatus;
	}

	public void setExbankStatus(String exbankStatus) {
		this.exbankStatus = exbankStatus;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getCostTypeId() {
		return this.costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getInAformId() {
		return this.inAformId;
	}

	public void setInAformId(String inAformId) {
		this.inAformId = inAformId;
	}

	public Long getEstaffId() {
		return this.estaffId;
	}

	public void setEstaffId(Long estaffId) {
		this.estaffId = estaffId;
	}

	public String getOpnum() {
		return this.opnum;
	}

	public void setOpnum(String opnum) {
		this.opnum = opnum;
	}

	public String getOpDnId() {
		return this.opDnId;
	}

	public void setOpDnId(String opDnId) {
		this.opDnId = opDnId;
	}

	public Long getEstablish() {
		return this.establish;
	}

	public void setEstablish(Long establish) {
		this.establish = establish;
	}

}