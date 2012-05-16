package leo.entity;

/**
 * NotifyModule entity. @author MyEclipse Persistence Tools
 */

public class NotifyModule implements java.io.Serializable {

	// Fields

	private Long nmid;
	private Long niid;
	private Long nmtid;
	private String remarks;
	private String result;
	private String resulCoding;

	// Constructors

	/** default constructor */
	public NotifyModule() {
	}

	/** full constructor */
	public NotifyModule(Long niid, Long nmtid, String remarks, String result,
			String resulCoding) {
		this.niid = niid;
		this.nmtid = nmtid;
		this.remarks = remarks;
		this.result = result;
		this.resulCoding = resulCoding;
	}

	// Property accessors

	public Long getNmid() {
		return this.nmid;
	}

	public void setNmid(Long nmid) {
		this.nmid = nmid;
	}

	public Long getNiid() {
		return this.niid;
	}

	public void setNiid(Long niid) {
		this.niid = niid;
	}

	public Long getNmtid() {
		return this.nmtid;
	}

	public void setNmtid(Long nmtid) {
		this.nmtid = nmtid;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResulCoding() {
		return this.resulCoding;
	}

	public void setResulCoding(String resulCoding) {
		this.resulCoding = resulCoding;
	}

}