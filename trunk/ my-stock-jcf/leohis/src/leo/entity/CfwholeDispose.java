package leo.entity;

/**
 * CfwholeDispose entity. @author MyEclipse Persistence Tools
 */

public class CfwholeDispose implements java.io.Serializable {

	// Fields

	private Long did;
	private String disposeName;
	private String cfvalue;

	// Constructors

	/** default constructor */
	public CfwholeDispose() {
	}

	/** minimal constructor */
	public CfwholeDispose(Long did) {
		this.did = did;
	}

	/** full constructor */
	public CfwholeDispose(Long did, String disposeName, String cfvalue) {
		this.did = did;
		this.disposeName = disposeName;
		this.cfvalue = cfvalue;
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

}