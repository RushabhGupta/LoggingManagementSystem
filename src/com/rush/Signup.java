package com.rush;

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private JTextField userfield;
	private JPasswordField passwordField;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		getContentPane().setBackground(UIManager.getColor("List.selectionBackground"));
		setBackground(UIManager.getColor("Label.foreground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSignUp.setBounds(202, 12, 92, 23);
		getContentPane().add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(51, 122, 100, 15);
		getContentPane().add(lblUsername);
		
		JLabel lblPassoword = new JLabel("Passoword");
		lblPassoword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassoword.setBounds(51, 171, 100, 15);
		getContentPane().add(lblPassoword);
		
		JLabel lblConfirm = new JLabel("Confirm");
		lblConfirm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblConfirm.setBounds(51, 221, 86, 15);
		getContentPane().add(lblConfirm);
		
		userfield = new JTextField();
		userfield.setFont(new Font("Dialog", Font.PLAIN, 14));
		userfield.setBounds(180, 118, 167, 31);
		getContentPane().add(userfield);
		userfield.setColumns(10);
		
		JLabel inserted = new JLabel(" ");
		inserted.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		inserted.setBounds(67, 297, 280, 23);
		getContentPane().add(inserted);
		
		JButton SignUpBut = new JButton("Sign Up");
		SignUpBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usr = userfield.getText();
				String pass = passwordField.getText();
				String confirm = confirmpass.getText();
				
				if(pass.equals(confirm))
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
	     			if(!con.isClosed() || con!=null)
	     				System.out.println("Connection Successful");
	     			
	     			Statement stmt = con.createStatement();
		     		stmt.executeUpdate("insert into adminLog values(\'"+usr+"\',\'"+confirm+"\')");
		     		inserted.setForeground(Color.green);
		     		inserted.setText("Signed Up Successfully");
		     		
		     		
	     			
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
	     			
			
			}
				else
				{
					inserted.setForeground(Color.red);
		     		inserted.setText("Password Doesnt Match");
		     		
				}
					
			}
		});
		SignUpBut.setBounds(230, 250, 117, 25);
		getContentPane().add(SignUpBut);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 165, 168, 31);
		getContentPane().add(passwordField);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(180, 207, 167, 31);
		getContentPane().add(confirmpass);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(346, 431, 117, 25);
		getContentPane().add(btnBack);
		
		
	}
}
