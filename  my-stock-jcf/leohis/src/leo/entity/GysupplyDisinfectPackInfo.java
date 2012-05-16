package leo.entity;

/**
 * GysupplyDisinfectPackInfo entity. @author MyEclipse Persistence Tools
 */

public class GysupplyDisinfectPackInfo implements java.io.Serializable {

	// Fields

	private Integer disinfectId;
	private String disinfectPackName;
	private String contentDisc;
	private String note;
	private Double ponceUse;
	private Integer disinfectUid;

	// Constructors

	/** default constructor */
	public GysupplyDisinfectPackInfo() {
	}

	/** minimal constructor */
	public GysupplyDisinfectPackInfo(Integer disinfectId) {
		this.disinfectId = disinfectId;
	}

	/** full constructor */
	public GysupplyDisinfectPackInfo(Integer disinfectId,
			String disinfectPackName, String contentDisc, String note,
			Double ponceUse, Integer disinfectUid) {
		this.disinfectId = disinfectId;
		this.disinfectPackName = disinfectPackName;
		this.contentDisc = contentDisc;
		this.note = note;
		this.ponceUse = ponceUse;
		this.disinfectUid = disinfectUid;
	}

	// Property accessors

	public Integer getDisinfectId() {
		return this.disinfectId;
	}

	public void setDisinfectId(Integer disinfectId) {
		this.disinfectId = disinfectId;
	}

	public String getDisinfectPackName() {
		return this.disinfectPackName;
	}

	public void setDisinfectPackName(String disinfectPackName) {
		this.disinfectPackName = disinfectPackName;
	}

	public String getContentDisc() {
		return this.contentDisc;
	}

	public void setContentDisc(String contentDisc) {
		this.contentDisc = contentDisc;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getPonceUse() {
		return this.ponceUse;
	}

	public void setPonceUse(Double ponceUse) {
		this.ponceUse = ponceUse;
	}

	public Integer getDisinfectUid() {
		return this.disinfectUid;
	}

	public void setDisinfectUid(Integer disinfectUid) {
		this.disinfectUid = disinfectUid;
	}

}