package leo.entity;

/**
 * Yfprice entity. @author MyEclipse Persistence Tools
 */

public class Yfprice implements java.io.Serializable {

	// Fields

	private Long pid;
	private String exbankType;
	private Double exbankP;
	private Integer minfoId;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public Yfprice() {
	}

	/** minimal constructor */
	public Yfprice(Long pid) {
		this.pid = pid;
	}



	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getExbankType() {
		return exbankType;
	}

	public void setExbankType(String exbankType) {
		this.exbankType = exbankType;
	}

	public Double getExbankP() {
		return this.exbankP;
	}

	public void setExbankP(Double exbankP) {
		this.exbankP = exbankP;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

}