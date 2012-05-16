package leo.entity;

import java.sql.Timestamp;

/**
 * ZydoctorAdvice entity. @author MyEclipse Persistence Tools
 */

public class ZydoctorAdvice implements java.io.Serializable {

	// Fields

	private String daid;
	private String ipid;
	private Long csId;
	private String diagnoseContent;
	private Long createDoctor;
	private Timestamp createTime;
	private Long approveNurse;
	private Timestamp approveTime;
	private String dastate;
	private Integer ipdeptId;
	private String treatmentId;
	private String aformId;
	private String doctorAdvice;

	// Constructors

	/** default constructor */
	public ZydoctorAdvice() {
	}

	/** minimal constructor */
	public ZydoctorAdvice(String daid) {
		this.daid = daid;
	}

	/** full constructor */
	public ZydoctorAdvice(String daid, String ipid, Long csId,
			String diagnoseContent, Long createDoctor, Timestamp createTime,
			Long approveNurse, Timestamp approveTime, String dastate,
			Integer ipdeptId, String treatmentId, String aformId,
			String doctorAdvice) {
		this.daid = daid;
		this.ipid = ipid;
		this.csId = csId;
		this.diagnoseContent = diagnoseContent;
		this.createDoctor = createDoctor;
		this.createTime = createTime;
		this.approveNurse = approveNurse;
		this.approveTime = approveTime;
		this.dastate = dastate;
		this.ipdeptId = ipdeptId;
		this.treatmentId = treatmentId;
		this.aformId = aformId;
		this.doctorAdvice = doctorAdvice;
	}

	// Property accessors

	public String getDaid() {
		return this.daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getDiagnoseContent() {
		return this.diagnoseContent;
	}

	public void setDiagnoseContent(String diagnoseContent) {
		this.diagnoseContent = diagnoseContent;
	}

	public Long getCreateDoctor() {
		return this.createDoctor;
	}

	public void setCreateDoctor(Long createDoctor) {
		this.createDoctor = createDoctor;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getApproveNurse() {
		return this.approveNurse;
	}

	public void setApproveNurse(Long approveNurse) {
		this.approveNurse = approveNurse;
	}

	public Timestamp getApproveTime() {
		return this.approveTime;
	}

	public void setApproveTime(Timestamp approveTime) {
		this.approveTime = approveTime;
	}

	public String getDastate() {
		return this.dastate;
	}

	public void setDastate(String dastate) {
		this.dastate = dastate;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

	public String getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
	}

	public String getDoctorAdvice() {
		return this.doctorAdvice;
	}

	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}

}