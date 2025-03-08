import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.text.*;


public class RTX4090OrderPlace extends JFrame{
	
	//Component Name & Price
	double price = 238999, shipping = 50;
	String ProductName = "ASUS_ROG_STRIX_GEFORCE_RTX_4090";
	//------------------------------------------------------
	
	private JTextField addressBox;
	private JButton placeOrder, backButton;
	private Container c;
	private Cursor cursor;
	String Quantity, user, user_username, user_password, user_email, user_phone, user_balance, user_name;
	

	int fileNo, orderFileNo, fileIs, addressFileNo;
	
	RTX4090OrderPlace(){
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250,110,1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Order Confirmation");
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
		
		////////////////////////Reading address file no to write address in new file////////////////////////////////////////////////////////
		String addressfile="";
		try{
			File running_user_File = new File("TXT FILES\\Address_NO.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
										
			while(scanFile.hasNext()){
				addressfile=scanFile.next();
				break;
			}
			scanFile.close();
							
			addressFileNo= Integer.parseInt(addressfile);
							
		}catch(Exception f)		{System.out.println("Running txt problem");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		try{
			File otp_File = new File("TXT FILES\\Quantity.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				Quantity=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		//Quantity Label
		JLabel quantity_Label = new JLabel(Quantity);
		quantity_Label.setBounds(833,238,300,20);
		quantity_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		quantity_Label.setForeground(Color.decode("#F2F2F2"));
		c.add(quantity_Label);
		
		//Shipping Label
		JLabel shipping_Label = new JLabel(String.valueOf(shipping) + " BDT");
		shipping_Label.setBounds(551,281,300,20);
		shipping_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		shipping_Label.setHorizontalAlignment(JLabel.RIGHT);
		shipping_Label.setForeground(Color.decode("#F2F2F2"));
		c.add(shipping_Label);
		
		//Total Label
		double totalprice = (Double.parseDouble(Quantity)) * price + shipping;
		
		JLabel BDT_Label = new JLabel(String.valueOf(totalprice) + " BDT");
		BDT_Label.setBounds(551,324,300,20);
		BDT_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		BDT_Label.setForeground(Color.decode("#F2F2F2"));
		BDT_Label.setHorizontalAlignment(JLabel.RIGHT);
		c.add(BDT_Label);
		
		//Balance Label
		JLabel Balance_Label = new JLabel(user_balance + " BDT");
		Balance_Label.setBounds(551,365,300,20);
		Balance_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		Balance_Label.setForeground(Color.decode("#F2F2F2"));
		Balance_Label.setHorizontalAlignment(JLabel.RIGHT);
		c.add(Balance_Label);
		
		//New Balance Label
		double newbalance = Double.parseDouble(user_balance);
		newbalance = newbalance - totalprice;
		String showuser_balance = String.valueOf(newbalance);
		JLabel NewBalance_Label = new JLabel(showuser_balance + " BDT");
		NewBalance_Label.setBounds(551,409,300,20);
		NewBalance_Label.setFont(new Font ("Open Sans", Font.PLAIN,16));
		NewBalance_Label.setForeground(Color.decode("#F2F2F2"));
		NewBalance_Label.setHorizontalAlignment(JLabel.RIGHT);
		c.add(NewBalance_Label);
		
		
		//Address Box 
		addressBox = new JTextField();
		Font addressBoxFont = new Font("Open Sans", Font.PLAIN, 15);
		addressBox.setBounds(574,149,285,72);
		addressBox.setFont(addressBoxFont);
		addressBox.setCursor(cursor);
		addressBox.setForeground(Color.decode("#F2F2F2"));
		addressBox.setOpaque(false);
		addressBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		c.add(addressBox);
		
		
		//Place Order Button
		placeOrder = new JButton();
		Font placeOrderFont = new Font("Open Sans",Font.BOLD,15);
		placeOrder.setBounds(597,464,152,42);
		placeOrder.setFont(placeOrderFont);
		placeOrder.setCursor(cursor);
		placeOrder.setContentAreaFilled(false);
		placeOrder.setBorderPainted(false);
		placeOrder.setFocusPainted(false);
		c.add(placeOrder);
		
		
		//Back Button
		backButton = new JButton();
		backButton.setBounds(952,529,27,27);
		backButton.setCursor(cursor);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		c.add(backButton);
		
	
	
		/////////////////////////////////////Action Listener///////////////////////////////////
		
		//Back Button ActionListener
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				try{
					new RTX4090Details();
				}
				catch(Exception fd){
					System.out.println("RTX4090Details panel gui call problem");
				}
			}
			});
			
			//PlaceOrder Button ActionListener
		placeOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
				String randomnumber;
				
				//Generate Order No
				Calendar c = Calendar.getInstance();
				SimpleDateFormat ft= new SimpleDateFormat("dd/MM/yyyy");
				String AMPM, date = ft.format(new Date());
				int meridiem= c.get(Calendar.AM_PM);
						
				if(meridiem==1)		{AMPM="PM";}
				else		{AMPM="AM";}
						
				String Time_Date= date+"_"+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+AMPM;
				
				randomnumber=generateOtp(2);
				String orderNUMBER="VOID"+randomnumber+Time_Date;
				////////////////
				
				if( addressBox.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Address can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					
					int orderConfirmation = JOptionPane.showConfirmDialog (null,"Do you want Confirm the order?", "Order Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (orderConfirmation == JOptionPane.YES_OPTION){
						////////////////////////Getting order file NO to create new order file////////////////////////////////////
						String orderfile="";
						try{
							File running_user_File = new File("TXT FILES\\OrderFileNo.txt");		
							Scanner scanFile = new Scanner(running_user_File);//Scan File
										
							while(scanFile.hasNext()){
								orderfile=scanFile.next();
								break;
							}
							scanFile.close();
							
							orderFileNo= Integer.parseInt(orderfile);
							
						}catch(Exception f){
							System.out.println("Running txt problem");
						}
///////////////Writting Order Info in file/////////////////////////////////////////////////////////////
						
						try{
							String USER_FILE="TXT FILES\\Order_Info\\Order-"+orderFileNo+".txt";
							Formatter formatter=new Formatter(USER_FILE);
							
							orderFileNo++;		
												
							formatter.format("%s\r\n", orderNUMBER);
							formatter.format("%s\r\n", ProductName);
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", ""+user_email);
							formatter.format("%s\r\n", ""+Quantity);
							formatter.format("%s\r\n", String.valueOf(totalprice));
							formatter.format("%s\r\n", user_name);
				
							formatter.close();	
							
						}catch(Exception f)		{System.out.println(f);}
					
/////////////////////Updating Order file NO file/////////////////////////////////////////////////
						try{
							String USER_File="TXT FILES\\OrderFileNo.txt";
							Formatter formatter=new Formatter(USER_File);
							
							formatter.format("%s\r\n", orderFileNo);
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
///////////////////Deducting balance from user file//////////////////////////////////////////////////////
						double userBalance=Double.parseDouble(user_balance);
						userBalance = userBalance - totalprice;
						user_balance=Double.toString(userBalance);
						
						try{
						String User_Information_File_Path="TXT FILES/User Informations/User--"+fileNo+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						fileNo++;
						
						formatter.format("%s\r\n", user_username);
						formatter.format("%s\r\n", user_password);
						formatter.format("%s\r\n", user_email);
						formatter.format("%s\r\n", user_phone);
						formatter.format("%s\r\n", user_balance);
						formatter.format("%s\r\n", user_name);				
						
						formatter.close();	
					}catch(Exception f)		{System.out.println(f);}
						
						JOptionPane.showMessageDialog(null, "Order Successfully Placed","Order Confirmation",-1,new ImageIcon("Images\\Successful_Icon.png"));

/////////////////////Updating Order ID in tempfile/////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\tempOrder.txt");
							
							formatter.format("%s\r\n", orderNUMBER);
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}

////////////////////////Writting Address for each order////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\Adresses\\Adress-"+addressFileNo+".txt");
							addressFileNo++;
							
							formatter.format("%s\r\n", addressBox.getText());
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
						
////////////////////////Writting address file number for next file////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\Address_NO.txt");
							
							formatter.format("%s\r\n", addressFileNo);
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						

					
						frame.setVisible(false);
						new RTX4090OrderComplete();
/////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
					else{
						//Do Nothing
					}
					
				}
				
				
			}
		});
			
		

		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\RTX4090PlaceOrder.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		frame.setVisible(true);
		
	}
	private String generateOtp(int otpLength){
		SplittableRandom split = new SplittableRandom();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<otpLength; i++){
			sb.append(split.nextInt(0,10));
		}
		return sb.toString();
	}
}
