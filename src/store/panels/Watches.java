package store.panels;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import store.gui.MainClass;

public class Watches extends JPanel {
	private static final long serialVersionUID = 1L;

	public Watches() {

		this.setBackground(Color.BLACK);
		this.setLayout(new GridBagLayout());

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(MainClass.itemList.get(17).getImage()));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
