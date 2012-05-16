package leo.entity;

import java.sql.Timestamp;

/**
 * Agreement entity. @author MyEclipse Persistence Tools
 */

public class Agreement implements java.io.Serializable {

	// Fields

	private String recordId;
	private String msignature;
	private Timestamp mdate;
	private String wsignature;
	private Timestamp wdate;
	private String ssignature;
	private Timestamp sdate;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public Agreement() {
	}

	/** minimal constructor */
	public Agreement(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public Agreement(String recordId, String msignature, Timestamp mdate,
			String wsignature, Timestamp wdate, String ssignature,
			Timestamp sdate, Long stuffId) {
		this.recordId = recordId;
		this.msignature = msignature;
		this.mdate = mdate;
		this.wsignature = wsignature;
		this.wdate = wdate;
		this.ssignature = ssignature;
		this.sdate = sdate;
		this.stuffId = stuffId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getMsignature() {
		return this.msignature;
	}

	public void setMsignature(String msignature) {
		this.msignature = msignature;
	}

	public Timestamp getMdate() {
		return this.mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}

	public String getWsignature() {
		return this.wsignature;
	}

	public void setWsignature(String wsignature) {
		this.wsignature = wsignature;
	}

	public Timestamp getWdate() {
		return this.wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public String getSsignature() {
		return this.ssignature;
	}

	public void setSsignature(String ssignature) {
		this.ssignature = ssignature;
	}

	public Timestamp getSdate() {
		return this.sdate;
	}

	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}

	public Long getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

}