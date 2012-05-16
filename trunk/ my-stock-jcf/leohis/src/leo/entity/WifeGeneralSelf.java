package leo.entity;

import java.sql.Timestamp;

/**
 * WifeGeneralSelf entity. @author MyEclipse Persistence Tools
 */

public class WifeGeneralSelf implements java.io.Serializable {

	// Fields

	private String recordId;
	private Boolean disease;
	private String diseasesNameS;
	private Boolean birthDefect;
	private String birthDefectName;
	private Boolean wdisease;
	private String wdiseaseOther;
	private Boolean takeMedicine;
	private String drugNames;
	private Boolean vaccinate;
	private String vaccinateOther;
	private String contraceptive;
	private String cother;
	private String ctime;
	private String cblockYear;
	private String cblockMonth;
	private String menarcheAge;
	private Timestamp lmp;
	private Boolean menstrualCycle;
	private Integer periodDays;
	private Integer cycleNumber;
	private Integer mpnum;
	private String dysmenorrhea;
	private Boolean fetation;
	private Integer fetationNum;
	private Integer livebornNum;
	private Integer pretermLabor;
	private Integer termLabor;
	private Boolean hapo;
	private Integer stillbirth;
	private Integer abortion;
	private Integer inducedAbortion;
	private Boolean laborDefect;
	private String diseases;
	private String details;
	private Integer childrenNum;
	private String physicalCondition;
	private String diseaseName;
	private Boolean intermarriage;
	private String diseasezOther;
	private Boolean familyMarriage;
	private String fgenetic;
	private String familyDiseasez;
	private String birthDefectOther;
	private String relation;
	private Boolean raptatorial;
	private Boolean vegetables;
	private Boolean rawMeat;
	private Boolean smoke;
	private String dayNum;
	private Boolean passiveSmoke;
	private String smokeType;
	private String smokeTime;
	private Boolean drink;
	private String drinkingType;
	private String drinkNum;
	private Boolean drug;
	private String drugName;
	private Boolean ozostomia;
	private Boolean bleedingGums;
	private String contactFactors;
	private Boolean contact;
	private String contactOther;

	// Constructors

	/** default constructor */
	public WifeGeneralSelf() {
	}

	/** minimal constructor */
	public WifeGeneralSelf(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public WifeGeneralSelf(String recordId, Boolean disease,
			String diseasesNameS, Boolean birthDefect, String birthDefectName,
			Boolean wdisease, String wdiseaseOther, Boolean takeMedicine,
			String drugNames, Boolean vaccinate, String vaccinateOther,
			String contraceptive, String cother, String ctime,
			String cblockYear, String cblockMonth, String menarcheAge,
			Timestamp lmp, Boolean menstrualCycle, Integer periodDays,
			Integer cycleNumber, Integer mpnum, String dysmenorrhea,
			Boolean fetation, Integer fetationNum, Integer livebornNum,
			Integer pretermLabor, Integer termLabor, Boolean hapo,
			Integer stillbirth, Integer abortion, Integer inducedAbortion,
			Boolean laborDefect, String diseases, String details,
			Integer childrenNum, String physicalCondition, String diseaseName,
			Boolean intermarriage, String diseasezOther,
			Boolean familyMarriage, String fgenetic, String familyDiseasez,
			String birthDefectOther, String relation, Boolean raptatorial,
			Boolean vegetables, Boolean rawMeat, Boolean smoke, String dayNum,
			Boolean passiveSmoke, String smokeType, String smokeTime,
			Boolean drink, String drinkingType, String drinkNum, Boolean drug,
			String drugName, Boolean ozostomia, Boolean bleedingGums,
			String contactFactors, Boolean contact, String contactOther) {
		this.recordId = recordId;
		this.disease = disease;
		this.diseasesNameS = diseasesNameS;
		this.birthDefect = birthDefect;
		this.birthDefectName = birthDefectName;
		this.wdisease = wdisease;
		this.wdiseaseOther = wdiseaseOther;
		this.takeMedicine = takeMedicine;
		this.drugNames = drugNames;
		this.vaccinate = vaccinate;
		this.vaccinateOther = vaccinateOther;
		this.contraceptive = contraceptive;
		this.cother = cother;
		this.ctime = ctime;
		this.cblockYear = cblockYear;
		this.cblockMonth = cblockMonth;
		this.menarcheAge = menarcheAge;
		this.lmp = lmp;
		this.menstrualCycle = menstrualCycle;
		this.periodDays = periodDays;
		this.cycleNumber = cycleNumber;
		this.mpnum = mpnum;
		this.dysmenorrhea = dysmenorrhea;
		this.fetation = fetation;
		this.fetationNum = fetationNum;
		this.livebornNum = livebornNum;
		this.pretermLabor = pretermLabor;
		this.termLabor = termLabor;
		this.hapo = hapo;
		this.stillbirth = stillbirth;
		this.abortion = abortion;
		this.inducedAbortion = inducedAbortion;
		this.laborDefect = laborDefect;
		this.diseases = diseases;
		this.details = details;
		this.childrenNum = childrenNum;
		this.physicalCondition = physicalCondition;
		this.diseaseName = diseaseName;
		this.intermarriage = intermarriage;
		this.diseasezOther = diseasezOther;
		this.familyMarriage = familyMarriage;
		this.fgenetic = fgenetic;
		this.familyDiseasez = familyDiseasez;
		this.birthDefectOther = birthDefectOther;
		this.relation = relation;
		this.raptatorial = raptatorial;
		this.vegetables = vegetables;
		this.rawMeat = rawMeat;
		this.smoke = smoke;
		this.dayNum = dayNum;
		this.passiveSmoke = passiveSmoke;
		this.smokeType = smokeType;
		this.smokeTime = smokeTime;
		this.drink = drink;
		this.drinkingType = drinkingType;
		this.drinkNum = drinkNum;
		this.drug = drug;
		this.drugName = drugName;
		this.ozostomia = ozostomia;
		this.bleedingGums = bleedingGums;
		this.contactFactors = contactFactors;
		this.contact = contact;
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

	public Boolean getWdisease() {
		return this.wdisease;
	}

	public void setWdisease(Boolean wdisease) {
		this.wdisease = wdisease;
	}

	public String getWdiseaseOther() {
		return this.wdiseaseOther;
	}

	public void setWdiseaseOther(String wdiseaseOther) {
		this.wdiseaseOther = wdiseaseOther;
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

	public String getContraceptive() {
		return this.contraceptive;
	}

	public void setContraceptive(String contraceptive) {
		this.contraceptive = contraceptive;
	}

	public String getCother() {
		return this.cother;
	}

	public void setCother(String cother) {
		this.cother = cother;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCblockYear() {
		return this.cblockYear;
	}

	public void setCblockYear(String cblockYear) {
		this.cblockYear = cblockYear;
	}

	public String getCblockMonth() {
		return this.cblockMonth;
	}

	public void setCblockMonth(String cblockMonth) {
		this.cblockMonth = cblockMonth;
	}

	public String getMenarcheAge() {
		return this.menarcheAge;
	}

	public void setMenarcheAge(String menarcheAge) {
		this.menarcheAge = menarcheAge;
	}

	public Timestamp getLmp() {
		return this.lmp;
	}

	public void setLmp(Timestamp lmp) {
		this.lmp = lmp;
	}

	public Boolean getMenstrualCycle() {
		return this.menstrualCycle;
	}

	public void setMenstrualCycle(Boolean menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}

	public Integer getPeriodDays() {
		return this.periodDays;
	}

	public void setPeriodDays(Integer periodDays) {
		this.periodDays = periodDays;
	}

	public Integer getCycleNumber() {
		return this.cycleNumber;
	}

	public void setCycleNumber(Integer cycleNumber) {
		this.cycleNumber = cycleNumber;
	}

	public Integer getMpnum() {
		return this.mpnum;
	}

	public void setMpnum(Integer mpnum) {
		this.mpnum = mpnum;
	}

	public String getDysmenorrhea() {
		return this.dysmenorrhea;
	}

	public void setDysmenorrhea(String dysmenorrhea) {
		this.dysmenorrhea = dysmenorrhea;
	}

	public Boolean getFetation() {
		return this.fetation;
	}

	public void setFetation(Boolean fetation) {
		this.fetation = fetation;
	}

	public Integer getFetationNum() {
		return this.fetationNum;
	}

	public void setFetationNum(Integer fetationNum) {
		this.fetationNum = fetationNum;
	}

	public Integer getLivebornNum() {
		return this.livebornNum;
	}

	public void setLivebornNum(Integer livebornNum) {
		this.livebornNum = livebornNum;
	}

	public Integer getPretermLabor() {
		return this.pretermLabor;
	}

	public void setPretermLabor(Integer pretermLabor) {
		this.pretermLabor = pretermLabor;
	}

	public Integer getTermLabor() {
		return this.termLabor;
	}

	public void setTermLabor(Integer termLabor) {
		this.termLabor = termLabor;
	}

	public Boolean getHapo() {
		return this.hapo;
	}

	public void setHapo(Boolean hapo) {
		this.hapo = hapo;
	}

	public Integer getStillbirth() {
		return this.stillbirth;
	}

	public void setStillbirth(Integer stillbirth) {
		this.stillbirth = stillbirth;
	}

	public Integer getAbortion() {
		return this.abortion;
	}

	public void setAbortion(Integer abortion) {
		this.abortion = abortion;
	}

	public Integer getInducedAbortion() {
		return this.inducedAbortion;
	}

	public void setInducedAbortion(Integer inducedAbortion) {
		this.inducedAbortion = inducedAbortion;
	}

	public Boolean getLaborDefect() {
		return this.laborDefect;
	}

	public void setLaborDefect(Boolean laborDefect) {
		this.laborDefect = laborDefect;
	}

	public String getDiseases() {
		return this.diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getChildrenNum() {
		return this.childrenNum;
	}

	public void setChildrenNum(Integer childrenNum) {
		this.childrenNum = childrenNum;
	}

	public String getPhysicalCondition() {
		return this.physicalCondition;
	}

	public void setPhysicalCondition(String physicalCondition) {
		this.physicalCondition = physicalCondition;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Boolean getIntermarriage() {
		return this.intermarriage;
	}

	public void setIntermarriage(Boolean intermarriage) {
		this.intermarriage = intermarriage;
	}

	public String getDiseasezOther() {
		return this.diseasezOther;
	}

	public void setDiseasezOther(String diseasezOther) {
		this.diseasezOther = diseasezOther;
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

	public Boolean getSmoke() {
		return this.smoke;
	}

	public void setSmoke(Boolean smoke) {
		this.smoke = smoke;
	}

	public String getDayNum() {
		return this.dayNum;
	}

	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}

	public Boolean getPassiveSmoke() {
		return this.passiveSmoke;
	}

	public void setPassiveSmoke(Boolean passiveSmoke) {
		this.passiveSmoke = passiveSmoke;
	}

	public String getSmokeType() {
		return this.smokeType;
	}

	public void setSmokeType(String smokeType) {
		this.smokeType = smokeType;
	}

	public String getSmokeTime() {
		return this.smokeTime;
	}

	public void setSmokeTime(String smokeTime) {
		this.smokeTime = smokeTime;
	}

	public Boolean getDrink() {
		return this.drink;
	}

	public void setDrink(Boolean drink) {
		this.drink = drink;
	}

	public String getDrinkingType() {
		return this.drinkingType;
	}

	public void setDrinkingType(String drinkingType) {
		this.drinkingType = drinkingType;
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

	public Boolean getOzostomia() {
		return this.ozostomia;
	}

	public void setOzostomia(Boolean ozostomia) {
		this.ozostomia = ozostomia;
	}

	public Boolean getBleedingGums() {
		return this.bleedingGums;
	}

	public void setBleedingGums(Boolean bleedingGums) {
		this.bleedingGums = bleedingGums;
	}

	public String getContactFactors() {
		return this.contactFactors;
	}

	public void setContactFactors(String contactFactors) {
		this.contactFactors = contactFactors;
	}

	public Boolean getContact() {
		return this.contact;
	}

	public void setContact(Boolean contact) {
		this.contact = contact;
	}

	public String getContactOther() {
		return this.contactOther;
	}

	public void setContactOther(String contactOther) {
		this.contactOther = contactOther;
	}

}