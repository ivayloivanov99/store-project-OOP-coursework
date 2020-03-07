package store.gui;

import java.util.ArrayList;

import store.util.FileReader;
import store.util.ItemInfo;

public class MainClass {

	public static ArrayList<ItemInfo> itemList = new ArrayList<ItemInfo>();

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		readData();
		MyFrame frame = new MyFrame();

	}

	public static void readData() {

		ItemInfo[] items = FileReader.readItems();
		for (ItemInfo item : items) {
			itemList.add(item);
		}
	}
}
