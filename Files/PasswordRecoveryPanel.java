//Mail Classes
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


//Others Classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//Activation Framework 

/////////////////////////////////////////////////////////SEND OTP TO GMAIL PANEL/////////////////////////////////////////////////////


public class PasswordRecoveryPanel extends JFrame{
	private JTextField userName;
	private JButton getOtp, backButton;
	private Cursor cursor;
	private Container c;
	int fileNo;
	String otp;
	
	//User Info
	String user_username, user_password, user_email, user_phone, user_name, user_gender;
		
	
	public PasswordRecoveryPanel(){
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Password Recovery");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		c = frame.getContentPane();
		frame.setLocationRelativeTo(null);
		c.setLayout(null);
		
		//Frame Close Confirmation action listener
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
		
		
		//UserName Field
		userName = new JTextField();
		Font userNameFieldFont = new Font("Open Sans", Font.PLAIN, 14);
		userName.setBounds(605,313,222,38);
		userName.setFont(userNameFieldFont);
		userName.setHorizontalAlignment(JTextField.LEFT);
		userName.setCursor(cursor);
		userName.setOpaque(false);
		userName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Enter Username", userName);
		userName.setForeground(Color.decode("#F2F2F2"));
		c.add(userName);	
		 
		
		//Get Otp Button
		getOtp = new JButton("GET OTP");
		Font getOtpButtonFont = new Font("Open Sans", Font.BOLD, 17);
		getOtp.setBounds(558,366,268,39);
		getOtp.setFont(getOtpButtonFont);
		getOtp.setCursor(cursor);
		getOtp.setContentAreaFilled(false);
		getOtp.setBorderPainted(false);
		getOtp.setFocusPainted(false);
		c.add(getOtp);
		
		
		//Back Button
		backButton = new JButton();
		backButton.setBounds(930,529,41,21);
		backButton.setCursor(cursor);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		c.add(backButton);
		
		//Back Button ActionListener
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					frame.setVisible(false);
					new LoginPanel();
				}
			});
			
		
		//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\PasswordRecoveryPanel.png");
		
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);
		
		
		
		/////////////////////////Reading user File No////////////////////////////////////////
		String filenumber="";
		try{
			File otp_File = new File("TXT Files\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			fileNo= Integer.parseInt(filenumber);
			fileNo=fileNo-1;
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		
		
	///////////////////////////////////////////////////////////////////////////////////	
		
		//ActionListener for Get OTP Button
		getOtp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){

				//Get User Information
				
				String user=userName.getText();
				
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
							break;
						}
						scanFile.close();
							
							
						if(user.equals(user_username))
						{
							
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
					
					
					
				if(user.equals(user_username))
				{
			//Writing OTP in File
					try{
						Formatter formatter=new Formatter("TXT FILES\\OTP.txt");
						
						otp=generateOtp(4);//Getting OTP
						
						formatter.format("%s\r\n", otp);
						formatter.format("%s\r\n", user_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
			//Sending email in user Account
					try{
						Mail mail = new Mail();
						mail.setupServerProperties();
						mail.draftEmail(user_email,"Void Tech OTP", "Your One Time Password is "+otp);
						System.out.println(mail.sendEmail());						
					}catch(Exception tata){
						System.out.println("mail send problem");
					}
			

					JOptionPane.showMessageDialog(null, "An OTP has been send to "+user_email,"OTP send to email account",-1,new ImageIcon("Images\\Successful_Icon.png"));
					
					frame.setVisible(false);
					new OTP();
				 
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Enter a valid Username","Username NOT Found",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		frame.setVisible(true);
		
	}
	
	
	
	//OTP generator
	private String generateOtp(int otpLength){
		SplittableRandom split = new SplittableRandom();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<otpLength; i++){
			sb.append(split.nextInt(0,10));
		}
		return sb.toString();
	}
}

