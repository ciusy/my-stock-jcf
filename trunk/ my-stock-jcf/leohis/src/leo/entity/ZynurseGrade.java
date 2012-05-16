package leo.entity;

/**
 * ZynurseGrade entity. @author MyEclipse Persistence Tools
 */

public class ZynurseGrade implements java.io.Serializable {

	// Fields

	private Integer nurseGradeId;
	private String nurseGradeName;
	private Double nurseFee;

	// Constructors

	/** default constructor */
	public ZynurseGrade() {
	}

	/** minimal constructor */
	public ZynurseGrade(Integer nurseGradeId) {
		this.nurseGradeId = nurseGradeId;
	}

	/** full constructor */
	public ZynurseGrade(Integer nurseGradeId, String nurseGradeName,
			Double nurseFee) {
		this.nurseGradeId = nurseGradeId;
		this.nurseGradeName = nurseGradeName;
		this.nurseFee = nurseFee;
	}

	// Property accessors

	public Integer getNurseGradeId() {
		return this.nurseGradeId;
	}

	public void setNurseGradeId(Integer nurseGradeId) {
		this.nurseGradeId = nurseGradeId;
	}

	public String getNurseGradeName() {
		return this.nurseGradeName;
	}

	public void setNurseGradeName(String nurseGradeName) {
		this.nurseGradeName = nurseGradeName;
	}

	public Double getNurseFee() {
		return this.nurseFee;
	}

	public void setNurseFee(Double nurseFee) {
		this.nurseFee = nurseFee;
	}

}