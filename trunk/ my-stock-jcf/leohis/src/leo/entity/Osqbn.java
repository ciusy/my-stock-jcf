package leo.entity;

/**
 * Osqbn entity. @author MyEclipse Persistence Tools
 */

public class Osqbn implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private Long sid;
	private String menuName;
	private Integer num;
	private String imagePath;
	private Integer fnBlocksId;

	// Constructors

	/** default constructor */
	public Osqbn() {
	}

	/** minimal constructor */
	public Osqbn(Integer menuId) {
		this.menuId = menuId;
	}

	/** full constructor */
	public Osqbn(Integer menuId, Long sid, String menuName, Integer num,
			String imagePath, Integer fnBlocksId) {
		this.menuId = menuId;
		this.sid = sid;
		this.menuName = menuName;
		this.num = num;
		this.imagePath = imagePath;
		this.fnBlocksId = fnBlocksId;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
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

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getFnBlocksId() {
		return this.fnBlocksId;
	}

	public void setFnBlocksId(Integer fnBlocksId) {
		this.fnBlocksId = fnBlocksId;
	}

}