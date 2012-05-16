package leo.entity;

import java.sql.Timestamp;

/**
 * BloodCellTest entity. @author MyEclipse Persistence Tools
 */

public class BloodCellTest implements java.io.Serializable {

	// Fields

	private String recordId;
	private String hb;
	private String rbc;
	private String plt;
	private String wbc;
	private String n;
	private String e;
	private String b;
	private String l;
	private String m;
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
	public BloodCellTest() {
	}

	/** minimal constructor */
	public BloodCellTest(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public BloodCellTest(String recordId, String hb, String rbc, String plt,
			String wbc, String n, String e, String b, String l, String m,
			Boolean lis, String itemId, String executeU, Timestamp date,
			String doctor, String source, String hname, Integer medicalInstId,
			Long stuffId, Boolean isNormal) {
		this.recordId = recordId;
		this.hb = hb;
		this.rbc = rbc;
		this.plt = plt;
		this.wbc = wbc;
		this.n = n;
		this.e = e;
		this.b = b;
		this.l = l;
		this.m = m;
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

	public String getHb() {
		return this.hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getRbc() {
		return this.rbc;
	}

	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	public String getPlt() {
		return this.plt;
	}

	public void setPlt(String plt) {
		this.plt = plt;
	}

	public String getWbc() {
		return this.wbc;
	}

	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	public String getN() {
		return this.n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getL() {
		return this.l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getM() {
		return this.m;
	}

	public void setM(String m) {
		this.m = m;
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