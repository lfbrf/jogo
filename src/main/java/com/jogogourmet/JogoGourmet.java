package com.jogogourmet;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class JogoGourmet extends JFrame {
	private static final long serialVersionUID = -1195617528474947903L;

	private Node rootNode;

	private void init() {
		setInitialLayout();
		setPanelConfig();
		pack();
		setRootNode();
	}
	
	private void setInitialLayout() {
		setTitle("Jogo Gourmet");
		setDefaultCloseOperation(3);
		
	}

	private void setPanelConfig() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, 3));
		Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
		panel.setBorder(padding);
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogoGourmet.this.okPressed();
			}
		});
		button.setAlignmentX(0.5F);
		JLabel label = new JLabel("Pense em um prato que gosta");
		label.setAlignmentX(0.5F);
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(button);
		setContentPane(panel);
	}
	
	private void setRootNode() {
		EndNodeEntity endNodeEntity = new EndNodeEntity ();
		setLocationRelativeTo(null);
		setVisible(true);
		EndNode yesNode = new EndNode(this); 
		endNodeEntity.setDish("Lasanha");
		yesNode.setEndNodeEntity(endNodeEntity);
		EndNode noNode = new EndNode(this);
		endNodeEntity.setDish("Bolo de Chocolate");
		noNode.setEndNodeEntity(endNodeEntity);
		this.rootNode = new Node(this);
		this.rootNode.setQuestion("O prato que você pensou é massa?");
		this.rootNode.setYes(yesNode);
		this.rootNode.setNo(noNode);
		
	}

	public JogoGourmet() {
		init();
	}

	private void okPressed() {
		System.out.println("VALOR RETORNADO");
		EndNodeEntity endNodeEntity = new EndNodeEntity ();
		endNodeEntity.setDish(this.rootNode.ask());
		this.rootNode.setEndNodeEntity(endNodeEntity);
		this.rootNode.setParentNode(this.rootNode, true);
		System.out.println(this.rootNode.getEndNodeEntity().getDish());
	}

}

