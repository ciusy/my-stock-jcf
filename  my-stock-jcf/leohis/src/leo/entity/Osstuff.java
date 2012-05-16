package leo.entity;

import java.sql.Timestamp;

/**
 * Osstuff entity. @author MyEclipse Persistence Tools
 */

public class Osstuff implements java.io.Serializable {

	// Fields

	private Long sid;
	private String loginName;
	private String idcardNum;
	private String sname;
	private String password;
	private String sex;
	private Timestamp birthday;
	private String nationality;
	private String homeAddress;
	private String censusRegisterAddress;
	private String mobilePhoneNum;
	private String email;
	private String title;
	private String administrativePosts;
	private String staffingLevelType;
	private String qualificationName;
	private String dutyDescription;
	private String headImage;
	private String note;
	private Boolean expertOrNot;
	private Double chargeBalance;
	private String spellAbbreviation;
	private Integer defaultCasello;
	private Integer defaultPharmacy;
	private Integer defaultU;
	private Integer meiid;
	private String province;
	private String city;
	private String prefecture;
	private String town;

	// Constructors

	/** default constructor */
	public Osstuff() {
	}

	/** minimal constructor */
	public Osstuff(String loginName) {
		this.loginName = loginName;
	}

	/** full constructor */
	public Osstuff(String loginName, String idcardNum, String sname,
			String password, String sex, Timestamp birthday,
			String nationality, String homeAddress,
			String censusRegisterAddress, String mobilePhoneNum, String email,
			String title, String administrativePosts, String staffingLevelType,
			String qualificationName, String dutyDescription, String headImage,
			String note, Boolean expertOrNot, Double chargeBalance,
			String spellAbbreviation, Integer defaultCasello,
			Integer defaultPharmacy, Integer defaultU, Integer meiid,
			String province, String city, String prefecture, String town) {
		this.loginName = loginName;
		this.idcardNum = idcardNum;
		this.sname = sname;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.nationality = nationality;
		this.homeAddress = homeAddress;
		this.censusRegisterAddress = censusRegisterAddress;
		this.mobilePhoneNum = mobilePhoneNum;
		this.email = email;
		this.title = title;
		this.administrativePosts = administrativePosts;
		this.staffingLevelType = staffingLevelType;
		this.qualificationName = qualificationName;
		this.dutyDescription = dutyDescription;
		this.headImage = headImage;
		this.note = note;
		this.expertOrNot = expertOrNot;
		this.chargeBalance = chargeBalance;
		this.spellAbbreviation = spellAbbreviation;
		this.defaultCasello = defaultCasello;
		this.defaultPharmacy = defaultPharmacy;
		this.defaultU = defaultU;
		this.meiid = meiid;
		this.province = province;
		this.city = city;
		this.prefecture = prefecture;
		this.town = town;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIdcardNum() {
		return this.idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getCensusRegisterAddress() {
		return this.censusRegisterAddress;
	}

	public void setCensusRegisterAddress(String censusRegisterAddress) {
		this.censusRegisterAddress = censusRegisterAddress;
	}

	public String getMobilePhoneNum() {
		return this.mobilePhoneNum;
	}

	public void setMobilePhoneNum(String mobilePhoneNum) {
		this.mobilePhoneNum = mobilePhoneNum;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdministrativePosts() {
		return this.administrativePosts;
	}

	public void setAdministrativePosts(String administrativePosts) {
		this.administrativePosts = administrativePosts;
	}

	public String getStaffingLevelType() {
		return this.staffingLevelType;
	}

	public void setStaffingLevelType(String staffingLevelType) {
		this.staffingLevelType = staffingLevelType;
	}

	public String getQualificationName() {
		return this.qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getDutyDescription() {
		return this.dutyDescription;
	}

	public void setDutyDescription(String dutyDescription) {
		this.dutyDescription = dutyDescription;
	}

	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getExpertOrNot() {
		return this.expertOrNot;
	}

	public void setExpertOrNot(Boolean expertOrNot) {
		this.expertOrNot = expertOrNot;
	}

	public Double getChargeBalance() {
		return this.chargeBalance;
	}

	public void setChargeBalance(Double chargeBalance) {
		this.chargeBalance = chargeBalance;
	}

	public String getSpellAbbreviation() {
		return this.spellAbbreviation;
	}

	public void setSpellAbbreviation(String spellAbbreviation) {
		this.spellAbbreviation = spellAbbreviation;
	}

	public Integer getDefaultCasello() {
		return this.defaultCasello;
	}

	public void setDefaultCasello(Integer defaultCasello) {
		this.defaultCasello = defaultCasello;
	}

	public Integer getDefaultPharmacy() {
		return this.defaultPharmacy;
	}

	public void setDefaultPharmacy(Integer defaultPharmacy) {
		this.defaultPharmacy = defaultPharmacy;
	}

	public Integer getDefaultU() {
		return this.defaultU;
	}

	public void setDefaultU(Integer defaultU) {
		this.defaultU = defaultU;
	}

	public Integer getMeiid() {
		return this.meiid;
	}

	public void setMeiid(Integer meiid) {
		this.meiid = meiid;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

}