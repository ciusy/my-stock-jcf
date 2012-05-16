package leo.entity;

/**
 * OsfnBlocks entity. @author MyEclipse Persistence Tools
 */

public class OsfnBlocks implements java.io.Serializable {

	// Fields

	private Integer fnBlocksId;
	private Integer fatherFnBlocksId;
	private String fnBlocksName;
	private String fnBlocksClass;
	private String fnBlocksDescription;
	private Boolean basicAuthorityOrNot;

	// Constructors

	/** default constructor */
	public OsfnBlocks() {
	}

	/** minimal constructor */
	public OsfnBlocks(Integer fnBlocksId) {
		this.fnBlocksId = fnBlocksId;
	}

	/** full constructor */
	public OsfnBlocks(Integer fnBlocksId, Integer fatherFnBlocksId,
			String fnBlocksName, String fnBlocksClass,
			String fnBlocksDescription, Boolean basicAuthorityOrNot) {
		this.fnBlocksId = fnBlocksId;
		this.fatherFnBlocksId = fatherFnBlocksId;
		this.fnBlocksName = fnBlocksName;
		this.fnBlocksClass = fnBlocksClass;
		this.fnBlocksDescription = fnBlocksDescription;
		this.basicAuthorityOrNot = basicAuthorityOrNot;
	}

	// Property accessors

	public Integer getFnBlocksId() {
		return this.fnBlocksId;
	}

	public void setFnBlocksId(Integer fnBlocksId) {
		this.fnBlocksId = fnBlocksId;
	}

	public Integer getFatherFnBlocksId() {
		return this.fatherFnBlocksId;
	}

	public void setFatherFnBlocksId(Integer fatherFnBlocksId) {
		this.fatherFnBlocksId = fatherFnBlocksId;
	}

	public String getFnBlocksName() {
		return this.fnBlocksName;
	}

	public void setFnBlocksName(String fnBlocksName) {
		this.fnBlocksName = fnBlocksName;
	}

	public String getFnBlocksClass() {
		return this.fnBlocksClass;
	}

	public void setFnBlocksClass(String fnBlocksClass) {
		this.fnBlocksClass = fnBlocksClass;
	}

	public String getFnBlocksDescription() {
		return this.fnBlocksDescription;
	}

	public void setFnBlocksDescription(String fnBlocksDescription) {
		this.fnBlocksDescription = fnBlocksDescription;
	}

	public Boolean getBasicAuthorityOrNot() {
		return this.basicAuthorityOrNot;
	}

	public void setBasicAuthorityOrNot(Boolean basicAuthorityOrNot) {
		this.basicAuthorityOrNot = basicAuthorityOrNot;
	}

}