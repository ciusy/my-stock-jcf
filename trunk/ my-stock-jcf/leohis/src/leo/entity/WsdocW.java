package leo.entity;

import java.sql.Timestamp;

/**
 * WsdocW entity. @author MyEclipse Persistence Tools
 */

public class WsdocW implements java.io.Serializable {

	// Fields

	private Long docWid;
	private Long itemDocWid;
	private Integer wsorder;
	private Long docId;
	private Timestamp wtime;
	private String wstatus;

	// Constructors

	/** default constructor */
	public WsdocW() {
	}

	/** minimal constructor */
	public WsdocW(Long docWid) {
		this.docWid = docWid;
	}

	/** full constructor */
	public WsdocW(Long docWid, Long itemDocWid, Integer wsorder, Long docId,
			Timestamp wtime, String wstatus) {
		this.docWid = docWid;
		this.itemDocWid = itemDocWid;
		this.wsorder = wsorder;
		this.docId = docId;
		this.wtime = wtime;
		this.wstatus = wstatus;
	}

	// Property accessors

	public Long getDocWid() {
		return this.docWid;
	}

	public void setDocWid(Long docWid) {
		this.docWid = docWid;
	}

	public Long getItemDocWid() {
		return this.itemDocWid;
	}

	public void setItemDocWid(Long itemDocWid) {
		this.itemDocWid = itemDocWid;
	}

	public Integer getWsorder() {
		return this.wsorder;
	}

	public void setWsorder(Integer wsorder) {
		this.wsorder = wsorder;
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Timestamp getWtime() {
		return this.wtime;
	}

	public void setWtime(Timestamp wtime) {
		this.wtime = wtime;
	}

	public String getWstatus() {
		return this.wstatus;
	}

	public void setWstatus(String wstatus) {
		this.wstatus = wstatus;
	}

}