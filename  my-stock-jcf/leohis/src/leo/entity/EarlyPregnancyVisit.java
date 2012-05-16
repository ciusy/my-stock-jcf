package leo.entity;

import java.sql.Timestamp;

/**
 * EarlyPregnancyVisit entity. @author MyEclipse Persistence Tools
 */

public class EarlyPregnancyVisit implements java.io.Serializable {

	// Fields

	private String recordId;
	private String csname;
	private Integer age;
	private String telephone;
	private String fprovince;
	private String fprefecture;
	private String ftown;
	private String fvillage;
	private String vprovince;
	private String vprefecture;
	private String medicalInst;
	private String menstrualdate;
	private String menstrualAccurate;
	private String folicacid;
	private String takingMethod;
	private String meatEggs;
	private String vegetables;
	private String wquitSmoking;
	private String mquitSmoking;
	private String mdrinking;
	private String harmful;
	private String harmfulOther;
	private String disease;
	private String diseaseOther;
	private String drug;
	private String drugName;
	private String institutions;
	private String otherInstitutionsName;
	private String otherSituation;
	private String pregnancy;
	private String bultrasonic;
	private String bdescription;
	private String evaluation;
	private Timestamp date;
	private String personnel;
	private Long stuffId;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public EarlyPregnancyVisit() {
	}

	/** minimal constructor */
	public EarlyPregnancyVisit(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public EarlyPregnancyVisit(String recordId, String csname, Integer age,
			String telephone, String fprovince, String fprefecture,
			String ftown, String fvillage, String vprovince,
			String vprefecture, String medicalInst, String menstrualdate,
			String menstrualAccurate, String folicacid, String takingMethod,
			String meatEggs, String vegetables, String wquitSmoking,
			String mquitSmoking, String mdrinking, String harmful,
			String harmfulOther, String disease, String diseaseOther,
			String drug, String drugName, String institutions,
			String otherInstitutionsName, String otherSituation,
			String pregnancy, String bultrasonic, String bdescription,
			String evaluation, Timestamp date, String personnel, Long stuffId,
			Integer medicalInstId) {
		this.recordId = recordId;
		this.csname = csname;
		this.age = age;
		this.telephone = telephone;
		this.fprovince = fprovince;
		this.fprefecture = fprefecture;
		this.ftown = ftown;
		this.fvillage = fvillage;
		this.vprovince = vprovince;
		this.vprefecture = vprefecture;
		this.medicalInst = medicalInst;
		this.menstrualdate = menstrualdate;
		this.menstrualAccurate = menstrualAccurate;
		this.folicacid = folicacid;
		this.takingMethod = takingMethod;
		this.meatEggs = meatEggs;
		this.vegetables = vegetables;
		this.wquitSmoking = wquitSmoking;
		this.mquitSmoking = mquitSmoking;
		this.mdrinking = mdrinking;
		this.harmful = harmful;
		this.harmfulOther = harmfulOther;
		this.disease = disease;
		this.diseaseOther = diseaseOther;
		this.drug = drug;
		this.drugName = drugName;
		this.institutions = institutions;
		this.otherInstitutionsName = otherInstitutionsName;
		this.otherSituation = otherSituation;
		this.pregnancy = pregnancy;
		this.bultrasonic = bultrasonic;
		this.bdescription = bdescription;
		this.evaluation = evaluation;
		this.date = date;
		this.personnel = personnel;
		this.stuffId = stuffId;
		this.medicalInstId = medicalInstId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getCsname() {
		return this.csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFprovince() {
		return this.fprovince;
	}

	public void setFprovince(String fprovince) {
		this.fprovince = fprovince;
	}

	public String getFprefecture() {
		return this.fprefecture;
	}

	public void setFprefecture(String fprefecture) {
		this.fprefecture = fprefecture;
	}

	public String getFtown() {
		return this.ftown;
	}

	public void setFtown(String ftown) {
		this.ftown = ftown;
	}

	public String getFvillage() {
		return this.fvillage;
	}

	public void setFvillage(String fvillage) {
		this.fvillage = fvillage;
	}

	public String getVprovince() {
		return this.vprovince;
	}

	public void setVprovince(String vprovince) {
		this.vprovince = vprovince;
	}

	public String getVprefecture() {
		return this.vprefecture;
	}

	public void setVprefecture(String vprefecture) {
		this.vprefecture = vprefecture;
	}

	public String getMedicalInst() {
		return this.medicalInst;
	}

	public void setMedicalInst(String medicalInst) {
		this.medicalInst = medicalInst;
	}

	public String getMenstrualdate() {
		return this.menstrualdate;
	}

	public void setMenstrualdate(String menstrualdate) {
		this.menstrualdate = menstrualdate;
	}

	public String getMenstrualAccurate() {
		return this.menstrualAccurate;
	}

	public void setMenstrualAccurate(String menstrualAccurate) {
		this.menstrualAccurate = menstrualAccurate;
	}

	public String getFolicacid() {
		return this.folicacid;
	}

	public void setFolicacid(String folicacid) {
		this.folicacid = folicacid;
	}

	public String getTakingMethod() {
		return this.takingMethod;
	}

	public void setTakingMethod(String takingMethod) {
		this.takingMethod = takingMethod;
	}

	public String getMeatEggs() {
		return this.meatEggs;
	}

	public void setMeatEggs(String meatEggs) {
		this.meatEggs = meatEggs;
	}

	public String getVegetables() {
		return this.vegetables;
	}

	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}

	public String getWquitSmoking() {
		return this.wquitSmoking;
	}

	public void setWquitSmoking(String wquitSmoking) {
		this.wquitSmoking = wquitSmoking;
	}

	public String getMquitSmoking() {
		return this.mquitSmoking;
	}

	public void setMquitSmoking(String mquitSmoking) {
		this.mquitSmoking = mquitSmoking;
	}

	public String getMdrinking() {
		return this.mdrinking;
	}

	public void setMdrinking(String mdrinking) {
		this.mdrinking = mdrinking;
	}

	public String getHarmful() {
		return this.harmful;
	}

	public void setHarmful(String harmful) {
		this.harmful = harmful;
	}

	public String getHarmfulOther() {
		return this.harmfulOther;
	}

	public void setHarmfulOther(String harmfulOther) {
		this.harmfulOther = harmfulOther;
	}

	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDiseaseOther() {
		return this.diseaseOther;
	}

	public void setDiseaseOther(String diseaseOther) {
		this.diseaseOther = diseaseOther;
	}

	public String getDrug() {
		return this.drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}

	public String getOtherInstitutionsName() {
		return this.otherInstitutionsName;
	}

	public void setOtherInstitutionsName(String otherInstitutionsName) {
		this.otherInstitutionsName = otherInstitutionsName;
	}

	public String getOtherSituation() {
		return this.otherSituation;
	}

	public void setOtherSituation(String otherSituation) {
		this.otherSituation = otherSituation;
	}

	public String getPregnancy() {
		return this.pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	public String getBultrasonic() {
		return this.bultrasonic;
	}

	public void setBultrasonic(String bultrasonic) {
		this.bultrasonic = bultrasonic;
	}

	public String getBdescription() {
		return this.bdescription;
	}

	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public Long getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

}