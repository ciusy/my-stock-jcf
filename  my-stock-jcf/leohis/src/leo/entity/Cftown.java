package leo.entity;

/**
 * Cftown entity. @author MyEclipse Persistence Tools
 */

public class Cftown implements java.io.Serializable {

	// Fields

	private Long townId;
	private Long prefectureId;
	private String townName;

	// Constructors

	/** default constructor */
	public Cftown() {
	}

	/** minimal constructor */
	public Cftown(Long townId) {
		this.townId = townId;
	}

	/** full constructor */
	public Cftown(Long townId, Long prefectureId, String townName) {
		this.townId = townId;
		this.prefectureId = prefectureId;
		this.townName = townName;
	}

	// Property accessors

	public Long getTownId() {
		return this.townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Long getPrefectureId() {
		return this.prefectureId;
	}

	public void setPrefectureId(Long prefectureId) {
		this.prefectureId = prefectureId;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

}