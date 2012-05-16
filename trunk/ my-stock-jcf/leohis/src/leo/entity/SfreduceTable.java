package leo.entity;

/**
 * SfreduceTable entity. @author MyEclipse Persistence Tools
 */

public class SfreduceTable implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer minfoId;
	private Integer ptype;
	private Double reduceByNum;
	private Double reduceByPercent;

	// Constructors

	/** default constructor */
	public SfreduceTable() {
	}

	/** minimal constructor */
	public SfreduceTable(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SfreduceTable(Integer id, Integer minfoId, Integer ptype,
			Double reduceByNum, Double reduceByPercent) {
		this.id = id;
		this.minfoId = minfoId;
		this.ptype = ptype;
		this.reduceByNum = reduceByNum;
		this.reduceByPercent = reduceByPercent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Integer getPtype() {
		return this.ptype;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

	public Double getReduceByNum() {
		return this.reduceByNum;
	}

	public void setReduceByNum(Double reduceByNum) {
		this.reduceByNum = reduceByNum;
	}

	public Double getReduceByPercent() {
		return this.reduceByPercent;
	}

	public void setReduceByPercent(Double reduceByPercent) {
		this.reduceByPercent = reduceByPercent;
	}

}