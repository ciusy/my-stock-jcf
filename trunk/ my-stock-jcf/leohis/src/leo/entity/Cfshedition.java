package leo.entity;

import java.sql.Timestamp;

/**
 * Cfshedition entity. @author MyEclipse Persistence Tools
 */

public class Cfshedition implements java.io.Serializable {

	// Fields

	private String editionNum;
	private String editionShow;
	private Timestamp changeTime;
	private String changer;

	// Constructors

	/** default constructor */
	public Cfshedition() {
	}

	/** minimal constructor */
	public Cfshedition(String editionNum) {
		this.editionNum = editionNum;
	}

	/** full constructor */
	public Cfshedition(String editionNum, String editionShow,
			Timestamp changeTime, String changer) {
		this.editionNum = editionNum;
		this.editionShow = editionShow;
		this.changeTime = changeTime;
		this.changer = changer;
	}

	// Property accessors

	public String getEditionNum() {
		return this.editionNum;
	}

	public void setEditionNum(String editionNum) {
		this.editionNum = editionNum;
	}

	public String getEditionShow() {
		return this.editionShow;
	}

	public void setEditionShow(String editionShow) {
		this.editionShow = editionShow;
	}

	public Timestamp getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

	public String getChanger() {
		return this.changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}

}