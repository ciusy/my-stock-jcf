package leo.entity;

/**
 * CfsellInfo entity. @author MyEclipse Persistence Tools
 */

public class CfsellInfo implements java.io.Serializable {

	// Fields

	private String sellNum;
	private String customerName;
	private String districtNum;

	// Constructors

	/** default constructor */
	public CfsellInfo() {
	}

	/** minimal constructor */
	public CfsellInfo(String sellNum) {
		this.sellNum = sellNum;
	}

	/** full constructor */
	public CfsellInfo(String sellNum, String customerName, String districtNum) {
		this.sellNum = sellNum;
		this.customerName = customerName;
		this.districtNum = districtNum;
	}

	// Property accessors

	public String getSellNum() {
		return this.sellNum;
	}

	public void setSellNum(String sellNum) {
		this.sellNum = sellNum;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDistrictNum() {
		return this.districtNum;
	}

	public void setDistrictNum(String districtNum) {
		this.districtNum = districtNum;
	}

}