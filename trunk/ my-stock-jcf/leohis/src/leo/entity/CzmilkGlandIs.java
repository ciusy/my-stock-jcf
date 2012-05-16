package leo.entity;

import java.sql.Timestamp;

/**
 * CzmilkGlandIs entity. @author MyEclipse Persistence Tools
 */

public class CzmilkGlandIs implements java.io.Serializable {

	// Fields

	private String reid;
	private String itemId;
	private String rename;
	private Long csId;
	private String mgdnDescribe;
	private String mgdnVerdict;
	private Timestamp istime;
	private Integer isdoctor;
	private Integer isu;
	private String alterId;
	private String isnum;
	private String ischeck;

	// Constructors

	/** default constructor */
	public CzmilkGlandIs() {
	}

	/** minimal constructor */
	public CzmilkGlandIs(String reid) {
		this.reid = reid;
	}

	/** full constructor */
	public CzmilkGlandIs(String reid, String itemId, String rename, Long csId,
			String mgdnDescribe, String mgdnVerdict, Timestamp istime,
			Integer isdoctor, Integer isu, String alterId, String isnum,
			String ischeck) {
		this.reid = reid;
		this.itemId = itemId;
		this.rename = rename;
		this.csId = csId;
		this.mgdnDescribe = mgdnDescribe;
		this.mgdnVerdict = mgdnVerdict;
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

	public String getMgdnDescribe() {
		return this.mgdnDescribe;
	}

	public void setMgdnDescribe(String mgdnDescribe) {
		this.mgdnDescribe = mgdnDescribe;
	}

	public String getMgdnVerdict() {
		return this.mgdnVerdict;
	}

	public void setMgdnVerdict(String mgdnVerdict) {
		this.mgdnVerdict = mgdnVerdict;
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