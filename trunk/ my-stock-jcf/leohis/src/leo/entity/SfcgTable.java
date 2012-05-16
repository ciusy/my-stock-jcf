package leo.entity;

import java.sql.Timestamp;

/**
 * SfcgTable entity. @author MyEclipse Persistence Tools
 */

public class SfcgTable implements java.io.Serializable {

	// Fields

	private String cgId;
	private String tableLocateIn;
	private String idofTableLocateIn;
	private Long cashier;
	private Timestamp cgTime;
	private Integer cgRoomId;
	private Double cgAmount;
	private Double cash;
	private String cgType;

	// Constructors

	/** default constructor */
	public SfcgTable() {
	}

	/** minimal constructor */
	public SfcgTable(String cgId) {
		this.cgId = cgId;
	}

	/** full constructor */
	public SfcgTable(String cgId, String tableLocateIn,
			String idofTableLocateIn, Long cashier, Timestamp cgTime,
			Integer cgRoomId, Double cgAmount, Double cash, String cgType) {
		this.cgId = cgId;
		this.tableLocateIn = tableLocateIn;
		this.idofTableLocateIn = idofTableLocateIn;
		this.cashier = cashier;
		this.cgTime = cgTime;
		this.cgRoomId = cgRoomId;
		this.cgAmount = cgAmount;
		this.cash = cash;
		this.cgType = cgType;
	}

	// Property accessors

	public String getCgId() {
		return this.cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public String getTableLocateIn() {
		return this.tableLocateIn;
	}

	public void setTableLocateIn(String tableLocateIn) {
		this.tableLocateIn = tableLocateIn;
	}

	public String getIdofTableLocateIn() {
		return this.idofTableLocateIn;
	}

	public void setIdofTableLocateIn(String idofTableLocateIn) {
		this.idofTableLocateIn = idofTableLocateIn;
	}

	public Long getCashier() {
		return this.cashier;
	}

	public void setCashier(Long cashier) {
		this.cashier = cashier;
	}

	public Timestamp getCgTime() {
		return this.cgTime;
	}

	public void setCgTime(Timestamp cgTime) {
		this.cgTime = cgTime;
	}

	public Integer getCgRoomId() {
		return this.cgRoomId;
	}

	public void setCgRoomId(Integer cgRoomId) {
		this.cgRoomId = cgRoomId;
	}

	public Double getCgAmount() {
		return this.cgAmount;
	}

	public void setCgAmount(Double cgAmount) {
		this.cgAmount = cgAmount;
	}

	public Double getCash() {
		return this.cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public String getCgType() {
		return this.cgType;
	}

	public void setCgType(String cgType) {
		this.cgType = cgType;
	}

}