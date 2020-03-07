package store.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import store.util.CreditCardModel;
import store.util.CreditCardWrite;

public class CreditCardDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel totalPriceLabel = new JLabel("The total price is " + Item.fullPrice + " leva.", SwingConstants.CENTER);
	JLabel itemLabel = new JLabel("", SwingConstants.CENTER);
	JLabel receiptLabel = new JLabel("Credit Card Receipt", SwingConstants.CENTER);
	String item = "";

	JScrollPane scrollPane = new JScrollPane();
	JButton finishOrder = new JButton("Finish your order");

	JLabel creditCardLabel = new JLabel("Credit Card Number", SwingConstants.RIGHT);
	JTextField creditNumberTField = new JTextField();
	JLabel expirationDateLabel = new JLabel("Expiration Date", SwingConstants.RIGHT);
	JTextField expirationDateTField = new JTextField();
	JLabel cardHolderLabel = new JLabel("Card Holder Name", SwingConstants.RIGHT);
	JTextField cardHolderTField = new JTextField();

	JPanel topPanel = new JPanel();
	JPanel receiptPanel = new JPanel();
	JPanel totalPricePanel = new JPanel();
	JPanel userInfoPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	public CreditCardDialog() {
		this.setTitle("Receipt");
		this.setModal(true);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		for (int i = 0; i < ShoppingCart.itemsList.size(); i++) {
			item = item + "----PRODUCT: " + ShoppingCart.itemsList.get(i).getName().toUpperCase() + "----COUNT: "
					+ ShoppingCart.itemsList.get(i).getItemCount() + "----PRICE: "
					+ ShoppingCart.itemsList.get(i).getCombinedPrice() + "<br/>"
					+ "---------------------------------------------------------"
					+ "---------------------------------------------------------  <br/>";

		}
		itemLabel = new JLabel("<html>" + item + "</html>");

		// Top Panel
		topPanel.add(receiptLabel);
		topPanel.setBackground(Color.WHITE);

		// Items Panel
		receiptPanel.add(itemLabel, BorderLayout.CENTER);
		receiptPanel.add(totalPriceLabel, BorderLayout.SOUTH);
		receiptPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		receiptPanel.setBackground(Color.WHITE);
		scrollPane = new JScrollPane(receiptPanel);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Price Panel
		totalPricePanel.add(totalPriceLabel);
		totalPricePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		totalPricePanel.setBackground(Color.WHITE);

		// User Info Panel
		userInfoPanel.setLayout(new GridLayout(3, 2));
		userInfoPanel.add(creditCardLabel);
		userInfoPanel.add(creditNumberTField);
		userInfoPanel.add(expirationDateLabel);
		userInfoPanel.add(expirationDateTField);
		userInfoPanel.add(cardHolderLabel);
		userInfoPanel.add(cardHolderTField);
		userInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		userInfoPanel.setBackground(Color.WHITE);

		// Button Panel
		buttonPanel.add(finishOrder, BorderLayout.CENTER);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(100, 40));

		finishOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String items = "";
				int totalPrice = Item.fullPrice;
				String buyer = cardHolderTField.getText().toString();
				String cardNum = creditNumberTField.getText().toString();

				for (int i = 0; i < ShoppingCart.itemsList.size(); i++) {
					items = items + "(|" + ShoppingCart.itemsList.get(i).getItemCount() + "|"
							+ ShoppingCart.itemsList.get(i).getName() + "|)";
				}

				CreditCardModel order = new CreditCardModel(items, totalPrice, buyer, cardNum);
				if (!CreditCardWrite.isFileExists()) {
					CreditCardWrite.createItemFile();
				}
				if ((cardHolderTField.getText() != null && !cardHolderTField.getText().isEmpty())
						&& ((creditNumberTField.getText() != null && !creditNumberTField.getText().isEmpty()))
						&& ((expirationDateTField.getText() != null && !expirationDateTField.getText().isEmpty()))) {
					CreditCardWrite.writeItems(order);
					cardHolderTField.setText("");
					expirationDateTField.setText("");
					creditNumberTField.setText("");
					JOptionPane.showMessageDialog(CreditCardDialog.this, "The order was made successfully!");
				} else {
					JOptionPane.showMessageDialog(CreditCardDialog.this, "One or more fields are empty.");
				}

			}
		});

		this.add(topPanel);
		this.add(scrollPane);
		this.add(totalPricePanel);
		this.add(userInfoPanel);
		this.add(buttonPanel);
		this.pack();

	}

}