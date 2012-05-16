package leo.entity;

/**
 * CzbcultrasoundImage entity. @author MyEclipse Persistence Tools
 */

public class CzbcultrasoundImage implements java.io.Serializable {

	// Fields

	private Long bid;
	private String reid;
	private String pictureWay;

	// Constructors

	/** default constructor */
	public CzbcultrasoundImage() {
	}

	/** minimal constructor */
	public CzbcultrasoundImage(Long bid) {
		this.bid = bid;
	}

	/** full constructor */
	public CzbcultrasoundImage(Long bid, String reid, String pictureWay) {
		this.bid = bid;
		this.reid = reid;
		this.pictureWay = pictureWay;
	}

	// Property accessors

	public Long getBid() {
		return this.bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getReid() {
		return this.reid;
	}

	public void setReid(String reid) {
		this.reid = reid;
	}

	public String getPictureWay() {
		return this.pictureWay;
	}

	public void setPictureWay(String pictureWay) {
		this.pictureWay = pictureWay;
	}

}