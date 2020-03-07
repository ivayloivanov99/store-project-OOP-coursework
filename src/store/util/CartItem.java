package store.util;

public class CartItem {

	private String name;
	private int price;
	private int itemCount;
	private int combinedPrice;

	public CartItem(String name, int price, int itemCount, int combinedPrice) {
		this.name = name;
		this.price = price;
		this.itemCount = itemCount;
		this.combinedPrice = combinedPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCombinedPrice() {
		return combinedPrice;
	}

	public void setCombinedPrice(int combinedPrice) {
		this.combinedPrice = combinedPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

}
