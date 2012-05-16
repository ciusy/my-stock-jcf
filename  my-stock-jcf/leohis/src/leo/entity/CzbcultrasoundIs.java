package leo.entity;

import java.sql.Timestamp;

/**
 * CzbcultrasoundIs entity. @author MyEclipse Persistence Tools
 */

public class CzbcultrasoundIs implements java.io.Serializable {

	// Fields

	private String reid;
	private String itemId;
	private String rename;
	private Long csId;
	private String bdnDescribe;
	private String bdnVerdict;
	private Timestamp istime;
	private Integer isdoctor;
	private Integer isu;
	private String alterId;
	private String ischeck;
	private String bc;

	// Constructors

	/** default constructor */
	public CzbcultrasoundIs() {
	}

	/** minimal constructor */
	public CzbcultrasoundIs(String reid) {
		this.reid = reid;
	}

	/** full constructor */
	public CzbcultrasoundIs(String reid, String itemId, String rename,
			Long csId, String bdnDescribe, String bdnVerdict, Timestamp istime,
			Integer isdoctor, Integer isu, String alterId, String ischeck,
			String bc) {
		this.reid = reid;
		this.itemId = itemId;
		this.rename = rename;
		this.csId = csId;
		this.bdnDescribe = bdnDescribe;
		this.bdnVerdict = bdnVerdict;
		this.istime = istime;
		this.isdoctor = isdoctor;
		this.isu = isu;
		this.alterId = alterId;
		this.ischeck = ischeck;
		this.bc = bc;
	}

	// Property accessors

	public String getReid() {
		return this.reid;
	}

	public void setReid(String reid) {
		this.reid = reid;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getRename() {
		return this.rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getBdnDescribe() {
		return this.bdnDescribe;
	}

	public void setBdnDescribe(String bdnDescribe) {
		this.bdnDescribe = bdnDescribe;
	}

	public String getBdnVerdict() {
		return this.bdnVerdict;
	}

	public void setBdnVerdict(String bdnVerdict) {
		this.bdnVerdict = bdnVerdict;
	}

	public Timestamp getIstime() {
		return this.istime;
	}

	public void setIstime(Timestamp istime) {
		this.istime = istime;
	}

	public Integer getIsdoctor() {
		return this.isdoctor;
	}

	public void setIsdoctor(Integer isdoctor) {
		this.isdoctor = isdoctor;
	}

	public Integer getIsu() {
		return this.isu;
	}

	public void setIsu(Integer isu) {
		this.isu = isu;
	}

	public String getAlterId() {
		return this.alterId;
	}

	public void setAlterId(String alterId) {
		this.alterId = alterId;
	}

	public String getIscheck() {
		return this.ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

	public String getBc() {
		return this.bc;
	}

	public void setBc(String bc) {
		this.bc = bc;
	}

}