package leo.entity;

import java.sql.Timestamp;

/**
 * WifeBodyDoc entity. @author MyEclipse Persistence Tools
 */

public class WifeBodyDoc implements java.io.Serializable {

	// Fields

	private String recordId;
	private String pubicHair;
	private String pubicHairAbnormal;
	private String breast;
	private String breastAbnormal;
	private String vulva;
	private String vulvaAbnormal;
	private String vagina;
	private String vaginaAbnormal;
	private String secretion;
	private String secretionAbnormal;
	private String cervix;
	private String cervixAbnormal;
	private String wombBigSmall;
	private String wombExercise;
	private String wombEm;
	private String wombEmabnormal;
	private String wombAccessory;
	private String wombAbnormal;
	private Timestamp date;
	private String doctor;
	private Integer medicalInstId;
	private Long stuffId;
	private Boolean isNormal;

	// Constructors

	/** default constructor */
	public WifeBodyDoc() {
	}

	/** minimal constructor */
	public WifeBodyDoc(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public WifeBodyDoc(String recordId, String pubicHair,
			String pubicHairAbnormal, String breast, String breastAbnormal,
			String vulva, String vulvaAbnormal, String vagina,
			String vaginaAbnormal, String secretion, String secretionAbnormal,
			String cervix, String cervixAbnormal, String wombBigSmall,
			String wombExercise, String wombEm, String wombEmabnormal,
			String wombAccessory, String wombAbnormal, Timestamp date,
			String doctor, Integer medicalInstId, Long stuffId, Boolean isNormal) {
		this.recordId = recordId;
		this.pubicHair = pubicHair;
		this.pubicHairAbnormal = pubicHairAbnormal;
		this.breast = breast;
		this.breastAbnormal = breastAbnormal;
		this.vulva = vulva;
		this.vulvaAbnormal = vulvaAbnormal;
		this.vagina = vagina;
		this.vaginaAbnormal = vaginaAbnormal;
		this.secretion = secretion;
		this.secretionAbnormal = secretionAbnormal;
		this.cervix = cervix;
		this.cervixAbnormal = cervixAbnormal;
		this.wombBigSmall = wombBigSmall;
		this.wombExercise = wombExercise;
		this.wombEm = wombEm;
		this.wombEmabnormal = wombEmabnormal;
		this.wombAccessory = wombAccessory;
		this.wombAbnormal = wombAbnormal;
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

	public String getBreast() {
		return this.breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}

	public String getBreastAbnormal() {
		return this.breastAbnormal;
	}

	public void setBreastAbnormal(String breastAbnormal) {
		this.breastAbnormal = breastAbnormal;
	}

	public String getVulva() {
		return this.vulva;
	}

	public void setVulva(String vulva) {
		this.vulva = vulva;
	}

	public String getVulvaAbnormal() {
		return this.vulvaAbnormal;
	}

	public void setVulvaAbnormal(String vulvaAbnormal) {
		this.vulvaAbnormal = vulvaAbnormal;
	}

	public String getVagina() {
		return this.vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}

	public String getVaginaAbnormal() {
		return this.vaginaAbnormal;
	}

	public void setVaginaAbnormal(String vaginaAbnormal) {
		this.vaginaAbnormal = vaginaAbnormal;
	}

	public String getSecretion() {
		return this.secretion;
	}

	public void setSecretion(String secretion) {
		this.secretion = secretion;
	}

	public String getSecretionAbnormal() {
		return this.secretionAbnormal;
	}

	public void setSecretionAbnormal(String secretionAbnormal) {
		this.secretionAbnormal = secretionAbnormal;
	}

	public String getCervix() {
		return this.cervix;
	}

	public void setCervix(String cervix) {
		this.cervix = cervix;
	}

	public String getCervixAbnormal() {
		return this.cervixAbnormal;
	}

	public void setCervixAbnormal(String cervixAbnormal) {
		this.cervixAbnormal = cervixAbnormal;
	}

	public String getWombBigSmall() {
		return this.wombBigSmall;
	}

	public void setWombBigSmall(String wombBigSmall) {
		this.wombBigSmall = wombBigSmall;
	}

	public String getWombExercise() {
		return this.wombExercise;
	}

	public void setWombExercise(String wombExercise) {
		this.wombExercise = wombExercise;
	}

	public String getWombEm() {
		return this.wombEm;
	}

	public void setWombEm(String wombEm) {
		this.wombEm = wombEm;
	}

	public String getWombEmabnormal() {
		return this.wombEmabnormal;
	}

	public void setWombEmabnormal(String wombEmabnormal) {
		this.wombEmabnormal = wombEmabnormal;
	}

	public String getWombAccessory() {
		return this.wombAccessory;
	}

	public void setWombAccessory(String wombAccessory) {
		this.wombAccessory = wombAccessory;
	}

	public String getWombAbnormal() {
		return this.wombAbnormal;
	}

	public void setWombAbnormal(String wombAbnormal) {
		this.wombAbnormal = wombAbnormal;
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