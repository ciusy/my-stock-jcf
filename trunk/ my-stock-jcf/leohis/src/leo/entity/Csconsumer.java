package leo.entity;

import java.sql.Timestamp;

/**
 * Csconsumer entity. @author MyEclipse Persistence Tools
 */

public class Csconsumer implements java.io.Serializable {

	// Fields

	private Long csId;
	private String idcardNum;
	private String csname;
	private String wiscode;
	private String sex;
	private Timestamp birthday;
	private String province;
	private String city;
	private String prefecture;
	private String town;
	private String village;
	private String tgroup;
	private String address;
	private String cellphone;
	private String telephone;
	private String nameForShort;
	private String email;
	private String password;
	private Boolean beenHereBefore;
	private Boolean ensureIdcardNumOrNot;
	private String medicalInsuranceCode;
	private String ruralCooperCode;
	private String mateId;

	// Constructors

	/** default constructor */
	public Csconsumer() {
	}

	/** minimal constructor */
	public Csconsumer(Long csId) {
		this.csId = csId;
	}

	/** full constructor */
	public Csconsumer(Long csId, String idcardNum, String csname,
			String wiscode, String sex, Timestamp birthday, String province,
			String city, String prefecture, String town, String village,
			String tgroup, String address, String cellphone, String telephone,
			String nameForShort, String email, String password,
			Boolean beenHereBefore, Boolean ensureIdcardNumOrNot,
			String medicalInsuranceCode, String ruralCooperCode, String mateId) {
		this.csId = csId;
		this.idcardNum = idcardNum;
		this.csname = csname;
		this.wiscode = wiscode;
		this.sex = sex;
		this.birthday = birthday;
		this.province = province;
		this.city = city;
		this.prefecture = prefecture;
		this.town = town;
		this.village = village;
		this.tgroup = tgroup;
		this.address = address;
		this.cellphone = cellphone;
		this.telephone = telephone;
		this.nameForShort = nameForShort;
		this.email = email;
		this.password = password;
		this.beenHereBefore = beenHereBefore;
		this.ensureIdcardNumOrNot = ensureIdcardNumOrNot;
		this.medicalInsuranceCode = medicalInsuranceCode;
		this.ruralCooperCode = ruralCooperCode;
		this.mateId = mateId;
	}

	// Property accessors

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getIdcardNum() {
		return this.idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getCsname() {
		return this.csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public String getWiscode() {
		return this.wiscode;
	}

	public void setWiscode(String wiscode) {
		this.wiscode = wiscode;
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

	public String getVillage() {
		return this.village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTgroup() {
		return this.tgroup;
	}

	public void setTgroup(String tgroup) {
		this.tgroup = tgroup;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNameForShort() {
		return this.nameForShort;
	}

	public void setNameForShort(String nameForShort) {
		this.nameForShort = nameForShort;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getBeenHereBefore() {
		return this.beenHereBefore;
	}

	public void setBeenHereBefore(Boolean beenHereBefore) {
		this.beenHereBefore = beenHereBefore;
	}

	public Boolean getEnsureIdcardNumOrNot() {
		return this.ensureIdcardNumOrNot;
	}

	public void setEnsureIdcardNumOrNot(Boolean ensureIdcardNumOrNot) {
		this.ensureIdcardNumOrNot = ensureIdcardNumOrNot;
	}

	public String getMedicalInsuranceCode() {
		return this.medicalInsuranceCode;
	}

	public void setMedicalInsuranceCode(String medicalInsuranceCode) {
		this.medicalInsuranceCode = medicalInsuranceCode;
	}

	public String getRuralCooperCode() {
		return this.ruralCooperCode;
	}

	public void setRuralCooperCode(String ruralCooperCode) {
		this.ruralCooperCode = ruralCooperCode;
	}

	public String getMateId() {
		return this.mateId;
	}

	public void setMateId(String mateId) {
		this.mateId = mateId;
	}

}