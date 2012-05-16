package leo.entity;

/**
 * SmsModuleTerm entity. @author MyEclipse Persistence Tools
 */

public class SmsModuleTerm implements java.io.Serializable {

	// Fields

	private Long sttid;
	private Long moduleId;
	private Integer pointTime;
	private Long unitId;
	private String content;
	private String remarks;

	// Constructors

	/** default constructor */
	public SmsModuleTerm() {
	}

	/** full constructor */
	public SmsModuleTerm(Long moduleId, Integer pointTime, Long unitId,
			String content, String remarks) {
		this.moduleId = moduleId;
		this.pointTime = pointTime;
		this.unitId = unitId;
		this.content = content;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getSttid() {
		return this.sttid;
	}

	public void setSttid(Long sttid) {
		this.sttid = sttid;
	}

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getPointTime() {
		return this.pointTime;
	}

	public void setPointTime(Integer pointTime) {
		this.pointTime = pointTime;
	}

	public Long getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}