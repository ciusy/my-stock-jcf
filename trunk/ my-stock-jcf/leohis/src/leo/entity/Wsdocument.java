package leo.entity;

/**
 * Wsdocument entity. @author MyEclipse Persistence Tools
 */

public class Wsdocument implements java.io.Serializable {

	// Fields

	private Long docId;
	private String docName;
	private String docDescribe;
	private String docStore;
	private String docEdition;
	private String note;
	private Boolean visitDocOrNot;
	private Integer daysOfVisitRemind;

	// Constructors

	/** default constructor */
	public Wsdocument() {
	}

	/** full constructor */
	public Wsdocument(String docName, String docDescribe, String docStore, String docEdition, String note, Boolean visitDocOrNot,
			Integer daysOfVisitRemind) {
		this.docName = docName;
		this.docDescribe = docDescribe;
		this.docStore = docStore;
		this.docEdition = docEdition;
		this.note = note;
		this.visitDocOrNot = visitDocOrNot;
		this.daysOfVisitRemind = daysOfVisitRemind;
	}

	// Property accessors

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocDescribe() {
		return this.docDescribe;
	}

	public void setDocDescribe(String docDescribe) {
		this.docDescribe = docDescribe;
	}

	public String getDocStore() {
		return this.docStore;
	}

	public void setDocStore(String docStore) {
		this.docStore = docStore;
	}

	public String getDocEdition() {
		return this.docEdition;
	}

	public void setDocEdition(String docEdition) {
		this.docEdition = docEdition;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getVisitDocOrNot() {
		return this.visitDocOrNot;
	}

	public void setVisitDocOrNot(Boolean visitDocOrNot) {
		this.visitDocOrNot = visitDocOrNot;
	}

	public Integer getDaysOfVisitRemind() {
		return this.daysOfVisitRemind;
	}

	public void setDaysOfVisitRemind(Integer daysOfVisitRemind) {
		this.daysOfVisitRemind = daysOfVisitRemind;
	}

}