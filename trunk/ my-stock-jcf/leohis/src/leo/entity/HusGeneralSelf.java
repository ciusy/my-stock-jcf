package leo.entity;

/**
 * HusGeneralSelf entity. @author MyEclipse Persistence Tools
 */

public class HusGeneralSelf implements java.io.Serializable {

	// Fields

	private String recordId;
	private Boolean disease;
	private String diseasesNameS;
	private Boolean birthDefect;
	private String birthDefectName;
	private Boolean mdisease;
	private String mdiseaseOther;
	private Boolean takeMedicine;
	private String drugNames;
	private Boolean vaccinate;
	private String vaccinateOther;
	private Boolean familyMarriage;
	private String fgenetic;
	private String familyDiseasez;
	private String birthDefectOther;
	private String relation;
	private Boolean raptatorial;
	private Boolean vegetables;
	private Boolean rawMeat;
	private String smokeType;
	private Boolean smoke;
	private Integer dayNum;
	private Boolean passiveSmoke;
	private String smokeTime;
	private String drinkingType;
	private Boolean drink;
	private String drinkNum;
	private Boolean drug;
	private String drugName;
	private Boolean contact;
	private String contactFactors;
	private String contactOther;

	// Constructors

	/** default constructor */
	public HusGeneralSelf() {
	}

	/** minimal constructor */
	public HusGeneralSelf(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusGeneralSelf(String recordId, Boolean disease,
			String diseasesNameS, Boolean birthDefect, String birthDefectName,
			Boolean mdisease, String mdiseaseOther, Boolean takeMedicine,
			String drugNames, Boolean vaccinate, String vaccinateOther,
			Boolean familyMarriage, String fgenetic, String familyDiseasez,
			String birthDefectOther, String relation, Boolean raptatorial,
			Boolean vegetables, Boolean rawMeat, String smokeType,
			Boolean smoke, Integer dayNum, Boolean passiveSmoke,
			String smokeTime, String drinkingType, Boolean drink,
			String drinkNum, Boolean drug, String drugName, Boolean contact,
			String contactFactors, String contactOther) {
		this.recordId = recordId;
		this.disease = disease;
		this.diseasesNameS = diseasesNameS;
		this.birthDefect = birthDefect;
		this.birthDefectName = birthDefectName;
		this.mdisease = mdisease;
		this.mdiseaseOther = mdiseaseOther;
		this.takeMedicine = takeMedicine;
		this.drugNames = drugNames;
		this.vaccinate = vaccinate;
		this.vaccinateOther = vaccinateOther;
		this.familyMarriage = familyMarriage;
		this.fgenetic = fgenetic;
		this.familyDiseasez = familyDiseasez;
		this.birthDefectOther = birthDefectOther;
		this.relation = relation;
		this.raptatorial = raptatorial;
		this.vegetables = vegetables;
		this.rawMeat = rawMeat;
		this.smokeType = smokeType;
		this.smoke = smoke;
		this.dayNum = dayNum;
		this.passiveSmoke = passiveSmoke;
		this.smokeTime = smokeTime;
		this.drinkingType = drinkingType;
		this.drink = drink;
		this.drinkNum = drinkNum;
		this.drug = drug;
		this.drugName = drugName;
		this.contact = contact;
		this.contactFactors = contactFactors;
		this.contactOther = contactOther;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public Boolean getDisease() {
		return this.disease;
	}

	public void setDisease(Boolean disease) {
		this.disease = disease;
	}

	public String getDiseasesNameS() {
		return this.diseasesNameS;
	}

	public void setDiseasesNameS(String diseasesNameS) {
		this.diseasesNameS = diseasesNameS;
	}

	public Boolean getBirthDefect() {
		return this.birthDefect;
	}

	public void setBirthDefect(Boolean birthDefect) {
		this.birthDefect = birthDefect;
	}

	public String getBirthDefectName() {
		return this.birthDefectName;
	}

	public void setBirthDefectName(String birthDefectName) {
		this.birthDefectName = birthDefectName;
	}

	public Boolean getMdisease() {
		return this.mdisease;
	}

	public void setMdisease(Boolean mdisease) {
		this.mdisease = mdisease;
	}

	public String getMdiseaseOther() {
		return this.mdiseaseOther;
	}

	public void setMdiseaseOther(String mdiseaseOther) {
		this.mdiseaseOther = mdiseaseOther;
	}

	public Boolean getTakeMedicine() {
		return this.takeMedicine;
	}

	public void setTakeMedicine(Boolean takeMedicine) {
		this.takeMedicine = takeMedicine;
	}

	public String getDrugNames() {
		return this.drugNames;
	}

	public void setDrugNames(String drugNames) {
		this.drugNames = drugNames;
	}

	public Boolean getVaccinate() {
		return this.vaccinate;
	}

	public void setVaccinate(Boolean vaccinate) {
		this.vaccinate = vaccinate;
	}

	public String getVaccinateOther() {
		return this.vaccinateOther;
	}

	public void setVaccinateOther(String vaccinateOther) {
		this.vaccinateOther = vaccinateOther;
	}

	public Boolean getFamilyMarriage() {
		return this.familyMarriage;
	}

	public void setFamilyMarriage(Boolean familyMarriage) {
		this.familyMarriage = familyMarriage;
	}

	public String getFgenetic() {
		return this.fgenetic;
	}

	public void setFgenetic(String fgenetic) {
		this.fgenetic = fgenetic;
	}

	public String getFamilyDiseasez() {
		return this.familyDiseasez;
	}

	public void setFamilyDiseasez(String familyDiseasez) {
		this.familyDiseasez = familyDiseasez;
	}

	public String getBirthDefectOther() {
		return this.birthDefectOther;
	}

	public void setBirthDefectOther(String birthDefectOther) {
		this.birthDefectOther = birthDefectOther;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Boolean getRaptatorial() {
		return this.raptatorial;
	}

	public void setRaptatorial(Boolean raptatorial) {
		this.raptatorial = raptatorial;
	}

	public Boolean getVegetables() {
		return this.vegetables;
	}

	public void setVegetables(Boolean vegetables) {
		this.vegetables = vegetables;
	}

	public Boolean getRawMeat() {
		return this.rawMeat;
	}

	public void setRawMeat(Boolean rawMeat) {
		this.rawMeat = rawMeat;
	}

	public String getSmokeType() {
		return this.smokeType;
	}

	public void setSmokeType(String smokeType) {
		this.smokeType = smokeType;
	}

	public Boolean getSmoke() {
		return this.smoke;
	}

	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}

	public Integer getDayNum() {
		return this.dayNum;
	}

	public void setDayNum(Integer dayNum) {
		this.dayNum = dayNum;
	}

	public Boolean getPassiveSmoke() {
		return this.passiveSmoke;
	}

	public void setPassiveSmoke(Boolean passiveSmoke) {
		this.passiveSmoke = passiveSmoke;
	}

	public String getSmokeTime() {
		return this.smokeTime;
	}

	public void setSmokeTime(String smokeTime) {
		this.smokeTime = smokeTime;
	}

	public String getDrinkingType() {
		return this.drinkingType;
	}

	public void setDrinkingType(String drinkingType) {
		this.drinkingType = drinkingType;
	}

	public Boolean getDrink() {
		return this.drink;
	}

	public void setDrink(Boolean drink) {
		this.drink = drink;
	}

	public String getDrinkNum() {
		return this.drinkNum;
	}

	public void setDrinkNum(String drinkNum) {
		this.drinkNum = drinkNum;
	}

	public Boolean getDrug() {
		return this.drug;
	}

	public void setDrug(Boolean drug) {
		this.drug = drug;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public Boolean getContact() {
		return this.contact;
	}

	public void setContact(Boolean contact) {
		this.contact = contact;
	}

	public String getContactFactors() {
		return this.contactFactors;
	}

	public void setContactFactors(String contactFactors) {
		this.contactFactors = contactFactors;
	}

	public String getContactOther() {
		return this.contactOther;
	}

	public void setContactOther(String contactOther) {
		this.contactOther = contactOther;
	}

}