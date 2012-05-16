package leo.entity;

import java.sql.Timestamp;

/**
 * YfapproveTable entity. @author MyEclipse Persistence Tools
 */

public class YfapproveTable implements java.io.Serializable {

	// Fields

	private Long approveFormId;
	private String formBelongTo;
	private String recordId;
	private String approveLogic;
	private Timestamp validityPeriod;
	private String status;

	// Constructors

	/** default constructor */
	public YfapproveTable() {
	}

	/** minimal constructor */
	public YfapproveTable(Long approveFormId) {
		this.approveFormId = approveFormId;
	}

	/** full constructor */
	public YfapproveTable(Long approveFormId, String formBelongTo,
			String recordId, String approveLogic, Timestamp validityPeriod,
			String status) {
		this.approveFormId = approveFormId;
		this.formBelongTo = formBelongTo;
		this.recordId = recordId;
		this.approveLogic = approveLogic;
		this.validityPeriod = validityPeriod;
		this.status = status;
	}

	// Property accessors

	public Long getApproveFormId() {
		return this.approveFormId;
	}

	public void setApproveFormId(Long approveFormId) {
		this.approveFormId = approveFormId;
	}

	public String getFormBelongTo() {
		return this.formBelongTo;
	}

	public void setFormBelongTo(String formBelongTo) {
		this.formBelongTo = formBelongTo;
	}

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getApproveLogic() {
		return this.approveLogic;
	}

	public void setApproveLogic(String approveLogic) {
		this.approveLogic = approveLogic;
	}

	public Timestamp getValidityPeriod() {
		return this.validityPeriod;
	}

	public void setValidityPeriod(Timestamp validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}