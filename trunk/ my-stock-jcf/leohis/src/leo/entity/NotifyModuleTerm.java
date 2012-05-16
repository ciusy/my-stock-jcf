package leo.entity;

/**
 * NotifyModuleTerm entity. @author MyEclipse Persistence Tools
 */

public class NotifyModuleTerm implements java.io.Serializable {

	// Fields

	private Long nmtid;
	private String conditionName;
	private String sex;
	private String conditionSet;
	private String sr;
	private String srcoding;

	// Constructors

	/** default constructor */
	public NotifyModuleTerm() {
	}

	/** full constructor */
	public NotifyModuleTerm(String conditionName, String sex,
			String conditionSet, String sr, String srcoding) {
		this.conditionName = conditionName;
		this.sex = sex;
		this.conditionSet = conditionSet;
		this.sr = sr;
		this.srcoding = srcoding;
	}

	// Property accessors

	public Long getNmtid() {
		return this.nmtid;
	}

	public void setNmtid(Long nmtid) {
		this.nmtid = nmtid;
	}

	public String getConditionName() {
		return this.conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getConditionSet() {
		return this.conditionSet;
	}

	public void setConditionSet(String conditionSet) {
		this.conditionSet = conditionSet;
	}

	public String getSr() {
		return this.sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}

	public String getSrcoding() {
		return this.srcoding;
	}

	public void setSrcoding(String srcoding) {
		this.srcoding = srcoding;
	}

}