package leo.entity;

/**
 * SfmzinvoiceContent entity. @author MyEclipse Persistence Tools
 */

public class SfmzinvoiceContent implements java.io.Serializable {

	// Fields

	private Long id;
	private Long invoiceNo;
	private String projectName;
	private String projectDetailName;
	private Double projectMoney;
	private Double projectReduceMoney;
	private String projectType;
	private String billNo;
	private Integer medOrgId;

	// Constructors

	/** default constructor */
	public SfmzinvoiceContent() {
	}

	/** minimal constructor */
	public SfmzinvoiceContent(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SfmzinvoiceContent(Long id, Long invoiceNo, String projectName,
			String projectDetailName, Double projectMoney,
			Double projectReduceMoney, String projectType, String billNo,
			Integer medOrgId) {
		this.id = id;
		this.invoiceNo = invoiceNo;
		this.projectName = projectName;
		this.projectDetailName = projectDetailName;
		this.projectMoney = projectMoney;
		this.projectReduceMoney = projectReduceMoney;
		this.projectType = projectType;
		this.billNo = billNo;
		this.medOrgId = medOrgId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDetailName() {
		return this.projectDetailName;
	}

	public void setProjectDetailName(String projectDetailName) {
		this.projectDetailName = projectDetailName;
	}

	public Double getProjectMoney() {
		return this.projectMoney;
	}

	public void setProjectMoney(Double projectMoney) {
		this.projectMoney = projectMoney;
	}

	public Double getProjectReduceMoney() {
		return this.projectReduceMoney;
	}

	public void setProjectReduceMoney(Double projectReduceMoney) {
		this.projectReduceMoney = projectReduceMoney;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Integer getMedOrgId() {
		return this.medOrgId;
	}

	public void setMedOrgId(Integer medOrgId) {
		this.medOrgId = medOrgId;
	}

}