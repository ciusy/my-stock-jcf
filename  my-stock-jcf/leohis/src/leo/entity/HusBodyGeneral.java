package leo.entity;

import java.sql.Timestamp;

/**
 * HusBodyGeneral entity. @author MyEclipse Persistence Tools
 */

public class HusBodyGeneral implements java.io.Serializable {

	// Fields

	private String recordId;
	private String height;
	private String weight;
	private Double weightIndex;
	private Integer heartRate;
	private Integer bloodPressureHigh;
	private Integer bloodPressureLow;
	private String mentalState;
	private String mentalStateDescription;
	private String intelligence;
	private String intelligenceDegree;
	private String facial;
	private String facialAbnormal;
	private String specialPosture;
	private String spabnormal;
	private String faceSpecial;
	private String fpabnormal;
	private String skin;
	private String skinAbnormal;
	private String thyroid;
	private String thyroidAbnormal;
	private String lung;
	private String lungAbnormal;
	private String heartRhythm;
	private String hrabnormal;
	private String heartNoise;
	private String hndegree;
	private String liver;
	private String liverTouch;
	private String limbs;
	private String limbsAbnormal;
	private String other;
	private Timestamp date;
	private String doctor;
	private Integer medicalInstId;
	private Long stuffId;
	private Boolean isNormal;

	// Constructors

	/** default constructor */
	public HusBodyGeneral() {
	}

	/** minimal constructor */
	public HusBodyGeneral(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusBodyGeneral(String recordId, String height, String weight,
			Double weightIndex, Integer heartRate, Integer bloodPressureHigh,
			Integer bloodPressureLow, String mentalState,
			String mentalStateDescription, String intelligence,
			String intelligenceDegree, String facial, String facialAbnormal,
			String specialPosture, String spabnormal, String faceSpecial,
			String fpabnormal, String skin, String skinAbnormal,
			String thyroid, String thyroidAbnormal, String lung,
			String lungAbnormal, String heartRhythm, String hrabnormal,
			String heartNoise, String hndegree, String liver,
			String liverTouch, String limbs, String limbsAbnormal,
			String other, Timestamp date, String doctor, Integer medicalInstId,
			Long stuffId, Boolean isNormal) {
		this.recordId = recordId;
		this.height = height;
		this.weight = weight;
		this.weightIndex = weightIndex;
		this.heartRate = heartRate;
		this.bloodPressureHigh = bloodPressureHigh;
		this.bloodPressureLow = bloodPressureLow;
		this.mentalState = mentalState;
		this.mentalStateDescription = mentalStateDescription;
		this.intelligence = intelligence;
		this.intelligenceDegree = intelligenceDegree;
		this.facial = facial;
		this.facialAbnormal = facialAbnormal;
		this.specialPosture = specialPosture;
		this.spabnormal = spabnormal;
		this.faceSpecial = faceSpecial;
		this.fpabnormal = fpabnormal;
		this.skin = skin;
		this.skinAbnormal = skinAbnormal;
		this.thyroid = thyroid;
		this.thyroidAbnormal = thyroidAbnormal;
		this.lung = lung;
		this.lungAbnormal = lungAbnormal;
		this.heartRhythm = heartRhythm;
		this.hrabnormal = hrabnormal;
		this.heartNoise = heartNoise;
		this.hndegree = hndegree;
		this.liver = liver;
		this.liverTouch = liverTouch;
		this.limbs = limbs;
		this.limbsAbnormal = limbsAbnormal;
		this.other = other;
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

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Double getWeightIndex() {
		return this.weightIndex;
	}

	public void setWeightIndex(Double weightIndex) {
		this.weightIndex = weightIndex;
	}

	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	public Integer getBloodPressureHigh() {
		return this.bloodPressureHigh;
	}

	public void setBloodPressureHigh(Integer bloodPressureHigh) {
		this.bloodPressureHigh = bloodPressureHigh;
	}

	public Integer getBloodPressureLow() {
		return this.bloodPressureLow;
	}

	public void setBloodPressureLow(Integer bloodPressureLow) {
		this.bloodPressureLow = bloodPressureLow;
	}

	public String getMentalState() {
		return this.mentalState;
	}

	public void setMentalState(String mentalState) {
		this.mentalState = mentalState;
	}

	public String getMentalStateDescription() {
		return this.mentalStateDescription;
	}

	public void setMentalStateDescription(String mentalStateDescription) {
		this.mentalStateDescription = mentalStateDescription;
	}

	public String getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	public String getIntelligenceDegree() {
		return this.intelligenceDegree;
	}

	public void setIntelligenceDegree(String intelligenceDegree) {
		this.intelligenceDegree = intelligenceDegree;
	}

	public String getFacial() {
		return this.facial;
	}

	public void setFacial(String facial) {
		this.facial = facial;
	}

	public String getFacialAbnormal() {
		return this.facialAbnormal;
	}

	public void setFacialAbnormal(String facialAbnormal) {
		this.facialAbnormal = facialAbnormal;
	}

	public String getSpecialPosture() {
		return this.specialPosture;
	}

	public void setSpecialPosture(String specialPosture) {
		this.specialPosture = specialPosture;
	}

	public String getSpabnormal() {
		return this.spabnormal;
	}

	public void setSpabnormal(String spabnormal) {
		this.spabnormal = spabnormal;
	}

	public String getFaceSpecial() {
		return this.faceSpecial;
	}

	public void setFaceSpecial(String faceSpecial) {
		this.faceSpecial = faceSpecial;
	}

	public String getFpabnormal() {
		return this.fpabnormal;
	}

	public void setFpabnormal(String fpabnormal) {
		this.fpabnormal = fpabnormal;
	}

	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getSkinAbnormal() {
		return this.skinAbnormal;
	}

	public void setSkinAbnormal(String skinAbnormal) {
		this.skinAbnormal = skinAbnormal;
	}

	public String getThyroid() {
		return this.thyroid;
	}

	public void setThyroid(String thyroid) {
		this.thyroid = thyroid;
	}

	public String getThyroidAbnormal() {
		return this.thyroidAbnormal;
	}

	public void setThyroidAbnormal(String thyroidAbnormal) {
		this.thyroidAbnormal = thyroidAbnormal;
	}

	public String getLung() {
		return this.lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}

	public String getLungAbnormal() {
		return this.lungAbnormal;
	}

	public void setLungAbnormal(String lungAbnormal) {
		this.lungAbnormal = lungAbnormal;
	}

	public String getHeartRhythm() {
		return this.heartRhythm;
	}

	public void setHeartRhythm(String heartRhythm) {
		this.heartRhythm = heartRhythm;
	}

	public String getHrabnormal() {
		return this.hrabnormal;
	}

	public void setHrabnormal(String hrabnormal) {
		this.hrabnormal = hrabnormal;
	}

	public String getHeartNoise() {
		return this.heartNoise;
	}

	public void setHeartNoise(String heartNoise) {
		this.heartNoise = heartNoise;
	}

	public String getHndegree() {
		return this.hndegree;
	}

	public void setHndegree(String hndegree) {
		this.hndegree = hndegree;
	}

	public String getLiver() {
		return this.liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getLiverTouch() {
		return this.liverTouch;
	}

	public void setLiverTouch(String liverTouch) {
		this.liverTouch = liverTouch;
	}

	public String getLimbs() {
		return this.limbs;
	}

	public void setLimbs(String limbs) {
		this.limbs = limbs;
	}

	public String getLimbsAbnormal() {
		return this.limbsAbnormal;
	}

	public void setLimbsAbnormal(String limbsAbnormal) {
		this.limbsAbnormal = limbsAbnormal;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
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