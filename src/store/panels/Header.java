package store.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel storeName = new JLabel("MY STORE");

	public Header() {

		this.setBackground(Color.BLACK);
		this.add(storeName);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		storeName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		storeName.setForeground(Color.WHITE);

	}
}
