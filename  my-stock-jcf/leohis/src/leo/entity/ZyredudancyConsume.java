package leo.entity;

import java.sql.Timestamp;

/**
 * ZyredudancyConsume entity. @author MyEclipse Persistence Tools
 */

public class ZyredudancyConsume implements java.io.Serializable {

	// Fields

	private Long consumeId;
	private String ipid;
	private String consumeItem;
	private Integer itemId;
	private Double charge;
	private Timestamp zytime;
	private Integer ipdeptId;

	// Constructors

	/** default constructor */
	public ZyredudancyConsume() {
	}

	/** minimal constructor */
	public ZyredudancyConsume(Long consumeId) {
		this.consumeId = consumeId;
	}

	/** full constructor */
	public ZyredudancyConsume(Long consumeId, String ipid, String consumeItem,
			Integer itemId, Double charge, Timestamp zytime, Integer ipdeptId) {
		this.consumeId = consumeId;
		this.ipid = ipid;
		this.consumeItem = consumeItem;
		this.itemId = itemId;
		this.charge = charge;
		this.zytime = zytime;
		this.ipdeptId = ipdeptId;
	}

	// Property accessors

	public Long getConsumeId() {
		return this.consumeId;
	}

	public void setConsumeId(Long consumeId) {
		this.consumeId = consumeId;
	}

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public String getConsumeItem() {
		return this.consumeItem;
	}

	public void setConsumeItem(String consumeItem) {
		this.consumeItem = consumeItem;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Double getCharge() {
		return this.charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Timestamp getZytime() {
		return this.zytime;
	}

	public void setZytime(Timestamp zytime) {
		this.zytime = zytime;
	}

	public Integer getIpdeptId() {
		return this.ipdeptId;
	}

	public void setIpdeptId(Integer ipdeptId) {
		this.ipdeptId = ipdeptId;
	}

}