package leo.entity;

/**
 * OsunitHasS entity. @author MyEclipse Persistence Tools
 */

public class OsunitHasS implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer unitId;
	private Long sid;

	// Constructors

	/** default constructor */
	public OsunitHasS() {
	}

	/** minimal constructor */
	public OsunitHasS(Long id) {
		this.id = id;
	}

	/** full constructor */
	public OsunitHasS(Long id, Integer unitId, Long sid) {
		this.id = id;
		this.unitId = unitId;
		this.sid = sid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

}