package store.panels;

import java.awt.GridLayout;
import javax.swing.JPanel;

import store.gui.MainClass;

public class WatchesPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public WatchesPanel() {

		this.setLayout(new GridLayout(2, 2));
		this.add(new Item(MainClass.itemList.get(0).getName(), MainClass.itemList.get(0).getPrice(),
				MainClass.itemList.get(0).getImage()));
		this.add(new Item(MainClass.itemList.get(1).getName(), MainClass.itemList.get(1).getPrice(),
				MainClass.itemList.get(1).getImage()));
		this.add(new Item(MainClass.itemList.get(2).getName(), MainClass.itemList.get(2).getPrice(),
				MainClass.itemList.get(2).getImage()));
		this.add(new Item(MainClass.itemList.get(3).getName(), MainClass.itemList.get(3).getPrice(),
				MainClass.itemList.get(3).getImage()));
		this.add(new Item(MainClass.itemList.get(4).getName(), MainClass.itemList.get(4).getPrice(),
				MainClass.itemList.get(4).getImage()));
		this.add(new ShoppingCart());

	}

}
