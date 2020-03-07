package store.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class CartDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JButton buyCreditButton = new JButton("Buy with Credit Card");
	JButton buyPaypalButton = new JButton("Buy with Paypal");

	public static String paymentMethod = "";

	JTable table = new JTable();
	PersonDataModel personDataModel;
	JPanel tablePanel = new JPanel();
	JPanel optionPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel fullPriceLabel = new JLabel("The entire price is: " + Item.fullPrice + " leva", SwingConstants.CENTER);

	public CartDialog() {

		this.setTitle("Shopping Cart");
		this.setModal(true);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Table
		personDataModel = new PersonDataModel(ShoppingCart.itemsList);
		table = new JTable(personDataModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		tablePanel.add(scrollPane);
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// ButtonPanel
		buttonPanel.add(buyCreditButton);
		buttonPanel.add(buyPaypalButton);

		// Option Panel
		optionPanel.setLayout(new BorderLayout());
		optionPanel.setBackground(Color.WHITE);
		optionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		optionPanel.setPreferredSize(new Dimension(800, 100));
		optionPanel.add(fullPriceLabel, BorderLayout.CENTER);
		optionPanel.add(buttonPanel, BorderLayout.SOUTH);
		fullPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));

		buyCreditButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				paymentMethod = "Credit Card";
				CreditCardDialog receipt = new CreditCardDialog();
				receipt.setVisible(true);

			}

		});

		buyPaypalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				paymentMethod = "PayPal";
				PaypalDialog receipt = new PaypalDialog();
				receipt.setVisible(true);

			}

		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (e.getClickCount() > 1) {
					String input = JOptionPane.showInputDialog(
							"<html>Change the amount for: <br/>" + table.getValueAt(row, 0) + "</html>");
					try {

						int amount = Integer.parseInt(input);
						if (amount < 100) {
							ShoppingCart.itemsList.get(table.getSelectedRow()).setItemCount(amount);
							ShoppingCart.itemsList.get(table.getSelectedRow()).setCombinedPrice(
									ShoppingCart.itemsList.get(table.getSelectedRow()).getPrice() * amount);
							Item.fullPrice = 0;
							for (int i = 0; i < ShoppingCart.itemsList.size(); i++) {
								Item.fullPrice += ShoppingCart.itemsList.get(i).getCombinedPrice();
							}
							fullPriceLabel.setText("The entire price is: " + Item.fullPrice + " leva");
							table.repaint();
						} else {
							JOptionPane.showMessageDialog(CartDialog.this, "The amount must be less than 100");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(CartDialog.this, "The amount must be a number");
					}

				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		this.add(tablePanel);
		this.add(optionPanel);
		this.pack();

	}

}
