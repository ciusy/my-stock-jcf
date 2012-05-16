package leo.entity;

/**
 * GhcostType entity. @author MyEclipse Persistence Tools
 */

public class GhcostType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String costType;
	private Double rrp;
	private Double rrv;
	private Boolean enterAddress;
	private Boolean derate;
	private int medicalInstId;

	// Constructors

	public int getMedicalInstId() {
		return medicalInstId;
	}

	public void setMedicalInstId(int medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	/** default constructor */
	public GhcostType() {
	}

	/** minimal constructor */
	public GhcostType(Integer id, String costType) {
		this.id = id;
		this.costType = costType;
	}

	/** full constructor */
	public GhcostType(Integer id, String costType, Double rrp, Double rrv,
			Boolean enterAddress, Boolean derate) {
		this.id = id;
		this.costType = costType;
		this.rrp = rrp;
		this.rrv = rrv;
		this.enterAddress = enterAddress;
		this.derate = derate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCostType() {
		return this.costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public Double getRrp() {
		return this.rrp;
	}

	public void setRrp(Double rrp) {
		this.rrp = rrp;
	}

	public Double getRrv() {
		return this.rrv;
	}

	public void setRrv(Double rrv) {
		this.rrv = rrv;
	}

	public Boolean getEnterAddress() {
		return this.enterAddress;
	}

	public void setEnterAddress(Boolean enterAddress) {
		this.enterAddress = enterAddress;
	}

	public Boolean getDerate() {
		return this.derate;
	}

	public void setDerate(Boolean derate) {
		this.derate = derate;
	}

}