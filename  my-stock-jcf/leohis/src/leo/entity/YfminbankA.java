package leo.entity;

import java.sql.Timestamp;

/**
 * YfminbankA entity. @author MyEclipse Persistence Tools
 */

public class YfminbankA implements java.io.Serializable {

	// Fields

	private String aformId;
	private Integer inbankTypeId;
	private String aobject;
	private Timestamp atime;
	private Timestamp approveTime;
	private String inbankStatus;
	private Timestamp inbankTime;
	private String note;
	private Integer pharmacyId;
	private Long istaffId;
	private Long establish;
	private String opnum;

	// Constructors

	/** default constructor */
	public YfminbankA() {
	}

	/** minimal constructor */
	public YfminbankA(String aformId) {
		this.aformId = aformId;
	}

	/** full constructor */
	public YfminbankA(String aformId, Integer inbankTypeId, String aobject,
			Timestamp atime, Timestamp approveTime, String inbankStatus,
			Timestamp inbankTime, String note, Integer pharmacyId,
			Long istaffId, Long establish, String opnum) {
		this.aformId = aformId;
		this.inbankTypeId = inbankTypeId;
		this.aobject = aobject;
		this.atime = atime;
		this.approveTime = approveTime;
		this.inbankStatus = inbankStatus;
		this.inbankTime = inbankTime;
		this.note = note;
		this.pharmacyId = pharmacyId;
		this.istaffId = istaffId;
		this.establish = establish;
		this.opnum = opnum;
	}

	// Property accessors

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
	}

	public Integer getInbankTypeId() {
		return this.inbankTypeId;
	}

	public void setInbankTypeId(Integer inbankTypeId) {
		this.inbankTypeId = inbankTypeId;
	}

	public String getAobject() {
		return this.aobject;
	}

	public void setAobject(String aobject) {
		this.aobject = aobject;
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

	public String getInbankStatus() {
		return this.inbankStatus;
	}

	public void setInbankStatus(String inbankStatus) {
		this.inbankStatus = inbankStatus;
	}

	public Timestamp getInbankTime() {
		return this.inbankTime;
	}

	public void setInbankTime(Timestamp inbankTime) {
		this.inbankTime = inbankTime;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public Long getIstaffId() {
		return this.istaffId;
	}

	public void setIstaffId(Long istaffId) {
		this.istaffId = istaffId;
	}

	public Long getEstablish() {
		return this.establish;
	}

	public void setEstablish(Long establish) {
		this.establish = establish;
	}

	public String getOpnum() {
		return this.opnum;
	}

	public void setOpnum(String opnum) {
		this.opnum = opnum;
	}

}