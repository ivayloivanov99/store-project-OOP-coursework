package store.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import store.panels.WatchesPanel;
import store.panels.SmartphonesPanel;
import store.panels.LaptopsPanel;
import store.panels.Laptops;
import store.panels.Smartphones;
import store.panels.Watches;
import store.panels.WelcomePanel;

public class MenuClass extends JPanel {

	private static final long serialVersionUID = 1L;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Store");
	DefaultTreeModel model = new DefaultTreeModel(root);
	JTree tree = new JTree(model);
	JPanel card = new JPanel();

	public MenuClass() {

		card.setLayout(new CardLayout());
		card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		card.setSize(600, 600);

		DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("Watches");
		n1.add(new DefaultMutableTreeNode("Rolex"));
		DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("Smartphones");
		n2.add(new DefaultMutableTreeNode("Apple"));
		DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("Laptops");
		n3.add(new DefaultMutableTreeNode("Dell"));

		card.add(new WelcomePanel(), "Shop");
		card.add(new Watches(), "Watches");
		card.add(new Smartphones(), "Smartphones");
		card.add(new Laptops(), "Laptops");
		card.add(new WatchesPanel(), "Rolex");
		card.add(new SmartphonesPanel(), "Apple");
		card.add(new LaptopsPanel(), "Dell");

		root.add(n1);
		root.add(n2);
		root.add(n3);

		tree.setEditable(true);
		tree.setSelectionRow(0);
		tree.setRootVisible(true);
		tree.setShowsRootHandles(true);

		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {

				final CardLayout cards = (CardLayout) card.getLayout();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				cards.show(card, selectedNode.toString());
			}
		});

		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(250, 800));
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.WEST);
		this.add(card, BorderLayout.CENTER);
		this.setVisible(true);

	}
}
