import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class RTX3090OrderComplete
{

	int total_orderNo, orderfileIs;
	String order_model, order_user, order, order_orderID, order_userPhone, order_userEmail, order_quantity, order_price, order_userName, address="";
	
	
	public RTX3090OrderComplete ()
	{
		//frame
		JFrame frame = new JFrame("Delivery Information");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(fr_icon);
		frame.setLayout(null);
		frame.setResizable(false);
	
		frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
		
	
///////////////////////////////////////////////////////////////////////////ORDER Information///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getting TOtal Order NO 
		String orderNo="";
		try{
			File orderFile = new File("TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(orderFile);//Scan File
						
			while(scanFile.hasNext()){
				orderNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			total_orderNo= Integer.parseInt(orderNo);
			total_orderNo=total_orderNo-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Confirm");}

//Getting Running Order 
		try{
			File running_user_File = new File("TXT FILES\\tempOrder.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				order=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running Order file problem in Confirm Panel");
		}

//Getting Running Order Information
		for(int i=1; i<=total_orderNo; i++)
		{
			String Order_File_NO="TXT FILES\\Order_Info\\Order-"+i+".txt";
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					order_orderID=scanFile.next();
					order_model=scanFile.next();
					order_user=scanFile.next();
					order_userPhone=scanFile.next();
					order_userEmail=scanFile.next();
					order_quantity=scanFile.next();
					order_price=scanFile.next();
					order_userName=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(order_orderID.equals(order))
				{
					orderfileIs=i;
					break;
				}
			}catch(Exception f)		{System.out.println("Order File Problem in Confirm Panel");}
		}
		//Getting Address 
		String addressFile="TXT FILES\\Adresses\\Adress-"+orderfileIs+".txt";
						
			try{
				File address_file = new File(addressFile);		
				Scanner scanFile = new Scanner(address_file);//Scan File
						
				while(scanFile.hasNext()){
					address=address+scanFile.next()+" ";
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("address file problem");}

		 
		 //Tick_Mark label	
	    JLabel Tick_Mark_Label = new JLabel((new ImageIcon("Images\\green-tick.gif")));
		Tick_Mark_Label.setBounds(403,118,53,50);
        Tick_Mark_Label.setOpaque(true);		
		frame.add(Tick_Mark_Label);
		
		//Name label	
	    JLabel Name_label = new JLabel(order_userName);
		Name_label.setBounds(340,287,250,30);
		Name_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Name_label.setForeground(Color.decode("#F2F2F2"));
		frame.add(Name_label);
		
		//Phone_Number label	
	    JLabel Phone_Number_label = new JLabel(order_userPhone);
		Phone_Number_label.setBounds(340,325,250,30);
		Phone_Number_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Phone_Number_label.setForeground(Color.decode("#F2F2F2"));
		frame.add(Phone_Number_label);
		
		//Email_Address label	
	    JLabel Email_Address_label = new JLabel(order_userEmail);
		Email_Address_label.setBounds(340,362,250,30);
		Email_Address_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Email_Address_label.setForeground(Color.decode("#F2F2F2"));
		frame.add(Email_Address_label);
		
		//Order_Amount label	
	    JLabel Order_Amount_label = new JLabel(order_price);
		Order_Amount_label.setBounds(340,400,250,30);
		Order_Amount_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Order_Amount_label.setForeground(Color.decode("#F2F2F2"));
		frame.add(Order_Amount_label);
		
		//Delivery_address label	
	    JLabel Delivery_address_label = new JLabel(address);
		Delivery_address_label.setBounds(340,437,250,30);
		Delivery_address_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Delivery_address_label.setForeground(Color.decode("#F2F2F2"));
		frame.add(Delivery_address_label);
		
		
		//------------------ Button ------------------
		//Home button
		JButton Home_Button = new JButton();
		Home_Button.setBounds(362,488,110,31);
		Home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Home_Button.setContentAreaFilled(false);
		Home_Button.setBorderPainted(false);
		Home_Button.setFocusPainted(false);
		Home_Button.setToolTipText("Back to Home");
		frame.add(Home_Button);
		
		//Print button
		JButton Print_Button = new JButton();
		Print_Button.setBounds(546,488,110,31);
		Print_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Print_Button.setContentAreaFilled(false);
		Print_Button.setBorderPainted(false);
		Print_Button.setFocusPainted(false);
		Print_Button.setToolTipText("Print Recite");
		frame.add(Print_Button);
		

		
		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\Order Placed - RTX 3090 Ti.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		frame.add(bg_label);
		
		frame.setVisible(true);



		///////////////////////////////////////////////////////// Action Listeners /////////////////////////////////////////////////////////
		
		//Back to Home Button Action Listener
			 	Home_Button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent u){
						frame.setVisible(false);
						new Components();
					}
				}); 

		 //Print Button Action Listener
				new Print_Operation(address);
				Print_Button.addActionListener(new Print_Operation());

		frame.setVisible(true);
		}
}
