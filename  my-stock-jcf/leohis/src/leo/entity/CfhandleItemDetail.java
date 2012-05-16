package leo.entity;

/**
 * CfhandleItemDetail entity. @author MyEclipse Persistence Tools
 */

public class CfhandleItemDetail implements java.io.Serializable {

	// Fields

	private Long itemId;
	private Integer modelId;
	private Integer handleItemId;

	// Constructors

	/** default constructor */
	public CfhandleItemDetail() {
	}

	/** minimal constructor */
	public CfhandleItemDetail(Long itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public CfhandleItemDetail(Long itemId, Integer modelId, Integer handleItemId) {
		this.itemId = itemId;
		this.modelId = modelId;
		this.handleItemId = handleItemId;
	}

	// Property accessors

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getHandleItemId() {
		return this.handleItemId;
	}

	public void setHandleItemId(Integer handleItemId) {
		this.handleItemId = handleItemId;
	}

}