import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class Profile extends JFrame {
	
	private JTextField voucher_Field;
	private JButton Recharge, home, logout;
	private Container c;
	private Cursor cursor;
	boolean recharge_access, found_access;
	int fileNo;
	int fileIs;
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	static String usedCode1, usedCode2, usedCode3, usedCode4, usedCode5;
	
	
	//Colors
	Color White = Color.decode("#F2F2F2");

	Profile() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Profile");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		c = frame.getContentPane();
		c.setLayout(null);
		
		//Frame Close Confirmation
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
		

//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			fileNo= Integer.parseInt(filenumber);
			fileNo=fileNo-1;
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}

//Get the Running user from running user file
		try{
			File running_user_File = new File("TXT FILES\\Running_User.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				user=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running user file problem in Account Panel");
		}
		
	
//Match the user got from running user file with the list of users
		for(int i=1; i<=fileNo; i++)
		{
			String User_Information_File_Path="TXT FILES\\User Informations\\User--"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					user_username=scanFile.next();
					user_password=scanFile.next();
					user_email=scanFile.next();
					user_phone=scanFile.next();
					user_balance=scanFile.next();
					user_name=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(user_username.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}
		//Got the all information about user|||||Now time to display them
		
		
		//-----------------------------------------Information Labels-----------------------------------------
		//Users Name Display
		JLabel nameLabel = new JLabel(user_name);
		nameLabel.setBounds(190,425,280,30);
		nameLabel.setFont(new Font ("Open Sans", Font.BOLD,28));
		nameLabel.setForeground(Color.decode("#4B4A87"));
		c.add(nameLabel);
		
		//Email Label
		JLabel email_Label = new JLabel(user_email);
		email_Label.setBounds(643,281,300,20);
		email_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		email_Label.setForeground(Color.decode("#F2F2F2"));
		c.add(email_Label);
		
		//Phone Number Label
		JLabel phone_Label = new JLabel(user_phone);
		phone_Label.setBounds(643,230,250,20);
		phone_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		phone_Label.setForeground(Color.decode("#F2F2F2"));
		c.add(phone_Label);
		
		//Username Label
		JLabel username_label = new JLabel(user_username);
		username_label.setBounds(643,179,200,20);
		username_label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		username_label.setForeground(Color.decode("#F2F2F2"));
		c.add(username_label);
				
		//Balance Label
		JLabel balance_Label = new JLabel(user_balance);
		balance_Label.setBounds(643,330,150,25);
		balance_Label.setFont(new Font ("Open Sans", Font.BOLD,16));
		balance_Label.setForeground(Color.decode("#F2F2F2"));
		c.add(balance_Label);
		
		//Voucher
		voucher_Field = new JTextField();
		voucher_Field = new HintTextField("#Apply Your Voucher");
		Font voucher_FieldFont = new Font("Open Sans", Font.PLAIN,16);
		voucher_Field.setBounds(548,375,315,33);
		voucher_Field.setFont(voucher_FieldFont);
		voucher_Field.setHorizontalAlignment(JTextField.LEFT);
		voucher_Field.setCursor(cursor);
		voucher_Field.setOpaque(false);
		voucher_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		voucher_Field.setHorizontalAlignment(JTextField.LEFT);
		new TextPrompt("#Apply Your Voucher", voucher_Field);
		voucher_Field.setForeground(Color.decode("#F2F2F2"));
		c.add(voucher_Field); 
		
		//Home
		home = new JButton();
		home.setBounds(32,73,35,35);
		home.setCursor(cursor);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		c.add(home);
		
		//Logout
		logout = new JButton();
		logout.setBounds(848,74,106,32);
		logout.setCursor(cursor);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		c.add(logout);
		
		//Recharge Button
		Recharge = new JButton();
		Recharge.setBounds(530,429,170,42);
		Recharge.setCursor(cursor);
		Recharge.setContentAreaFilled(false);
		Recharge.setBorderPainted(false);
		c.add(Recharge);
		
		//-----------------------------------------Action Listeners-----------------------------------------
		
		//ActionListener for Home
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Components();
				} 
		});
		
		//ActionListener for Logout
		logout.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Logout?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						frame.setVisible(false);
						new LoginPanel();
					}
				}
			}
		);
		
		//ActionListener for Add Balance
		Recharge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
		//Get the Running user from running user file
				try{
					File running_user_File = new File("TXT FILES\\Running_User.txt");		
					Scanner scanFile = new Scanner(running_user_File);//Scan File
								
					while(scanFile.hasNext()){
						user=scanFile.next();
						break;
					}
					scanFile.close();
								
				}catch(Exception f){
					System.out.println("Running user file problem in Add Balance");
				}
		
		
		//Match the user got from running user file with the list of users
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES\\User Informations\\User--"+i+".txt";
								
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
								
						while(scanFile.hasNext()){
							user_username=scanFile.next();
							user_password=scanFile.next();
							user_email=scanFile.next();
							user_phone=scanFile.next();
							user_balance=scanFile.next();
							user_name=scanFile.next()+" "+scanFile.next();
							break;
						}
						scanFile.close();
									
									
						if(user_username.equals(user))
						{
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
				
		//Got the all information about user|||||Now time to modify them

				String voucher=voucher_Field.getText();//Getting user input code
				
				String c1="",c2="",c3="",c4="",c5="";
				
			//Getting voucher codes
				try{
					File balanceCodeFile = new File("TXT FILES\\Balance_Codes.txt");		
					Scanner scanFile = new Scanner(balanceCodeFile);//Scan File
						
					while(scanFile.hasNext()){
						c1=scanFile.next();
						c2=scanFile.next();
						c3=scanFile.next();
						c4=scanFile.next();
						c5=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("Balance_Codes file has problem in Add Balance Panel");
				}
				
			//Got all the voucher codes		
				
			//Match the voucher codes with user input
				if( (voucher.equals(c1)) || (voucher.equals(c2)) || (voucher.equals(c3)) || (voucher.equals(c4)) || (voucher.equals(c5)) ) {	found_access=true;	}
				else{found_access=false;		recharge_access=false;}
				
			//Matching Done and got the found access true or false
				
			//Checking if the code is already been used or not
				if(found_access){
					
					if( (voucher.equals(usedCode1)) || (voucher.equals(usedCode2)) || (voucher.equals(usedCode3)) || (voucher.equals(usedCode4)) || (voucher.equals(usedCode5)) ){
						recharge_access=false;
					}else{
						recharge_access=true;
					}
				}
			//-----------
				if(recharge_access){
					double balance=Double.parseDouble(user_balance);
					balance+=50000;
					user_balance = Double.toString(balance);
					
					//Writing user file with updated balance
					try{
						String User_Information_File_Path="TXT FILES\\User Informations\\User--"+fileIs+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						
						formatter.format("%s\r\n", user_username);
						formatter.format("%s\r\n", user_password);
						formatter.format("%s\r\n", user_email);
						formatter.format("%s\r\n", user_phone);
						formatter.format("%s\r\n", user_balance);
						formatter.format("%s\r\n", user_name);
						
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					//Write successfuly done
					
				
				//Storing used Code
					if( usedCode1==null ){
						usedCode1=voucher;
					}
					else if( usedCode2==null ){
						usedCode2=voucher;
					}
					else if( usedCode3==null ){
						usedCode3=voucher;
					}
					else if( usedCode4==null ){
						usedCode4=voucher;
					}else{
						usedCode5=voucher;
					}
					
					JOptionPane.showMessageDialog(null, "Recharge Successful","Success",1);
					frame.setVisible(false);
					new Profile();
					
				}
				else{JOptionPane.showMessageDialog(null, "Invalid Code or Code has been already used","Warning",JOptionPane.WARNING_MESSAGE);}

			} 
		});

		// Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Profile.png");
		
		Image img = Newpass_Background.getImage();
		Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
		Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		frame.setVisible(true);

	}

}