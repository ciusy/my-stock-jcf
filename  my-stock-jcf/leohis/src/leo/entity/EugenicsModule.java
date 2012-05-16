package leo.entity;

/**
 * EugenicsModule entity. @author MyEclipse Persistence Tools
 */

public class EugenicsModule implements java.io.Serializable {

	// Fields

	private Long moduleId;
	private String remarks;
	private String title;
	private String content;

	// Constructors

	/** default constructor */
	public EugenicsModule() {
	}

	/** minimal constructor */
	public EugenicsModule(Long moduleId) {
		this.moduleId = moduleId;
	}

	/** full constructor */
	public EugenicsModule(Long moduleId, String remarks, String title,
			String content) {
		this.moduleId = moduleId;
		this.remarks = remarks;
		this.title = title;
		this.content = content;
	}

	// Property accessors

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}