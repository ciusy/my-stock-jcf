package leo.entity;

import java.sql.Timestamp;

/**
 * GhloInvoice entity. @author MyEclipse Persistence Tools
 */

public class GhloInvoice implements java.io.Serializable {

	// Fields

	private String opnum;
	private Integer rtid;
	private Long csId;
	private String ritemName;
	private Double rePrice;
	private Boolean expertOrNot;
	private Long rexpert;
	private Integer ruid;
	private Long registrar;
	private Timestamp rtime;
	private String rstatus;
	private Double realP;
	private String invoiceId;
	private String rchangeStatus;

	// Constructors

	/** default constructor */
	public GhloInvoice() {
	}

	/** minimal constructor */
	public GhloInvoice(String opnum, Long csId) {
		this.opnum = opnum;
		this.csId = csId;
	}

	/** full constructor */
	public GhloInvoice(String opnum, Integer rtid, Long csId, String ritemName,
			Double rePrice, Boolean expertOrNot, Long rexpert, Integer ruid,
			Long registrar, Timestamp rtime, String rstatus, Double realP,
			String invoiceId, String rchangeStatus) {
		this.opnum = opnum;
		this.rtid = rtid;
		this.csId = csId;
		this.ritemName = ritemName;
		this.rePrice = rePrice;
		this.expertOrNot = expertOrNot;
		this.rexpert = rexpert;
		this.ruid = ruid;
		this.registrar = registrar;
		this.rtime = rtime;
		this.rstatus = rstatus;
		this.realP = realP;
		this.invoiceId = invoiceId;
		this.rchangeStatus = rchangeStatus;
	}

	// Property accessors

	public String getOpnum() {
		return this.opnum;
	}

	public void setOpnum(String opnum) {
		this.opnum = opnum;
	}

	public Integer getRtid() {
		return this.rtid;
	}

	public void setRtid(Integer rtid) {
		this.rtid = rtid;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getRitemName() {
		return this.ritemName;
	}

	public void setRitemName(String ritemName) {
		this.ritemName = ritemName;
	}

	public Double getRePrice() {
		return this.rePrice;
	}

	public void setRePrice(Double rePrice) {
		this.rePrice = rePrice;
	}

	public Boolean getExpertOrNot() {
		return this.expertOrNot;
	}

	public void setExpertOrNot(Boolean expertOrNot) {
		this.expertOrNot = expertOrNot;
	}

	public Long getRexpert() {
		return this.rexpert;
	}

	public void setRexpert(Long rexpert) {
		this.rexpert = rexpert;
	}

	public Integer getRuid() {
		return this.ruid;
	}

	public void setRuid(Integer ruid) {
		this.ruid = ruid;
	}

	public Long getRegistrar() {
		return this.registrar;
	}

	public void setRegistrar(Long registrar) {
		this.registrar = registrar;
	}

	public Timestamp getRtime() {
		return this.rtime;
	}

	public void setRtime(Timestamp rtime) {
		this.rtime = rtime;
	}

	public String getRstatus() {
		return this.rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public Double getRealP() {
		return this.realP;
	}

	public void setRealP(Double realP) {
		this.realP = realP;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getRchangeStatus() {
		return this.rchangeStatus;
	}

	public void setRchangeStatus(String rchangeStatus) {
		this.rchangeStatus = rchangeStatus;
	}

}