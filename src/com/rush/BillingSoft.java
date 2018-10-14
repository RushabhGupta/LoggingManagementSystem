package com.rush;


//import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;

import java.sql.*;

public class BillingSoft {
	
	public static JLabel heading,namel,vehical_typel,vehicle_nol,phone,purposel, queryResultlabel; 
  
	public  static JTextField name_text,veh_no_text;
	
	public  static JTextArea purpose;
	
	public static JRadioButton car,bike,walk;
	
	public static ButtonGroup bg;
	 
	public static JFormattedTextField phone_text;
	public static JButton submit,reset;


	
	static String name,phn_no,vehicle_type,vehicle_no,purpo;
	
	static long long_no;
	public static void paintForm()
	{
      JFrame f= new JFrame("Log Book");  
	    
	    Border border=BorderFactory.createLineBorder(Color.BLACK,1);
	    
	    f.setBounds(500,100,900,800);
		   f.getContentPane().setBackground(Color.BLACK);
		   f.getContentPane().setForeground(Color.WHITE);

	  //....Heading " LOG BOOK"....
	    heading=new JLabel("Log Book"); 
	    heading.setForeground(Color.WHITE);
	    heading.setFont(new java.awt.Font("Serif",2|1|3, 30));
	    heading.setBackground(Color.white);
	    heading.setBounds(332,12,188,50);
	    f.getContentPane().add(heading);
	    f.getContentPane().setLayout(null);  

	    
	    // NAME label
	   namel = new JLabel("Name");
	   namel.setForeground(Color.WHITE);
	   namel.setFont(new java.awt.Font("Arial Black", 0,22 ));
	   namel.setBackground(Color.DARK_GRAY);
	   namel.setBounds(75, 150, 100, 100);
	   f.getContentPane().add(namel);
	   
	   //Phone number
	   
	   phone=new JLabel("Mobile Number");
	   phone.setForeground(Color.WHITE);
	   phone.setFont(new java.awt.Font("Arial Black",0,22));
	   phone.setBounds(75,280,193,70);
	   f.getContentPane().add(phone);
	   
	   
	   walk = new JRadioButton("Walk");
	   walk.setFont(new Font("Dialog", Font.PLAIN, 22));
	   walk.setBounds(605, 386, 90, 40);
	  
	   f.setVisible(true);
	   //Vehicle Type label
	   
	   vehical_typel = new JLabel("Vehicle Type");
	   vehical_typel.setForeground(Color.WHITE);
	   vehical_typel.setFont(new java.awt.Font("Arial Black",0,22));
	   vehical_typel.setBounds(75,363,155,87);
	   f.getContentPane().add(vehical_typel);
	   
	   //Vehicle number
	   vehicle_nol=new JLabel("Vehicle Number");
	   vehicle_nol.setForeground(Color.WHITE);
	   vehicle_nol.setFont(new java.awt.Font("Arial Black",0,22));
	   vehicle_nol.setBounds(75,438,193,100);
	   f.getContentPane().add(vehicle_nol);
	   
	   //Purpose
	   purposel=new JLabel("Purpose");
	   purposel.setFont(new java.awt.Font("Arial Black",0,22));
	   purposel.setForeground(Color.WHITE);
	   purposel.setBounds(75,550,300,100);
	   f.getContentPane().add(purposel);
	   
	   /// TextBox
	   name_text=new JTextField(" ");
	   name_text.setBounds(407, 185, 300,40);
	   name_text.setFont(new java.awt.Font("Arial Black",0,22));
	   name_text.setBorder(border);
	   name_text.setVisible(true);
	   f.getContentPane().add(name_text);
	   
	   phone_text = new JFormattedTextField();
	   phone_text.setFont(new Font("Dialog", Font.PLAIN, 22));
	   phone_text.setBounds(407, 296, 300,40);
	   phone_text.setBorder(border);

	   phone_text.setVisible(true);
	   f.getContentPane().add(phone_text);
	   
	   
	  
	   
	   veh_no_text = new JTextField(" ");
	   veh_no_text.setFont(new Font("Dialog", Font.PLAIN, 22));
	   veh_no_text.setBounds(407, 469, 300,40);
	   veh_no_text.setBorder(border);

	   veh_no_text.setVisible(true);
	   f.getContentPane().add(veh_no_text);
	   
	   purpose = new JTextArea(" ");
	   //purpose.setUI(new HintTextFieldUI("Search", true));

	   purpose.setFont(new Font("Dialog", Font.PLAIN, 22));
	   purpose.setBounds(407, 553, 200, 138);
	   purpose.setBorder(border);

	   purpose.setForeground(Color.BLACK);
	   purpose.setVisible(true);
	   f.getContentPane().add(purpose);
	   f.setVisible(true);
	   
	   car = new JRadioButton("Car");
	   car.setBounds(420,386,76,40);
	   car.setFont(new java.awt.Font("Arial Black",0,22));

	   
	   bike = new JRadioButton("Bike");
	   bike.setBounds(513,386,76,40);
	   bike.setFont(new java.awt.Font("Arial Black",0,22));
	   bg = new ButtonGroup();
	   bg.add(car);
	   bg.add(bike);
	   bg.add(walk);
	   
	   f.getContentPane().add(car);
	   f.getContentPane().add(bike);
	   f.getContentPane().add(walk);
	   
	   submit = new JButton("Submit Data");
	   submit.setForeground(new Color(0, 0, 0));
	   submit.setBackground(new Color(64, 224, 208));
	   submit.setBounds(619,550,135,40);
	   submit.setVisible(true);
	   reset = new JButton("Reset Data");
	   reset.setBackground(new Color(64, 224, 208));
	   reset.setBounds(619,599,135,40);
	   reset.setVisible(true);
	  
	   f.getContentPane().add(reset);
	   f.getContentPane().add(submit);
	   
	   queryResultlabel = new JLabel("");
	   queryResultlabel.setFont(new Font("Dialog", Font.BOLD, 18));
	   queryResultlabel.setForeground(Color.GREEN);
	   queryResultlabel.setBounds(407, 703, 357, 40);
	   f.getContentPane().add(queryResultlabel);
	   
	   JButton jumptologin = new JButton("Admin");
	   jumptologin.setBackground(new Color(64, 224, 208));
	   jumptologin.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		
	   		new AdminLogin().setVisible(true);
	   		f.dispose();
	        
	   	}
	   });
	   jumptologin.setBounds(619, 651, 135, 40);
	   f.getContentPane().add(jumptologin);
	   
	   
	   
	  
	}
	
	public static void getdata()
	{
		name =name_text.getText();
	
		phn_no=phone_text.getText();
	

	vehicle_type="";
	boolean carr = car.isSelected();
	boolean bikee= bike.isSelected();
	boolean walkk = walk.isSelected(); 
	if(carr==true)
	{
		vehicle_type="Car";
		
	}
	if(bikee==true)
	{
		vehicle_type="Bike";
	}
	if(walkk==true)
	{
		vehicle_type="Walk";
	}
	vehicle_no = veh_no_text.getText().trim();
	purpo = purpose.getText().trim();
	String g = name+"\n"+phn_no+"\n"+vehicle_type+"\n"+vehicle_no+"\n"+purpo ;
  ;
 long_no=Long.parseLong(phn_no);
 

 

		
	}
	public static void cleardata()
	{
		name_text.setText("");
		phone_text.setText("");
		
		veh_no_text.setText("");
		purpose.setText("");
		purpose.setText("");

		name=phn_no=vehicle_type=vehicle_no=purpo=null;
		long_no=0;
		queryResultlabel.setVisible(false);

		
		
	}
	
	public static void callAll()
	{
		paintForm();
		
		 reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					cleardata();
					
				}
			});
		 
		 submit.addActionListener(new ActionListener(){  //button method
			  
				public void actionPerformed(ActionEvent e) {

					getdata();
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
						if(!con.isClosed() || con!=null)
							System.out.println("Connection Successful");
						String query = " insert into test1 (v_name,v_phone,v_type,v_vehno,v_purpose,date_time)" + " values (?, ?, ?, ?, ?, now());";

						PreparedStatement preparedStatement = con.prepareStatement(query);
						preparedStatement.setString(1, name);
						preparedStatement.setLong(2,long_no);
						preparedStatement.setString(3, vehicle_type);
						preparedStatement.setString(4, vehicle_no);
						preparedStatement.setString(5, purpo);

						boolean ack = preparedStatement.execute();
						if(ack==false)
						{
							queryResultlabel.setVisible(true);
							queryResultlabel.setText("Data Inserted Successfully");
						}
						else
						{
							queryResultlabel.setVisible(true);

							queryResultlabel.setForeground(Color.RED);
							queryResultlabel.setText("Data not Inserted");
						
						}
							
						con.close();	
			       }catch(Exception e1)
			       {
			    	   System.out.println(e1);
			       }
					 
					 }  
			    });  
	}
	
	public static void main(String args[])
	{
     callAll();// calling paint form as well as action listener 
    
     

	}
