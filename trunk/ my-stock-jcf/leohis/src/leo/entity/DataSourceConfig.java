package leo.entity;

/**
 * DataSourceConfig entity. @author MyEclipse Persistence Tools
 */

public class DataSourceConfig implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer itemTypeId;
	private String typeName;
	private String source;
	private String contents;
	private Integer interiorUid;
	private Integer interiorMedicalInstId;

	// Constructors

	/** default constructor */
	public DataSourceConfig() {
	}

	/** minimal constructor */
	public DataSourceConfig(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public DataSourceConfig(Integer id, Integer itemTypeId, String typeName,
			String source, String contents, Integer interiorUid,
			Integer interiorMedicalInstId) {
		this.id = id;
		this.itemTypeId = itemTypeId;
		this.typeName = typeName;
		this.source = source;
		this.contents = contents;
		this.interiorUid = interiorUid;
		this.interiorMedicalInstId = interiorMedicalInstId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemTypeId() {
		return this.itemTypeId;
	}

	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getInteriorUid() {
		return this.interiorUid;
	}

	public void setInteriorUid(Integer interiorUid) {
		this.interiorUid = interiorUid;
	}

	public Integer getInteriorMedicalInstId() {
		return this.interiorMedicalInstId;
	}

	public void setInteriorMedicalInstId(Integer interiorMedicalInstId) {
		this.interiorMedicalInstId = interiorMedicalInstId;
	}

}