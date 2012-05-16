package leo.entity;

/**
 * SfreceiptContent entity. @author MyEclipse Persistence Tools
 */

public class SfreceiptContent implements java.io.Serializable {

	// Fields

	private String receiptCode;

	// Constructors

	/** default constructor */
	public SfreceiptContent() {
	}

	/** full constructor */
	public SfreceiptContent(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	// Property accessors

	public String getReceiptCode() {
		return this.receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

}