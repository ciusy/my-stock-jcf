package leo.entity;

/**
 * CznkendImage entity. @author MyEclipse Persistence Tools
 */

public class CznkendImage implements java.io.Serializable {

	// Fields

	private Long imageId;
	private String itemId;
	private String picture;

	// Constructors

	/** default constructor */
	public CznkendImage() {
	}

	/** minimal constructor */
	public CznkendImage(Long imageId) {
		this.imageId = imageId;
	}

	/** full constructor */
	public CznkendImage(Long imageId, String itemId, String picture) {
		this.imageId = imageId;
		this.itemId = itemId;
		this.picture = picture;
	}

	// Property accessors

	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}