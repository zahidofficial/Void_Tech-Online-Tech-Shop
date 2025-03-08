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


public class AccountCreation extends JFrame {
	private JTextField invisible, Uname, Fname, Lname, Mnumb, pass, email;
	private JPasswordField passField;
	private JButton loginPage, clearButton, forgotPass, createAccount;
	private Container c;
	private Font f;
	private Cursor cursor;
	int fileNo = 1;
	//Colors
	Color White = Color.decode("#F2F2F2");

	AccountCreation() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame -----------------------------------------------------------------------
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("Account Creation");
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


		// Text Fields -----------------------------------------------------------------------
	
		//Username
		Uname = new JTextField();
		Uname = new HintTextField("Username (a - z)");
		Font UnameFont = new Font("Open Sans", Font.PLAIN,14);
		Uname.setBounds(510, 191, 162, 37);
		Uname.setFont(UnameFont);
		Uname.setHorizontalAlignment(JTextField.LEFT);
		Uname.setCursor(cursor);
		Uname.setOpaque(false);
		Uname.setForeground(Color.decode("#F2F2F2"));
		Uname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Username (a - z)", Uname);
		c.add(Uname);
		
		//Mobile Number
		Mnumb = new JTextField();
		Mnumb = new HintTextField("Mobile Number");
		Font MnumbFont = new Font("Open Sans", Font.PLAIN,14);
		Mnumb.setBounds(750,192,162,37);
		Mnumb.setFont(MnumbFont);
		Mnumb.setHorizontalAlignment(JTextField.LEFT);
		Mnumb.setCursor(cursor);
		Mnumb.setOpaque(false);
		Mnumb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Mnumb.setHorizontalAlignment(JTextField.LEFT);
		Mnumb.setForeground(Color.decode("#F2F2F2"));
		new TextPrompt("Mobile Number", Mnumb);   
		c.add(Mnumb);
		
		//First Name
		Fname = new JTextField();
		Fname = new HintTextField("First Name");
		Font FnameFont = new Font("Open Sans", Font.PLAIN,14);
		Fname.setBounds(510,263,162,37);
		Fname.setFont(FnameFont);
		Fname.setHorizontalAlignment(JTextField.LEFT);
		Fname.setCursor(cursor);
		Fname.setOpaque(false);
		Fname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Fname.setHorizontalAlignment(JTextField.LEFT);
		new TextPrompt("First Name", Fname);
		Fname.setForeground(Color.decode("#F2F2F2"));
		c.add(Fname);
		
		//Last Name
		Lname = new JTextField();
		Lname = new HintTextField("Last Name");
		Font LnameFont = new Font("Open Sans", Font.PLAIN,14);
		Lname.setBounds(750,264,162,37);
		Lname.setFont(LnameFont);
		Lname.setHorizontalAlignment(JTextField.LEFT);
		Lname.setCursor(cursor);
		Lname.setOpaque(false);
		Lname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Lname.setHorizontalAlignment(JTextField.LEFT);
		new TextPrompt("Last Name", Lname);
		Lname.setForeground(Color.decode("#F2F2F2"));
		c.add(Lname); 
		
		//Password
		pass = new JTextField();
		pass = new HintTextField("Password (6 - 10 Char)");
		Font passFont = new Font("Open Sans", Font.PLAIN,14);
		pass.setBounds(510,334,162,37);
		pass.setFont(passFont);
		pass.setHorizontalAlignment(JTextField.LEFT);
		pass.setCursor(cursor);
		pass.setOpaque(false);
		pass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pass.setHorizontalAlignment(JTextField.LEFT);
	    new TextPrompt("Password (6 - 10 Char)", pass);
		pass.setForeground(Color.decode("#F2F2F2"));
		c.add(pass); 
		
		//Gmail
		email = new JTextField();
		email = new HintTextField("Gmail");
		Font emailFont = new Font("Open Sans", Font.PLAIN,14);
		email.setBounds(750,335,162,37);
		email.setFont(emailFont);
		email.setHorizontalAlignment(JTextField.LEFT);
		email.setCursor(cursor);
		email.setOpaque(false);
		email.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		email.setHorizontalAlignment(JTextField.LEFT);
		new TextPrompt("Gmail", email);
		email.setForeground(Color.decode("#F2F2F2"));
		c.add(email); 

		// Buttons -----------------------------------------------------------------------
		
		//Create Account Button
		createAccount = new JButton();
		createAccount.setBounds(575,407,258,36);
		createAccount.setToolTipText("Account Creation");
		createAccount.setCursor(cursor);
		createAccount.setContentAreaFilled(false);
		createAccount.setBorderPainted(false);
		c.add(createAccount);
		
		//LoginPage button
		
		loginPage = new JButton("Login Page");
		loginPage.setFont(new Font("Open Sans", Font.PLAIN, 17));
		loginPage.setBounds(655,520,120,22);
		loginPage.setToolTipText("Back to Login Page");
		loginPage.setCursor(cursor);
		loginPage.setContentAreaFilled(false);
		loginPage.setForeground(Color.decode("#FCB13A"));
		loginPage.setFocusPainted(false);
		loginPage.setBorderPainted(false); 
		loginPage.setOpaque(false);
		
		//Add hover in Forgot password button
		loginPage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				loginPage.setForeground(Color.decode("#FFE699"));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				loginPage.setForeground(Color.decode("#FCB13A"));
			}
		}); 
		c.add(loginPage);
		
		
		// Set Background Image -----------------------------------------------------------------------
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\Account Creation.png");
		
		Image img = Newpass_Background.getImage();
		Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
		Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		


		// Action Listeners -----------------------------------------------------------------------
		
		//Back to Login Page Button Action Listener
		loginPage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent u){
				frame.setVisible(false);
				new LoginPanel();
			}
		});	
		
		//Create Account Button Action Listener
		createAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent u){
		
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
						
				}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
				
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
				String username,mobilenumber,firstname,lastname,password,gmail,balance,name;
				
				//Getting User Information
				username=Uname.getText();
				mobilenumber=Mnumb.getText();
				firstname=Fname.getText();
				lastname=Lname.getText();
				password=pass.getText();
				gmail=email.getText();
				balance="0";
				name=Fname.getText()+" "+Lname.getText();
				
				
				int Username_Warning=5;
				int Username_Exist_Warning=5;
				int Phone_Warning=5;
				
				//Check Username ok or not
				for(int i=0; i<username.length(); i++)
				{
					if( (username.charAt(i)<97) || (username.charAt(i)>122) ){
						Username_Warning=1;
						break;
					}
				}
				
				//Check Mobile Number or not
				for(int i=0; i<mobilenumber.length(); i++)
				{
					if( (mobilenumber.charAt(i)<48) || (mobilenumber.charAt(i)>57) ){
						Phone_Warning=1;
						break;
					}
				}
				
				//Check Username Exist or not			
					String username_exist="";
					for(int i=1; i<=(fileNo-1); i++)
					{
						String User_Information_File_Path="TXT FILES/User Informations/User--"+i+".txt";
						
						try{
							File user_file = new File(User_Information_File_Path);		
							Scanner scanFile = new Scanner(user_file);//Scan File
							
							while(scanFile.hasNext()){
								username_exist=scanFile.next();
								break;
							}
							scanFile.close();
							
							
							if((username.equals(username_exist)))
							{
								Username_Exist_Warning+=1;
								break;
							}
						}catch(Exception f)		{System.out.println("User File Problem in Sigup Panel");}
					}

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			if( (Fname.getText().isEmpty()) || (username.isEmpty()) || (password.isEmpty()) || (gmail.isEmpty()) || (mobilenumber.isEmpty()) )
				{
					if( Fname.getText().isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "First Name can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( gmail.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Email can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( mobilenumber.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Phone Number can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( username.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Username can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Password can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(Email_Decision(gmail))
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Email Address","Email Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (mobilenumber.length()<11) || (mobilenumber.length()>11) || Phone_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Phone Number","Phone Number Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Username contains small Alphabets only","Username Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Exist_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Username already exist. Try different One","Username Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (password.length()<6) || (password.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
				
				//////////////////////////////////////////////////////////////User Information Written//////////////////////////////////////////////////////////////
				
				else{
					try{
						String User_Information_File_Path="TXT FILES/User Informations/User--"+fileNo+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						fileNo++;
						
						formatter.format("%s\r\n", username);
						formatter.format("%s\r\n", password);
						formatter.format("%s\r\n", gmail);
						formatter.format("%s\r\n", mobilenumber);
						formatter.format("%s\r\n", balance);
						formatter.format("%s\r\n", name);				
						
						formatter.close();	
					}catch(Exception f)		{System.out.println(f);}
	
				
				//////////////////////////////////////////////////////////////Writting Next User File Number//////////////////////////////////////////////////////////////
				
					try{
						Formatter formatter=new Formatter("TXT FILES\\User_File_No.txt");
							
							
						formatter.format("%s\r\n", fileNo);
						formatter.close();	
							
					}catch(Exception f)		{System.out.println(f);}
		JOptionPane.showMessageDialog(null, "Welcome to Void Tech "+Fname.getText(),"Successfully Account Created",-1,new ImageIcon("Images\\Successful Icon.png"));
		frame.setVisible(false);
		new LoginPanel();
				}
				
			}
		});
		
	frame.setVisible(true);
	
}
	
private boolean Email_Decision(String gmail){
		
	String word=gmail;
	int countAt=0,countDot=0;	
		
	for(int i=0; i<word.length();i++)
		{
			if(word.charAt(i)=='@')
			{
				countAt++;
			}if(countAt==1 && word.charAt(i)=='.')
			{
				countDot++;
			}
		}
	if(countAt==1 && countDot==1){
		return false;
	}
	else{
		return true;
		}
	}
}