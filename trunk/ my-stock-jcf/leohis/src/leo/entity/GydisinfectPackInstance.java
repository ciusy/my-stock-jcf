package leo.entity;

import java.sql.Timestamp;

/**
 * GydisinfectPackInstance entity. @author MyEclipse Persistence Tools
 */

public class GydisinfectPackInstance implements java.io.Serializable {

	// Fields

	private Integer disinfectPackId;
	private Integer disinfectId;
	private Integer udisinfectPackIn;
	private String disinfectPackStatus;
	private Integer ubespeak;
	private Timestamp disinfectPackEsTime;
	private Integer disinfectPackOfficeId;

	// Constructors

	/** default constructor */
	public GydisinfectPackInstance() {
	}

	/** minimal constructor */
	public GydisinfectPackInstance(Integer disinfectPackId) {
		this.disinfectPackId = disinfectPackId;
	}

	/** full constructor */
	public GydisinfectPackInstance(Integer disinfectPackId,
			Integer disinfectId, Integer udisinfectPackIn,
			String disinfectPackStatus, Integer ubespeak,
			Timestamp disinfectPackEsTime, Integer disinfectPackOfficeId) {
		this.disinfectPackId = disinfectPackId;
		this.disinfectId = disinfectId;
		this.udisinfectPackIn = udisinfectPackIn;
		this.disinfectPackStatus = disinfectPackStatus;
		this.ubespeak = ubespeak;
		this.disinfectPackEsTime = disinfectPackEsTime;
		this.disinfectPackOfficeId = disinfectPackOfficeId;
	}

	// Property accessors

	public Integer getDisinfectPackId() {
		return this.disinfectPackId;
	}

	public void setDisinfectPackId(Integer disinfectPackId) {
		this.disinfectPackId = disinfectPackId;
	}

	public Integer getDisinfectId() {
		return this.disinfectId;
	}

	public void setDisinfectId(Integer disinfectId) {
		this.disinfectId = disinfectId;
	}

	public Integer getUdisinfectPackIn() {
		return this.udisinfectPackIn;
	}

	public void setUdisinfectPackIn(Integer udisinfectPackIn) {
		this.udisinfectPackIn = udisinfectPackIn;
	}

	public String getDisinfectPackStatus() {
		return this.disinfectPackStatus;
	}

	public void setDisinfectPackStatus(String disinfectPackStatus) {
		this.disinfectPackStatus = disinfectPackStatus;
	}

	public Integer getUbespeak() {
		return this.ubespeak;
	}

	public void setUbespeak(Integer ubespeak) {
		this.ubespeak = ubespeak;
	}

	public Timestamp getDisinfectPackEsTime() {
		return this.disinfectPackEsTime;
	}

	public void setDisinfectPackEsTime(Timestamp disinfectPackEsTime) {
		this.disinfectPackEsTime = disinfectPackEsTime;
	}

	public Integer getDisinfectPackOfficeId() {
		return this.disinfectPackOfficeId;
	}

	public void setDisinfectPackOfficeId(Integer disinfectPackOfficeId) {
		this.disinfectPackOfficeId = disinfectPackOfficeId;
	}

}