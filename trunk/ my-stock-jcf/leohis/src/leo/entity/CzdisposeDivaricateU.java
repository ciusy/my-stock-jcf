package leo.entity;

/**
 * CzdisposeDivaricateU entity. @author MyEclipse Persistence Tools
 */

public class CzdisposeDivaricateU implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer itemTypeId;
	private Integer uid;

	// Constructors

	/** default constructor */
	public CzdisposeDivaricateU() {
	}

	/** minimal constructor */
	public CzdisposeDivaricateU(Long id) {
		this.id = id;
	}

	/** full constructor */
	public CzdisposeDivaricateU(Long id, Integer itemTypeId, Integer uid) {
		this.id = id;
		this.itemTypeId = itemTypeId;
		this.uid = uid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}