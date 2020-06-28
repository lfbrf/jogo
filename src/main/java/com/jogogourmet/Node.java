package com.jogogourmet;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Node {
	private JFrame parent;

	private String question;

	private Node parentNode;

	private Node yes;

	private Node no;

	private EndNodeEntity endNodeEntity;

	private boolean isYesNode;

	public Node(JFrame parent) {
		this.parent = parent;
	}

	public String ask() {
		boolean response = (JOptionPane.showConfirmDialog(
				this.parent, 
				this.question, 
				"Confirm", 
				0) == 0);
		if (response) {
			return this.yes.ask();
		} else {
			return this.no.ask();
		} 
	}

	public EndNodeEntity getEndNodeEntity() {
		return endNodeEntity;
	}

	public void setEndNodeEntity(EndNodeEntity endNodeEntity) {
		this.endNodeEntity = endNodeEntity;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Node getYes() {
		return this.yes;
	}

	public void setYes(Node yes) {
		this.yes = yes;
		yes.setParentNode(this, true);
	}

	public Node getNo() {
		return this.no;
	}

	public void setNo(Node no) {
		this.no = no;
		no.setParentNode(this, false);
	}

	public JFrame getParent() {
		return this.parent;
	}

	protected Node getParentNode() {
		return this.parentNode;
	}

	protected void setParentNode(Node parentNode, boolean isYesNode) {
		this.parentNode = parentNode;
		this.isYesNode = isYesNode;
	}

	protected boolean isYesNode() {
		return this.isYesNode;
	}
}

