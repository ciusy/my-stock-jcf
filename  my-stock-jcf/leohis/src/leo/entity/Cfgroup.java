package leo.entity;

/**
 * Cfgroup entity. @author MyEclipse Persistence Tools
 */

public class Cfgroup implements java.io.Serializable {

	// Fields

	private Long groupId;
	private Long villageId;
	private String groupName;

	// Constructors

	/** default constructor */
	public Cfgroup() {
	}

	/** minimal constructor */
	public Cfgroup(Long groupId) {
		this.groupId = groupId;
	}

	/** full constructor */
	public Cfgroup(Long groupId, Long villageId, String groupName) {
		this.groupId = groupId;
		this.villageId = villageId;
		this.groupName = groupName;
	}

	// Property accessors

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getVillageId() {
		return this.villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}