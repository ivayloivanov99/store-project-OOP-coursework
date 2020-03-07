package store.util;

public class CreditCardModel {

	private String items;
	private int totalPrice;
	private String buyer;
	private String cardNumber;

	public CreditCardModel(String items, int totalPrice, String buyer, String cardNumber) {
		this.items = items;
		this.totalPrice = totalPrice;
		this.buyer = buyer;
		this.cardNumber = cardNumber;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
