package leo.entity;

/**
 * NotifyItems entity. @author MyEclipse Persistence Tools
 */

public class NotifyItems implements java.io.Serializable {

	// Fields

	private Long niid;
	private String condition;
	private String content;
	private String type;

	// Constructors

	/** default constructor */
	public NotifyItems() {
	}

	/** full constructor */
	public NotifyItems(String condition, String content, String type) {
		this.condition = condition;
		this.content = content;
		this.type = type;
	}

	// Property accessors

	public Long getNiid() {
		return this.niid;
	}

	public void setNiid(Long niid) {
		this.niid = niid;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}