package leo.entity;

import java.sql.Timestamp;

/**
 * ZyippresExecute entity. @author MyEclipse Persistence Tools
 */

public class ZyippresExecute implements java.io.Serializable {

	// Fields

	private String executeId;
	private String daid;
	private Long mreceiver;
	private Timestamp receiveTime;

	// Constructors

	/** default constructor */
	public ZyippresExecute() {
	}

	/** minimal constructor */
	public ZyippresExecute(String executeId, String daid) {
		this.executeId = executeId;
		this.daid = daid;
	}

	/** full constructor */
	public ZyippresExecute(String executeId, String daid, Long mreceiver,
			Timestamp receiveTime) {
		this.executeId = executeId;
		this.daid = daid;
		this.mreceiver = mreceiver;
		this.receiveTime = receiveTime;
	}

	// Property accessors

	public String getExecuteId() {
		return this.executeId;
	}

	public void setExecuteId(String executeId) {
		this.executeId = executeId;
	}

	public String getDaid() {
		return this.daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public Long getMreceiver() {
		return this.mreceiver;
	}

	public void setMreceiver(Long mreceiver) {
		this.mreceiver = mreceiver;
	}

	public Timestamp getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

}