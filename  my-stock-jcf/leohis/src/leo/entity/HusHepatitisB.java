package leo.entity;

import java.sql.Timestamp;

/**
 * HusHepatitisB entity. @author MyEclipse Persistence Tools
 */

public class HusHepatitisB implements java.io.Serializable {

	// Fields

	private String recordId;
	private String hbsAg;
	private String hbsAb;
	private String hbeAg;
	private String hbeAb;
	private String hbcAb;
	private Boolean isNormal;
	private Boolean lis;
	private String itemId;
	private String executeU;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private String column14;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public HusHepatitisB() {
	}

	/** minimal constructor */
	public HusHepatitisB(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusHepatitisB(String recordId, String hbsAg, String hbsAb,
			String hbeAg, String hbeAb, String hbcAb, Boolean isNormal,
			Boolean lis, String itemId, String executeU, Timestamp date,
			String doctor, String source, String hname, String column14,
			Integer medicalInstId, Long stuffId) {
		this.recordId = recordId;
		this.hbsAg = hbsAg;
		this.hbsAb = hbsAb;
		this.hbeAg = hbeAg;
		this.hbeAb = hbeAb;
		this.hbcAb = hbcAb;
		this.isNormal = isNormal;
		this.lis = lis;
		this.itemId = itemId;
		this.executeU = executeU;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
		this.column14 = column14;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getHbsAg() {
		return this.hbsAg;
	}

	public void setHbsAg(String hbsAg) {
		this.hbsAg = hbsAg;
	}

	public String getHbsAb() {
		return this.hbsAb;
	}

	public void setHbsAb(String hbsAb) {
		this.hbsAb = hbsAb;
	}

	public String getHbeAg() {
		return this.hbeAg;
	}

	public void setHbeAg(String hbeAg) {
		this.hbeAg = hbeAg;
	}

	public String getHbeAb() {
		return this.hbeAb;
	}

	public void setHbeAb(String hbeAb) {
		this.hbeAb = hbeAb;
	}

	public String getHbcAb() {
		return this.hbcAb;
	}

	public void setHbcAb(String hbcAb) {
		this.hbcAb = hbcAb;
	}

	public Boolean getIsNormal() {
		return this.isNormal;
	}

	public void setIsNormal(Boolean isNormal) {
		this.isNormal = isNormal;
	}

	public Boolean getLis() {
		return this.lis;
	}

	public void setLis(Boolean lis) {
		this.lis = lis;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(String executeU) {
		this.executeU = executeU;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getColumn14() {
		return this.column14;
	}

	public void setColumn14(String column14) {
		this.column14 = column14;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public Long getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

}