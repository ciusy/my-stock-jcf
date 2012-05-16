package leo.entity;

/**
 * OsfnAuthorityForm entity. @author MyEclipse Persistence Tools
 */

public class OsfnAuthorityForm implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private Integer fatherMenuId;
	private Integer fnBlocksId;
	private Long sid;
	private String menuName;
	private String quickName;
	private String quickImageId;
	private String quickClass;

	// Constructors

	/** default constructor */
	public OsfnAuthorityForm() {
	}

	/** minimal constructor */
	public OsfnAuthorityForm(Integer menuId) {
		this.menuId = menuId;
	}

	/** full constructor */
	public OsfnAuthorityForm(Integer menuId, Integer fatherMenuId,
			Integer fnBlocksId, Long sid, String menuName, String quickName,
			String quickImageId, String quickClass) {
		this.menuId = menuId;
		this.fatherMenuId = fatherMenuId;
		this.fnBlocksId = fnBlocksId;
		this.sid = sid;
		this.menuName = menuName;
		this.quickName = quickName;
		this.quickImageId = quickImageId;
		this.quickClass = quickClass;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getFatherMenuId() {
		return this.fatherMenuId;
	}

	public void setFatherMenuId(Integer fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}

	public Integer getFnBlocksId() {
		return this.fnBlocksId;
	}

	public void setFnBlocksId(Integer fnBlocksId) {
		this.fnBlocksId = fnBlocksId;
	}

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getQuickName() {
		return this.quickName;
	}

	public void setQuickName(String quickName) {
		this.quickName = quickName;
	}

	public String getQuickImageId() {
		return this.quickImageId;
	}

	public void setQuickImageId(String quickImageId) {
		this.quickImageId = quickImageId;
	}

	public String getQuickClass() {
		return this.quickClass;
	}

	public void setQuickClass(String quickClass) {
		this.quickClass = quickClass;
	}

}