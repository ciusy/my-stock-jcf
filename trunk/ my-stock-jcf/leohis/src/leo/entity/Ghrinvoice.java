package leo.entity;

/**
 * Ghrinvoice entity. @author MyEclipse Persistence Tools
 */

public class Ghrinvoice implements java.io.Serializable {

	// Fields

	private String invoiceId;
	private String opnum;

	// Constructors

	/** default constructor */
	public Ghrinvoice() {
	}

	/** full constructor */
	public Ghrinvoice(String invoiceId, String opnum) {
		this.invoiceId = invoiceId;
		this.opnum = opnum;
	}

	// Property accessors

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getOpnum() {
		return this.opnum;
	}

	public void setOpnum(String opnum) {
		this.opnum = opnum;
	}

}