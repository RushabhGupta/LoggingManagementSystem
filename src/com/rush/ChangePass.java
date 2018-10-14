package com.rush;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChangePass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}
	public ChangePass(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(500,100, 500, 500);
		getContentPane().setLayout(null);

		
		
		contentPane = new JPanel();
		
		
		contentPane.setLayout(null);
		this.setVisible(true);
	}

}
