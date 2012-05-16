package leo.entity;

import java.sql.Timestamp;

/**
 * LeucorrheaTest entity. @author MyEclipse Persistence Tools
 */

public class LeucorrheaTest implements java.io.Serializable {

	// Fields

	private String recordId;
	private String clueCell;
	private String monilial;
	private String trichomonas;
	private String cleanness;
	private String amine;
	private String ph;
	private String gonococcus;
	private String chlamydiaT;
	private Boolean lis;
	private String itemId;
	private String executeU;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private Integer medicalInstId;
	private Long stuffId;
	private Boolean isNormal;

	// Constructors

	/** default constructor */
	public LeucorrheaTest() {
	}

	/** minimal constructor */
	public LeucorrheaTest(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public LeucorrheaTest(String recordId, String clueCell, String monilial,
			String trichomonas, String cleanness, String amine, String ph,
			String gonococcus, String chlamydiaT, Boolean lis, String itemId,
			String executeU, Timestamp date, String doctor, String source,
			String hname, Integer medicalInstId, Long stuffId, Boolean isNormal) {
		this.recordId = recordId;
		this.clueCell = clueCell;
		this.monilial = monilial;
		this.trichomonas = trichomonas;
		this.cleanness = cleanness;
		this.amine = amine;
		this.ph = ph;
		this.gonococcus = gonococcus;
		this.chlamydiaT = chlamydiaT;
		this.lis = lis;
		this.itemId = itemId;
		this.executeU = executeU;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
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

	public String getClueCell() {
		return this.clueCell;
	}

	public void setClueCell(String clueCell) {
		this.clueCell = clueCell;
	}

	public String getMonilial() {
		return this.monilial;
	}

	public void setMonilial(String monilial) {
		this.monilial = monilial;
	}

	public String getTrichomonas() {
		return this.trichomonas;
	}

	public void setTrichomonas(String trichomonas) {
		this.trichomonas = trichomonas;
	}

	public String getCleanness() {
		return this.cleanness;
	}

	public void setCleanness(String cleanness) {
		this.cleanness = cleanness;
	}

	public String getAmine() {
		return this.amine;
	}

	public void setAmine(String amine) {
		this.amine = amine;
	}

	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getGonococcus() {
		return this.gonococcus;
	}

	public void setGonococcus(String gonococcus) {
		this.gonococcus = gonococcus;
	}

	public String getChlamydiaT() {
		return this.chlamydiaT;
	}

	public void setChlamydiaT(String chlamydiaT) {
		this.chlamydiaT = chlamydiaT;
	}

	public Boolean getLis() {
		return this.lis;
	}

	public void setLis(Boolean lis) {
		this.lis = lis;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(String executeU) {
		this.executeU = executeU;
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

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
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