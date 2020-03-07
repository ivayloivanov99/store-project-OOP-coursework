package store.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import store.panels.Header;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel header = new Header();
	JPanel menu = new MenuClass();
	JPanel footer = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

	int height = 800;
	int width = 1200;

	public MyFrame() {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setTitle("My Store");
		this.add(header, BorderLayout.NORTH);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(menu, BorderLayout.CENTER);
		this.add(footer, BorderLayout.SOUTH);
		footer.setBackground(Color.BLACK);
		leftPanel.setBackground(Color.BLACK);
		rightPanel.setBackground(Color.BLACK);

		this.setVisible(true);
	}
}
