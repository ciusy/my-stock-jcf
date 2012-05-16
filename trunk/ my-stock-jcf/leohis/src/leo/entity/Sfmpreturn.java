package leo.entity;

import java.sql.Timestamp;

/**
 * Sfmpreturn entity. @author MyEclipse Persistence Tools
 */

public class Sfmpreturn implements java.io.Serializable {

	// Fields

	private String preturnId;
	private String inbankAformId;
	private String exbankAformId;
	private Long preturner;
	private Timestamp preturnTime;
	private Boolean preturnOrNot;
	private String note;
	private Integer pharmacyId;

	// Constructors

	/** default constructor */
	public Sfmpreturn() {
	}

	/** minimal constructor */
	public Sfmpreturn(String preturnId, String inbankAformId) {
		this.preturnId = preturnId;
		this.inbankAformId = inbankAformId;
	}

	/** full constructor */
	public Sfmpreturn(String preturnId, String inbankAformId,
			String exbankAformId, Long preturner, Timestamp preturnTime,
			Boolean preturnOrNot, String note, Integer pharmacyId) {
		this.preturnId = preturnId;
		this.inbankAformId = inbankAformId;
		this.exbankAformId = exbankAformId;
		this.preturner = preturner;
		this.preturnTime = preturnTime;
		this.preturnOrNot = preturnOrNot;
		this.note = note;
		this.pharmacyId = pharmacyId;
	}

	// Property accessors

	public String getPreturnId() {
		return this.preturnId;
	}

	public void setPreturnId(String preturnId) {
		this.preturnId = preturnId;
	}

	public String getInbankAformId() {
		return this.inbankAformId;
	}

	public void setInbankAformId(String inbankAformId) {
		this.inbankAformId = inbankAformId;
	}

	public String getExbankAformId() {
		return this.exbankAformId;
	}

	public void setExbankAformId(String exbankAformId) {
		this.exbankAformId = exbankAformId;
	}

	public Long getPreturner() {
		return this.preturner;
	}

	public void setPreturner(Long preturner) {
		this.preturner = preturner;
	}

	public Timestamp getPreturnTime() {
		return this.preturnTime;
	}

	public void setPreturnTime(Timestamp preturnTime) {
		this.preturnTime = preturnTime;
	}

	public Boolean getPreturnOrNot() {
		return this.preturnOrNot;
	}

	public void setPreturnOrNot(Boolean preturnOrNot) {
		this.preturnOrNot = preturnOrNot;
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

}