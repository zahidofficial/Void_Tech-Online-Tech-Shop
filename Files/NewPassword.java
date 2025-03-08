import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

////////////////////////////////////////// NEW PASSWORD AND CONFIRM PASSWORD PANEL //////////////////////////////////////////


public class NewPassword extends JFrame{
	private JTextField confirmNewPassword,newPassword;
	private JButton confirmButton,backButton;
	private Cursor cursor;
	private Container c;
	String user_username, user_password, user_balance, user_email, user_phone, user_name;
	int fileNo;
	int fileIs;
	String user,otp;
	Color White = Color.decode("#F2F2F2");
	
	public NewPassword(){
	
	cursor = new Cursor(Cursor.HAND_CURSOR);
	
	//Frame
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(250,110,1000,600);
	frame.setTitle("New password");
	Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	frame.setIconImage(frame_icon);
	frame.setResizable(false);
	c = frame.getContentPane();
	frame.setLocationRelativeTo(null);
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
	
	//New Password Field
	newPassword = new JTextField();
	Font newPasswordFont = new Font("Open Sans", Font.PLAIN,14);
	newPassword.setFont(newPasswordFont);
	newPassword.setBounds(603,312,222,38);
	newPassword.setCursor(cursor);
	newPassword.setHorizontalAlignment(JTextField.LEFT);
	newPassword.setOpaque(false);
	newPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	newPassword.setForeground(Color.decode("#F2F2F2"));
	new TextPrompt("New Password", newPassword);
	c.add(newPassword);
	
	
	
	//Confirm Button
	confirmButton = new JButton("Confirm");
	Font confirmButtonFont = new Font("Open Sans", Font.BOLD, 17);
	confirmButton.setBounds(557,367,268,36);
	confirmButton.setFont(confirmButtonFont);
	confirmButton.setCursor(cursor);
	confirmButton.setContentAreaFilled(false);
	confirmButton.setBorderPainted(false);
	confirmButton.setFocusPainted(false);
	c.add(confirmButton);
	
	
	//Back Button
	backButton = new JButton();
	backButton.setBounds(930,529,41,21);
	backButton.setCursor(cursor);
	backButton.setContentAreaFilled(false);
	backButton.setBorderPainted(false);
	c.add(backButton);

	
	
	
	//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\NewPassword.png");
		
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);
		
		
		
		
		////////////////////////////////////////////////////////////////////ActionListener//////////////////////////////////////////////////
		
		
		
		//Back Button ActionListener
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
					new PasswordRecoveryPanel();
				
			}
		});
		
		
		///////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
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
		
		//ActionListener for Change Password button
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
///////////////////////////////////////

				String password=newPassword.getText();
				if( (password.length()<6) || (password.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					
			//Getting username from file, whice password will be change
					try{
						File admin_file = new File("TXT FILES\\OTP.txt");		
						Scanner scanFile = new Scanner(admin_file);//Scan File
							
						while(scanFile.hasNext()){
							otp=scanFile.next();
							user=scanFile.next();
							break;
						}
						scanFile.close();
							
					}catch(Exception f){
						System.out.println("OTP File has problem in OTP Panel");
					}
						
			//Getting the usernames file
					for(int i=1; i<=fileNo; i++)
					{
						String User_Information_File_Path="TXT FILES/User Informations/User--"+i+".txt";
							
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
								
								
							if(user.equals(user_username))
							{
								fileIs=i;
								break;
							}
						}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
					}
	//////////////////////////////////////////////////Got the File
			//Re-Write the file with new password
					
					String user_password=newPassword.getText();
					try{
							String User_Information_File_Path="TXT FILES/User Informations/User--"+fileIs+".txt";
							Formatter formatter=new Formatter(User_Information_File_Path);
							
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", user_password);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_balance);
							formatter.format("%s\r\n", user_name);			
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
				

					frame.setVisible(false);
					new LoginPanel();
				}
////////////////////////////////////
			} 
		});
	
	frame.setVisible(true);	
	
	}
	
}