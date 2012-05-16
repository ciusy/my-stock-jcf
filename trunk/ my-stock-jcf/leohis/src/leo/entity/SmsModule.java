package leo.entity;

/**
 * SmsModule entity. @author MyEclipse Persistence Tools
 */

public class SmsModule implements java.io.Serializable {

	// Fields

	private Long moduleId;
	private String moduleName;
	private Long affiliationId;
	private String pointName;
	private String remarks;

	// Constructors

	/** default constructor */
	public SmsModule() {
	}

	/** full constructor */
	public SmsModule(String moduleName, Long affiliationId, String pointName,
			String remarks) {
		this.moduleName = moduleName;
		this.affiliationId = affiliationId;
		this.pointName = pointName;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getAffiliationId() {
		return this.affiliationId;
	}

	public void setAffiliationId(Long affiliationId) {
		this.affiliationId = affiliationId;
	}

	public String getPointName() {
		return this.pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}