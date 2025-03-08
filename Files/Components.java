import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.Border;

//new TextPrompt("Name", object);

public class Components extends JFrame {

	//private JLabel userLabel, passLabel;
	private JButton mobo, cpu, gpu, profile, contact, back, home;
	private Container c;
	private Cursor cursor;
	
	//Colors
	Color White  = Color.decode("#F2F2F2");
	Color Orange = Color.decode("#FCB13A");
	Color LightOrange = Color.decode("#FFE699");
	

	public Components() {
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);

		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Choose Components");
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
		
		//Graphics Card
		gpu = new JButton();
		gpu.setBounds(234,353,142,54);//353
		gpu.setToolTipText("Graphics Card");
		gpu.setCursor(cursor);
		gpu.setContentAreaFilled(false);
		gpu.setBorderPainted(false);
		c.add(gpu); 

		//Processor
		cpu = new JButton();
		cpu.setBounds(423,352,142,54);
		cpu.setToolTipText("Processor");
		cpu.setCursor(cursor);
		cpu.setContentAreaFilled(false);
		cpu.setBorderPainted(false);
		c.add(cpu);
		
		//Mother Board
		mobo = new JButton();
		mobo.setBounds(612,352,142,54);
		mobo.setCursor(cursor);
		mobo.setToolTipText("Motherboard");
		mobo.setContentAreaFilled(false);
		mobo.setBorderPainted(false);
		c.add(mobo);
		
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
		contact.setToolTipText("Contact US");
		contact.setContentAreaFilled(false);
		contact.setBorderPainted(false);
		c.add(contact);
		
		
		// Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Choose Component.png");
		
		Image img = Newpass_Background.getImage();
		Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
		Newpass_Background = new ImageIcon(temp_img);
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		


		///////////////////////////////////Action Listener////////////////////////////////////////
		
		
		//ActionListener for GPU
		gpu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new GPU();
			} 
		});
		//ActionListener for CPU
		cpu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new CPU();
			} 
		});
		//ActionListener for MOTHERBOARD
		mobo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new MOBO();
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