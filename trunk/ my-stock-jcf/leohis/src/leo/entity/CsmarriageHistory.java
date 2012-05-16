package leo.entity;

import java.sql.Timestamp;

/**
 * CsmarriageHistory entity. @author MyEclipse Persistence Tools
 */

public class CsmarriageHistory implements java.io.Serializable {

	// Fields

	private Long id;
	private Long csId;
	private String marriageHistory;
	private String marriageStatus;
	private Timestamp marriageDates;
	private String spouseIdcard;
	private Boolean intermarriqeornot;

	// Constructors

	/** default constructor */
	public CsmarriageHistory() {
	}

	/** minimal constructor */
	public CsmarriageHistory(Long id) {
		this.id = id;
	}

	/** full constructor */
	public CsmarriageHistory(Long id, Long csId, String marriageHistory,
			String marriageStatus, Timestamp marriageDates,
			String spouseIdcard, Boolean intermarriqeornot) {
		this.id = id;
		this.csId = csId;
		this.marriageHistory = marriageHistory;
		this.marriageStatus = marriageStatus;
		this.marriageDates = marriageDates;
		this.spouseIdcard = spouseIdcard;
		this.intermarriqeornot = intermarriqeornot;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getMarriageHistory() {
		return this.marriageHistory;
	}

	public void setMarriageHistory(String marriageHistory) {
		this.marriageHistory = marriageHistory;
	}

	public String getMarriageStatus() {
		return this.marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public Timestamp getMarriageDates() {
		return this.marriageDates;
	}

	public void setMarriageDates(Timestamp marriageDates) {
		this.marriageDates = marriageDates;
	}

	public String getSpouseIdcard() {
		return this.spouseIdcard;
	}

	public void setSpouseIdcard(String spouseIdcard) {
		this.spouseIdcard = spouseIdcard;
	}

	public Boolean getIntermarriqeornot() {
		return this.intermarriqeornot;
	}

	public void setIntermarriqeornot(Boolean intermarriqeornot) {
		this.intermarriqeornot = intermarriqeornot;
	}

}