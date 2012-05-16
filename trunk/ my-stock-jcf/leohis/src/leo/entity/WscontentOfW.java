package leo.entity;

/**
 * WscontentOfW entity. @author MyEclipse Persistence Tools
 */

public class WscontentOfW implements java.io.Serializable {

	// Fields

	private Long wid;
	private Long docWid;
	private String witem;
	private String wscontent;

	// Constructors

	/** default constructor */
	public WscontentOfW() {
	}

	/** minimal constructor */
	public WscontentOfW(Long wid) {
		this.wid = wid;
	}

	/** full constructor */
	public WscontentOfW(Long wid, Long docWid, String witem, String wscontent) {
		this.wid = wid;
		this.docWid = docWid;
		this.witem = witem;
		this.wscontent = wscontent;
	}

	// Property accessors

	public Long getWid() {
		return this.wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public Long getDocWid() {
		return this.docWid;
	}

	public void setDocWid(Long docWid) {
		this.docWid = docWid;
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

}