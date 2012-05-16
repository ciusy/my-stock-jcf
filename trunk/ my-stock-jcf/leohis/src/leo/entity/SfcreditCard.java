package leo.entity;

/**
 * SfcreditCard entity. @author MyEclipse Persistence Tools
 */

public class SfcreditCard implements java.io.Serializable {

	// Fields

	private Long creditCardId;
	private String cgId;
	private Double creditCard;
	private String creditCardType;

	// Constructors

	/** default constructor */
	public SfcreditCard() {
	}

	/** minimal constructor */
	public SfcreditCard(Long creditCardId, String cgId) {
		this.creditCardId = creditCardId;
		this.cgId = cgId;
	}

	/** full constructor */
	public SfcreditCard(Long creditCardId, String cgId, Double creditCard,
			String creditCardType) {
		this.creditCardId = creditCardId;
		this.cgId = cgId;
		this.creditCard = creditCard;
		this.creditCardType = creditCardType;
	}

	// Property accessors

	public Long getCreditCardId() {
		return this.creditCardId;
	}

	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getCgId() {
		return this.cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public Double getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(Double creditCard) {
		this.creditCard = creditCard;
	}

	public String getCreditCardType() {
		return this.creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

}