package com.jogogourmet;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EndNode extends Node {


	public EndNode(JFrame parent) {
		super(parent);
	}

	private void setNewNode(String question, String dish) {
		Node newNode = new Node(getParent());
		EndNode newEndNode = new EndNode(getParent());
		EndNodeEntity nodeEntity = new EndNodeEntity();
		nodeEntity.setDish(dish);
		setEndNodeEntity(nodeEntity);
		getParentNode().setEndNodeEntity(nodeEntity);
		if (isYesNode()) {
			getParentNode().setYes(newNode);
		} else {
			getParentNode().setNo(newNode);
		} 
		newNode.setQuestion(question);
		newNode.setYes(newEndNode);
		newNode.setNo(this);
		newNode.setEndNodeEntity(nodeEntity);
	}

	private String checkResponse(boolean response) {
		if (response) {
			JOptionPane.showMessageDialog(getParent(), "Acertei de novo!", "Jogo Gourmet", 1);
		} else {

			String dish = JOptionPane.showInputDialog(
					getParent(), 
					"Qual prato você pensou?", 
					"Desisto", 
					3); 
			String question = JOptionPane.showInputDialog(
					getParent(), 
					dish + " é _______ mas " + getEndNodeEntity().getDish() + " não. \n" +
							"Complete", 
							3);
			question = "O prato que você pensou é " + question + "?";


			setNewNode( question,  dish);
			return dish;
		} 
		return "";
	}

	public String ask() {
		if(getEndNodeEntity() == null) {
			setEndNodeEntity(getParentNode().getEndNodeEntity());
		}
		boolean response = (JOptionPane.showConfirmDialog(
				getParent(), 
				"O prato que você pensou é " + getEndNodeEntity().getDish() + "?", 
				"Confirm", 
				0) == 0);
		return checkResponse(response);
	}
}

