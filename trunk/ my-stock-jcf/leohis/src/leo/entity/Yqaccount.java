package leo.entity;

/**
 * Yqaccount entity. @author MyEclipse Persistence Tools
 */

public class Yqaccount implements java.io.Serializable {

	// Fields

	private String loginName;
	private String password;
	private Integer meiid;

	// Constructors

	/** default constructor */
	public Yqaccount() {
	}

	/** minimal constructor */
	public Yqaccount(String loginName) {
		this.loginName = loginName;
	}

	/** full constructor */
	public Yqaccount(String loginName, String password, Integer meiid) {
		this.loginName = loginName;
		this.password = password;
		this.meiid = meiid;
	}

	// Property accessors

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMeiid() {
		return this.meiid;
	}

	public void setMeiid(Integer meiid) {
		this.meiid = meiid;
	}

}