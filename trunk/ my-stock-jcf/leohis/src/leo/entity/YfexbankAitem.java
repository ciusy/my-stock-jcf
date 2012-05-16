package leo.entity;

import java.sql.Timestamp;

/**
 * YfexbankAitem entity. @author MyEclipse Persistence Tools
 */

public class YfexbankAitem implements java.io.Serializable {

	// Fields

	private Long itemId;
	private String aformId;
	private Integer mid;
	private Timestamp validityPeriod;
	private Integer num;
	private String unit;
	private Double preceivable;
	private Double reduceMoney;
	private Integer numReturned;
	private Double preturned;
	private Double price;
	private String approveFormId;

	// Constructors

	/** default constructor */
	public YfexbankAitem() {
	}

	/** minimal constructor */
	public YfexbankAitem(Long itemId, String aformId, Integer mid) {
		this.itemId = itemId;
		this.aformId = aformId;
		this.mid = mid;
	}

	/** full constructor */
	public YfexbankAitem(Long itemId, String aformId, Integer mid,
			Timestamp validityPeriod, Integer num, String unit,
			Double preceivable, Double reduceMoney, Integer numReturned,
			Double preturned, Double price, String approveFormId) {
		this.itemId = itemId;
		this.aformId = aformId;
		this.mid = mid;
		this.validityPeriod = validityPeriod;
		this.num = num;
		this.unit = unit;
		this.preceivable = preceivable;
		this.reduceMoney = reduceMoney;
		this.numReturned = numReturned;
		this.preturned = preturned;
		this.price = price;
		this.approveFormId = approveFormId;
	}

	// Property accessors

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
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

	public Double getPreceivable() {
		return this.preceivable;
	}

	public void setPreceivable(Double preceivable) {
		this.preceivable = preceivable;
	}

	public Double getReduceMoney() {
		return this.reduceMoney;
	}

	public void setReduceMoney(Double reduceMoney) {
		this.reduceMoney = reduceMoney;
	}

	public Integer getNumReturned() {
		return this.numReturned;
	}

	public void setNumReturned(Integer numReturned) {
		this.numReturned = numReturned;
	}

	public Double getPreturned() {
		return this.preturned;
	}

	public void setPreturned(Double preturned) {
		this.preturned = preturned;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getApproveFormId() {
		return this.approveFormId;
	}

	public void setApproveFormId(String approveFormId) {
		this.approveFormId = approveFormId;
	}

}