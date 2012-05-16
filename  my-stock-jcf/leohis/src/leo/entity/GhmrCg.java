package leo.entity;

import java.sql.Timestamp;

/**
 * GhmrCg entity. @author MyEclipse Persistence Tools
 */

public class GhmrCg implements java.io.Serializable {

	// Fields

	private Long buyId;
	private Long csId;
	private Double cgOfClinicRecord;
	private Double cgOfMedicalCard;
	private Timestamp buytime;
	private Long sid;

	// Constructors

	/** default constructor */
	public GhmrCg() {
	}

	/** minimal constructor */
	public GhmrCg(Long buyId, Long sid) {
		this.buyId = buyId;
		this.sid = sid;
	}

	/** full constructor */
	public GhmrCg(Long buyId, Long csId, Double cgOfClinicRecord,
			Double cgOfMedicalCard, Timestamp buytime, Long sid) {
		this.buyId = buyId;
		this.csId = csId;
		this.cgOfClinicRecord = cgOfClinicRecord;
		this.cgOfMedicalCard = cgOfMedicalCard;
		this.buytime = buytime;
		this.sid = sid;
	}

	// Property accessors

	public Long getBuyId() {
		return this.buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Double getCgOfClinicRecord() {
		return this.cgOfClinicRecord;
	}

	public void setCgOfClinicRecord(Double cgOfClinicRecord) {
		this.cgOfClinicRecord = cgOfClinicRecord;
	}

	public Double getCgOfMedicalCard() {
		return this.cgOfMedicalCard;
	}

	public void setCgOfMedicalCard(Double cgOfMedicalCard) {
		this.cgOfMedicalCard = cgOfMedicalCard;
	}

	public Timestamp getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

}