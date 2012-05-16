package leo.entity;

/**
 * CzmilkGlandImage entity. @author MyEclipse Persistence Tools
 */

public class CzmilkGlandImage implements java.io.Serializable {

	// Fields

	private Long mgid;
	private String pictureWay;
	private String reid;

	// Constructors

	/** default constructor */
	public CzmilkGlandImage() {
	}

	/** minimal constructor */
	public CzmilkGlandImage(Long mgid) {
		this.mgid = mgid;
	}

	/** full constructor */
	public CzmilkGlandImage(Long mgid, String pictureWay, String reid) {
		this.mgid = mgid;
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