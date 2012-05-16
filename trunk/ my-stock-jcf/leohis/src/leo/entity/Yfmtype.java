package leo.entity;

/**
 * Yfmtype entity. @author MyEclipse Persistence Tools
 */

public class Yfmtype implements java.io.Serializable {

	// Fields

	private String mtype;

	// Constructors

	/** default constructor */
	public Yfmtype() {
	}

	/** full constructor */
	public Yfmtype(String mtype) {
		this.mtype = mtype;
	}

	// Property accessors

	public String getMtype() {
		return this.mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

}