package leo.entity;

/**
 * Zyipmedicine entity. @author MyEclipse Persistence Tools
 */

public class Zyipmedicine implements java.io.Serializable {

	// Fields

	private Long daitemId;
	private String daid;
	private Integer pharmacyUid;
	private String usage;
	private Integer minfoId;
	private Integer num;
	private String wayTo;
	private Double cost;

	// Constructors

	/** default constructor */
	public Zyipmedicine() {
	}

	/** minimal constructor */
	public Zyipmedicine(Long daitemId) {
		this.daitemId = daitemId;
	}

	/** full constructor */
	public Zyipmedicine(Long daitemId, String daid, Integer pharmacyUid,
			String usage, Integer minfoId, Integer num, String wayTo,
			Double cost) {
		this.daitemId = daitemId;
		this.daid = daid;
		this.pharmacyUid = pharmacyUid;
		this.usage = usage;
		this.minfoId = minfoId;
		this.num = num;
		this.wayTo = wayTo;
		this.cost = cost;
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

	public Integer getPharmacyUid() {
		return this.pharmacyUid;
	}

	public void setPharmacyUid(Integer pharmacyUid) {
		this.pharmacyUid = pharmacyUid;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getWayTo() {
		return this.wayTo;
	}

	public void setWayTo(String wayTo) {
		this.wayTo = wayTo;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}