package leo.entity;

import java.sql.Timestamp;

/**
 * OsloginRecord entity. @author MyEclipse Persistence Tools
 */

public class OsloginRecord implements java.io.Serializable {

	// Fields

	private Long loginRecordId;
	private Long sid;
	private Timestamp loginTime;
	private String loginIp;

	// Constructors

	/** default constructor */
	public OsloginRecord() {
	}

	/** minimal constructor */
	public OsloginRecord(Long loginRecordId) {
		this.loginRecordId = loginRecordId;
	}

	/** full constructor */
	public OsloginRecord(Long loginRecordId, Long sid, Timestamp loginTime,
			String loginIp) {
		this.loginRecordId = loginRecordId;
		this.sid = sid;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
	}

	// Property accessors

	public Long getLoginRecordId() {
		return this.loginRecordId;
	}

	public void setLoginRecordId(Long loginRecordId) {
		this.loginRecordId = loginRecordId;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

}