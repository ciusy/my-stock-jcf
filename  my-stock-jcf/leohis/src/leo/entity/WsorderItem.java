package leo.entity;

/**
 * WsorderItem entity. @author MyEclipse Persistence Tools
 */

public class WsorderItem implements java.io.Serializable {

	// Fields

	private Long orderId;
	private Long frameworkId;
	private Long docId;
	private Integer step;

	// Constructors

	/** default constructor */
	public WsorderItem() {
	}

	/** minimal constructor */
	public WsorderItem(Long orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public WsorderItem(Long orderId, Long frameworkId, Long docId, Integer step) {
		this.orderId = orderId;
		this.frameworkId = frameworkId;
		this.docId = docId;
		this.step = step;
	}

	// Property accessors

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getFrameworkId() {
		return this.frameworkId;
	}

	public void setFrameworkId(Long frameworkId) {
		this.frameworkId = frameworkId;
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Integer getStep() {
		return this.step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

}