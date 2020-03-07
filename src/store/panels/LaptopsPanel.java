package store.panels;

import java.awt.GridLayout;
import javax.swing.JPanel;

import store.gui.MainClass;

public class LaptopsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public LaptopsPanel() {

		this.setLayout(new GridLayout(2, 2));
		this.add(new Item(MainClass.itemList.get(10).getName(), MainClass.itemList.get(10).getPrice(),
				MainClass.itemList.get(10).getImage()));
		this.add(new Item(MainClass.itemList.get(11).getName(), MainClass.itemList.get(11).getPrice(),
				MainClass.itemList.get(11).getImage()));
		this.add(new Item(MainClass.itemList.get(12).getName(), MainClass.itemList.get(12).getPrice(),
				MainClass.itemList.get(12).getImage()));
		this.add(new Item(MainClass.itemList.get(13).getName(), MainClass.itemList.get(13).getPrice(),
				MainClass.itemList.get(13).getImage()));
		this.add(new Item(MainClass.itemList.get(14).getName(), MainClass.itemList.get(14).getPrice(),
				MainClass.itemList.get(14).getImage()));
		this.add(new ShoppingCart());

	}

}
