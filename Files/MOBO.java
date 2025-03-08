import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class MOBO extends JFrame {

	private JButton MSI, ROG, AORUS, profile, contact, back;
	private Container c;
	private Cursor cursor;
	
	//Colors
	Color White = Color.decode("#F2F2F2");

	MOBO() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("Account Creation");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
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

		//MSI
		MSI = new JButton();
		MSI.setBounds(190,446,111,38);
		MSI.setCursor(cursor);
		MSI.setContentAreaFilled(false);
		MSI.setBorderPainted(false);
		c.add(MSI);
		
		
		//ROG
		ROG = new JButton();
		ROG.setBounds(439,446,111,38);
		ROG.setCursor(cursor);
		ROG.setContentAreaFilled(false);
		ROG.setBorderPainted(false);
		c.add(ROG);
		
		
		//AORUS
		AORUS = new JButton();
		AORUS.setBounds(702,446,111,38);
		AORUS.setCursor(cursor);
		AORUS.setContentAreaFilled(false);
		AORUS.setBorderPainted(false);
		c.add(AORUS);
		
		//Profile
		profile = new JButton();
		profile.setBounds(306,69,134,42);
		profile.setCursor(cursor);
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		c.add(profile);
		
		//Contact
		contact = new JButton();
		contact.setBounds(550,70,134,42);
		contact.setCursor(cursor);
		contact.setContentAreaFilled(false);
		contact.setBorderPainted(false);
		c.add(contact);
		
		//Back
		back = new JButton();
		back.setBounds(482,529,27,27);
		back.setCursor(cursor);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setToolTipText("Back");
		c.add(back);
		
		

		// Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\MotherBoard.png");
		
		Image img = Newpass_Background.getImage();
		Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
		Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		


		///////////////////////////////////Action Listener////////////////////////////////////////
		
		
		//ActionListener for BACK
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Components();
			} 
		});
		//ActionListener for MSI
		MSI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new MSIMEGDetails();
			} 
		});
		//ActionListener for ROG
		ROG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new ASUSROGDetails();
			} 
		});
		//ActionListener for AORUS
		AORUS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new AORUSMASTERDetails();
			} 
		});
		//ActionListener for Profile
		profile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Profile();
			} 
		});
		//ActionListener for Contace
		contact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new contactUs();
			} 
		});
		
		frame.setVisible(true);

	}

}