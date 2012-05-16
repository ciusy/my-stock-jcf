package leo.entity;

import java.sql.Timestamp;

/**
 * SfzyinvoiceHead entity. @author MyEclipse Persistence Tools
 */

public class SfzyinvoiceHead implements java.io.Serializable {

	// Fields

	private Long invoiceNo;
	private Timestamp invoiceTime;
	private Long consumerId;
	private Double money;
	private String uppcaseMoeny;
	private Long cashierId;
	private String outpatientId;
	private Boolean isCancel;
	private Long originalInvoiceNo;
	private Integer medOrgId;
	private Integer uid;
	private Integer costType;

	// Constructors

	/** default constructor */
	public SfzyinvoiceHead() {
	}

	/** minimal constructor */
	public SfzyinvoiceHead(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/** full constructor */
	public SfzyinvoiceHead(Long invoiceNo, Timestamp invoiceTime,
			Long consumerId, Double money, String uppcaseMoeny, Long cashierId,
			String outpatientId, Boolean isCancel, Long originalInvoiceNo,
			Integer medOrgId, Integer uid, Integer costType) {
		this.invoiceNo = invoiceNo;
		this.invoiceTime = invoiceTime;
		this.consumerId = consumerId;
		this.money = money;
		this.uppcaseMoeny = uppcaseMoeny;
		this.cashierId = cashierId;
		this.outpatientId = outpatientId;
		this.isCancel = isCancel;
		this.originalInvoiceNo = originalInvoiceNo;
		this.medOrgId = medOrgId;
		this.uid = uid;
		this.costType = costType;
	}

	// Property accessors

	public Long getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Timestamp getInvoiceTime() {
		return this.invoiceTime;
	}

	public void setInvoiceTime(Timestamp invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public Long getConsumerId() {
		return this.consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getUppcaseMoeny() {
		return this.uppcaseMoeny;
	}

	public void setUppcaseMoeny(String uppcaseMoeny) {
		this.uppcaseMoeny = uppcaseMoeny;
	}

	public Long getCashierId() {
		return this.cashierId;
	}

	public void setCashierId(Long cashierId) {
		this.cashierId = cashierId;
	}

	public String getOutpatientId() {
		return this.outpatientId;
	}

	public void setOutpatientId(String outpatientId) {
		this.outpatientId = outpatientId;
	}

	public Boolean getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(Boolean isCancel) {
		this.isCancel = isCancel;
	}

	public Long getOriginalInvoiceNo() {
		return this.originalInvoiceNo;
	}

	public void setOriginalInvoiceNo(Long originalInvoiceNo) {
		this.originalInvoiceNo = originalInvoiceNo;
	}

	public Integer getMedOrgId() {
		return this.medOrgId;
	}

	public void setMedOrgId(Integer medOrgId) {
		this.medOrgId = medOrgId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getCostType() {
		return this.costType;
	}

	public void setCostType(Integer costType) {
		this.costType = costType;
	}

}