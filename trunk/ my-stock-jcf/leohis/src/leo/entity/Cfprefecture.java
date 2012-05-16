package leo.entity;

/**
 * Cfprefecture entity. @author MyEclipse Persistence Tools
 */

public class Cfprefecture implements java.io.Serializable {

	// Fields

	private Long prefectureId;
	private Integer cityId;
	private String prefectureName;

	// Constructors

	/** default constructor */
	public Cfprefecture() {
	}

	/** minimal constructor */
	public Cfprefecture(Long prefectureId) {
		this.prefectureId = prefectureId;
	}

	/** full constructor */
	public Cfprefecture(Long prefectureId, Integer cityId, String prefectureName) {
		this.prefectureId = prefectureId;
		this.cityId = cityId;
		this.prefectureName = prefectureName;
	}

	// Property accessors

	public Long getPrefectureId() {
		return this.prefectureId;
	}

	public void setPrefectureId(Long prefectureId) {
		this.prefectureId = prefectureId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getPrefectureName() {
		return this.prefectureName;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

}