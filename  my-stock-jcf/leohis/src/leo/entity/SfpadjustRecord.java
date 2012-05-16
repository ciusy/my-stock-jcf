package leo.entity;

import java.sql.Timestamp;

/**
 * SfpadjustRecord entity. @author MyEclipse Persistence Tools
 */

public class SfpadjustRecord implements java.io.Serializable {

	// Fields

	private Long padjustId;
	private Long pid;
	private Double formerP;
	private Double nowadayP;
	private Long adjuster;
	private Timestamp padjustTime;
	private String atype;
	private Double amount;

	// Constructors

	/** default constructor */
	public SfpadjustRecord() {
	}

	/** minimal constructor */
	public SfpadjustRecord(Long padjustId) {
		this.padjustId = padjustId;
	}

	/** full constructor */
	public SfpadjustRecord(Long padjustId, Long pid, Double formerP,
			Double nowadayP, Long adjuster, Timestamp padjustTime,
			String atype, Double amount) {
		this.padjustId = padjustId;
		this.pid = pid;
		this.formerP = formerP;
		this.nowadayP = nowadayP;
		this.adjuster = adjuster;
		this.padjustTime = padjustTime;
		this.atype = atype;
		this.amount = amount;
	}

	// Property accessors

	public Long getPadjustId() {
		return this.padjustId;
	}

	public void setPadjustId(Long padjustId) {
		this.padjustId = padjustId;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Double getFormerP() {
		return this.formerP;
	}

	public void setFormerP(Double formerP) {
		this.formerP = formerP;
	}

	public Double getNowadayP() {
		return this.nowadayP;
	}

	public void setNowadayP(Double nowadayP) {
		this.nowadayP = nowadayP;
	}

	public Long getAdjuster() {
		return this.adjuster;
	}

	public void setAdjuster(Long adjuster) {
		this.adjuster = adjuster;
	}

	public Timestamp getPadjustTime() {
		return this.padjustTime;
	}

	public void setPadjustTime(Timestamp padjustTime) {
		this.padjustTime = padjustTime;
	}

	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}