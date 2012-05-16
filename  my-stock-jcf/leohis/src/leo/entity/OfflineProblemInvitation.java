package leo.entity;

import java.sql.Timestamp;

/**
 * OfflineProblemInvitation entity. @author MyEclipse Persistence Tools
 */

public class OfflineProblemInvitation implements java.io.Serializable {

	// Fields

	private Long invitationId;
	private Long topicId;
	private Long staffId;
	private Long csId;
	private Timestamp responseTime;
	private String content;

	// Constructors

	/** default constructor */
	public OfflineProblemInvitation() {
	}

	/** minimal constructor */
	public OfflineProblemInvitation(Long invitationId) {
		this.invitationId = invitationId;
	}

	/** full constructor */
	public OfflineProblemInvitation(Long invitationId, Long topicId,
			Long staffId, Long csId, Timestamp responseTime, String content) {
		this.invitationId = invitationId;
		this.topicId = topicId;
		this.staffId = staffId;
		this.csId = csId;
		this.responseTime = responseTime;
		this.content = content;
	}

	// Property accessors

	public Long getInvitationId() {
		return this.invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}

	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Timestamp getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(Timestamp responseTime) {
		this.responseTime = responseTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}