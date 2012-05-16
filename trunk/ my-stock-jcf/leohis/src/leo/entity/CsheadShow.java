package leo.entity;

/**
 * CsheadShow entity. @author MyEclipse Persistence Tools
 */

public class CsheadShow implements java.io.Serializable {

	// Fields

	private Long csId;
	private String headShow;

	// Constructors

	/** default constructor */
	public CsheadShow() {
	}

	/** minimal constructor */
	public CsheadShow(Long csId) {
		this.csId = csId;
	}

	/** full constructor */
	public CsheadShow(Long csId, String headShow) {
		this.csId = csId;
		this.headShow = headShow;
	}

	// Property accessors

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getHeadShow() {
		return this.headShow;
	}

	public void setHeadShow(String headShow) {
		this.headShow = headShow;
	}

}