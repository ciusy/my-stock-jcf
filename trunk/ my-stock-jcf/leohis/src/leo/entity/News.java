package leo.entity;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Long newsid;
	private String newsTitle;
	private String newsContent;
	private String listingStatus;
	private Timestamp lastModify;
	private Timestamp submitTime;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Long newsid) {
		this.newsid = newsid;
	}

	/** full constructor */
	public News(Long newsid, String newsTitle, String newsContent,
			String listingStatus, Timestamp lastModify, Timestamp submitTime) {
		this.newsid = newsid;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.listingStatus = listingStatus;
		this.lastModify = lastModify;
		this.submitTime = submitTime;
	}

	// Property accessors

	public Long getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Long newsid) {
		this.newsid = newsid;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getListingStatus() {
		return this.listingStatus;
	}

	public void setListingStatus(String listingStatus) {
		this.listingStatus = listingStatus;
	}

	public Timestamp getLastModify() {
		return this.lastModify;
	}

	public void setLastModify(Timestamp lastModify) {
		this.lastModify = lastModify;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

}