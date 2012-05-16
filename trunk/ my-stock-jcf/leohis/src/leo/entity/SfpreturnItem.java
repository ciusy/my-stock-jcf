package leo.entity;

import java.sql.Timestamp;

/**
 * SfpreturnItem entity. @author MyEclipse Persistence Tools
 */

public class SfpreturnItem implements java.io.Serializable {

	// Fields

	private Long itemId;
	private String preturnId;
	private Integer mid;
	private Timestamp validityPeriod;
	private Integer num;
	private String unit;
	private Double exbankP;
	private Double inbankP;

	// Constructors

	/** default constructor */
	public SfpreturnItem() {
	}

	/** minimal constructor */
	public SfpreturnItem(Long itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public SfpreturnItem(Long itemId, String preturnId, Integer mid,
			Timestamp validityPeriod, Integer num, String unit, Double exbankP,
			Double inbankP) {
		this.itemId = itemId;
		this.preturnId = preturnId;
		this.mid = mid;
		this.validityPeriod = validityPeriod;
		this.num = num;
		this.unit = unit;
		this.exbankP = exbankP;
		this.inbankP = inbankP;
	}

	// Property accessors

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getPreturnId() {
		return this.preturnId;
	}

	public void setPreturnId(String preturnId) {
		this.preturnId = preturnId;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Timestamp getValidityPeriod() {
		return this.validityPeriod;
	}

	public void setValidityPeriod(Timestamp validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getExbankP() {
		return this.exbankP;
	}

	public void setExbankP(Double exbankP) {
		this.exbankP = exbankP;
	}

	public Double getInbankP() {
		return this.inbankP;
	}

	public void setInbankP(Double inbankP) {
		this.inbankP = inbankP;
	}

}