package store.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import store.gui.MainClass;
import store.util.CartItem;

public class ShoppingCart extends JPanel {

	private static final long serialVersionUID = 1L;

	public static ArrayList<CartItem> itemsList = new ArrayList<CartItem>();
	public static int itemCount;

	JLabel text = new JLabel("You have " + itemsList.size() + " items in your cart!", SwingConstants.CENTER);
	JLabel shoppingCart = new JLabel("", SwingConstants.CENTER);

	public ShoppingCart() {

		ImageIcon imageIcon = new ImageIcon(new ImageIcon(MainClass.itemList.get(18).getImage()).getImage()
				.getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
		shoppingCart.setIcon(imageIcon);
		this.setLayout(new GridLayout(2, 2));
		this.setBackground(Color.WHITE);
		this.add(text);
		text.setVisible(false);
		text.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(shoppingCart);

		shoppingCart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CartDialog dialog = new CartDialog();
				dialog.setVisible(true);
			}

			public void mouseEntered(MouseEvent arg0) {
				text.setText("You have " + itemCount + " items in your cart");
				text.setVisible(true);

			}

			public void mouseExited(MouseEvent arg0) {
				text.setVisible(false);
			}

		});

	}

}
