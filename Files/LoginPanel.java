import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.*;

public class LoginPanel extends JFrame {
	
	private JTextField userField;
	private JPasswordField passField;
	private JButton loginButton, forgotPass, createAccount;
	private Container c;
	private Cursor cursor;
	
	
	String user_username, user_password;
	String admin_username, admin_password;
	
	static int invalidCount=0;
	int fileNo;
	
	//Colors
	Color LIGHT_RED = new Color (255,102,102);
	Color LIGHT_BLUE = new Color (51,153,255);
	Color Dark_CYAN = new Color (14,161,177);
	


	LoginPanel() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Login");
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
		
		
		// Username panel

		userField = new JTextField();
		userField = new HintTextField("Username");
		Font userFieldFont = new Font("Open Sans", Font.PLAIN,14);
		userField.setBounds(602, 194, 222, 37);
		userField.setFont(userFieldFont);
		userField.setHorizontalAlignment(JTextField.LEFT);
		userField.setCursor(cursor);
		userField.setOpaque(false);
		userField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Username", userField);
		userField.setForeground(Color.WHITE);
		c.add(userField);

		
		//Hide Icon 
		
		JButton hide = new JButton(new ImageIcon("Images\\hide.png"));
		hide.setBounds(793,269,22,20);
		hide.setVisible(true);
		hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hide.setContentAreaFilled(false);
		hide.setFocusPainted(false);
		hide.setBorderPainted(false);
		c.add(hide);


		//Unhide Icon 
		
		JButton unhide = new JButton(new ImageIcon("Images\\unhide.png"));
		unhide.setBounds(793,268,22,20);
		unhide.setVisible(false);
		unhide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		unhide.setContentAreaFilled(false);
		unhide.setFocusPainted(false);
		unhide.setBorderPainted(false);
		c.add(unhide);

		//Hide Action Listener
		
		hide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				passField.setEchoChar((char) 0);
				hide.setVisible(false);
				unhide.setVisible(true);
				passField.requestFocusInWindow();
				
			} 
		});

		//Unide Action Listener
		
		unhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				passField.setEchoChar('*');//display password
				unhide.setVisible(false);
				hide.setVisible(true);
				passField.requestFocusInWindow();
			} 
		});
		
		
		// Password panel

		passField = new JPasswordField();
		Font passwordFieldFont = new Font("Open Sans", Font.PLAIN,14);
		passField.setBounds(602, 260, 222, 37);
		passField.setFont(passwordFieldFont);
		passField.setHorizontalAlignment(JTextField.LEFT);
		passField.setEchoChar('*');
		passField.setCursor(cursor);
		passField.setOpaque(false);
		passField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Password", passField);
		passField.setForeground(Color.WHITE);
		c.add(passField);
		
		
		// Login Button
		
		loginButton = new JButton("Login");
		Font loginFont = new Font("Open Sans", Font.BOLD,17);
		loginButton.setBounds(559, 326, 270, 40);
		loginButton.setFont(loginFont);
		loginButton.setCursor(cursor);
		loginButton.setContentAreaFilled(false);
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setToolTipText("Login");
		c.add(loginButton);
		
		
		
		//Forgot password button
		
		forgotPass = new JButton("Forgot Password");
		forgotPass.setFont(new Font("Open Sans", Font.PLAIN, 13));
		forgotPass.setBounds(628,380,133,18);
		forgotPass.setToolTipText("Recover Password");
		forgotPass.setCursor(cursor);
		forgotPass.setContentAreaFilled(false);
		forgotPass.setForeground(Color.WHITE);
		forgotPass.setFocusPainted(false);
		forgotPass.setBackground(Color.decode("#FCB13A"));
		forgotPass.setBorderPainted(false); 
		forgotPass.setOpaque(false);
		
		//Add hover in Forgot password button
		forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				forgotPass.setForeground(Color.decode("#FFE699"));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				forgotPass.setForeground(Color.WHITE);
			}
		}); 
		c.add(forgotPass);
		
		
		//Create Account Button
		
		createAccount = new JButton("Create Account");
		createAccount.setCursor(cursor);
		createAccount.setForeground(Color.ORANGE);
		createAccount.setContentAreaFilled(false);
		createAccount.setBorderPainted(false);
		createAccount.setFocusPainted(false);
		createAccount.setFont(new Font("Open Sans", Font.PLAIN, 15));
		createAccount.setBounds(685,459,145,18);
		createAccount.setToolTipText("Account Creation");
		createAccount.setOpaque(false);
		
		//Add hover in Create Account button
		createAccount.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				createAccount.setForeground(Color.decode("#FFE699"));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				createAccount.setForeground(Color.ORANGE);
			}
		}); 
		c.add(createAccount);

		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\LoginPanel.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		

		///////////////////////////////////Action Listener////////////////////////////////////////
		
		
		//Forgot password button Action Listener
		forgotPass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				try{
					new PasswordRecoveryPanel();
				}
				catch(Exception fd){
					System.out.println("Login panel user gui call problem");
				}
			}
		});
		
		//Create Account button Action Listener
		createAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new AccountCreation();
				
			}
		});
		
		
		///////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
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
		
		//ActionListener for Login Button
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				/////////////////////////////////////////////////////////////////////
		//Admin Panel Login Confirmation	
				String user=userField.getText();
				String pass=new String(passField.getPassword());
				boolean user_access,admin_access;
				
				
		//Get Admin Information
				try{
					File admin_file = new File("TXT FILES\\Admin_Info.txt");		
					Scanner scanFile = new Scanner(admin_file);//Scan File
						
					while(scanFile.hasNext()){
						admin_username=scanFile.next();
						admin_password=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("Admin File Problem in Login Panel");
				}
				
				if((user.equals(admin_username)) && (pass.equals(admin_password)))
				{
					admin_access=true;
				}
				else{
					admin_access=false;
				}
						
				
				//////////////////////////////////////////////////////////////////////////
				
				
				
				
				
		//Get User Information
				
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES/User Informations/User--"+i+".txt";
						
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
						
						while(scanFile.hasNext()){
							user_username=scanFile.next();
							user_password=scanFile.next();
							break;
						}
						scanFile.close();
							
							
						if((user.equals(user_username)) && (pass.equals(user_password)))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Login Panel");}
				}
					
				if((user.equals(user_username)) && (pass.equals(user_password)))
				{
					user_access=true;
				}
				else{
					user_access=false;
				}
				
				
		//Get Login
				if(admin_access)
				{
					
					//Writting the username to running user file
					try{
						Formatter formatter=new Formatter("TXT FILES\\Running_User.txt");
						
						formatter.format("%s", admin_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
					//writting done
					frame.setVisible(false);
					new adminView();
					
				}
				else if(user_access){
					
					//Writting the username to running user file
					try{
						Formatter formatter=new Formatter("TXT FILES\\Running_User.txt");
						
						formatter.format("%s", user_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
					//writting done
					frame.setVisible(false);
					new Components();
				}
				
				else{
					invalidCount++;
					
					if(invalidCount>5){
						JOptionPane.showMessageDialog(null,"You Have Entered wrong Information more than 5 times. Get Out from my Store","WARNING",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					JOptionPane.showMessageDialog(null, "Enter Valid Username or Password","Login Confirmation",JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
		
		frame.setVisible(true);
	}
}
