package leo.entity;

import java.sql.Timestamp;

/**
 * GydisinfectPackUseRe entity. @author MyEclipse Persistence Tools
 */

public class GydisinfectPackUseRe implements java.io.Serializable {

	// Fields

	private Long useId;
	private Integer disinfectPackId;
	private Integer useU;
	private Double amount;
	private Boolean returnOrNot;
	private Timestamp bespeakTime;
	private Timestamp drawTime;
	private Timestamp returnTime;
	private Integer disinfectPackUid;

	// Constructors

	/** default constructor */
	public GydisinfectPackUseRe() {
	}

	/** minimal constructor */
	public GydisinfectPackUseRe(Long useId) {
		this.useId = useId;
	}

	/** full constructor */
	public GydisinfectPackUseRe(Long useId, Integer disinfectPackId,
			Integer useU, Double amount, Boolean returnOrNot,
			Timestamp bespeakTime, Timestamp drawTime, Timestamp returnTime,
			Integer disinfectPackUid) {
		this.useId = useId;
		this.disinfectPackId = disinfectPackId;
		this.useU = useU;
		this.amount = amount;
		this.returnOrNot = returnOrNot;
		this.bespeakTime = bespeakTime;
		this.drawTime = drawTime;
		this.returnTime = returnTime;
		this.disinfectPackUid = disinfectPackUid;
	}

	// Property accessors

	public Long getUseId() {
		return this.useId;
	}

	public void setUseId(Long useId) {
		this.useId = useId;
	}

	public Integer getDisinfectPackId() {
		return this.disinfectPackId;
	}

	public void setDisinfectPackId(Integer disinfectPackId) {
		this.disinfectPackId = disinfectPackId;
	}

	public Integer getUseU() {
		return this.useU;
	}

	public void setUseU(Integer useU) {
		this.useU = useU;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getReturnOrNot() {
		return this.returnOrNot;
	}

	public void setReturnOrNot(Boolean returnOrNot) {
		this.returnOrNot = returnOrNot;
	}

	public Timestamp getBespeakTime() {
		return this.bespeakTime;
	}

	public void setBespeakTime(Timestamp bespeakTime) {
		this.bespeakTime = bespeakTime;
	}

	public Timestamp getDrawTime() {
		return this.drawTime;
	}

	public void setDrawTime(Timestamp drawTime) {
		this.drawTime = drawTime;
	}

	public Timestamp getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}

	public Integer getDisinfectPackUid() {
		return this.disinfectPackUid;
	}

	public void setDisinfectPackUid(Integer disinfectPackUid) {
		this.disinfectPackUid = disinfectPackUid;
	}

}