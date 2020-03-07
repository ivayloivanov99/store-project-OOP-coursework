package store.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel welcomeText = new JLabel("<html><strong>Welcome!</strong><br/>Please, select a category!</html>",
			SwingConstants.CENTER);

	public WelcomePanel() {

		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		this.add(welcomeText);

		welcomeText.setFont(new Font("Arial", Font.ITALIC, 40));
		welcomeText.setForeground(Color.BLACK);
	}
}
