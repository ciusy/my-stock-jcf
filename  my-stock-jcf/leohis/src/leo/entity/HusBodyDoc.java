package leo.entity;

import java.sql.Timestamp;

/**
 * HusBodyDoc entity. @author MyEclipse Persistence Tools
 */

public class HusBodyDoc implements java.io.Serializable {

	// Fields

	private String recordId;
	private String pubicHair;
	private String pubicHairAbnormal;
	private String laryngealTuberculosis;
	private String ltabnormal;
	private String penis;
	private String penisAbnormal;
	private String wrapping;
	private String testicular;
	private Integer testicularLeft;
	private Integer testicularRight;
	private String epididymis;
	private String epididymisAbnormal;
	private String vasectomy;
	private String vasectomyAbnormal;
	private String spermatic;
	private String spermaticAbnormal;
	private String spermaticDegree;
	private Timestamp date;
	private String doctor;
	private Integer medicalInstId;
	private Long stuffId;
	private Boolean isNormal;

	// Constructors

	/** default constructor */
	public HusBodyDoc() {
	}

	/** minimal constructor */
	public HusBodyDoc(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusBodyDoc(String recordId, String pubicHair,
			String pubicHairAbnormal, String laryngealTuberculosis,
			String ltabnormal, String penis, String penisAbnormal,
			String wrapping, String testicular, Integer testicularLeft,
			Integer testicularRight, String epididymis,
			String epididymisAbnormal, String vasectomy,
			String vasectomyAbnormal, String spermatic,
			String spermaticAbnormal, String spermaticDegree, Timestamp date,
			String doctor, Integer medicalInstId, Long stuffId, Boolean isNormal) {
		this.recordId = recordId;
		this.pubicHair = pubicHair;
		this.pubicHairAbnormal = pubicHairAbnormal;
		this.laryngealTuberculosis = laryngealTuberculosis;
		this.ltabnormal = ltabnormal;
		this.penis = penis;
		this.penisAbnormal = penisAbnormal;
		this.wrapping = wrapping;
		this.testicular = testicular;
		this.testicularLeft = testicularLeft;
		this.testicularRight = testicularRight;
		this.epididymis = epididymis;
		this.epididymisAbnormal = epididymisAbnormal;
		this.vasectomy = vasectomy;
		this.vasectomyAbnormal = vasectomyAbnormal;
		this.spermatic = spermatic;
		this.spermaticAbnormal = spermaticAbnormal;
		this.spermaticDegree = spermaticDegree;
		this.date = date;
		this.doctor = doctor;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
		this.isNormal = isNormal;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getPubicHair() {
		return this.pubicHair;
	}

	public void setPubicHair(String pubicHair) {
		this.pubicHair = pubicHair;
	}

	public String getPubicHairAbnormal() {
		return this.pubicHairAbnormal;
	}

	public void setPubicHairAbnormal(String pubicHairAbnormal) {
		this.pubicHairAbnormal = pubicHairAbnormal;
	}

	public String getLaryngealTuberculosis() {
		return this.laryngealTuberculosis;
	}

	public void setLaryngealTuberculosis(String laryngealTuberculosis) {
		this.laryngealTuberculosis = laryngealTuberculosis;
	}

	public String getLtabnormal() {
		return this.ltabnormal;
	}

	public void setLtabnormal(String ltabnormal) {
		this.ltabnormal = ltabnormal;
	}

	public String getPenis() {
		return this.penis;
	}

	public void setPenis(String penis) {
		this.penis = penis;
	}

	public String getPenisAbnormal() {
		return this.penisAbnormal;
	}

	public void setPenisAbnormal(String penisAbnormal) {
		this.penisAbnormal = penisAbnormal;
	}

	public String getWrapping() {
		return this.wrapping;
	}

	public void setWrapping(String wrapping) {
		this.wrapping = wrapping;
	}

	public String getTesticular() {
		return this.testicular;
	}

	public void setTesticular(String testicular) {
		this.testicular = testicular;
	}

	public Integer getTesticularLeft() {
		return this.testicularLeft;
	}

	public void setTesticularLeft(Integer testicularLeft) {
		this.testicularLeft = testicularLeft;
	}

	public Integer getTesticularRight() {
		return this.testicularRight;
	}

	public void setTesticularRight(Integer testicularRight) {
		this.testicularRight = testicularRight;
	}

	public String getEpididymis() {
		return this.epididymis;
	}

	public void setEpididymis(String epididymis) {
		this.epididymis = epididymis;
	}

	public String getEpididymisAbnormal() {
		return this.epididymisAbnormal;
	}

	public void setEpididymisAbnormal(String epididymisAbnormal) {
		this.epididymisAbnormal = epididymisAbnormal;
	}

	public String getVasectomy() {
		return this.vasectomy;
	}

	public void setVasectomy(String vasectomy) {
		this.vasectomy = vasectomy;
	}

	public String getVasectomyAbnormal() {
		return this.vasectomyAbnormal;
	}

	public void setVasectomyAbnormal(String vasectomyAbnormal) {
		this.vasectomyAbnormal = vasectomyAbnormal;
	}

	public String getSpermatic() {
		return this.spermatic;
	}

	public void setSpermatic(String spermatic) {
		this.spermatic = spermatic;
	}

	public String getSpermaticAbnormal() {
		return this.spermaticAbnormal;
	}

	public void setSpermaticAbnormal(String spermaticAbnormal) {
		this.spermaticAbnormal = spermaticAbnormal;
	}

	public String getSpermaticDegree() {
		return this.spermaticDegree;
	}

	public void setSpermaticDegree(String spermaticDegree) {
		this.spermaticDegree = spermaticDegree;
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

	public Boolean getIsNormal() {
		return this.isNormal;
	}

	public void setIsNormal(Boolean isNormal) {
		this.isNormal = isNormal;
	}

}