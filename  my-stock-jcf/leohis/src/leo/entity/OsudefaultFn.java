package leo.entity;

/**
 * OsudefaultFn entity. @author MyEclipse Persistence Tools
 */

public class OsudefaultFn implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer uid;
	private Integer fcBlocksId;

	// Constructors

	/** default constructor */
	public OsudefaultFn() {
	}

	/** minimal constructor */
	public OsudefaultFn(Long id) {
		this.id = id;
	}

	/** full constructor */
	public OsudefaultFn(Long id, Integer uid, Integer fcBlocksId) {
		this.id = id;
		this.uid = uid;
		this.fcBlocksId = fcBlocksId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getFcBlocksId() {
		return this.fcBlocksId;
	}

	public void setFcBlocksId(Integer fcBlocksId) {
		this.fcBlocksId = fcBlocksId;
	}

}