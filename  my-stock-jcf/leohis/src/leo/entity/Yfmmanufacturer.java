package leo.entity;

/**
 * Yfmmanufacturer entity. @author MyEclipse Persistence Tools
 */

public class Yfmmanufacturer implements java.io.Serializable {

	// Fields

	private String manufacturer;

	// Constructors

	/** default constructor */
	public Yfmmanufacturer() {
	}

	/** full constructor */
	public Yfmmanufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	// Property accessors

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}