package leo.entity;

/**
 * Yfmsupplier entity. @author MyEclipse Persistence Tools
 */

public class Yfmsupplier implements java.io.Serializable {

	// Fields

	private Integer supplierId;
	private String supplierName;
	private String address;
	private String phone;
	private String postcode;
	private String fax;
	private String bank;
	private String accNum;
	private String email;
	private String url;
	private String contact;

	// Constructors

	/** default constructor */
	public Yfmsupplier() {
	}

	/** minimal constructor */
	public Yfmsupplier(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/** full constructor */
	public Yfmsupplier(Integer supplierId, String supplierName, String address,
			String phone, String postcode, String fax, String bank,
			String accNum, String email, String url, String contact) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.phone = phone;
		this.postcode = postcode;
		this.fax = fax;
		this.bank = bank;
		this.accNum = accNum;
		this.email = email;
		this.url = url;
		this.contact = contact;
	}

	// Property accessors

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccNum() {
		return this.accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}