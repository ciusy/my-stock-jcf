package leo.entity;

/**
 * Zybed entity. @author MyEclipse Persistence Tools
 */

public class Zybed implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bed;
	private String currentStatus;
	private Double bedCharge;
	private Long attendingDoctor;
	private Long nurseInCharge;
	private Long seniorDoctor;
	private String sex;
	private Integer ipdeptId;

	// Constructors

	/** default constructor */
	public Zybed() {
	}

	/** minimal constructor */
	public Zybed(Integer id, String bed) {
		this.id = id;
		this.bed = bed;
	}

	/** full constructor */
	public Zybed(Integer id, String bed, String currentStatus,
			Double bedCharge, Long attendingDoctor, Long nurseInCharge,
			Long seniorDoctor, String sex, Integer ipdeptId) {
		this.id = id;
		this.bed = bed;
		this.currentStatus = currentStatus;
		this.bedCharge = bedCharge;
		this.attendingDoctor = attendingDoctor;
		this.nurseInCharge = nurseInCharge;
		this.seniorDoctor = seniorDoctor;
		this.sex = sex;
		this.ipdeptId = ipdeptId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getCurrentStatus() {
		return this.currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Double getBedCharge() {
		return this.bedCharge;
	}

	public void setBedCharge(Double bedCharge) {
		this.bedCharge = bedCharge;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

}