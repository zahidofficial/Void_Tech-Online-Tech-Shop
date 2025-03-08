import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;


public class RTX4090Details extends JFrame{
	private JButton increaseQuantity, decreaseQuantity, buyNowButton, backButton;
	private Container c;
	private Cursor cursor;
	int valueInt=1, price = 238999, fileNo, fileIs;
	String  user, Quantity, Total, Balance, user_username, user_password, user_email, user_phone, user_balance, user_name;
	
	RTX4090Details(){
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Checkout");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");
		frame.setIconImage(frame_icon);
		frame.setLocationRelativeTo(null);
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
					fileIs=i;
					break;
				}
							
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}
		
		//Increase Quantity button
		
		increaseQuantity = new JButton("");
		increaseQuantity.setBounds(505,473,22,17);
		increaseQuantity.setForeground(Color.decode("#F2F2F2"));
		increaseQuantity.setContentAreaFilled(false);
		increaseQuantity.setBorderPainted(false);
		increaseQuantity.setFocusPainted(false);
		increaseQuantity.setCursor(cursor);
		c.add(increaseQuantity);
		
		//Decrease Quantity button	
		decreaseQuantity = new JButton("");
		decreaseQuantity.setBounds(505,490,22,17);
		decreaseQuantity.setForeground(Color.decode("#F2F2F2"));
		decreaseQuantity.setContentAreaFilled(false);
		decreaseQuantity.setBorderPainted(false);
		decreaseQuantity.setFocusPainted(false);
		decreaseQuantity.setCursor(cursor);
		c.add(decreaseQuantity);
		
		//Buy Now Button
		buyNowButton = new JButton();
		Font buyNowButtonFont = new Font("Open Sans", Font.BOLD, 15);
		buyNowButton.setBounds(537,474,111,33);
		buyNowButton.setContentAreaFilled(false);
		buyNowButton.setBorderPainted(false);
		buyNowButton.setFocusPainted(false);
		buyNowButton.setFont(buyNowButtonFont);
		buyNowButton.setCursor(cursor);
		c.add(buyNowButton);
		
		//Back Button
		backButton = new JButton();
		backButton.setBounds(952,529,27,27);
		backButton.setCursor(cursor);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		c.add(backButton);
		
		
		//////////////////////////Action Listener/////////////////////////////
		
		//Back Button ActionListener
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				try{
					new GPU();
				}
				catch(Exception fd){
					System.out.println("RTX4090Details panel gui call problem");
				}
			}
			});
		
		//------------Quantity------------
			
		//Quantity Box
		JLabel showQuantity = new JLabel("01");
		showQuantity.setBounds(473,480,30,20);
		showQuantity.setFont(new Font("Open Sans", Font.BOLD, 15));
		showQuantity.setForeground(Color.decode("#F2F2F2"));
		c.add(showQuantity);
		
		//Increase Button ActionListener
		
		increaseQuantity.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				valueInt = Integer.parseInt(showQuantity.getText());
				valueInt++;
				if(valueInt>=10){
					showQuantity.setText(String.valueOf(valueInt));
				}
				else{
				showQuantity.setText("0"+String.valueOf(valueInt));
				}
			}
		});
		
		//Decrease Button Action Listener
		decreaseQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				valueInt = Integer.parseInt(showQuantity.getText());
				if (valueInt > 1) {
					valueInt--;
				}
				if (valueInt >= 10) {
					showQuantity.setText(String.valueOf(valueInt));
				} else {
					showQuantity.setText("0" + String.valueOf(valueInt));
				}
			}
		});
		
		//Buy Button ActionListener
		buyNowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
					
				String Quantity=showQuantity.getText();
				double total = (Double.parseDouble(Quantity)) * price;
				double balance = (Double.parseDouble(user_balance));
					try{
						Formatter formatter=new Formatter("TXT FILES\\Quantity.txt");
										
						formatter.format("%s\r\n", Quantity);
						formatter.close();	
							
					}catch(Exception f)		{System.out.println(f);}
					
					if((total) > (balance)){
					JOptionPane.showMessageDialog(null, "Do not have sufficient balance to order", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
				}
				else{
					frame.setVisible(false);
					new RTX4090OrderPlace();
				}
							
			}
		});
		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\RTX4090Details.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		frame.setVisible(true);	
	}
}
		