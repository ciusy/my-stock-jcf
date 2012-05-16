package leo.entity;

/**
 * YfsetExbankType entity. @author MyEclipse Persistence Tools
 */

public class YfsetExbankType implements java.io.Serializable {

	// Fields

	private Integer exbankId;
	private String etypeName;
	private String balanceAccountMethod;
	private Double inExbankP;
	private String exbankApproveLogic;
	private String note;
	private Integer pharmacyId;

	// Constructors

	/** default constructor */
	public YfsetExbankType() {
	}

	/** minimal constructor */
	public YfsetExbankType(Integer exbankId) {
		this.exbankId = exbankId;
	}

	/** full constructor */
	public YfsetExbankType(Integer exbankId, String etypeName,
			String balanceAccountMethod, Double inExbankP,
			String exbankApproveLogic, String note, Integer pharmacyId) {
		this.exbankId = exbankId;
		this.etypeName = etypeName;
		this.balanceAccountMethod = balanceAccountMethod;
		this.inExbankP = inExbankP;
		this.exbankApproveLogic = exbankApproveLogic;
		this.note = note;
		this.pharmacyId = pharmacyId;
	}

	// Property accessors

	public Integer getExbankId() {
		return this.exbankId;
	}

	public void setExbankId(Integer exbankId) {
		this.exbankId = exbankId;
	}

	public String getEtypeName() {
		return this.etypeName;
	}

	public void setEtypeName(String etypeName) {
		this.etypeName = etypeName;
	}

	public String getBalanceAccountMethod() {
		return this.balanceAccountMethod;
	}

	public void setBalanceAccountMethod(String balanceAccountMethod) {
		this.balanceAccountMethod = balanceAccountMethod;
	}

	public Double getInExbankP() {
		return this.inExbankP;
	}

	public void setInExbankP(Double inExbankP) {
		this.inExbankP = inExbankP;
	}

	public String getExbankApproveLogic() {
		return this.exbankApproveLogic;
	}

	public void setExbankApproveLogic(String exbankApproveLogic) {
		this.exbankApproveLogic = exbankApproveLogic;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

}