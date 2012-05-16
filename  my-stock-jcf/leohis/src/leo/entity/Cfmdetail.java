package leo.entity;

/**
 * Cfmdetail entity. @author MyEclipse Persistence Tools
 */

public class Cfmdetail implements java.io.Serializable {

	// Fields

	private Long iid;
	private Integer modelId;
	private Integer mid;
	private String unit;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Cfmdetail() {
	}

	/** minimal constructor */
	public Cfmdetail(Long iid) {
		this.iid = iid;
	}

	/** full constructor */
	public Cfmdetail(Long iid, Integer modelId, Integer mid, String unit,
			Integer quantity) {
		this.iid = iid;
		this.modelId = modelId;
		this.mid = mid;
		this.unit = unit;
		this.quantity = quantity;
	}

	// Property accessors

	public Long getIid() {
		return this.iid;
	}

	public void setIid(Long iid) {
		this.iid = iid;
	}

	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}