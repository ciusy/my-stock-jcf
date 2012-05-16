package leo.entity;

/**
 * WsidocW entity. @author MyEclipse Persistence Tools
 */

public class WsidocW implements java.io.Serializable {

	// Fields

	private Long itemDocWid;
	private String itemName;
	private String akind;
	private String kindId;
	private Long csId;
	private Integer executeU;
	private String docNum;
	private Integer dneu;
	private String docStorage;
	private Integer periodOfKeep;
	private String status;

	// Constructors

	/** default constructor */
	public WsidocW() {
	}

	/** minimal constructor */
	public WsidocW(Long itemDocWid) {
		this.itemDocWid = itemDocWid;
	}

	/** full constructor */
	public WsidocW(Long itemDocWid, String itemName, String akind,
			String kindId, Long csId, Integer executeU, String docNum,
			Integer dneu, String docStorage, Integer periodOfKeep, String status) {
		this.itemDocWid = itemDocWid;
		this.itemName = itemName;
		this.akind = akind;
		this.kindId = kindId;
		this.csId = csId;
		this.executeU = executeU;
		this.docNum = docNum;
		this.dneu = dneu;
		this.docStorage = docStorage;
		this.periodOfKeep = periodOfKeep;
		this.status = status;
	}

	// Property accessors

	public Long getItemDocWid() {
		return this.itemDocWid;
	}

	public void setItemDocWid(Long itemDocWid) {
		this.itemDocWid = itemDocWid;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAkind() {
		return this.akind;
	}

	public void setAkind(String akind) {
		this.akind = akind;
	}

	public String getKindId() {
		return this.kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getDocNum() {
		return this.docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public Integer getDneu() {
		return this.dneu;
	}

	public void setDneu(Integer dneu) {
		this.dneu = dneu;
	}

	public String getDocStorage() {
		return this.docStorage;
	}

	public void setDocStorage(String docStorage) {
		this.docStorage = docStorage;
	}

	public Integer getPeriodOfKeep() {
		return this.periodOfKeep;
	}

	public void setPeriodOfKeep(Integer periodOfKeep) {
		this.periodOfKeep = periodOfKeep;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}