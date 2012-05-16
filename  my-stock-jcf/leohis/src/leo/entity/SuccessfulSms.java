package leo.entity;

import java.sql.Timestamp;

/**
 * SuccessfulSms entity. @author MyEclipse Persistence Tools
 */

public class SuccessfulSms implements java.io.Serializable {

	// Fields

	private Long id;
	private Long sendId;
	private Long csId;
	private String telephone;
	private String messageContend;
	private Timestamp sendTime;
	private String status;
	private String sender;
	private String moduleNum;
	private Integer unitId;
	private String errorCode;

	// Constructors

	/** default constructor */
	public SuccessfulSms() {
	}

	/** full constructor */
	public SuccessfulSms(Long sendId, Long csId, String telephone,
			String messageContend, Timestamp sendTime, String status,
			String sender, String moduleNum, Integer unitId, String errorCode) {
		this.sendId = sendId;
		this.csId = csId;
		this.telephone = telephone;
		this.messageContend = messageContend;
		this.sendTime = sendTime;
		this.status = status;
		this.sender = sender;
		this.moduleNum = moduleNum;
		this.unitId = unitId;
		this.errorCode = errorCode;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSendId() {
		return this.sendId;
	}

	public void setSendId(Long sendId) {
		this.sendId = sendId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMessageContend() {
		return this.messageContend;
	}

	public void setMessageContend(String messageContend) {
		this.messageContend = messageContend;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getModuleNum() {
		return this.moduleNum;
	}

	public void setModuleNum(String moduleNum) {
		this.moduleNum = moduleNum;
	}

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}