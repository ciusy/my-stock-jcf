package leo.entity;

import java.sql.Timestamp;

/**
 * ZydoctorAdviceLongTerm entity. @author MyEclipse Persistence Tools
 */

public class ZydoctorAdviceLongTerm implements java.io.Serializable {

	// Fields

	private Long ltid;
	private String ipid;
	private Long csId;
	private String type;
	private Integer itemId;
	private Integer num;
	private String usage;
	private String wayTo;
	private Double cost;
	private Integer uid;
	private String exeTime;
	private String nextExeDate;
	private Long createDoctor;
	private Timestamp createTime;
	private Long stopDoctor;
	private Timestamp stopTime;
	private Boolean beginExe;

	// Constructors

	/** default constructor */
	public ZydoctorAdviceLongTerm() {
	}

	/** minimal constructor */
	public ZydoctorAdviceLongTerm(Long ltid) {
		this.ltid = ltid;
	}

	/** full constructor */
	public ZydoctorAdviceLongTerm(Long ltid, String ipid, Long csId,
			String type, Integer itemId, Integer num, String usage,
			String wayTo, Double cost, Integer uid, String exeTime,
			String nextExeDate, Long createDoctor, Timestamp createTime,
			Long stopDoctor, Timestamp stopTime, Boolean beginExe) {
		this.ltid = ltid;
		this.ipid = ipid;
		this.csId = csId;
		this.type = type;
		this.itemId = itemId;
		this.num = num;
		this.usage = usage;
		this.wayTo = wayTo;
		this.cost = cost;
		this.uid = uid;
		this.exeTime = exeTime;
		this.nextExeDate = nextExeDate;
		this.createDoctor = createDoctor;
		this.createTime = createTime;
		this.stopDoctor = stopDoctor;
		this.stopTime = stopTime;
		this.beginExe = beginExe;
	}

	// Property accessors

	public Long getLtid() {
		return this.ltid;
	}

	public void setLtid(Long ltid) {
		this.ltid = ltid;
	}

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Long getCsId() {
		return this.csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
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

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getExeTime() {
		return this.exeTime;
	}

	public void setExeTime(String exeTime) {
		this.exeTime = exeTime;
	}

	public String getNextExeDate() {
		return this.nextExeDate;
	}

	public void setNextExeDate(String nextExeDate) {
		this.nextExeDate = nextExeDate;
	}

	public Long getCreateDoctor() {
		return this.createDoctor;
	}

	public void setCreateDoctor(Long createDoctor) {
		this.createDoctor = createDoctor;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getStopDoctor() {
		return this.stopDoctor;
	}

	public void setStopDoctor(Long stopDoctor) {
		this.stopDoctor = stopDoctor;
	}

	public Timestamp getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public Boolean getBeginExe() {
		return this.beginExe;
	}

	public void setBeginExe(Boolean beginExe) {
		this.beginExe = beginExe;
	}

}