package leo.entity;

import java.sql.Timestamp;

/**
 * MzopDn entity. @author MyEclipse Persistence Tools
 */

public class MzopDn implements java.io.Serializable {

	// Fields

	private String opDnId;
	private String opnum;
	private Long csId;
	private Long doctorId;
	private String chief;
	private String dn;
	private Timestamp dnTime;
	private String alterDntimeId;
	private String note;
	private String status;
	private Integer csu;

	// Constructors

	/** default constructor */
	public MzopDn() {
	}

	/** minimal constructor */
	public MzopDn(String opDnId) {
		this.opDnId = opDnId;
	}

	/** full constructor */
	public MzopDn(String opDnId, String opnum, Long csId, Long doctorId,
			String chief, String dn, Timestamp dnTime, String alterDntimeId,
			String note, String status, Integer csu) {
		this.opDnId = opDnId;
		this.opnum = opnum;
		this.csId = csId;
		this.doctorId = doctorId;
		this.chief = chief;
		this.dn = dn;
		this.dnTime = dnTime;
		this.alterDntimeId = alterDntimeId;
		this.note = note;
		this.status = status;
		this.csu = csu;
	}

	// Property accessors

	public String getOpDnId() {
		return this.opDnId;
	}

	public void setOpDnId(String opDnId) {
		this.opDnId = opDnId;
	}

	public String getOpnum() {
		return this.opnum;
	}

	public void setOpnum(String opnum) {
		this.opnum = opnum;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Long getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getChief() {
		return this.chief;
	}

	public void setChief(String chief) {
		this.chief = chief;
	}

	public String getDn() {
		return this.dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public Timestamp getDnTime() {
		return this.dnTime;
	}

	public void setDnTime(Timestamp dnTime) {
		this.dnTime = dnTime;
	}

	public String getAlterDntimeId() {
		return this.alterDntimeId;
	}

	public void setAlterDntimeId(String alterDntimeId) {
		this.alterDntimeId = alterDntimeId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCsu() {
		return this.csu;
	}

	public void setCsu(Integer csu) {
		this.csu = csu;
	}

}