package leo.entity;

import java.sql.Timestamp;

/**
 * HealthyPregnantSms entity. @author MyEclipse Persistence Tools
 */

public class HealthyPregnantSms implements java.io.Serializable {

	// Fields

	private Long sendId;
	private Long csId;
	private String telephone;
	private String messageContend;
	private Timestamp sendTime;
	private String sender;
	private String sendState;
	private String moduleNum;
	private Integer unitId;

	// Constructors

	/** default constructor */
	public HealthyPregnantSms() {
	}

	/** full constructor */
	public HealthyPregnantSms(Long csId, String telephone,
			String messageContend, Timestamp sendTime, String sender,
			String sendState, String moduleNum, Integer unitId) {
		this.csId = csId;
		this.telephone = telephone;
		this.messageContend = messageContend;
		this.sendTime = sendTime;
		this.sender = sender;
		this.sendState = sendState;
		this.moduleNum = moduleNum;
		this.unitId = unitId;
	}

	// Property accessors

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

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSendState() {
		return this.sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
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

}