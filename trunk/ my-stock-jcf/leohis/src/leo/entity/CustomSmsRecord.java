package leo.entity;

import java.sql.Timestamp;

/**
 * CustomSmsRecord entity. @author MyEclipse Persistence Tools
 */

public class CustomSmsRecord implements java.io.Serializable {

	// Fields

	private Long recordId;
	private Long csId;
	private Long smsModuleId;
	private Timestamp timeOrigin;
	private Timestamp customisedTime;
	private String remarks;

	// Constructors

	/** default constructor */
	public CustomSmsRecord() {
	}

	/** minimal constructor */
	public CustomSmsRecord(Long recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public CustomSmsRecord(Long recordId, Long csId, Long smsModuleId,
			Timestamp timeOrigin, Timestamp customisedTime, String remarks) {
		this.recordId = recordId;
		this.csId = csId;
		this.smsModuleId = smsModuleId;
		this.timeOrigin = timeOrigin;
		this.customisedTime = customisedTime;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Long getSmsModuleId() {
		return this.smsModuleId;
	}

	public void setSmsModuleId(Long smsModuleId) {
		this.smsModuleId = smsModuleId;
	}

	public Timestamp getTimeOrigin() {
		return this.timeOrigin;
	}

	public void setTimeOrigin(Timestamp timeOrigin) {
		this.timeOrigin = timeOrigin;
	}

	public Timestamp getCustomisedTime() {
		return this.customisedTime;
	}

	public void setCustomisedTime(Timestamp customisedTime) {
		this.customisedTime = customisedTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}