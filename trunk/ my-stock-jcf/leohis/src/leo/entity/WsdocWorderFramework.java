package leo.entity;

/**
 * WsdocWorderFramework entity. @author MyEclipse Persistence Tools
 */

public class WsdocWorderFramework implements java.io.Serializable {

	// Fields

	private Long frameworkId;
	private String frameworkName;
	private Integer itemTypeId;
	private Integer executeU;
	private String note;

	// Constructors

	/** default constructor */
	public WsdocWorderFramework() {
	}

	/** minimal constructor */
	public WsdocWorderFramework(Long frameworkId) {
		this.frameworkId = frameworkId;
	}

	/** full constructor */
	public WsdocWorderFramework(Long frameworkId, String frameworkName,
			Integer itemTypeId, Integer executeU, String note) {
		this.frameworkId = frameworkId;
		this.frameworkName = frameworkName;
		this.itemTypeId = itemTypeId;
		this.executeU = executeU;
		this.note = note;
	}

	// Property accessors

	public Long getFrameworkId() {
		return this.frameworkId;
	}

	public void setFrameworkId(Long frameworkId) {
		this.frameworkId = frameworkId;
	}

	public String getFrameworkName() {
		return this.frameworkName;
	}

	public void setFrameworkName(String frameworkName) {
		this.frameworkName = frameworkName;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}