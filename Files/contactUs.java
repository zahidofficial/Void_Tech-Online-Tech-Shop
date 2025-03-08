import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class contactUs extends JFrame{
	
	private JButton logoutButton,homeButton;
	private JLabel emailLabel,facebookLabel;
	private Container c;
	private Cursor cursor;
	
	contactUs() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Helpline Panel");
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
		
		 
		 
		 //Logout Button
		JButton logoutButton = new JButton();
		logoutButton.setBounds(858,510,110,35);
		logoutButton.setCursor(cursor);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(false);
		c.add(logoutButton);
		
		
		 //Back to home Button
		JButton homeButton = new JButton();
		homeButton.setBounds(20,18,40,38);
		homeButton.setCursor(cursor);
		homeButton.setContentAreaFilled(false);
		homeButton.setFocusPainted(false);
		homeButton.setBorderPainted(false);
		c.add(homeButton);
		
		
		//Email Address Label
		
		JLabel emailLabel = new JLabel("voidtechproject@gmail.com");
		emailLabel.setBounds(270,421,225,22);
		Font emailLabelFont = new Font("Open Sans", Font.PLAIN,18);
		emailLabel.setFont(emailLabelFont);
		emailLabel.setForeground(Color.decode("#F2F2F2"));
		emailLabel.setCursor(cursor);
		c.add(emailLabel);
		
		
		//Mouse Listener
		emailLabel.addMouseListener(new MouseAdapter() {
 
			public void mouseClicked(MouseEvent e) {
				try {
         
					Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?ogbl#inbox?compose=CllgCHrjDvTXgCSbsnXzPzLLZKZpqjndsqNkVKjWwqgzPMhlNcSQnbfzxXXXmXSdFgNvLvRRbhg"));
					 
				} catch (IOException | URISyntaxException e1) {
					System.out.println("Browse problem");
				}
			}
		 
			public void mouseEntered(MouseEvent e) {
				emailLabel.setText("<html><a href=''>voidtechproject@gmail.com</a></html>");
			}
		 
			public void mouseExited(MouseEvent e) {
				emailLabel.setText("voidtechproject@gmail.com");
			}
		});
		
		
		
		//Facebook label
		
		JLabel zahidLabel = new JLabel("MD Zahidul Islam");
		zahidLabel.setBounds(278,482,220,22);
		Font zahidLabelFont = new Font("Open Sans", Font.PLAIN,20);
		zahidLabel.setFont(zahidLabelFont);
		zahidLabel.setForeground(Color.decode("#F2F2F2"));
		zahidLabel.setCursor(cursor);
		c.add(zahidLabel);
		
		//Mouse Listener
		zahidLabel.addMouseListener(new MouseAdapter() {
 
			public void mouseClicked(MouseEvent e) {
				try {
         
					Desktop.getDesktop().browse(new URI("https://www.facebook.com/zahidulislamofficial?mibextid=ZbWKwL"));
					 
				} catch (IOException | URISyntaxException e1) {
					System.out.println("Browse problem");
				}
			}
		 
			
			public void mouseEntered(MouseEvent e) {
				zahidLabel.setText("<html><a href=''>MD Zahidul Islam</a></html>");
			}
		 
			
			public void mouseExited(MouseEvent e) {
				zahidLabel.setText("MD Zahidul Islam");
			}
		});
		
		//Facebook label
		
		JLabel azharLabel = new JLabel("Azhar Sabbir");
		azharLabel.setBounds(278,510,220,22);
		Font azharLabelFont = new Font("Open Sans", Font.PLAIN,20);
		azharLabel.setFont(azharLabelFont);
		azharLabel.setForeground(Color.decode("#F2F2F2"));
		azharLabel.setCursor(cursor);
		c.add(azharLabel);
		
		//Mouse Listener
		azharLabel.addMouseListener(new MouseAdapter() {
 
			public void mouseClicked(MouseEvent e) {
				try {
         
					Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100029287549330&mibextid=ZbWKwL"));
					 
				} catch (IOException | URISyntaxException e1) {
					System.out.println("Browse problem");
				}
			}
		 
			
			public void mouseEntered(MouseEvent e) {
				azharLabel.setText("<html><a href=''>Azhar Sabbir</a></html>");
			}
		 
			
			public void mouseExited(MouseEvent e) {
				azharLabel.setText("Azhar Sabbir");
			}
		});
		
		
		//Action Listeners
		
		
		homeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Components();
			} 
		});
		
		logoutButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Logout?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						frame.setVisible(false);
						new LoginPanel();
					}
				}
			}
		);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\contactUs.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		
		frame.setVisible(true);
	}
}
	
	
	