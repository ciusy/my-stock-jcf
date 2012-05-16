package leo.entity;

import java.sql.Timestamp;

/**
 * YfapproveItem entity. @author MyEclipse Persistence Tools
 */

public class YfapproveItem implements java.io.Serializable {

	// Fields

	private Long approveItemId;
	private Long approveFormId;
	private Long approver;
	private Boolean agreeOrNot;
	private String note;
	private Timestamp stime;

	// Constructors

	/** default constructor */
	public YfapproveItem() {
	}

	/** minimal constructor */
	public YfapproveItem(Long approveItemId) {
		this.approveItemId = approveItemId;
	}

	/** full constructor */
	public YfapproveItem(Long approveItemId, Long approveFormId, Long approver,
			Boolean agreeOrNot, String note, Timestamp stime) {
		this.approveItemId = approveItemId;
		this.approveFormId = approveFormId;
		this.approver = approver;
		this.agreeOrNot = agreeOrNot;
		this.note = note;
		this.stime = stime;
	}

	// Property accessors

	public Long getApproveItemId() {
		return this.approveItemId;
	}

	public void setApproveItemId(Long approveItemId) {
		this.approveItemId = approveItemId;
	}

	public Long getApproveFormId() {
		return this.approveFormId;
	}

	public void setApproveFormId(Long approveFormId) {
		this.approveFormId = approveFormId;
	}

	public Long getApprover() {
		return this.approver;
	}

	public void setApprover(Long approver) {
		this.approver = approver;
	}

	public Boolean getAgreeOrNot() {
		return this.agreeOrNot;
	}

	public void setAgreeOrNot(Boolean agreeOrNot) {
		this.agreeOrNot = agreeOrNot;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getStime() {
		return this.stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

}