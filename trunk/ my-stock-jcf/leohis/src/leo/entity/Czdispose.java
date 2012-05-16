package leo.entity;

import java.sql.Timestamp;

/**
 * Czdispose entity. @author MyEclipse Persistence Tools
 */

public class Czdispose implements java.io.Serializable {

	// Fields

	private String itemId;
	private Integer itemTypeId;
	private Integer au;
	private Long aproposer;
	private Timestamp atime;
	private Long csId;
	private String akind;
	private String kindId;
	private String explain;
	private String status;
	private Double receivableP;
	private Double realP;
	private Integer fnBlockId;
	private Long executePerson;
	private Timestamp executeTime;
	private Integer executeU;
	private String resultTable;
	private String note;
	private Integer csu;
	private Integer costTypeId;
	private String lis;

	// Constructors

	/** default constructor */
	public Czdispose() {
	}

	/** minimal constructor */
	public Czdispose(String itemId) {
		this.itemId = itemId;
	}

	/** full constructor */
	public Czdispose(String itemId, Integer itemTypeId, Integer au,
			Long aproposer, Timestamp atime, Long csId, String akind,
			String kindId, String explain, String status, Double receivableP,
			Double realP, Integer fnBlockId, Long executePerson,
			Timestamp executeTime, Integer executeU, String resultTable,
			String note, Integer csu, Integer costTypeId, String lis) {
		this.itemId = itemId;
		this.itemTypeId = itemTypeId;
		this.au = au;
		this.aproposer = aproposer;
		this.atime = atime;
		this.csId = csId;
		this.akind = akind;
		this.kindId = kindId;
		this.explain = explain;
		this.status = status;
		this.receivableP = receivableP;
		this.realP = realP;
		this.fnBlockId = fnBlockId;
		this.executePerson = executePerson;
		this.executeTime = executeTime;
		this.executeU = executeU;
		this.resultTable = resultTable;
		this.note = note;
		this.csu = csu;
		this.costTypeId = costTypeId;
		this.lis = lis;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Integer getAu() {
		return this.au;
	}

	public void setAu(Integer au) {
		this.au = au;
	}

	public Long getAproposer() {
		return this.aproposer;
	}

	public void setAproposer(Long aproposer) {
		this.aproposer = aproposer;
	}

	public Timestamp getAtime() {
		return this.atime;
	}

	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
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

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getReceivableP() {
		return this.receivableP;
	}

	public void setReceivableP(Double receivableP) {
		this.receivableP = receivableP;
	}

	public Double getRealP() {
		return this.realP;
	}

	public void setRealP(Double realP) {
		this.realP = realP;
	}

	public Integer getFnBlockId() {
		return this.fnBlockId;
	}

	public void setFnBlockId(Integer fnBlockId) {
		this.fnBlockId = fnBlockId;
	}

	public Long getExecutePerson() {
		return this.executePerson;
	}

	public void setExecutePerson(Long executePerson) {
		this.executePerson = executePerson;
	}

	public Timestamp getExecuteTime() {
		return this.executeTime;
	}

	public void setExecuteTime(Timestamp executeTime) {
		this.executeTime = executeTime;
	}

	public Integer getExecuteU() {
		return this.executeU;
	}

	public void setExecuteU(Integer executeU) {
		this.executeU = executeU;
	}

	public String getResultTable() {
		return this.resultTable;
	}

	public void setResultTable(String resultTable) {
		this.resultTable = resultTable;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getCsu() {
		return this.csu;
	}

	public void setCsu(Integer csu) {
		this.csu = csu;
	}

	public Integer getCostTypeId() {
		return this.costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public String getLis() {
		return this.lis;
	}

	public void setLis(String lis) {
		this.lis = lis;
	}

}