package store.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import store.util.CartItem;

public class Item extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel nameLabel = new JLabel("", SwingConstants.CENTER);
	JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
	SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
	JSpinner spinner = new JSpinner(model);
	JButton buyButton = new JButton("Add to cart");

	public static int fullPrice = 0;

	JPanel optionPanel = new JPanel();
	JPanel imagePanel = new JPanel();

	public Item(String name, int price, String image) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(300, 300);
		this.setBackground(Color.WHITE);
		nameLabel = new JLabel("<html>" + name + "<br/>" + "Цена: " + price + "</html>", SwingConstants.CENTER);

		nameLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		optionPanel.setLayout(new BorderLayout());
		optionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionPanel.setSize(150, 200);
		optionPanel.setBackground(Color.WHITE);
		imagePanel.setLayout(new BorderLayout());
		imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		imagePanel.setSize(220, 220);
		imagePanel.setBackground(Color.WHITE);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(image).getImage().getScaledInstance(220, 220, Image.SCALE_AREA_AVERAGING));
		imageLabel.setIcon(imageIcon);
		optionPanel.add(nameLabel, BorderLayout.NORTH);
		optionPanel.add(spinner, BorderLayout.CENTER);
		optionPanel.add(buyButton, BorderLayout.SOUTH);
		imagePanel.add(imageLabel);
		this.add(imagePanel, BorderLayout.WEST);
		this.add(optionPanel, BorderLayout.EAST);

		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You added (" + spinner.getValue().toString() + ") " + name + " to the cart for "
						+ (price * Integer.parseInt(spinner.getValue().toString())) + " leva.");
				fullPrice = 0;
				ShoppingCart.itemCount = 0;

				ShoppingCart.itemsList.add(new CartItem(name, price, Integer.parseInt(spinner.getValue().toString()),
						(price * Integer.parseInt(spinner.getValue().toString()))));

				for (int i = 0; i < ShoppingCart.itemsList.size(); i++) {
					fullPrice += ShoppingCart.itemsList.get(i).getCombinedPrice();
					ShoppingCart.itemCount += ShoppingCart.itemsList.get(i).getItemCount();
				}

				spinner.setValue(1);
			}
		});

	}

}
