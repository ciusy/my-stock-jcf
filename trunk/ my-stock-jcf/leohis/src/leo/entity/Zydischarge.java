package leo.entity;

import java.sql.Timestamp;

/**
 * Zydischarge entity. @author MyEclipse Persistence Tools
 */

public class Zydischarge implements java.io.Serializable {

	// Fields

	private String ipid;
	private Timestamp plantime;
	private String situation;
	private String after;
	private String diagnosis;
	private String orders;
	private Timestamp ctime;
	private Long doctor;

	// Constructors

	/** default constructor */
	public Zydischarge() {
	}

	/** minimal constructor */
	public Zydischarge(String ipid) {
		this.ipid = ipid;
	}

	/** full constructor */
	public Zydischarge(String ipid, Timestamp plantime, String situation,
			String after, String diagnosis, String orders, Timestamp ctime,
			Long doctor) {
		this.ipid = ipid;
		this.plantime = plantime;
		this.situation = situation;
		this.after = after;
		this.diagnosis = diagnosis;
		this.orders = orders;
		this.ctime = ctime;
		this.doctor = doctor;
	}

	// Property accessors

	public String getIpid() {
		return this.ipid;
	}

	public void setIpid(String ipid) {
		this.ipid = ipid;
	}

	public Timestamp getPlantime() {
		return this.plantime;
	}

	public void setPlantime(Timestamp plantime) {
		this.plantime = plantime;
	}

	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getAfter() {
		return this.after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getOrders() {
		return this.orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Long getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Long doctor) {
		this.doctor = doctor;
	}

}