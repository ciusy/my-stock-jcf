package leo.entity;

import java.sql.Timestamp;

/**
 * Notify entity. @author MyEclipse Persistence Tools
 */

public class Notify implements java.io.Serializable {

	// Fields

	private String recordId;
	private String wname;
	private Integer wage;
	private String mname;
	private Integer mage;
	private String mtelephone;
	private String wtelephone;
	private String province;
	private String prefecture;
	private String town;
	private String village;
	private String told;
	private String suggest;
	private String doctor;
	private Timestamp ddate;
	private String wsignature;
	private Timestamp wdate;
	private String msignature;
	private Timestamp mdate;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public Notify() {
	}

	/** minimal constructor */
	public Notify(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public Notify(String recordId, String wname, Integer wage, String mname,
			Integer mage, String mtelephone, String wtelephone,
			String province, String prefecture, String town, String village,
			String told, String suggest, String doctor, Timestamp ddate,
			String wsignature, Timestamp wdate, String msignature,
			Timestamp mdate, Integer medicalInstId, Long stuffId) {
		this.recordId = recordId;
		this.wname = wname;
		this.wage = wage;
		this.mname = mname;
		this.mage = mage;
		this.mtelephone = mtelephone;
		this.wtelephone = wtelephone;
		this.province = province;
		this.prefecture = prefecture;
		this.town = town;
		this.village = village;
		this.told = told;
		this.suggest = suggest;
		this.doctor = doctor;
		this.ddate = ddate;
		this.wsignature = wsignature;
		this.wdate = wdate;
		this.msignature = msignature;
		this.mdate = mdate;
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

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public Integer getWage() {
		return this.wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMage() {
		return this.mage;
	}

	public void setMage(Integer mage) {
		this.mage = mage;
	}

	public String getMtelephone() {
		return this.mtelephone;
	}

	public void setMtelephone(String mtelephone) {
		this.mtelephone = mtelephone;
	}

	public String getWtelephone() {
		return this.wtelephone;
	}

	public void setWtelephone(String wtelephone) {
		this.wtelephone = wtelephone;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTold() {
		return this.told;
	}

	public void setTold(String told) {
		this.told = told;
	}

	public String getSuggest() {
		return this.suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Timestamp getDdate() {
		return this.ddate;
	}

	public void setDdate(Timestamp ddate) {
		this.ddate = ddate;
	}

	public String getWsignature() {
		return this.wsignature;
	}

	public void setWsignature(String wsignature) {
		this.wsignature = wsignature;
	}

	public Timestamp getWdate() {
		return this.wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public String getMsignature() {
		return this.msignature;
	}

	public void setMsignature(String msignature) {
		this.msignature = msignature;
	}

	public Timestamp getMdate() {
		return this.mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
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