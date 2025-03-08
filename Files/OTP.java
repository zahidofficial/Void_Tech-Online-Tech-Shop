import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

/////////////////////////////////////////////////////// OTP PANEL////////////////////////////////////////////


public class OTP extends JFrame{
	private JTextField confirmCode;
	private JButton nextButton, backButton;
	private Cursor cursor;
	private Container c;
	String otp;
	static int invalidCount = 0;
	
	OTP(){
	
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
	
	//Recovery Password Field
	confirmCode = new JTextField();
	Font confirmCodeFont = new Font("Open Sans", Font.PLAIN,14);
	confirmCode.setFont(confirmCodeFont);
	confirmCode.setBounds(605,346,222,38);
	confirmCode.setCursor(cursor);
	confirmCode.setHorizontalAlignment(JTextField.LEFT);
	confirmCode.setOpaque(false);
	confirmCode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	new TextPrompt("OTP", confirmCode);
	confirmCode.setForeground(Color.decode("#F2F2F2"));
	c.add(confirmCode);
	
	//Next Button
	nextButton = new JButton("Next");
	Font nextButtonFont = new Font("Open Sans", Font.BOLD, 17);
	nextButton.setBounds(558,400,268,37);
	nextButton.setFont(nextButtonFont);
	nextButton.setCursor(cursor);
	nextButton.setContentAreaFilled(false);
	nextButton.setBorderPainted(false);
	nextButton.setFocusPainted(false);
	c.add(nextButton);
	
	
	//Back Button
	backButton = new JButton();
	backButton.setBounds(930,529,41,21);
	backButton.setCursor(cursor);
	backButton.setContentAreaFilled(false);
	backButton.setBorderPainted(false);
	c.add(backButton);
	

	//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\OTP.png");
		
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);

		
		///////////////////////////////////////Action Listener//////////////////////////////////////////////////////////////


		//Back Button ActionListener
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new PasswordRecoveryPanel();
			}
		});
		
		//////////////////////////////////////////////////////////////////////////////////
		//Submit Button Action Listener
		nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent u){
				
/////////////////////////////////
				String otp_provided=confirmCode.getText();
				
				try{
					File otp_File = new File("TXT FILES\\OTP.txt");		
					Scanner scanFile = new Scanner(otp_File);//Scan File
						
					while(scanFile.hasNext()){
						otp=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("OTP File has problem in OTP Panel");
				}
				
				if(otp_provided.equals(otp))
				{
					
					frame.setVisible(false);
					new NewPassword();
				}
				else{
					invalidCount++;
					
					if(invalidCount>5){
						JOptionPane.showMessageDialog(null,"You have entered wrong OTP more than 5 times. Get Out from my Store","WARNING",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					else{
						JOptionPane.showMessageDialog(null,"Enter a valid OTP","Invalid OTP",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

	frame.setVisible(true);	
		
	}
}