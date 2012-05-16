package leo.entity;

import java.sql.Timestamp;

/**
 * Sfscharge entity. @author MyEclipse Persistence Tools
 */

public class Sfscharge implements java.io.Serializable {

	// Fields

	private Long chargeObjectId;
	private Long sid;
	private Integer uid;
	private String tableName;
	private String billId;
	private Double amount;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Sfscharge() {
	}

	/** minimal constructor */
	public Sfscharge(Long chargeObjectId) {
		this.chargeObjectId = chargeObjectId;
	}

	/** full constructor */
	public Sfscharge(Long chargeObjectId, Long sid, Integer uid,
			String tableName, String billId, Double amount, Timestamp date) {
		this.chargeObjectId = chargeObjectId;
		this.sid = sid;
		this.uid = uid;
		this.tableName = tableName;
		this.billId = billId;
		this.amount = amount;
		this.date = date;
	}

	// Property accessors

	public Long getChargeObjectId() {
		return this.chargeObjectId;
	}

	public void setChargeObjectId(Long chargeObjectId) {
		this.chargeObjectId = chargeObjectId;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBillId() {
		return this.billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}