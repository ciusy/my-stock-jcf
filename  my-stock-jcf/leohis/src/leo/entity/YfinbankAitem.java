package leo.entity;

import java.sql.Timestamp;

/**
 * YfinbankAitem entity. @author MyEclipse Persistence Tools
 */

public class YfinbankAitem implements java.io.Serializable {

	// Fields

	private Long itemId;
	private Integer mid;
	private String approveFormId;
	private Timestamp validityPeriod;
	private Integer num;
	private String unit;
	private Double inbankP;
	private Double reduceTotal;
	private String daid;
	private Long exbankItemId;

	// Constructors

	/** default constructor */
	public YfinbankAitem() {
		this.exbankItemId = -1L;
	}

	/** minimal constructor */
	public YfinbankAitem(Integer mid, String approveFormId) {
		this.mid = mid;
		this.approveFormId = approveFormId;
	}

	/** full constructor */
	public YfinbankAitem(Integer mid, String approveFormId,
			Timestamp validityPeriod, Integer num, String unit, Double inbankP,
			Double reduceTotal, String daid, Long exbankItemId) {
		this.mid = mid;
		this.approveFormId = approveFormId;
		this.validityPeriod = validityPeriod;
		this.num = num;
		this.unit = unit;
		this.inbankP = inbankP;
		this.reduceTotal = reduceTotal;
		this.daid = daid;
		if (null == exbankItemId)
			this.exbankItemId = -1L;
		else
			this.exbankItemId = exbankItemId;
	}

	// Property accessors

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getApproveFormId() {
		return this.approveFormId;
	}

	public void setApproveFormId(String approveFormId) {
		this.approveFormId = approveFormId;
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

	public Double getInbankP() {
		return this.inbankP;
	}

	public void setInbankP(Double inbankP) {
		this.inbankP = inbankP;
	}

	public Double getReduceTotal() {
		return this.reduceTotal;
	}

	public void setReduceTotal(Double reduceTotal) {
		this.reduceTotal = reduceTotal;
	}

	public String getDaid() {
		return this.daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public Long getExbankItemId() {
		return this.exbankItemId;
	}

	public void setExbankItemId(Long exbankItemId) {
		if (null == exbankItemId) {
			this.exbankItemId = -1l;
		} else {
			this.exbankItemId = exbankItemId;
		}

	}

}