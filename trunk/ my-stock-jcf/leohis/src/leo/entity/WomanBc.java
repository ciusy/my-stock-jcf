package leo.entity;

import java.sql.Timestamp;

/**
 * WomanBc entity. @author MyEclipse Persistence Tools
 */

public class WomanBc implements java.io.Serializable {

	// Fields

	private String recordId;
	private String bcnum;
	private String bc;
	private String bcabnormal;
	private String pictureWay;
	private Boolean lis;
	private String itemId;
	private String executeU;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public WomanBc() {
	}

	/** minimal constructor */
	public WomanBc(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public WomanBc(String recordId, String bcnum, String bc, String bcabnormal,
			String pictureWay, Boolean lis, String itemId, String executeU,
			Timestamp date, String doctor, String source, String hname,
			Integer medicalInstId, Long stuffId) {
		this.recordId = recordId;
		this.bcnum = bcnum;
		this.bc = bc;
		this.bcabnormal = bcabnormal;
		this.pictureWay = pictureWay;
		this.lis = lis;
		this.itemId = itemId;
		this.executeU = executeU;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
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

	public String getBcnum() {
		return this.bcnum;
	}

	public void setBcnum(String bcnum) {
		this.bcnum = bcnum;
	}

	public String getBc() {
		return this.bc;
	}

	public void setBc(String bc) {
		this.bc = bc;
	}

	public String getBcabnormal() {
		return this.bcabnormal;
	}

	public void setBcabnormal(String bcabnormal) {
		this.bcabnormal = bcabnormal;
	}

	public String getPictureWay() {
		return this.pictureWay;
	}

	public void setPictureWay(String pictureWay) {
		this.pictureWay = pictureWay;
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

}