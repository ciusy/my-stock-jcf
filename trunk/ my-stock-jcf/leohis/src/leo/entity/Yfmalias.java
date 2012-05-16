package leo.entity;

/**
 * Yfmalias entity. @author MyEclipse Persistence Tools
 */

public class Yfmalias implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer minfoId;
	private String aliasName;
	private String spellCode;
	private Integer aliasLabel;

	// Constructors

	/** default constructor */
	public Yfmalias() {
	}

	/** minimal constructor */
	public Yfmalias(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Yfmalias(Long id, Integer minfoId, String aliasName,
			String spellCode, Integer aliasLabel) {
		this.id = id;
		this.minfoId = minfoId;
		this.aliasName = aliasName;
		this.spellCode = spellCode;
		this.aliasLabel = aliasLabel;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getSpellCode() {
		return this.spellCode;
	}

	public void setSpellCode(String spellCode) {
		this.spellCode = spellCode;
	}

	public Integer getAliasLabel() {
		return this.aliasLabel;
	}

	public void setAliasLabel(Integer aliasLabel) {
		this.aliasLabel = aliasLabel;
	}

}