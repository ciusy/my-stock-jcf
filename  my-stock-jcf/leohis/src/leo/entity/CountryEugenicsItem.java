package leo.entity;

import java.sql.Timestamp;

/**
 * CountryEugenicsItem entity. @author MyEclipse Persistence Tools
 */

public class CountryEugenicsItem implements java.io.Serializable {

	// Fields

	private String filesId;
	private String manOpnum;
	private String wifeOpnum;
	private Long manIsdocmentId;
	private Timestamp filesUploadTime;
	private String assess;
	private String assessDoctor;
	private Timestamp filesEndTime;
	private String alterFilesId;
	private Timestamp filesCreationTime;
	private String ifUploading;

	// Constructors

	/** default constructor */
	public CountryEugenicsItem() {
	}

	/** minimal constructor */
	public CountryEugenicsItem(String filesId) {
		this.filesId = filesId;
	}

	/** full constructor */
	public CountryEugenicsItem(String filesId, String manOpnum,
			String wifeOpnum, Long manIsdocmentId, Timestamp filesUploadTime,
			String assess, String assessDoctor, Timestamp filesEndTime,
			String alterFilesId, Timestamp filesCreationTime, String ifUploading) {
		this.filesId = filesId;
		this.manOpnum = manOpnum;
		this.wifeOpnum = wifeOpnum;
		this.manIsdocmentId = manIsdocmentId;
		this.filesUploadTime = filesUploadTime;
		this.assess = assess;
		this.assessDoctor = assessDoctor;
		this.filesEndTime = filesEndTime;
		this.alterFilesId = alterFilesId;
		this.filesCreationTime = filesCreationTime;
		this.ifUploading = ifUploading;
	}

	// Property accessors

	public String getFilesId() {
		return this.filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}

	public String getManOpnum() {
		return this.manOpnum;
	}

	public void setManOpnum(String manOpnum) {
		this.manOpnum = manOpnum;
	}

	public String getWifeOpnum() {
		return this.wifeOpnum;
	}

	public void setWifeOpnum(String wifeOpnum) {
		this.wifeOpnum = wifeOpnum;
	}

	public Long getManIsdocmentId() {
		return this.manIsdocmentId;
	}

	public void setManIsdocmentId(Long manIsdocmentId) {
		this.manIsdocmentId = manIsdocmentId;
	}

	public Timestamp getFilesUploadTime() {
		return this.filesUploadTime;
	}

	public void setFilesUploadTime(Timestamp filesUploadTime) {
		this.filesUploadTime = filesUploadTime;
	}

	public String getAssess() {
		return this.assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public String getAssessDoctor() {
		return this.assessDoctor;
	}

	public void setAssessDoctor(String assessDoctor) {
		this.assessDoctor = assessDoctor;
	}

	public Timestamp getFilesEndTime() {
		return this.filesEndTime;
	}

	public void setFilesEndTime(Timestamp filesEndTime) {
		this.filesEndTime = filesEndTime;
	}

	public String getAlterFilesId() {
		return this.alterFilesId;
	}

	public void setAlterFilesId(String alterFilesId) {
		this.alterFilesId = alterFilesId;
	}

	public Timestamp getFilesCreationTime() {
		return this.filesCreationTime;
	}

	public void setFilesCreationTime(Timestamp filesCreationTime) {
		this.filesCreationTime = filesCreationTime;
	}

	public String getIfUploading() {
		return this.ifUploading;
	}

	public void setIfUploading(String ifUploading) {
		this.ifUploading = ifUploading;
	}

}