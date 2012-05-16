package leo.entity;

import java.sql.Timestamp;

/**
 * CzcolposcopeIs entity. @author MyEclipse Persistence Tools
 */

public class CzcolposcopeIs implements java.io.Serializable {

	// Fields

	private String reid;
	private String itemId;
	private String rename;
	private Long csId;
	private String cdnDescribe;
	private String cdnVerdict;
	private Timestamp istime;
	private Integer isdoctor;
	private Integer isu;
	private String alterId;
	private String isnum;
	private String ischeck;

	// Constructors

	/** default constructor */
	public CzcolposcopeIs() {
	}

	/** minimal constructor */
	public CzcolposcopeIs(String reid) {
		this.reid = reid;
	}

	/** full constructor */
	public CzcolposcopeIs(String reid, String itemId, String rename, Long csId,
			String cdnDescribe, String cdnVerdict, Timestamp istime,
			Integer isdoctor, Integer isu, String alterId, String isnum,
			String ischeck) {
		this.reid = reid;
		this.itemId = itemId;
		this.rename = rename;
		this.csId = csId;
		this.cdnDescribe = cdnDescribe;
		this.cdnVerdict = cdnVerdict;
		this.istime = istime;
		this.isdoctor = isdoctor;
		this.isu = isu;
		this.alterId = alterId;
		this.isnum = isnum;
		this.ischeck = ischeck;
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

	public String getCdnDescribe() {
		return this.cdnDescribe;
	}

	public void setCdnDescribe(String cdnDescribe) {
		this.cdnDescribe = cdnDescribe;
	}

	public String getCdnVerdict() {
		return this.cdnVerdict;
	}

	public void setCdnVerdict(String cdnVerdict) {
		this.cdnVerdict = cdnVerdict;
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

	public String getIsnum() {
		return this.isnum;
	}

	public void setIsnum(String isnum) {
		this.isnum = isnum;
	}

	public String getIscheck() {
		return this.ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

}