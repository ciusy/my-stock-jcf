package leo.entity;

/**
 * Cfstuff entity. @author MyEclipse Persistence Tools
 */

public class Cfstuff implements java.io.Serializable {

	// Fields

	private Long did;
	private String disposeName;
	private String cfvalue;
	private Long sid;

	// Constructors

	/** default constructor */
	public Cfstuff() {
	}

	/** minimal constructor */
	public Cfstuff(Long did) {
		this.did = did;
	}

	/** full constructor */
	public Cfstuff(Long did, String disposeName, String cfvalue, Long sid) {
		this.did = did;
		this.disposeName = disposeName;
		this.cfvalue = cfvalue;
		this.sid = sid;
	}

	// Property accessors

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDisposeName() {
		return this.disposeName;
	}

	public void setDisposeName(String disposeName) {
		this.disposeName = disposeName;
	}

	public String getCfvalue() {
		return this.cfvalue;
	}

	public void setCfvalue(String cfvalue) {
		this.cfvalue = cfvalue;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

}