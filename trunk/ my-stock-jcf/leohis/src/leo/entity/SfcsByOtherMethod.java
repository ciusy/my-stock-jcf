package leo.entity;

/**
 * SfcsByOtherMethod entity. @author MyEclipse Persistence Tools
 */

public class SfcsByOtherMethod implements java.io.Serializable {

	// Fields

	private Long id;
	private String opdiagnoseId;
	private Double cgAmount;
	private Integer pid;

	// Constructors

	/** default constructor */
	public SfcsByOtherMethod() {
	}

	/** minimal constructor */
	public SfcsByOtherMethod(Long id, String opdiagnoseId) {
		this.id = id;
		this.opdiagnoseId = opdiagnoseId;
	}

	/** full constructor */
	public SfcsByOtherMethod(Long id, String opdiagnoseId, Double cgAmount,
			Integer pid) {
		this.id = id;
		this.opdiagnoseId = opdiagnoseId;
		this.cgAmount = cgAmount;
		this.pid = pid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpdiagnoseId() {
		return this.opdiagnoseId;
	}

	public void setOpdiagnoseId(String opdiagnoseId) {
		this.opdiagnoseId = opdiagnoseId;
	}

	public Double getCgAmount() {
		return this.cgAmount;
	}

	public void setCgAmount(Double cgAmount) {
		this.cgAmount = cgAmount;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}