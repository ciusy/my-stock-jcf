package leo.entity;

/**
 * Osuform entity. @author MyEclipse Persistence Tools
 */

public class Osuform implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Long sid;
	private Integer meiid;
	private String uname;
	private String otype;
	private Boolean registerableUnitOrNot;
	private String note;

	// Constructors

	/** default constructor */
	public Osuform() {
	}

	/** minimal constructor */
	public Osuform(Integer uid) {
		this.uid = uid;
	}

	/** full constructor */
	public Osuform(Integer uid, Long sid, Integer meiid, String uname,
			String otype, Boolean registerableUnitOrNot, String note) {
		this.uid = uid;
		this.sid = sid;
		this.meiid = meiid;
		this.uname = uname;
		this.otype = otype;
		this.registerableUnitOrNot = registerableUnitOrNot;
		this.note = note;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Integer getMeiid() {
		return this.meiid;
	}

	public void setMeiid(Integer meiid) {
		this.meiid = meiid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getOtype() {
		return this.otype;
	}

	public void setOtype(String otype) {
		this.otype = otype;
	}

	public Boolean getRegisterableUnitOrNot() {
		return this.registerableUnitOrNot;
	}

	public void setRegisterableUnitOrNot(Boolean registerableUnitOrNot) {
		this.registerableUnitOrNot = registerableUnitOrNot;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}