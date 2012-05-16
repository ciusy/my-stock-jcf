package leo.entity;

import java.sql.Timestamp;

/**
 * YfcheckRecord entity. @author MyEclipse Persistence Tools
 */

public class YfcheckRecord implements java.io.Serializable {

	// Fields

	private String checkRecordId;
	private Timestamp startTime;
	private Long checker;
	private Integer checkU;
	private String checkStatus;
	private Timestamp finishTime;
	private String approveLogic;

	// Constructors

	/** default constructor */
	public YfcheckRecord() {
	}

	/** minimal constructor */
	public YfcheckRecord(String checkRecordId) {
		this.checkRecordId = checkRecordId;
	}

	/** full constructor */
	public YfcheckRecord(String checkRecordId, Timestamp startTime,
			Long checker, Integer checkU, String checkStatus,
			Timestamp finishTime, String approveLogic) {
		this.checkRecordId = checkRecordId;
		this.startTime = startTime;
		this.checker = checker;
		this.checkU = checkU;
		this.checkStatus = checkStatus;
		this.finishTime = finishTime;
		this.approveLogic = approveLogic;
	}

	// Property accessors

	public String getCheckRecordId() {
		return this.checkRecordId;
	}

	public void setCheckRecordId(String checkRecordId) {
		this.checkRecordId = checkRecordId;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Long getChecker() {
		return this.checker;
	}

	public void setChecker(Long checker) {
		this.checker = checker;
	}

	public Integer getCheckU() {
		return this.checkU;
	}

	public void setCheckU(Integer checkU) {
		this.checkU = checkU;
	}

	public String getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Timestamp getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public String getApproveLogic() {
		return this.approveLogic;
	}

	public void setApproveLogic(String approveLogic) {
		this.approveLogic = approveLogic;
	}

}