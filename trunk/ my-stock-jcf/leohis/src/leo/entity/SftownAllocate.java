package leo.entity;

/**
 * SftownAllocate entity. @author MyEclipse Persistence Tools
 */

public class SftownAllocate implements java.io.Serializable {

	// Fields

	private Integer townId;
	private String townName;
	private Double balance;
	private String telephone;
	private String note;
	private String contactPerson;
	private String spellCode;
	private Integer medicalInstitution;

	// Constructors

	/** default constructor */
	public SftownAllocate() {
	}

	/** minimal constructor */
	public SftownAllocate(Integer townId) {
		this.townId = townId;
	}

	/** full constructor */
	public SftownAllocate(Integer townId, String townName, Double balance,
			String telephone, String note, String contactPerson,
			String spellCode, Integer medicalInstitution) {
		this.townId = townId;
		this.townName = townName;
		this.balance = balance;
		this.telephone = telephone;
		this.note = note;
		this.contactPerson = contactPerson;
		this.spellCode = spellCode;
		this.medicalInstitution = medicalInstitution;
	}

	// Property accessors

	public Integer getTownId() {
		return this.townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getSpellCode() {
		return this.spellCode;
	}

	public void setSpellCode(String spellCode) {
		this.spellCode = spellCode;
	}

	public Integer getMedicalInstitution() {
		return this.medicalInstitution;
	}

	public void setMedicalInstitution(Integer medicalInstitution) {
		this.medicalInstitution = medicalInstitution;
	}

}