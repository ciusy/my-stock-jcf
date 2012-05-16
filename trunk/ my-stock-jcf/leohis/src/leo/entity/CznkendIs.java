package leo.entity;

import java.sql.Timestamp;

/**
 * CznkendIs entity. @author MyEclipse Persistence Tools
 */

public class CznkendIs implements java.io.Serializable {

	// Fields

	private String itemId;
	private String rename;
	private Long csId;
	private String endDnDescribe;
	private String endDnVerdict;
	private Timestamp istime;
	private Integer isdoctor;
	private Integer isu;
	private Long alterId;
	private String retype;

	// Constructors

	/** default constructor */
	public CznkendIs() {
	}

	/** minimal constructor */
	public CznkendIs(String itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public CznkendIs(String itemId, String rename, Long csId,
			String endDnDescribe, String endDnVerdict, Timestamp istime,
			Integer isdoctor, Integer isu, Long alterId, String retype) {
		this.itemId = itemId;
		this.rename = rename;
		this.csId = csId;
		this.endDnDescribe = endDnDescribe;
		this.endDnVerdict = endDnVerdict;
		this.istime = istime;
		this.isdoctor = isdoctor;
		this.isu = isu;
		this.alterId = alterId;
		this.retype = retype;
	}

	// Property accessors

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

	public String getEndDnDescribe() {
		return this.endDnDescribe;
	}

	public void setEndDnDescribe(String endDnDescribe) {
		this.endDnDescribe = endDnDescribe;
	}

	public String getEndDnVerdict() {
		return this.endDnVerdict;
	}

	public void setEndDnVerdict(String endDnVerdict) {
		this.endDnVerdict = endDnVerdict;
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

	public Long getAlterId() {
		return this.alterId;
	}

	public void setAlterId(Long alterId) {
		this.alterId = alterId;
	}

	public String getRetype() {
		return this.retype;
	}

	public void setRetype(String retype) {
		this.retype = retype;
	}

}