package leo.entity;

/**
 * GhregisterDivaricateU entity. @author MyEclipse Persistence Tools
 */

public class GhregisterDivaricateU implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer uid;
	private Integer rtid;

	// Constructors

	/** default constructor */
	public GhregisterDivaricateU() {
	}

	/** minimal constructor */
	public GhregisterDivaricateU(Long id, Integer rtid) {
		this.id = id;
		this.rtid = rtid;
	}

	/** full constructor */
	public GhregisterDivaricateU(Long id, Integer uid, Integer rtid) {
		this.id = id;
		this.uid = uid;
		this.rtid = rtid;
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

	public Integer getRtid() {
		return this.rtid;
	}

	public void setRtid(Integer rtid) {
		this.rtid = rtid;
	}

}