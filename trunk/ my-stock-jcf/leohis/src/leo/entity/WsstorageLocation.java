package leo.entity;

/**
 * WsstorageLocation entity. @author MyEclipse Persistence Tools
 */

public class WsstorageLocation implements java.io.Serializable {

	// Fields

	private Long slid;
	private String locationName;
	private Integer medicalInstId;

	// Constructors

	/** default constructor */
	public WsstorageLocation() {
	}

	/** minimal constructor */
	public WsstorageLocation(Long slid) {
		this.slid = slid;
	}

	/** full constructor */
	public WsstorageLocation(Long slid, String locationName,
			Integer medicalInstId) {
		this.slid = slid;
		this.locationName = locationName;
		this.medicalInstId = medicalInstId;
	}

	// Property accessors

	public Long getSlid() {
		return this.slid;
	}

	public void setSlid(Long slid) {
		this.slid = slid;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getMedicalInstId() {
		return this.medicalInstId;
	}

	public void setMedicalInstId(Integer medicalInstId) {
		this.medicalInstId = medicalInstId;
	}

}