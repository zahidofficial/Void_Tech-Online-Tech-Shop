import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class GPU extends JFrame {

	private JButton R4090, R3090Ti, R2080Ti, profile, contact, back;
	private Container c;
	private Cursor cursor;
	
	//Colors
	Color White = Color.decode("#F2F2F2");

	GPU() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Graphics Card");
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
		
		//RTX 4090
		R4090 = new JButton();
		R4090.setBounds(190,446,111,38);
		R4090.setCursor(cursor);
		R4090.setContentAreaFilled(false);
		R4090.setBorderPainted(false);
		c.add(R4090);
		
		
		//RTX 3090 Ti
		R3090Ti = new JButton();
		R3090Ti.setBounds(439,446,111,38);
		R3090Ti.setCursor(cursor);
		R3090Ti.setContentAreaFilled(false);
		R3090Ti.setBorderPainted(false);
		c.add(R3090Ti);
		
		
		//RTX 2080 Ti
		R2080Ti = new JButton();
		R2080Ti.setBounds(701,446,111,38);
		R2080Ti.setCursor(cursor);
		R2080Ti.setContentAreaFilled(false);
		R2080Ti.setBorderPainted(false);
		c.add(R2080Ti);
		
		//Profile
		profile = new JButton();
		profile.setBounds(306,69,134,42);
		profile.setCursor(cursor);
		profile.setToolTipText("Your Profile");
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
		ImageIcon Newpass_Background = new ImageIcon("Images\\GPU.png");
		
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
		//ActionListener for RTX4090
		R4090.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new RTX4090Details();
			} 
		});
		//ActionListener for RTX3090ti
		R3090Ti.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new RTX3090Details();
			} 
		});
		//ActionListener for RTX2080ti
		R2080Ti.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new RTX2080Details();
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