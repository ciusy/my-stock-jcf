package leo.entity;

/**
 * Cfvillage entity. @author MyEclipse Persistence Tools
 */

public class Cfvillage implements java.io.Serializable {

	// Fields

	private Long villageId;
	private Long townId;
	private String villageName;

	// Constructors

	/** default constructor */
	public Cfvillage() {
	}

	/** minimal constructor */
	public Cfvillage(Long villageId) {
		this.villageId = villageId;
	}

	/** full constructor */
	public Cfvillage(Long villageId, Long townId, String villageName) {
		this.villageId = villageId;
		this.townId = townId;
		this.villageName = villageName;
	}

	// Property accessors

	public Long getVillageId() {
		return this.villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public Long getTownId() {
		return this.townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public String getVillageName() {
		return this.villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

}