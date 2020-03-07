package store.util;

public class PayPalModel {

	private String items;
	private int totalPrice;
	private String buyer;
	private String payPal;

	public PayPalModel(String items, int totalPrice, String buyer, String payPal) {
		this.items = items;
		this.totalPrice = totalPrice;
		this.buyer = buyer;
		this.payPal = payPal;
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

	public String getPayPal() {
		return payPal;
	}

	public void setPayPal(String payPal) {
		this.payPal = payPal;
	}

}
