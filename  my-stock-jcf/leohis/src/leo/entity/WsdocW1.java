package leo.entity;

import java.sql.Timestamp;

/**
 * WsdocW1 entity. @author MyEclipse Persistence Tools
 */

public class WsdocW1 implements java.io.Serializable {

	// Fields

	private Long wid;
	private Long docWID;
	private Long cid;
	private Long docId;
	private Long docWriter;
	private Integer writeU;
	private Timestamp writeTime;
	private Long mdocId;
	private String note;
	private String xmlpath;
	private String wscontent;
	// Constructors
	/** default constructor */
	public WsdocW1() {
	}

	/** minimal constructor */
	public WsdocW1(Long wid) {
		this.wid = wid;
	}

	// Property accessors

	public Long getWid() {
		return this.wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public Long getDocWID() {
		return docWID;
	}

	public void setDocWID(Long docWID) {
		this.docWID = docWID;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getDocWriter() {
		return this.docWriter;
	}

	public void setDocWriter(Long docWriter) {
		this.docWriter = docWriter;
	}

	public Integer getWriteU() {
		return this.writeU;
	}

	public void setWriteU(Integer writeU) {
		this.writeU = writeU;
	}

	public Timestamp getWriteTime() {
		return this.writeTime;
	}

	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
	}

	public Long getMdocId() {
		return this.mdocId;
	}

	public void setMdocId(Long mdocId) {
		this.mdocId = mdocId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getXmlpath() {
		return this.xmlpath;
	}

	public void setXmlpath(String xmlpath) {
		this.xmlpath = xmlpath;
	}

	public String getWscontent() {
		return this.wscontent;
	}

	public void setWscontent(String wscontent) {
		this.wscontent = wscontent;
	}

}