package leo.entity;

import java.sql.Timestamp;

/**
 * ZyiptreatmentExecute entity. @author MyEclipse Persistence Tools
 */

public class ZyiptreatmentExecute implements java.io.Serializable {

	// Fields

	private String executeId;
	private String daitemId;
	private String treatmentId;
	private Timestamp executeTime;
	private Timestamp approveTime;

	// Constructors

	/** default constructor */
	public ZyiptreatmentExecute() {
	}

	/** minimal constructor */
	public ZyiptreatmentExecute(String executeId) {
		this.executeId = executeId;
	}

	/** full constructor */
	public ZyiptreatmentExecute(String executeId, String daitemId,
			String treatmentId, Timestamp executeTime, Timestamp approveTime) {
		this.executeId = executeId;
		this.daitemId = daitemId;
		this.treatmentId = treatmentId;
		this.executeTime = executeTime;
		this.approveTime = approveTime;
	}

	// Property accessors

	public String getExecuteId() {
		return this.executeId;
	}

	public void setExecuteId(String executeId) {
		this.executeId = executeId;
	}

	public String getDaitemId() {
		return this.daitemId;
	}

	public void setDaitemId(String daitemId) {
		this.daitemId = daitemId;
	}

	public String getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Timestamp getExecuteTime() {
		return this.executeTime;
	}

	public void setExecuteTime(Timestamp executeTime) {
		this.executeTime = executeTime;
	}

	public Timestamp getApproveTime() {
		return this.approveTime;
	}

	public void setApproveTime(Timestamp approveTime) {
		this.approveTime = approveTime;
	}

}