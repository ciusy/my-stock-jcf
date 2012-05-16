package leo.entity;

/**
 * GhregisterType entity. @author MyEclipse Persistence Tools
 */

public class GhregisterType implements java.io.Serializable {

	// Fields

	private Integer rtid;
	private String rpname;
	private String spell;
	private Double rePrice;
	private Integer uid;
	private Boolean expertOrNot;
	private Boolean isAlter;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public GhregisterType() {
	}

	/** minimal constructor */
	public GhregisterType(Integer rtid) {
		this.rtid = rtid;
	}

	/** full constructor */
	public GhregisterType(Integer rtid, String rpname, String spell,
			Double rePrice, Integer uid, Boolean expertOrNot, Boolean isAlter,
			Integer medicalInstId) {
		this.rtid = rtid;
		this.rpname = rpname;
		this.spell = spell;
		this.rePrice = rePrice;
		this.uid = uid;
		this.expertOrNot = expertOrNot;
		this.isAlter = isAlter;
		this.medicalInstId = medicalInstId;
	}

	// Property accessors

	public Integer getRtid() {
		return this.rtid;
	}

	public void setRtid(Integer rtid) {
		this.rtid = rtid;
	}

	public String getRpname() {
		return this.rpname;
	}

	public void setRpname(String rpname) {
		this.rpname = rpname;
	}

	public String getSpell() {
		return this.spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public Double getRePrice() {
		return this.rePrice;
	}

	public void setRePrice(Double rePrice) {
		this.rePrice = rePrice;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Boolean getExpertOrNot() {
		return this.expertOrNot;
	}

	public void setExpertOrNot(Boolean expertOrNot) {
		this.expertOrNot = expertOrNot;
	}

	public Boolean getIsAlter() {
		return this.isAlter;
	}

	public void setIsAlter(Boolean isAlter) {
		this.isAlter = isAlter;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

}