package leo.entity;

/**
 * FamiliRecord entity. @author MyEclipse Persistence Tools
 */

public class FamiliRecord implements java.io.Serializable {

	// Fields

	private String recordId;
	private Boolean medicalInstId;
	private String province;
	private String prefecture;
	private String town;
	private String medicalInstName;
	private Boolean agreement;
	private Long mcsId;
	private Long wcsId;
	private String midcardNum;
	private String widcardNum;
	private Boolean complete;
	private Boolean upload;
	private String mopDnId;
	private String wopDnId;
	private String prefectureName;
	private String townName;

	// Constructors

	/** default constructor */
	public FamiliRecord() {
	}

	/** minimal constructor */
	public FamiliRecord(String recordId) {
		this.recordId = recordId;
	}

	/** full constructor */
	public FamiliRecord(String recordId, Boolean medicalInstId,
			String province, String prefecture, String town,
			String medicalInstName, Boolean agreement, Long mcsId, Long wcsId,
			String midcardNum, String widcardNum, Boolean complete,
			Boolean upload, String mopDnId, String wopDnId,
			String prefectureName, String townName) {
		this.recordId = recordId;
		this.medicalInstId = medicalInstId;
		this.province = province;
		this.prefecture = prefecture;
		this.town = town;
		this.medicalInstName = medicalInstName;
		this.agreement = agreement;
		this.mcsId = mcsId;
		this.wcsId = wcsId;
		this.midcardNum = midcardNum;
		this.widcardNum = widcardNum;
		this.complete = complete;
		this.upload = upload;
		this.mopDnId = mopDnId;
		this.wopDnId = wopDnId;
		this.prefectureName = prefectureName;
		this.townName = townName;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public Boolean getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Boolean medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getMedicalInstName() {
		return this.medicalInstName;
	}

	public void setMedicalInstName(String medicalInstName) {
		this.medicalInstName = medicalInstName;
	}

	public Boolean getAgreement() {
		return this.agreement;
	}

	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}

	public Long getMcsId() {
		return this.mcsId;
	}

	public void setMcsId(Long mcsId) {
		this.mcsId = mcsId;
	}

	public Long getWcsId() {
		return this.wcsId;
	}

	public void setWcsId(Long wcsId) {
		this.wcsId = wcsId;
	}

	public String getMidcardNum() {
		return this.midcardNum;
	}

	public void setMidcardNum(String midcardNum) {
		this.midcardNum = midcardNum;
	}

	public String getWidcardNum() {
		return this.widcardNum;
	}

	public void setWidcardNum(String widcardNum) {
		this.widcardNum = widcardNum;
	}

	public Boolean getComplete() {
		return this.complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public Boolean getUpload() {
		return this.upload;
	}

	public void setUpload(Boolean upload) {
		this.upload = upload;
	}

	public String getMopDnId() {
		return this.mopDnId;
	}

	public void setMopDnId(String mopDnId) {
		this.mopDnId = mopDnId;
	}

	public String getWopDnId() {
		return this.wopDnId;
	}

	public void setWopDnId(String wopDnId) {
		this.wopDnId = wopDnId;
	}

	public String getPrefectureName() {
		return this.prefectureName;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

}