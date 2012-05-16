package leo.entity;

/**
 * CzdisposalType entity. @author MyEclipse Persistence Tools
 */

public class CzdisposalType implements java.io.Serializable {

	// Fields

	private Long id;
	private String disposeItemType;
	private String type;
	private Integer medicallnstId;

	// Constructors

	/** default constructor */
	public CzdisposalType() {
	}

	/** minimal constructor */
	public CzdisposalType(Long id) {
		this.id = id;
	}

	/** full constructor */
	public CzdisposalType(Long id, String disposeItemType, String type,
			Integer medicallnstId) {
		this.id = id;
		this.disposeItemType = disposeItemType;
		this.type = type;
		this.medicallnstId = medicallnstId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisposeItemType() {
		return this.disposeItemType;
	}

	public void setDisposeItemType(String disposeItemType) {
		this.disposeItemType = disposeItemType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMedicallnstId() {
		return this.medicallnstId;
	}

	public void setMedicallnstId(Integer medicallnstId) {
		this.medicallnstId = medicallnstId;
	}

}