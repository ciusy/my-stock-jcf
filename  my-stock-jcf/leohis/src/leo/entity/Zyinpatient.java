package leo.entity;

import java.sql.Timestamp;

/**
 * Zyinpatient entity. @author MyEclipse Persistence Tools
 */

public class Zyinpatient implements java.io.Serializable {

	// Fields

	private String ipid;
	private Integer nurseGradeId;
	private String bed;
	private Long csId;
	private Long amaker;
	private Timestamp atime;
	private Timestamp iptime;
	private String ipreason;
	private String astatus;
	private Double depositAdvised;
	private String note;
	private Long fillIpitemDocId;
	private Double depositBalance;
	private Boolean leaveHospOrNot;
	private Timestamp leaveTime;
	private String nurseType;
	private String dietCircs;
	private String csCircs;
	private Integer chargeType;
	private Integer ipdeptId;
	private Long ipdoctor;
	private Long attendingDoctor;
	private Long nurseInCharge;
	private Long seniorDoctor;

	// Constructors

	/** default constructor */
	public Zyinpatient() {
	}

	/** minimal constructor */
	public Zyinpatient(String ipid) {
		this.ipid = ipid;
	}

	/** full constructor */
	public Zyinpatient(String ipid, Integer nurseGradeId, String bed,
			Long csId, Long amaker, Timestamp atime, Timestamp iptime,
			String ipreason, String astatus, Double depositAdvised,
			String note, Long fillIpitemDocId, Double depositBalance,
			Boolean leaveHospOrNot, Timestamp leaveTime, String nurseType,
			String dietCircs, String csCircs, Integer chargeType,
			Integer ipdeptId, Long ipdoctor, Long attendingDoctor,
			Long nurseInCharge, Long seniorDoctor) {
		this.ipid = ipid;
		this.nurseGradeId = nurseGradeId;
		this.bed = bed;
		this.csId = csId;
		this.amaker = amaker;
		this.atime = atime;
		this.iptime = iptime;
		this.ipreason = ipreason;
		this.astatus = astatus;
		this.depositAdvised = depositAdvised;
		this.note = note;
		this.fillIpitemDocId = fillIpitemDocId;
		this.depositBalance = depositBalance;
		this.leaveHospOrNot = leaveHospOrNot;
		this.leaveTime = leaveTime;
		this.nurseType = nurseType;
		this.dietCircs = dietCircs;
		this.csCircs = csCircs;
		this.chargeType = chargeType;
		this.ipdeptId = ipdeptId;
		this.ipdoctor = ipdoctor;
		this.attendingDoctor = attendingDoctor;
		this.nurseInCharge = nurseInCharge;
		this.seniorDoctor = seniorDoctor;
	}

	// Property accessors

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Integer getNurseGradeId() {
		return this.nurseGradeId;
	}

	public void setNurseGradeId(Integer nurseGradeId) {
		this.nurseGradeId = nurseGradeId;
	}

	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Long getAmaker() {
		return this.amaker;
	}

	public void setAmaker(Long amaker) {
		this.amaker = amaker;
	}

	public Timestamp getAtime() {
		return this.atime;
	}

	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}

	public Timestamp getIptime() {
		return this.iptime;
	}

	public void setIptime(Timestamp iptime) {
		this.iptime = iptime;
	}

	public String getIpreason() {
		return this.ipreason;
	}

	public void setIpreason(String ipreason) {
		this.ipreason = ipreason;
	}

	public String getAstatus() {
		return this.astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}

	public Double getDepositAdvised() {
		return this.depositAdvised;
	}

	public void setDepositAdvised(Double depositAdvised) {
		this.depositAdvised = depositAdvised;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getFillIpitemDocId() {
		return this.fillIpitemDocId;
	}

	public void setFillIpitemDocId(Long fillIpitemDocId) {
		this.fillIpitemDocId = fillIpitemDocId;
	}

	public Double getDepositBalance() {
		return this.depositBalance;
	}

	public void setDepositBalance(Double depositBalance) {
		this.depositBalance = depositBalance;
	}

	public Boolean getLeaveHospOrNot() {
		return this.leaveHospOrNot;
	}

	public void setLeaveHospOrNot(Boolean leaveHospOrNot) {
		this.leaveHospOrNot = leaveHospOrNot;
	}

	public Timestamp getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getNurseType() {
		return this.nurseType;
	}

	public void setNurseType(String nurseType) {
		this.nurseType = nurseType;
	}

	public String getDietCircs() {
		return this.dietCircs;
	}

	public void setDietCircs(String dietCircs) {
		this.dietCircs = dietCircs;
	}

	public String getCsCircs() {
		return this.csCircs;
	}

	public void setCsCircs(String csCircs) {
		this.csCircs = csCircs;
	}

	public Integer getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

	public Long getIpdoctor() {
		return this.ipdoctor;
	}

	public void setIpdoctor(Long ipdoctor) {
		this.ipdoctor = ipdoctor;
	}

	public Long getAttendingDoctor() {
		return this.attendingDoctor;
	}

	public void setAttendingDoctor(Long attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}

	public Long getNurseInCharge() {
		return this.nurseInCharge;
	}

	public void setNurseInCharge(Long nurseInCharge) {
		this.nurseInCharge = nurseInCharge;
	}

	public Long getSeniorDoctor() {
		return this.seniorDoctor;
	}

	public void setSeniorDoctor(Long seniorDoctor) {
		this.seniorDoctor = seniorDoctor;
	}

}