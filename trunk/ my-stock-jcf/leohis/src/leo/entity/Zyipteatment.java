package leo.entity;

/**
 * Zyipteatment entity. @author MyEclipse Persistence Tools
 */

public class Zyipteatment implements java.io.Serializable {

	// Fields

	private Long daitemId;
	private String daid;
	private String status;
	private Integer timesExecuted;
	private Integer itemTypeId;
	private Integer executeU;
	private String itemId;
	private String acontent;

	// Constructors

	/** default constructor */
	public Zyipteatment() {
	}

	/** minimal constructor */
	public Zyipteatment(Long daitemId) {
		this.daitemId = daitemId;
	}

	/** full constructor */
	public Zyipteatment(Long daitemId, String daid, String status,
			Integer timesExecuted, Integer itemTypeId, Integer executeU,
			String itemId, String acontent) {
		this.daitemId = daitemId;
		this.daid = daid;
		this.status = status;
		this.timesExecuted = timesExecuted;
		this.itemTypeId = itemTypeId;
		this.executeU = executeU;
		this.itemId = itemId;
		this.acontent = acontent;
	}

	// Property accessors

	public Long getDaitemId() {
		return this.daitemId;
	}

	public void setDaitemId(Long daitemId) {
		this.daitemId = daitemId;
	}

	public String getDaid() {
		return this.daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTimesExecuted() {
		return this.timesExecuted;
	}

	public void setTimesExecuted(Integer timesExecuted) {
		this.timesExecuted = timesExecuted;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAcontent() {
		return this.acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

}