package leo.entity;

import java.sql.Timestamp;

/**
 * TorchandSyphilis entity. @author MyEclipse Persistence Tools
 */

public class TorchandSyphilis implements java.io.Serializable {

	// Fields

	private String recordId;
	private String ruV;
	private String mdlxtsc;
	private String cmvigM;
	private String cmvigG;
	private String toxigG;
	private String toxigGm;
	private Boolean lis;
	private String itemId;
	private String executeU;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public TorchandSyphilis() {
	}

	/** minimal constructor */
	public TorchandSyphilis(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public TorchandSyphilis(String recordId, String ruV, String mdlxtsc,
			String cmvigM, String cmvigG, String toxigG, String toxigGm,
			Boolean lis, String itemId, String executeU, Timestamp date,
			String doctor, String source, String hname, Integer medicalInstId,
			Long stuffId) {
		this.recordId = recordId;
		this.ruV = ruV;
		this.mdlxtsc = mdlxtsc;
		this.cmvigM = cmvigM;
		this.cmvigG = cmvigG;
		this.toxigG = toxigG;
		this.toxigGm = toxigGm;
		this.lis = lis;
		this.itemId = itemId;
		this.executeU = executeU;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
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

	public String getRuV() {
		return this.ruV;
	}

	public void setRuV(String ruV) {
		this.ruV = ruV;
	}

	public String getMdlxtsc() {
		return this.mdlxtsc;
	}

	public void setMdlxtsc(String mdlxtsc) {
		this.mdlxtsc = mdlxtsc;
	}

	public String getCmvigM() {
		return this.cmvigM;
	}

	public void setCmvigM(String cmvigM) {
		this.cmvigM = cmvigM;
	}

	public String getCmvigG() {
		return this.cmvigG;
	}

	public void setCmvigG(String cmvigG) {
		this.cmvigG = cmvigG;
	}

	public String getToxigG() {
		return this.toxigG;
	}

	public void setToxigG(String toxigG) {
		this.toxigG = toxigG;
	}

	public String getToxigGm() {
		return this.toxigGm;
	}

	public void setToxigGm(String toxigGm) {
		this.toxigGm = toxigGm;
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

}