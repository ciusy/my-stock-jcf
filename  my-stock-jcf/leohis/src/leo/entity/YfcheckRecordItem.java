package leo.entity;

/**
 * YfcheckRecordItem entity. @author MyEclipse Persistence Tools
 */

public class YfcheckRecordItem implements java.io.Serializable {

	// Fields

	private Long id;
	private String checkRecordId;
	private Integer mid;
	private Integer realNum;
	private Integer currentStock;
	private String note;

	// Constructors

	/** default constructor */
	public YfcheckRecordItem() {
	}

	/** minimal constructor */
	public YfcheckRecordItem(Long id) {
		this.id = id;
	}

	/** full constructor */
	public YfcheckRecordItem(Long id, String checkRecordId, Integer mid,
			Integer realNum, Integer currentStock, String note) {
		this.id = id;
		this.checkRecordId = checkRecordId;
		this.mid = mid;
		this.realNum = realNum;
		this.currentStock = currentStock;
		this.note = note;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckRecordId() {
		return this.checkRecordId;
	}

	public void setCheckRecordId(String checkRecordId) {
		this.checkRecordId = checkRecordId;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getRealNum() {
		return this.realNum;
	}

	public void setRealNum(Integer realNum) {
		this.realNum = realNum;
	}

	public Integer getCurrentStock() {
		return this.currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}