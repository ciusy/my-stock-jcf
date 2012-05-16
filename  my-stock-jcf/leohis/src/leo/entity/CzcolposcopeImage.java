package leo.entity;

/**
 * CzcolposcopeImage entity. @author MyEclipse Persistence Tools
 */

public class CzcolposcopeImage implements java.io.Serializable {

	// Fields

	private Long mgid;
	private String pictureWay;
	private String reid;

	// Constructors

	/** default constructor */
	public CzcolposcopeImage() {
	}

	/** full constructor */
	public CzcolposcopeImage(String pictureWay, String reid) {
		this.pictureWay = pictureWay;
		this.reid = reid;
	}

	// Property accessors

	public Long getMgid() {
		return this.mgid;
	}

	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}

	public String getPictureWay() {
		return this.pictureWay;
	}

	public void setPictureWay(String pictureWay) {
		this.pictureWay = pictureWay;
	}

	public String getReid() {
		return this.reid;
	}

	public void setReid(String reid) {
		this.reid = reid;
	}

}