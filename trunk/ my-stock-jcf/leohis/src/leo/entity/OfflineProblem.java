package leo.entity;

import java.sql.Timestamp;

/**
 * OfflineProblem entity. @author MyEclipse Persistence Tools
 */

public class OfflineProblem implements java.io.Serializable {

	// Fields

	private Long topicId;
	private String topicContent;
	private Timestamp startTime;
	private Long startCsId;
	private String content;

	// Constructors

	/** default constructor */
	public OfflineProblem() {
	}

	/** minimal constructor */
	public OfflineProblem(Long topicId) {
		this.topicId = topicId;
	}

	/** full constructor */
	public OfflineProblem(Long topicId, String topicContent,
			Timestamp startTime, Long startCsId, String content) {
		this.topicId = topicId;
		this.topicContent = topicContent;
		this.startTime = startTime;
		this.startCsId = startCsId;
		this.content = content;
	}

	// Property accessors

	public Long getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTopicContent() {
		return this.topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Long getStartCsId() {
		return this.startCsId;
	}

	public void setStartCsId(Long startCsId) {
		this.startCsId = startCsId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}