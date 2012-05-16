package leo.entity;

import java.sql.Timestamp;

/**
 * BirthDefects entity. @author MyEclipse Persistence Tools
 */

public class BirthDefects implements java.io.Serializable {

	// Fields

	private String recordId;
	private String fatherName;
	private Integer fatherAge;
	private String fatherNational;
	private String fatherIdcardNum;
	private String motherName;
	private Integer motherAge;
	private String motherNational;
	private String motherIdcardNum;
	private Integer pregnantNum;
	private Integer productionNum;
	private String oftenAddress;
	private String address;
	private String zipCode;
	private String telephone;
	private String birthday;
	private String sex;
	private Integer pregnantWeeks;
	private Integer pregnantWeight;
	private String fetalNum;
	private String turn;
	private String diagnosis;
	private String deformityTime;
	private String defects;
	private String defectsOther;
	private String sick;
	private String hepatitis;
	private String medication;
	private String medicationName1;
	private String grade;
	private String harmfulDetails1;
	private String harmful;
	private String gradeOther;
	private String information;
	private String harmfulDetails2;
	private String harmfulDetails3;
	private String harmfulDetails4;
	private String unit;
	private Timestamp date;
	private String medicationName2;
	private String medicationName3;
	private String medicationName4;
	private Long stuffId;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public BirthDefects() {
	}

	/** minimal constructor */
	public BirthDefects(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public BirthDefects(String recordId, String fatherName, Integer fatherAge,
			String fatherNational, String fatherIdcardNum, String motherName,
			Integer motherAge, String motherNational, String motherIdcardNum,
			Integer pregnantNum, Integer productionNum, String oftenAddress,
			String address, String zipCode, String telephone, String birthday,
			String sex, Integer pregnantWeeks, Integer pregnantWeight,
			String fetalNum, String turn, String diagnosis,
			String deformityTime, String defects, String defectsOther,
			String sick, String hepatitis, String medication,
			String medicationName1, String grade, String harmfulDetails1,
			String harmful, String gradeOther, String information,
			String harmfulDetails2, String harmfulDetails3,
			String harmfulDetails4, String unit, Timestamp date,
			String medicationName2, String medicationName3,
			String medicationName4, Long stuffId, Integer medicalInstId) {
		this.recordId = recordId;
		this.fatherName = fatherName;
		this.fatherAge = fatherAge;
		this.fatherNational = fatherNational;
		this.fatherIdcardNum = fatherIdcardNum;
		this.motherName = motherName;
		this.motherAge = motherAge;
		this.motherNational = motherNational;
		this.motherIdcardNum = motherIdcardNum;
		this.pregnantNum = pregnantNum;
		this.productionNum = productionNum;
		this.oftenAddress = oftenAddress;
		this.address = address;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.pregnantWeeks = pregnantWeeks;
		this.pregnantWeight = pregnantWeight;
		this.fetalNum = fetalNum;
		this.turn = turn;
		this.diagnosis = diagnosis;
		this.deformityTime = deformityTime;
		this.defects = defects;
		this.defectsOther = defectsOther;
		this.sick = sick;
		this.hepatitis = hepatitis;
		this.medication = medication;
		this.medicationName1 = medicationName1;
		this.grade = grade;
		this.harmfulDetails1 = harmfulDetails1;
		this.harmful = harmful;
		this.gradeOther = gradeOther;
		this.information = information;
		this.harmfulDetails2 = harmfulDetails2;
		this.harmfulDetails3 = harmfulDetails3;
		this.harmfulDetails4 = harmfulDetails4;
		this.unit = unit;
		this.date = date;
		this.medicationName2 = medicationName2;
		this.medicationName3 = medicationName3;
		this.medicationName4 = medicationName4;
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

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getFatherAge() {
		return this.fatherAge;
	}

	public void setFatherAge(Integer fatherAge) {
		this.fatherAge = fatherAge;
	}

	public String getFatherNational() {
		return this.fatherNational;
	}

	public void setFatherNational(String fatherNational) {
		this.fatherNational = fatherNational;
	}

	public String getFatherIdcardNum() {
		return this.fatherIdcardNum;
	}

	public void setFatherIdcardNum(String fatherIdcardNum) {
		this.fatherIdcardNum = fatherIdcardNum;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Integer getMotherAge() {
		return this.motherAge;
	}

	public void setMotherAge(Integer motherAge) {
		this.motherAge = motherAge;
	}

	public String getMotherNational() {
		return this.motherNational;
	}

	public void setMotherNational(String motherNational) {
		this.motherNational = motherNational;
	}

	public String getMotherIdcardNum() {
		return this.motherIdcardNum;
	}

	public void setMotherIdcardNum(String motherIdcardNum) {
		this.motherIdcardNum = motherIdcardNum;
	}

	public Integer getPregnantNum() {
		return this.pregnantNum;
	}

	public void setPregnantNum(Integer pregnantNum) {
		this.pregnantNum = pregnantNum;
	}

	public Integer getProductionNum() {
		return this.productionNum;
	}

	public void setProductionNum(Integer productionNum) {
		this.productionNum = productionNum;
	}

	public String getOftenAddress() {
		return this.oftenAddress;
	}

	public void setOftenAddress(String oftenAddress) {
		this.oftenAddress = oftenAddress;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPregnantWeeks() {
		return this.pregnantWeeks;
	}

	public void setPregnantWeeks(Integer pregnantWeeks) {
		this.pregnantWeeks = pregnantWeeks;
	}

	public Integer getPregnantWeight() {
		return this.pregnantWeight;
	}

	public void setPregnantWeight(Integer pregnantWeight) {
		this.pregnantWeight = pregnantWeight;
	}

	public String getFetalNum() {
		return this.fetalNum;
	}

	public void setFetalNum(String fetalNum) {
		this.fetalNum = fetalNum;
	}

	public String getTurn() {
		return this.turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDeformityTime() {
		return this.deformityTime;
	}

	public void setDeformityTime(String deformityTime) {
		this.deformityTime = deformityTime;
	}

	public String getDefects() {
		return this.defects;
	}

	public void setDefects(String defects) {
		this.defects = defects;
	}

	public String getDefectsOther() {
		return this.defectsOther;
	}

	public void setDefectsOther(String defectsOther) {
		this.defectsOther = defectsOther;
	}

	public String getSick() {
		return this.sick;
	}

	public void setSick(String sick) {
		this.sick = sick;
	}

	public String getHepatitis() {
		return this.hepatitis;
	}

	public void setHepatitis(String hepatitis) {
		this.hepatitis = hepatitis;
	}

	public String getMedication() {
		return this.medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getMedicationName1() {
		return this.medicationName1;
	}

	public void setMedicationName1(String medicationName1) {
		this.medicationName1 = medicationName1;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getHarmfulDetails1() {
		return this.harmfulDetails1;
	}

	public void setHarmfulDetails1(String harmfulDetails1) {
		this.harmfulDetails1 = harmfulDetails1;
	}

	public String getHarmful() {
		return this.harmful;
	}

	public void setHarmful(String harmful) {
		this.harmful = harmful;
	}

	public String getGradeOther() {
		return this.gradeOther;
	}

	public void setGradeOther(String gradeOther) {
		this.gradeOther = gradeOther;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getHarmfulDetails2() {
		return this.harmfulDetails2;
	}

	public void setHarmfulDetails2(String harmfulDetails2) {
		this.harmfulDetails2 = harmfulDetails2;
	}

	public String getHarmfulDetails3() {
		return this.harmfulDetails3;
	}

	public void setHarmfulDetails3(String harmfulDetails3) {
		this.harmfulDetails3 = harmfulDetails3;
	}

	public String getHarmfulDetails4() {
		return this.harmfulDetails4;
	}

	public void setHarmfulDetails4(String harmfulDetails4) {
		this.harmfulDetails4 = harmfulDetails4;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getMedicationName2() {
		return this.medicationName2;
	}

	public void setMedicationName2(String medicationName2) {
		this.medicationName2 = medicationName2;
	}

	public String getMedicationName3() {
		return this.medicationName3;
	}

	public void setMedicationName3(String medicationName3) {
		this.medicationName3 = medicationName3;
	}

	public String getMedicationName4() {
		return this.medicationName4;
	}

	public void setMedicationName4(String medicationName4) {
		this.medicationName4 = medicationName4;
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