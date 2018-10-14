package com.rush;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {


	private JTextField userfield;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
	}
				

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setBackground(UIManager.getColor("List.foreground"));
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAdministrartive = new JLabel("Log In");
		lblAdministrartive.setForeground(Color.WHITE);
		lblAdministrartive.setBackground(UIManager.getColor("Label.disabledForeground"));
		lblAdministrartive.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblAdministrartive.setBounds(210, 12, 175, 30);
		getContentPane().add(lblAdministrartive);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblUserName.setBounds(37, 106, 129, 30);
		getContentPane().add(lblUserName);
		
		userfield = new JTextField();
		userfield.setBounds(184, 99, 219, 37);
		getContentPane().add(userfield);
		userfield.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblPassword.setBounds(37, 166, 114, 31);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 163, 219, 37);
		getContentPane().add(passwordField);
		
		JLabel sucess = new JLabel("");
		sucess.setBackground(new Color(255, 0, 0));
		sucess.setFont(new Font("Dialog", Font.BOLD, 14));
		sucess.setBounds(184, 367, 243, 30);
		getContentPane().add(sucess);
		JButton create = new JButton("SignUp");
		create.setBackground(new Color(64, 224, 208));
		create.setVisible(false);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
				dispose();
				
			}
		});
		create.setBounds(184, 222, 96, 25);
		getContentPane().add(create);
		JButton showRecord = new JButton("Show Records");
		showRecord.setBackground(new Color(64, 224, 208));
		
		JButton login_but = new JButton("Login");
		login_but.setBackground(new Color(64, 224, 208));
		login_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = userfield.getText();
				String password =passwordField.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
	     			if(!con.isClosed() || con!=null)
	     				System.out.println("Connection Successful");
	     			
	     		Statement stmt = con.createStatement();
	     		String sqlpass="";
	     		
	     		ResultSet rs1 =stmt.executeQuery("select password from adminLog where username =\'"+username+"\'");
	     		
	     		while(rs1.next())
	     		{
	     		sqlpass=rs1.getString(1);
	     		}
	     	
	     		System.out.println(sqlpass);
	     		System.out.println(password);
	     		
	     		
	     		if(sqlpass.equals(password))
	     		{
	     			
	     			System.out.println("True");
	     			sucess.setForeground(Color.GREEN);
	     			sucess.setText("Authentication Successful");
	     			create.setVisible(true);
	     			showRecord.setVisible(true);
	     			
	     			
	     		}
	     		else
	     		{
	     			
	     			sucess.setForeground(Color.RED);
	     			sucess.setText("Authentication UnSuccessful");
	     			System.out.println("Else");
	     				     			
	     		}
					
				} catch (Exception e1) {
					System.err.println(e1);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     			
			}
		});
		login_but.setBounds(317, 222, 83, 25);
		getContentPane().add(login_but);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(127, 255, 212));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillingSoft();
				BillingSoft.paintForm();
				dispose();
			}
		});
		btnBack.setBounds(224, 372, 137, 25);
		getContentPane().add(btnBack);
		
		
		showRecord.setVisible(false);
		showRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().paintQueryBuilder();
				dispose();
			}
		});
		showRecord.setBounds(227, 272, 134, 25);
		getContentPane().add(showRecord);
		
		JButton ChangePass = new JButton("Change Pass");
		ChangePass.setBackground(new Color(64, 224, 208));
		ChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePass().setVisible(true);
				dispose();
			}
		});
		ChangePass.setVisible(false);
		ChangePass.setBounds(225, 319, 136, 25);
		getContentPane().add(ChangePass);
		
		
		
		
		
		
		
		
	}
}
