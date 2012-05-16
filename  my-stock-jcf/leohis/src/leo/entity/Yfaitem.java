package leo.entity;

/**
 * Yfaitem entity. @author MyEclipse Persistence Tools
 */

public class Yfaitem implements java.io.Serializable {

	// Fields

	private Long aitemId;
	private String aformId;
	private Integer num;
	private String unit;
	private Integer minfoId;
	private String mspec;
	private String mtype;
	private String mdosageType;
	private Double mdosage;
	private String dosageUnit;
	private String mname;

	// Constructors

	/** default constructor */
	public Yfaitem() {
	}

	/** minimal constructor */
	public Yfaitem(Long aitemId) {
		this.aitemId = aitemId;
	}

	/** full constructor */
	public Yfaitem(Long aitemId, String aformId, Integer num, String unit,
			Integer minfoId, String mspec, String mtype, String mdosageType,
			Double mdosage, String dosageUnit, String mname) {
		this.aitemId = aitemId;
		this.aformId = aformId;
		this.num = num;
		this.unit = unit;
		this.minfoId = minfoId;
		this.mspec = mspec;
		this.mtype = mtype;
		this.mdosageType = mdosageType;
		this.mdosage = mdosage;
		this.dosageUnit = dosageUnit;
		this.mname = mname;
	}

	// Property accessors

	public Long getAitemId() {
		return this.aitemId;
	}

	public void setAitemId(Long aitemId) {
		this.aitemId = aitemId;
	}

	public String getAformId() {
		return this.aformId;
	}

	public void setAformId(String aformId) {
		this.aformId = aformId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public String getMspec() {
		return this.mspec;
	}

	public void setMspec(String mspec) {
		this.mspec = mspec;
	}

	public String getMtype() {
		return this.mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getMdosageType() {
		return this.mdosageType;
	}

	public void setMdosageType(String mdosageType) {
		this.mdosageType = mdosageType;
	}

	public Double getMdosage() {
		return this.mdosage;
	}

	public void setMdosage(Double mdosage) {
		this.mdosage = mdosage;
	}

	public String getDosageUnit() {
		return this.dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

}