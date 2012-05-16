package leo.entity;

import java.sql.Timestamp;

/**
 * FamiliRecordBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class FamiliRecordBasicInfo implements java.io.Serializable {

	// Fields

	private String recordId;
	private String psid;
	private String gjRecordId;
	private String mname;
	private String mnation;
	private Timestamp mbirthDate;
	private Integer mage;
	private String mculture;
	private String midcardNum;
	private String mprofession;
	private String mprofessionOther;
	private String mprovince;
	private String mcity;
	private String mprefecture;
	private String mtown;
	private String mvillage;
	private String mdomicile;
	private String wname;
	private String wnation;
	private Timestamp wbirthDate;
	private Integer wage;
	private String wculture;
	private String widcardNum;
	private String wprofession;
	private String wprofessionOther;
	private String wprovince;
	private String wcity;
	private String wprefecture;
	private String wtown;
	private String wvillage;
	private String wdomicile;
	private String waddressProvince;
	private String waddressCity;
	private String waddressPrefecture;
	private String waddressTown;
	private String waddressVillage;
	private String postalCode;
	private Timestamp marryDate;
	private String telephone;
	private Timestamp writtenDate;
	private String doctor;
	private Timestamp pregnantTimeExpected;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public FamiliRecordBasicInfo() {
	}

	/** minimal constructor */
	public FamiliRecordBasicInfo(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public FamiliRecordBasicInfo(String recordId, String psid,
			String gjRecordId, String mname, String mnation,
			Timestamp mbirthDate, Integer mage, String mculture,
			String midcardNum, String mprofession, String mprofessionOther,
			String mprovince, String mcity, String mprefecture, String mtown,
			String mvillage, String mdomicile, String wname, String wnation,
			Timestamp wbirthDate, Integer wage, String wculture,
			String widcardNum, String wprofession, String wprofessionOther,
			String wprovince, String wcity, String wprefecture, String wtown,
			String wvillage, String wdomicile, String waddressProvince,
			String waddressCity, String waddressPrefecture,
			String waddressTown, String waddressVillage, String postalCode,
			Timestamp marryDate, String telephone, Timestamp writtenDate,
			String doctor, Timestamp pregnantTimeExpected,
			Integer medicalInstId, Long stuffId) {
		this.recordId = recordId;
		this.psid = psid;
		this.gjRecordId = gjRecordId;
		this.mname = mname;
		this.mnation = mnation;
		this.mbirthDate = mbirthDate;
		this.mage = mage;
		this.mculture = mculture;
		this.midcardNum = midcardNum;
		this.mprofession = mprofession;
		this.mprofessionOther = mprofessionOther;
		this.mprovince = mprovince;
		this.mcity = mcity;
		this.mprefecture = mprefecture;
		this.mtown = mtown;
		this.mvillage = mvillage;
		this.mdomicile = mdomicile;
		this.wname = wname;
		this.wnation = wnation;
		this.wbirthDate = wbirthDate;
		this.wage = wage;
		this.wculture = wculture;
		this.widcardNum = widcardNum;
		this.wprofession = wprofession;
		this.wprofessionOther = wprofessionOther;
		this.wprovince = wprovince;
		this.wcity = wcity;
		this.wprefecture = wprefecture;
		this.wtown = wtown;
		this.wvillage = wvillage;
		this.wdomicile = wdomicile;
		this.waddressProvince = waddressProvince;
		this.waddressCity = waddressCity;
		this.waddressPrefecture = waddressPrefecture;
		this.waddressTown = waddressTown;
		this.waddressVillage = waddressVillage;
		this.postalCode = postalCode;
		this.marryDate = marryDate;
		this.telephone = telephone;
		this.writtenDate = writtenDate;
		this.doctor = doctor;
		this.pregnantTimeExpected = pregnantTimeExpected;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getPsid() {
		return this.psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getGjRecordId() {
		return this.gjRecordId;
	}

	public void setGjRecordId(String gjRecordId) {
		this.gjRecordId = gjRecordId;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMnation() {
		return this.mnation;
	}

	public void setMnation(String mnation) {
		this.mnation = mnation;
	}

	public Timestamp getMbirthDate() {
		return this.mbirthDate;
	}

	public void setMbirthDate(Timestamp mbirthDate) {
		this.mbirthDate = mbirthDate;
	}

	public Integer getMage() {
		return this.mage;
	}

	public void setMage(Integer mage) {
		this.mage = mage;
	}

	public String getMculture() {
		return this.mculture;
	}

	public void setMculture(String mculture) {
		this.mculture = mculture;
	}

	public String getMidcardNum() {
		return this.midcardNum;
	}

	public void setMidcardNum(String midcardNum) {
		this.midcardNum = midcardNum;
	}

	public String getMprofession() {
		return this.mprofession;
	}

	public void setMprofession(String mprofession) {
		this.mprofession = mprofession;
	}

	public String getMprofessionOther() {
		return this.mprofessionOther;
	}

	public void setMprofessionOther(String mprofessionOther) {
		this.mprofessionOther = mprofessionOther;
	}

	public String getMprovince() {
		return this.mprovince;
	}

	public void setMprovince(String mprovince) {
		this.mprovince = mprovince;
	}

	public String getMcity() {
		return this.mcity;
	}

	public void setMcity(String mcity) {
		this.mcity = mcity;
	}

	public String getMprefecture() {
		return this.mprefecture;
	}

	public void setMprefecture(String mprefecture) {
		this.mprefecture = mprefecture;
	}

	public String getMtown() {
		return this.mtown;
	}

	public void setMtown(String mtown) {
		this.mtown = mtown;
	}

	public String getMvillage() {
		return this.mvillage;
	}

	public void setMvillage(String mvillage) {
		this.mvillage = mvillage;
	}

	public String getMdomicile() {
		return this.mdomicile;
	}

	public void setMdomicile(String mdomicile) {
		this.mdomicile = mdomicile;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWnation() {
		return this.wnation;
	}

	public void setWnation(String wnation) {
		this.wnation = wnation;
	}

	public Timestamp getWbirthDate() {
		return this.wbirthDate;
	}

	public void setWbirthDate(Timestamp wbirthDate) {
		this.wbirthDate = wbirthDate;
	}

	public Integer getWage() {
		return this.wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	public String getWculture() {
		return this.wculture;
	}

	public void setWculture(String wculture) {
		this.wculture = wculture;
	}

	public String getWidcardNum() {
		return this.widcardNum;
	}

	public void setWidcardNum(String widcardNum) {
		this.widcardNum = widcardNum;
	}

	public String getWprofession() {
		return this.wprofession;
	}

	public void setWprofession(String wprofession) {
		this.wprofession = wprofession;
	}

	public String getWprofessionOther() {
		return this.wprofessionOther;
	}

	public void setWprofessionOther(String wprofessionOther) {
		this.wprofessionOther = wprofessionOther;
	}

	public String getWprovince() {
		return this.wprovince;
	}

	public void setWprovince(String wprovince) {
		this.wprovince = wprovince;
	}

	public String getWcity() {
		return this.wcity;
	}

	public void setWcity(String wcity) {
		this.wcity = wcity;
	}

	public String getWprefecture() {
		return this.wprefecture;
	}

	public void setWprefecture(String wprefecture) {
		this.wprefecture = wprefecture;
	}

	public String getWtown() {
		return this.wtown;
	}

	public void setWtown(String wtown) {
		this.wtown = wtown;
	}

	public String getWvillage() {
		return this.wvillage;
	}

	public void setWvillage(String wvillage) {
		this.wvillage = wvillage;
	}

	public String getWdomicile() {
		return this.wdomicile;
	}

	public void setWdomicile(String wdomicile) {
		this.wdomicile = wdomicile;
	}

	public String getWaddressProvince() {
		return this.waddressProvince;
	}

	public void setWaddressProvince(String waddressProvince) {
		this.waddressProvince = waddressProvince;
	}

	public String getWaddressCity() {
		return this.waddressCity;
	}

	public void setWaddressCity(String waddressCity) {
		this.waddressCity = waddressCity;
	}

	public String getWaddressPrefecture() {
		return this.waddressPrefecture;
	}

	public void setWaddressPrefecture(String waddressPrefecture) {
		this.waddressPrefecture = waddressPrefecture;
	}

	public String getWaddressTown() {
		return this.waddressTown;
	}

	public void setWaddressTown(String waddressTown) {
		this.waddressTown = waddressTown;
	}

	public String getWaddressVillage() {
		return this.waddressVillage;
	}

	public void setWaddressVillage(String waddressVillage) {
		this.waddressVillage = waddressVillage;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Timestamp getMarryDate() {
		return this.marryDate;
	}

	public void setMarryDate(Timestamp marryDate) {
		this.marryDate = marryDate;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Timestamp getWrittenDate() {
		return this.writtenDate;
	}

	public void setWrittenDate(Timestamp writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Timestamp getPregnantTimeExpected() {
		return this.pregnantTimeExpected;
	}

	public void setPregnantTimeExpected(Timestamp pregnantTimeExpected) {
		this.pregnantTimeExpected = pregnantTimeExpected;
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

}