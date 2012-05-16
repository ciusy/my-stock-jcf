package leo.entity;

import java.sql.Timestamp;

/**
 * HusOthersTest entity. @author MyEclipse Persistence Tools
 */

public class HusOthersTest implements java.io.Serializable {

	// Fields

	private String recordId;
	private String results;
	private Timestamp date;
	private String doctor;
	private String source;
	private String hname;
	private Integer medicalInstId;
	private Long stuffId;

	// Constructors

	/** default constructor */
	public HusOthersTest() {
	}

	/** minimal constructor */
	public HusOthersTest(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public HusOthersTest(String recordId, String results, Timestamp date,
			String doctor, String source, String hname, Integer medicalInstId,
			Long stuffId) {
		this.recordId = recordId;
		this.results = results;
		this.date = date;
		this.doctor = doctor;
		this.source = source;
		this.hname = hname;
		this.medicalInstId = medicalInstId;
		this.stuffId = stuffId;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getResults() {
		return this.results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public Long getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

}