package store.util;

public class ItemInfo {

	private String name;
	private int price;
	private String image;

	public ItemInfo(String name, int price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
