package leo.entity;

/**
 * YfmalertInventory entity. @author MyEclipse Persistence Tools
 */

public class YfmalertInventory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer minfoId;
	private Integer muid;
	private Integer highInventory;
	private Integer lowInventory;

	// Constructors

	/** default constructor */
	public YfmalertInventory() {
	}

	/** minimal constructor */
	public YfmalertInventory(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public YfmalertInventory(Integer id, Integer minfoId, Integer muid,
			Integer highInventory, Integer lowInventory) {
		this.id = id;
		this.minfoId = minfoId;
		this.muid = muid;
		this.highInventory = highInventory;
		this.lowInventory = lowInventory;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Integer getMuid() {
		return this.muid;
	}

	public void setMuid(Integer muid) {
		this.muid = muid;
	}

	public Integer getHighInventory() {
		return this.highInventory;
	}

	public void setHighInventory(Integer highInventory) {
		this.highInventory = highInventory;
	}

	public Integer getLowInventory() {
		return this.lowInventory;
	}

	public void setLowInventory(Integer lowInventory) {
		this.lowInventory = lowInventory;
	}

}