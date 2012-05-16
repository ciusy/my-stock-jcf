package leo.entity;

import java.sql.Timestamp;

/**
 * Ghregister entity. @author MyEclipse Persistence Tools
 */

public class Ghregister implements java.io.Serializable {

	// Fields

	private String opnum;
	private Integer rtid;
	private String rpname;
	private Boolean expertOrNot;
	private Long sid;
	private Long csId;
	private Integer costTypeId;
	private Integer ru;
	private Long registrar;
	private Timestamp rtime;
	private String rstatus;
	private Double realPrice;
	private Double receivablePrice;
	private String ifCg;

	// Constructors

	/** default constructor */
	public Ghregister() {
	}

	/** minimal constructor */
	public Ghregister(String opnum) {
		this.opnum = opnum;
	}

	/** full constructor */
	public Ghregister(String opnum, Integer rtid, String rpname,
			Boolean expertOrNot, Long sid, Long csId, Integer costTypeId,
			Integer ru, Long registrar, Timestamp rtime, String rstatus,
			Double realPrice, Double receivablePrice, String ifCg) {
		this.opnum = opnum;
		this.rtid = rtid;
		this.rpname = rpname;
		this.expertOrNot = expertOrNot;
		this.sid = sid;
		this.csId = csId;
		this.costTypeId = costTypeId;
		this.ru = ru;
		this.registrar = registrar;
		this.rtime = rtime;
		this.rstatus = rstatus;
		this.realPrice = realPrice;
		this.receivablePrice = receivablePrice;
		this.ifCg = ifCg;
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

	public String getRpname() {
		return this.rpname;
	}

	public void setRpname(String rpname) {
		this.rpname = rpname;
	}

	public Boolean getExpertOrNot() {
		return this.expertOrNot;
	}

	public void setExpertOrNot(Boolean expertOrNot) {
		this.expertOrNot = expertOrNot;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Integer getCostTypeId() {
		return this.costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public Integer getRu() {
		return this.ru;
	}

	public void setRu(Integer ru) {
		this.ru = ru;
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

	public Double getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}

	public Double getReceivablePrice() {
		return this.receivablePrice;
	}

	public void setReceivablePrice(Double receivablePrice) {
		this.receivablePrice = receivablePrice;
	}

	public String getIfCg() {
		return this.ifCg;
	}

	public void setIfCg(String ifCg) {
		this.ifCg = ifCg;
	}

}