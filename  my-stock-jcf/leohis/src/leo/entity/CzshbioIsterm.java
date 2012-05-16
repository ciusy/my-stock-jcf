package leo.entity;

/**
 * CzshbioIsterm entity. @author MyEclipse Persistence Tools
 */

public class CzshbioIsterm implements java.io.Serializable {

	// Fields

	private Long id;
	private String itemId;
	private String termName;
	private String termValue;
	private String referenceValue;
	private String unit;
	private String prompt;
	private String englishName;

	// Constructors

	/** default constructor */
	public CzshbioIsterm() {
	}

	/** full constructor */
	public CzshbioIsterm(String itemId, String termName, String termValue,
			String referenceValue, String unit, String prompt,
			String englishName) {
		this.itemId = itemId;
		this.termName = termName;
		this.termValue = termValue;
		this.referenceValue = referenceValue;
		this.unit = unit;
		this.prompt = prompt;
		this.englishName = englishName;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getTermName() {
		return this.termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getTermValue() {
		return this.termValue;
	}

	public void setTermValue(String termValue) {
		this.termValue = termValue;
	}

	public String getReferenceValue() {
		return this.referenceValue;
	}

	public void setReferenceValue(String referenceValue) {
		this.referenceValue = referenceValue;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

}