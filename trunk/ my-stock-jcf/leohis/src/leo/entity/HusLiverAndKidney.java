package leo.entity;

import java.sql.Timestamp;

/**
 * HusLiverAndKidney entity. @author MyEclipse Persistence Tools
 */

public class HusLiverAndKidney implements java.io.Serializable {

	// Fields

	private String recordId;
	private String alt;
	private String cr;
	private Boolean lis;
	private String itemId;
	private String executeU;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private Integer medicalInstId;
	private Long stuffId;
	private Boolean liverIsNormal;
	private Boolean kidneyIsNormal;

	// Constructors

	/** default constructor */
	public HusLiverAndKidney() {
	}

	/** minimal constructor */
	public HusLiverAndKidney(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusLiverAndKidney(String recordId, String alt, String cr,
			Boolean lis, String itemId, String executeU, Timestamp date,
			String doctor, String source, String hname, Integer medicalInstId,
			Long stuffId, Boolean liverIsNormal, Boolean kidneyIsNormal) {
		this.recordId = recordId;
		this.alt = alt;
		this.cr = cr;
		this.lis = lis;
		this.itemId = itemId;
		this.executeU = executeU;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
		this.liverIsNormal = liverIsNormal;
		this.kidneyIsNormal = kidneyIsNormal;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getAlt() {
		return this.alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getCr() {
		return this.cr;
	}

	public void setCr(String cr) {
		this.cr = cr;
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

	public Boolean getLiverIsNormal() {
		return this.liverIsNormal;
	}

	public void setLiverIsNormal(Boolean liverIsNormal) {
		this.liverIsNormal = liverIsNormal;
	}

	public Boolean getKidneyIsNormal() {
		return this.kidneyIsNormal;
	}

	public void setKidneyIsNormal(Boolean kidneyIsNormal) {
		this.kidneyIsNormal = kidneyIsNormal;
	}

}