package leo.entity;

/**
 * SfreduceItem entity. @author MyEclipse Persistence Tools
 */

public class SfreduceItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer costTypeId;
	private Integer costType;
	private Double reducePercent;
	private Double reduceAmount;

	// Constructors

	/** default constructor */
	public SfreduceItem() {
	}

	/** minimal constructor */
	public SfreduceItem(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SfreduceItem(Integer id, Integer costTypeId, Integer costType,
			Double reducePercent, Double reduceAmount) {
		this.id = id;
		this.costTypeId = costTypeId;
		this.costType = costType;
		this.reducePercent = reducePercent;
		this.reduceAmount = reduceAmount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCostTypeId() {
		return this.costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public Integer getCostType() {
		return this.costType;
	}

	public void setCostType(Integer costType) {
		this.costType = costType;
	}

	public Double getReducePercent() {
		return this.reducePercent;
	}

	public void setReducePercent(Double reducePercent) {
		this.reducePercent = reducePercent;
	}

	public Double getReduceAmount() {
		return this.reduceAmount;
	}

	public void setReduceAmount(Double reduceAmount) {
		this.reduceAmount = reduceAmount;
	}

}