package leo.entity;

import java.sql.Timestamp;

/**
 * WsvisitRemind entity. @author MyEclipse Persistence Tools
 */

public class WsvisitRemind implements java.io.Serializable {

	// Fields

	private Long docWid;
	private Long cofRemind;
	private Long sreminded;
	private Timestamp remindTime;
	private Timestamp expectingTime;
	private Integer executeU;
	private String stel;
	private String semail;
	private String ctel;
	private String cemail;

	// Constructors

	/** default constructor */
	public WsvisitRemind() {
	}

	/** minimal constructor */
	public WsvisitRemind(Long docWid) {
		this.docWid = docWid;
	}

	/** full constructor */
	public WsvisitRemind(Long docWid, Long cofRemind, Long sreminded,
			Timestamp remindTime, Timestamp expectingTime, Integer executeU,
			String stel, String semail, String ctel, String cemail) {
		this.docWid = docWid;
		this.cofRemind = cofRemind;
		this.sreminded = sreminded;
		this.remindTime = remindTime;
		this.expectingTime = expectingTime;
		this.executeU = executeU;
		this.stel = stel;
		this.semail = semail;
		this.ctel = ctel;
		this.cemail = cemail;
	}

	// Property accessors

	public Long getDocWid() {
		return this.docWid;
	}

	public void setDocWid(Long docWid) {
		this.docWid = docWid;
	}

	public Long getCofRemind() {
		return this.cofRemind;
	}

	public void setCofRemind(Long cofRemind) {
		this.cofRemind = cofRemind;
	}

	public Long getSreminded() {
		return this.sreminded;
	}

	public void setSreminded(Long sreminded) {
		this.sreminded = sreminded;
	}

	public Timestamp getRemindTime() {
		return this.remindTime;
	}

	public void setRemindTime(Timestamp remindTime) {
		this.remindTime = remindTime;
	}

	public Timestamp getExpectingTime() {
		return this.expectingTime;
	}

	public void setExpectingTime(Timestamp expectingTime) {
		this.expectingTime = expectingTime;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getStel() {
		return this.stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getSemail() {
		return this.semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getCtel() {
		return this.ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCemail() {
		return this.cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

}