package store.panels;

import java.awt.GridLayout;
import javax.swing.JPanel;

import store.gui.MainClass;

public class SmartphonesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SmartphonesPanel() {

		this.setLayout(new GridLayout(2, 2));
		this.add(new Item(MainClass.itemList.get(5).getName(), MainClass.itemList.get(5).getPrice(),
				MainClass.itemList.get(5).getImage()));
		this.add(new Item(MainClass.itemList.get(6).getName(), MainClass.itemList.get(6).getPrice(),
				MainClass.itemList.get(6).getImage()));
		this.add(new Item(MainClass.itemList.get(7).getName(), MainClass.itemList.get(7).getPrice(),
				MainClass.itemList.get(7).getImage()));
		this.add(new Item(MainClass.itemList.get(8).getName(), MainClass.itemList.get(8).getPrice(),
				MainClass.itemList.get(8).getImage()));
		this.add(new Item(MainClass.itemList.get(9).getName(), MainClass.itemList.get(9).getPrice(),
				MainClass.itemList.get(9).getImage()));
		this.add(new ShoppingCart());
	}

}
