package leo.entity;

import java.sql.Timestamp;

/**
 * Yfmstock entity. @author MyEclipse Persistence Tools
 */

public class Yfmstock implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Integer minfoId;
	private Timestamp validityPeriod;
	private String unit;
	private Integer stock;
	private Integer pharmacyId;

	// Constructors

	/** default constructor */
	public Yfmstock() {
	}

	/** minimal constructor */
	public Yfmstock(Integer mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Yfmstock(Integer mid, Integer minfoId, Timestamp validityPeriod,
			String unit, Integer stock, Integer pharmacyId) {
		this.mid = mid;
		this.minfoId = minfoId;
		this.validityPeriod = validityPeriod;
		this.unit = unit;
		this.stock = stock;
		this.pharmacyId = pharmacyId;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getMinfoId() {
		return this.minfoId;
	}

	public void setMinfoId(Integer minfoId) {
		this.minfoId = minfoId;
	}

	public Timestamp getValidityPeriod() {
		return this.validityPeriod;
	}

	public void setValidityPeriod(Timestamp validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getPharmacyId() {
		return this.pharmacyId;
	}

	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

}