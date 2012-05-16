package leo.entity;

import java.sql.Timestamp;

/**
 * SfdisposeReturnP entity. @author MyEclipse Persistence Tools
 */

public class SfdisposeReturnP implements java.io.Serializable {

	// Fields

	private String itemId;
	private Long returnPpeople;
	private Timestamp returnPtime;
	private Integer returnPu;
	private Double returnPamount;

	// Constructors

	/** default constructor */
	public SfdisposeReturnP() {
	}

	/** minimal constructor */
	public SfdisposeReturnP(String itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public SfdisposeReturnP(String itemId, Long returnPpeople,
			Timestamp returnPtime, Integer returnPu, Double returnPamount) {
		this.itemId = itemId;
		this.returnPpeople = returnPpeople;
		this.returnPtime = returnPtime;
		this.returnPu = returnPu;
		this.returnPamount = returnPamount;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getReturnPpeople() {
		return this.returnPpeople;
	}

	public void setReturnPpeople(Long returnPpeople) {
		this.returnPpeople = returnPpeople;
	}

	public Timestamp getReturnPtime() {
		return this.returnPtime;
	}

	public void setReturnPtime(Timestamp returnPtime) {
		this.returnPtime = returnPtime;
	}

	public Integer getReturnPu() {
		return this.returnPu;
	}

	public void setReturnPu(Integer returnPu) {
		this.returnPu = returnPu;
	}

	public Double getReturnPamount() {
		return this.returnPamount;
	}

	public void setReturnPamount(Double returnPamount) {
		this.returnPamount = returnPamount;
	}

}