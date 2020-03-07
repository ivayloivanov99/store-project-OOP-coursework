package store.panels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import store.util.CartItem;

public class PersonDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ArrayList<CartItem> itemsArray = new ArrayList<CartItem>();

	public PersonDataModel(ArrayList<CartItem> itemsArray) {
		this.itemsArray = itemsArray;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {

		int itemLength = 0;
		try {
			itemLength = itemsArray.size();
		} catch (Exception e) {

		}

		return itemLength;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return itemsArray.get(rowIndex).getName();
		case 1:
			return itemsArray.get(rowIndex).getPrice();
		case 2:
			return itemsArray.get(rowIndex).getItemCount();
		case 3:
			return itemsArray.get(rowIndex).getCombinedPrice();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Име";
		case 1:
			return "Единична цена";
		case 2:
			return "Брой";
		case 3:
			return "Обща цена";
		default:
			return super.getColumnName(column);
		}
	}
}
