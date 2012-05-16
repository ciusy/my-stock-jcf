package leo.entity;

import java.sql.Timestamp;

/**
 * PregnancyResult entity. @author MyEclipse Persistence Tools
 */

public class PregnancyResult implements java.io.Serializable {

	// Fields

	private Integer id;
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
	private String pregnancy;
	private String pregnancyOther;
	private String fetalSex;
	private Integer weight;
	private String multiplebirths;
	private String deliveryDate;
	private String deliveryWeeks;
	private String deliveryProvince;
	private String deliveryPrefecture;
	private String deliveryInstitutions;
	private String deliveryOther;
	private String deliveryWay;
	private String deliveryWayOther;
	private String live;
	private Timestamp date;
	private String personnel;
	private Long stuffId;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public PregnancyResult() {
	}

	/** minimal constructor */
	public PregnancyResult(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public PregnancyResult(String recordId, String csname, Integer age,
			String telephone, String fprovince, String fprefecture,
			String ftown, String fvillage, String vprovince,
			String vprefecture, String medicalInst, String pregnancy,
			String pregnancyOther, String fetalSex, Integer weight,
			String multiplebirths, String deliveryDate, String deliveryWeeks,
			String deliveryProvince, String deliveryPrefecture,
			String deliveryInstitutions, String deliveryOther,
			String deliveryWay, String deliveryWayOther, String live,
			Timestamp date, String personnel, Long stuffId,
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
		this.pregnancy = pregnancy;
		this.pregnancyOther = pregnancyOther;
		this.fetalSex = fetalSex;
		this.weight = weight;
		this.multiplebirths = multiplebirths;
		this.deliveryDate = deliveryDate;
		this.deliveryWeeks = deliveryWeeks;
		this.deliveryProvince = deliveryProvince;
		this.deliveryPrefecture = deliveryPrefecture;
		this.deliveryInstitutions = deliveryInstitutions;
		this.deliveryOther = deliveryOther;
		this.deliveryWay = deliveryWay;
		this.deliveryWayOther = deliveryWayOther;
		this.live = live;
		this.date = date;
		this.personnel = personnel;
		this.stuffId = stuffId;
		this.medicalInstId = medicalInstId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPregnancy() {
		return this.pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	public String getPregnancyOther() {
		return this.pregnancyOther;
	}

	public void setPregnancyOther(String pregnancyOther) {
		this.pregnancyOther = pregnancyOther;
	}

	public String getFetalSex() {
		return this.fetalSex;
	}

	public void setFetalSex(String fetalSex) {
		this.fetalSex = fetalSex;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getMultiplebirths() {
		return this.multiplebirths;
	}

	public void setMultiplebirths(String multiplebirths) {
		this.multiplebirths = multiplebirths;
	}

	public String getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryWeeks() {
		return this.deliveryWeeks;
	}

	public void setDeliveryWeeks(String deliveryWeeks) {
		this.deliveryWeeks = deliveryWeeks;
	}

	public String getDeliveryProvince() {
		return this.deliveryProvince;
	}

	public void setDeliveryProvince(String deliveryProvince) {
		this.deliveryProvince = deliveryProvince;
	}

	public String getDeliveryPrefecture() {
		return this.deliveryPrefecture;
	}

	public void setDeliveryPrefecture(String deliveryPrefecture) {
		this.deliveryPrefecture = deliveryPrefecture;
	}

	public String getDeliveryInstitutions() {
		return this.deliveryInstitutions;
	}

	public void setDeliveryInstitutions(String deliveryInstitutions) {
		this.deliveryInstitutions = deliveryInstitutions;
	}

	public String getDeliveryOther() {
		return this.deliveryOther;
	}

	public void setDeliveryOther(String deliveryOther) {
		this.deliveryOther = deliveryOther;
	}

	public String getDeliveryWay() {
		return this.deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	public String getDeliveryWayOther() {
		return this.deliveryWayOther;
	}

	public void setDeliveryWayOther(String deliveryWayOther) {
		this.deliveryWayOther = deliveryWayOther;
	}

	public String getLive() {
		return this.live;
	}

	public void setLive(String live) {
		this.live = live;
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