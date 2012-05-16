package leo.entity;

import java.sql.Timestamp;

/**
 * CsmedicalCardDetail entity. @author MyEclipse Persistence Tools
 */

public class CsmedicalCardDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long csId;
	private String cgId;
	private String cgItem;
	private Double amount;
	private Long receiver;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public CsmedicalCardDetail() {
	}

	/** minimal constructor */
	public CsmedicalCardDetail(Long id) {
		this.id = id;
	}

	/** full constructor */
	public CsmedicalCardDetail(Long id, Long csId, String cgId, String cgItem,
			Double amount, Long receiver, Timestamp date) {
		this.id = id;
		this.csId = csId;
		this.cgId = cgId;
		this.cgItem = cgItem;
		this.amount = amount;
		this.receiver = receiver;
		this.date = date;
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

	public String getCgId() {
		return this.cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public String getCgItem() {
		return this.cgItem;
	}

	public void setCgItem(String cgItem) {
		this.cgItem = cgItem;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}