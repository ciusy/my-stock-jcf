package leo.entity;

/**
 * WsdocWframework entity. @author MyEclipse Persistence Tools
 */

public class WsdocWframework implements java.io.Serializable {

	// Fields

	private Long mwid;
	private String witem;
	private String wscontent;
	private Long docId;

	// Constructors

	/** default constructor */
	public WsdocWframework() {
	}

	/** minimal constructor */
	public WsdocWframework(Long mwid) {
		this.mwid = mwid;
	}

	/** full constructor */
	public WsdocWframework(Long mwid, String witem, String wscontent, Long docId) {
		this.mwid = mwid;
		this.witem = witem;
		this.wscontent = wscontent;
		this.docId = docId;
	}

	// Property accessors

	public Long getMwid() {
		return this.mwid;
	}

	public void setMwid(Long mwid) {
		this.mwid = mwid;
	}

	public String getWitem() {
		return this.witem;
	}

	public void setWitem(String witem) {
		this.witem = witem;
	}

	public String getWscontent() {
		return this.wscontent;
	}

	public void setWscontent(String wscontent) {
		this.wscontent = wscontent;
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

}