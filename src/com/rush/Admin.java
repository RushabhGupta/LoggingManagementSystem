package com.rush;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;
import com.sun.glass.ui.Pixels.Format;
import com.sun.javafx.embed.swing.Disposer;
import com.sun.org.apache.xpath.internal.operations.NotEquals;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

public class Admin {
	private static JTextField from_text;
	private static JTextField to_text;
	private static JTextField selectedText;
	private static JLabel from_l,to_l;
	
	public static int count_row1,count_row2;
	//private static JTable table1;
	
	public static JFrame j;
	private static JButton go_but;
	private JTableHeader header ;
	private JTable table;
	private String column_name[]= {"Name","Contact","Type","Vehica No","Purpose","DataTime","Srno"};
	DefaultTableModel defaultTableModel;
	
 
	
	
	
	 public void paintQueryBuilder()
	{
		

		
        j= new JFrame("Log Book"); 
	    j.setBounds(200,10,800,800);
	    j.getContentPane().setBackground(Color.BLACK);
	    j.setVisible(true);
	   
	    
	    JLabel admin_label = new JLabel("Administrator");
	    admin_label.setBounds(300, 29, 256, 43);
	    admin_label.setForeground(Color.WHITE);
	    admin_label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
	    j.setVisible(true);
	     
	      
	      JButton today_but = new JButton("Today's Entries");
	      today_but.setBounds(36, 131, 170, 32);
	      
	      today_but.setBackground(UIManager.getColor("CheckBox.focus"));
	      today_but.setVisible(true);
	      today_but.setFont(new Font("Dialog", Font.BOLD, 16));
	      
	      JButton today_time_but = new JButton("Search date and time");
	      today_time_but.setBounds(288, 131, 224, 32);
	      
	      JButton filterGo = new JButton("Go");
	      filterGo.setVisible(false);
	      
	      
	   
	      
	      today_time_but.setFont(new Font("Dialog", Font.BOLD, 16));
	      today_time_but.setToolTipText("");
	      
	      from_text = new JTextField();
	      from_text.setBounds(408, 206, 126, 30);
	      from_text.setVisible(false);
	      from_text.setColumns(10);
	      
	      
	      selectedText= new JTextField();
	      selectedText.setVisible(false);
	      selectedText.setBounds(576, 222, 170, 30);
	      
	      
	      
	      JLabel date_lab = new JLabel("Date");
	      date_lab.setBounds(36, 201, 70, 32);
	      date_lab.setVisible(false);
	      date_lab.setForeground(Color.RED);
	      date_lab.setFont(new Font("Dialog", Font.BOLD, 18));
	      
	      from_l = new JLabel("From");
	      from_l.setBounds(341, 210, 70, 15);
	      from_l.setVisible(false);
	      from_l.setFont(new Font("Dialog", Font.BOLD, 18));
	      from_l.setForeground(Color.RED);
	      
	      to_l = new JLabel("To");
	      to_l.setBounds(566, 205, 31, 25);
	      to_l.setVisible(false);
	      to_l.setFont(new Font("Dialog", Font.BOLD, 18));
	      to_l.setForeground(Color.RED);
	      
	      to_text = new JTextField();
	      to_text.setVisible(false);
	      to_text.setBounds(620, 206, 126, 30);
	      to_text.setColumns(10);
	      
	      go_but = new JButton("Go");
	      go_but.setBounds(408, 264, 126, 25);
	      
	      JDateChooser dateChooser = new JDateChooser();
	      dateChooser.setVisible(false);
	      dateChooser.setDateFormatString("yyyy-MM-dd");
	      dateChooser.setBounds(107, 206, 135, 28);
	      j.getContentPane().add(dateChooser);
	      
	      JLabel time_l = new JLabel("Time");
	      time_l.setBounds(277, 206, 70, 23);
	      time_l.setVisible(false);
	      time_l.setForeground(new Color(255, 0, 0));
	      time_l.setFont(new Font("Dialog", Font.BOLD, 18));
	      
	      JLabel lblNoteEnter = new JLabel("Note: Enter 24 hr format ");
	      lblNoteEnter.setBounds(312, 160, 180, 32);
	      lblNoteEnter.setVisible(false);
	      lblNoteEnter.setForeground(new Color(192, 192, 192));
	      
	      String filterStr[]= {"Name","Vehical Number","Type"};
	      JComboBox comboBox = new JComboBox(filterStr);
	      comboBox.setBounds(566, 186, 183, 24);
	      comboBox.setVisible(false);
	      
	      JButton btnFilterWith = new JButton("Filter With");
	      btnFilterWith.setBounds(566, 133, 180, 30);
	      btnFilterWith.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		comboBox.setVisible(true);
	      		filterGo.setVisible(true);
	      		
	      		from_l.setVisible(false);
	     		from_text.setVisible(false);
	     		to_l.setVisible(false);
	     		to_text.setVisible(false);
	     		go_but.setVisible(false);	
	     		date_lab.setVisible(false);
	     		time_l.setVisible(false);
	     		lblNoteEnter.setVisible(false);
	     		dateChooser.setVisible(false);
	     		selectedText.setVisible(true);
	     		filterGo.setVisible(true);
	     		
	     		
	     		
	      	}
	      });
	      j.getContentPane().setLayout(null);
	      j.getContentPane().add(admin_label);
	      j.getContentPane().add(time_l);
	      j.getContentPane().add(lblNoteEnter);
	      j.getContentPane().add(from_l);
	      j.getContentPane().add(from_text);
	      j.getContentPane().add(to_l);
	      j.getContentPane().add(to_text);
	      j.getContentPane().add(go_but);
	      j.getContentPane().add(today_but);
	      j.getContentPane().add(today_time_but);
	      j.getContentPane().add(date_lab);
	      j.getContentPane().add(btnFilterWith);
	      j.getContentPane().add(comboBox);
	      j.getContentPane().add(selectedText);
	      
	      
	      table = new JTable();
	      table.setForeground(Color.BLACK);
	      table.setFont(new Font(Font.SERIF, 0, 15));
	      table.setEnabled(false);
	      header = table.getTableHeader();
	      header.setFont(new Font(Font.SERIF, 0, 17));
	      header.setForeground(Color.red);
	    
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setEnabled(false);
	      scrollPane.setBounds(36, 415, 733, 308);
	      j.getContentPane().add(scrollPane);
	      
	      
	      scrollPane.setViewportView(table);
	      
	      
	      filterGo.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		int count_row1 = 0;
      			//String column_name[]= {"Name","MobileNo","Vehciletype","Vehiclenumber","Purpose","DataTime","Srno"};
      			String ThirdData[][] = null;
      			String selected=null;
      			String SelectedStr =selectedText.getText(); 
      			int count_row2=0;
      		  		
      		  		try {
      		  		 
      		  			
      		  			
      		  			
      		  			Class.forName("com.mysql.jdbc.Driver");
      		  			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
      		  			if(!con2.isClosed() || con2!=null)
      		  				System.out.println("Connection Successful");
      		  			
      		  		
      		  			if(comboBox.getSelectedIndex()==0)
      		  			{
      		  				selected="v_name";
      		  			System.out.println("In Index 0 if"+selected);
      		  			}
      		  			else if (comboBox.getSelectedIndex()==1) {
      		  			selected="v_vehno";
      		  			System.out.println("In Index 1 if"+selected);
						}
      		  			else if(comboBox.getSelectedIndex()==2)
      		  			{
      		  			selected="v_type";
      		  			System.out.println("In Index 2 if"+selected);
      		  			}
      		  			
      		  			System.out.println(" "+SelectedStr);
      		  			
      		  		String query2 ="select count(*) from test1 where "+ selected +" like '%"+SelectedStr+"%'";
      		  		
      		  		
      		  		PreparedStatement preparedStatement2=con2.prepareStatement(query2);
      		  		
      		  		
      		  		ResultSet rss2 =preparedStatement2.executeQuery(query2);
      		  		System.out.println(query2);
      		  		
      		  		while(rss2.next())
      		  		{
      		  			count_row2 = rss2.getInt(1);
      		  		}	
      		  		
      		  		System.out.println(count_row2);
      		  		
      		  		ThirdData = new String[count_row2][7] ;
      		  		
      		  		String query1="select * from test1 where "+selected+" like '%"+SelectedStr+"%';";
      		  		
      		  		
      		  		PreparedStatement preparedStatement21=con2.prepareStatement(query1);
      		  		
      				ResultSet rss = preparedStatement21.executeQuery(query1);
      				int i=0;
      				while(rss.next())
      				{
      					
      					
      						
      				           	ThirdData[i][0]=rss.getString(1);
      				           	
      				           	ThirdData[i][1]=Long.toString(rss.getLong(2));
      				           	ThirdData[i][2]=rss.getString(3);
      				           	ThirdData[i][3]=rss.getString(4);
      				           	ThirdData[i][4]=rss.getString(5);
      				      		ThirdData[i][5]= rss.getString(6);
      				      		ThirdData[i][6]=Integer.toString(rss.getInt(7));
      							
      							i++;
      							
      					
      					
      				}
      				defaultTableModel = new DefaultTableModel(ThirdData, column_name);
      				table.setModel(defaultTableModel);
	      		
	      		
	      	}catch (Exception e1) {
				// TODO: handle exception
	      		System.out.println(e);
			}
      		  		
	      	}
	      });
	      filterGo.setBounds(596, 264, 126, 25);
	      j.getContentPane().add(filterGo);
	      
	      JLabel result_l = new JLabel("");
	      result_l.setFont(new Font("Dialog", Font.BOLD, 12));
	      result_l.setForeground(Color.GREEN);
	      result_l.setBounds(36, 368, 107, 23);
	      j.getContentPane().add(result_l);
	      
	      
	      go_but.setVisible(false);
	      
	      ///////////////// Go Button;
	      
	      
	      go_but.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		 
	      		String str1 =from_text.getText();
      			String str2 =to_text.getText();	
      			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      			String strdt=dateFormat.format(dateChooser.getDate());
      			
			 ///  new DateTimeTable(strdt, str1, str2).setVisible(true);
			   //j.dispose();
      			
      			int count_row1 = 0;
      			//String column_name[]= {"Name","MobileNo","Vehciletype","Vehiclenumber","Purpose","DataTime","Srno"};
      			String SecondData[][] = null;
      		
      			
      			int count_row2=0;
      		  		
      		  		try {
      		  		 
      		  			
      		  			System.out.println(strdt);
      		  			
      		  			Class.forName("com.mysql.jdbc.Driver");
      		  			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
      		  			if(!con1.isClosed() || con1!=null)
      		  				System.out.println("Connection Successful");
      		  			
      		  		
      		  			
      		  		String query11 ="select count(*) from test1 where date_time  between  \'"+strdt+" " +str1+"\' and \'"+strdt+" " +str2+"\'";
      		  		
      		  		PreparedStatement preparedStatement1=con1.prepareStatement(query11);
      		  		
      		  		
      		  		ResultSet rss1 =preparedStatement1.executeQuery(query11);

      		  		
      		  		while(rss1.next())
      		  		{
      		  			count_row2 = rss1.getInt(1);
      		  		}	
      		  		
      		  		System.out.println(count_row2);
      		  		
      		  		SecondData = new String[count_row2][7] ;
      		  		
      		  		String query1="select * from test1 where date_time between \'"+strdt+" "+str1+"\' and \'"+strdt+" " +str2+"\'";
      		  		
      		  		PreparedStatement preparedStatement2=con1.prepareStatement(query1);
      		  		
      				ResultSet rss = preparedStatement2.executeQuery(query1);
      				int i=0;
      				while(rss.next())
      				{
      					
      					
      						
      				           	SecondData[i][0]=rss.getString(1);
      				           	
      			        		SecondData[i][1]=Long.toString(rss.getLong(2));
      							SecondData[i][2]=rss.getString(3);
      							SecondData[i][3]=rss.getString(4);
      							SecondData[i][4]=rss.getString(5);
      							SecondData[i][5]= rss.getString(6);
      							SecondData[i][6]=Integer.toString(rss.getInt(7));
      							
      							i++;
      							
      					
      					
      				}
      				
      				defaultTableModel = new DefaultTableModel(SecondData, column_name);
      				table.setModel(defaultTableModel);
      				
		    		
      				
      				
      			
      		            
      			    
      			    con1.close();
      		  		}catch(Exception e1)
      					{
      					System.out.println(e1);	
      					}
	      	
	      	}
	      	
	      	
	      });
	      
	      
	      
	      ////////visible other button today time
	      
	      
	      today_time_but.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) 
		     	{
		     		dateChooser.setVisible(true);
		     		from_l.setVisible(true);
		     		from_text.setVisible(true);
		     		to_l.setVisible(true);
		     		to_text.setVisible(true);
		     		go_but.setVisible(true);	
		     		date_lab.setVisible(true);
		     		time_l.setVisible(true);
		     		lblNoteEnter.setVisible(true);
		     		comboBox.setVisible(false);
		     		table.setVisible(false);
		     		filterGo.setVisible(false);
		     		selectedText.setVisible(false);

		     		
		     		
		     				     	
		     			     		
		     	}
		     	
		     });

	      
//////////////today time button
	      today_but.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     	
		     		

		     		table.setVisible(true);
		    		
		    		try {
		     			
		     			Class.forName("com.mysql.jdbc.Driver");
		     			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booklog", "root", "mahi123");
		     			
		     		Statement stmt = (Statement) con.createStatement();
		     		System.out.println("Connection Successfull");
		     		ResultSet rs1 =stmt.executeQuery("select count(*) from test1 where date_time>date(now());");
		     		
		     		
		     		while(rs1.next())
		     		{
		     			count_row1 = rs1.getInt(1);
		     		}	
		     		String firstData[][] = new String[count_row1][7] ;
		    		ResultSet rs = stmt.executeQuery("select * from test1 where date_time >date(now())");
		    		int i=0;
		    		while(rs.next())
		    		{
		    			
		    			
		    				
		    					firstData[i][0]=rs.getString(1);
		    					
		    					firstData[i][1]=Long.toString(rs.getLong(2));
		    					firstData[i][2]=rs.getString(3);
		    					firstData[i][3]=rs.getString(4);
		    					firstData[i][4]=rs.getString(5);
		    					firstData[i][5]= rs.getString(6);
		    					firstData[i][6]=Integer.toString(rs.getInt(7));
		    					i++;
		    					
		    			
		    			
		    		}

		    		
		    		System.out.println(count_row1);
		    		
      				defaultTableModel = new DefaultTableModel(firstData, column_name);
      				table.setModel(defaultTableModel);
      				
		    	        
		                
		               
		    		     
		    		  
		    		con.close();
		     		}catch(Exception e1)
		    			{
		    			System.out.println(e1);	
		    			}
		     		//new TodayTable().setVisible(true);
		     		//j.dispose();
		     		
		     		
		     	}
		     });
	     
	
	     j.setVisible(true);
	    	     
	    
	   
	    
	j.setVisible(true);     

	}
	
	public static void main(String args[])
	{
		Admin admin=new Admin();
		admin.paintQueryBuilder();
	}
}

