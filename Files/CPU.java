import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

//new TextPrompt("Name", object);

public class CPU extends JFrame {

	//private JLabel userLabel, passLabel;
	private JButton i9, i7, i5, profile, contact, back;
	private Container c;
	private Cursor cursor;
	
	//Colors
	Color White = Color.decode("#F2F2F2");

	CPU() {
		
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
		
		//i9
		i9 = new JButton();
		i9.setBounds(190,446,111,38);
		i9.setToolTipText("Core i9-12th Gen");
		i9.setCursor(cursor);
		i9.setContentAreaFilled(false);
		i9.setBorderPainted(false);
		c.add(i9);
		
		
		//i7
		i7 = new JButton();
		i7.setBounds(439,446,111,38);
		i7.setToolTipText("Core i7-12th Gen");
		i7.setCursor(cursor);
		i7.setContentAreaFilled(false);
		i7.setBorderPainted(false);
		c.add(i7);
		
		
		//i5
		i5 = new JButton();
		i5.setBounds(691,446,111,38);
		i5.setToolTipText("Core i5-12th Gen");
		i5.setCursor(cursor);
		i5.setContentAreaFilled(false);
		i5.setBorderPainted(false);
		c.add(i5);
		
		//Profile
		profile = new JButton();
		profile.setBounds(306,69,134,42);
		profile.setToolTipText("Your Profile");
		profile.setCursor(cursor);
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		c.add(profile);
		
		//Contact
		contact = new JButton();
		contact.setBounds(550,70,134,42);
		contact.setToolTipText("Contuct Us");
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
		ImageIcon Newpass_Background = new ImageIcon("Images\\Processor.png");
		
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
		//ActionListener for i9
		i9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new COREI9Details();
			} 
		});
		//ActionListener for i7
		i7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new COREI7Details();
			} 
		});
		//ActionListener for i5
		i5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new COREI5Details();
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