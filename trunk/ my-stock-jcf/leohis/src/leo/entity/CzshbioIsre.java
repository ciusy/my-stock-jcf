package leo.entity;

import java.sql.Timestamp;

/**
 * CzshbioIsre entity. @author MyEclipse Persistence Tools
 */

public class CzshbioIsre implements java.io.Serializable {

	// Fields

	private String itemId;
	private String bioNum;
	private Integer isdoctor;
	private Timestamp istime;
	private Integer isu;
	private Long csId;
	private String rename;
	private String isdoctorName;

	// Constructors

	/** default constructor */
	public CzshbioIsre() {
	}

	/** minimal constructor */
	public CzshbioIsre(String itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public CzshbioIsre(String itemId, String bioNum, Integer isdoctor,
			Timestamp istime, Integer isu, Long csId, String rename,
			String isdoctorName) {
		this.itemId = itemId;
		this.bioNum = bioNum;
		this.isdoctor = isdoctor;
		this.istime = istime;
		this.isu = isu;
		this.csId = csId;
		this.rename = rename;
		this.isdoctorName = isdoctorName;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getBioNum() {
		return this.bioNum;
	}

	public void setBioNum(String bioNum) {
		this.bioNum = bioNum;
	}

	public Integer getIsdoctor() {
		return this.isdoctor;
	}

	public void setIsdoctor(Integer isdoctor) {
		this.isdoctor = isdoctor;
	}

	public Timestamp getIstime() {
		return this.istime;
	}

	public void setIstime(Timestamp istime) {
		this.istime = istime;
	}

	public Integer getIsu() {
		return this.isu;
	}

	public void setIsu(Integer isu) {
		this.isu = isu;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getRename() {
		return this.rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getIsdoctorName() {
		return this.isdoctorName;
	}

	public void setIsdoctorName(String isdoctorName) {
		this.isdoctorName = isdoctorName;
	}

}