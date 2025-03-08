import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class CustomerInfo extends JFrame{
	private Container c;
	private JButton logoutButton, backButton;
	private Cursor cursor;
	
	
	
	int fileNo;
	String user_username, user_password, user_balance, user_email, user_phone, user_name;
	
	CustomerInfo(){
		
		//Cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		// Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 110, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Admin Panel");
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
		logoutButton.setBounds(6,33,110,32);
		logoutButton.setCursor(cursor);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(false);
		c.add(logoutButton);
		 
		 //Back Button
		 JButton backButton= new JButton();
		 backButton.setBounds(930,530,40,20);
		 backButton.setCursor(cursor);
		 backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setBorderPainted(false);
		c.add(backButton);
		
		
		//////////////////////////Reading users
		
			String userFileNo="";
					
					try{
						File book_file = new File("TXT FILES\\User_File_No.txt");		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							userFileNo=scanFile.next();
							break;
						}
						
						fileNo = Integer.parseInt(userFileNo);			
						fileNo -=1;		
						
					}catch(Exception f)		{System.out.println("User file No problem in admin view");}
		
		// Tabel related code;
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,190,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		c.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,170,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		c.add(label_Row);
		
		
		//Adding Serial No label;
		JLabel serial_No =new JLabel("Serial No");
		serial_No.setBounds(70,170,100,20);
		c.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(183,170,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		c.add(label_colum1);
		
		//Adding label for top left colum1;
		JLabel label_leftcolum1=new JLabel();
		label_leftcolum1.setBounds(10,170,1,20);
		label_leftcolum1.setOpaque(true);
		label_leftcolum1.setBackground(Color.BLACK);
		c.add(label_leftcolum1);
		
		
		//Adding Customer Name label;
		JLabel employeeName_label =new JLabel("Customer Name");
		employeeName_label.setBounds(225,170,100,20);
		c.add(employeeName_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(357,170,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		c.add(label_colum2);
		
		
	   //Adding Customer balance label;
		JLabel customerGender_label =new JLabel("Customer Balance");
		customerGender_label.setBounds(389,170,120,20);
		c.add(customerGender_label);
	
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(531,170,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		c.add(label_colum3);
		
		
		//Adding Customer balance label;
		JLabel employeeID_label =new JLabel("Customer Phone");
		employeeID_label.setBounds(565,170,100,20);
		c.add(employeeID_label); 
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(706,170,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		c.add(label_colum4);
		
		
		//Adding Customer Email label;
		JLabel employeePass_label =new JLabel("Customer Email");
		employeePass_label.setBounds(795,165,120,30);
		c.add(employeePass_label);
		
		//Adding label for top right colum;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(975,170,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		c.add(label_colum5);
		
		
		//for table;
		String order_data[][] = new String [fileNo][5];
		
		for(int row=0; row<fileNo; row++)
		{
			for(int col=0; col<5; col++)
			{
					String User_Information_File_Path="TXT FILES\\User Informations\\User--"+(row+1)+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
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
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						else if(col==1){
							order_data[row][col]=user_name;
						}
					    else if(col==2){
							order_data[row][col]=user_balance;
						} 
						else if(col==3){
							order_data[row][col]=user_phone;
						}
						else if(col==4){
							order_data[row][col]=user_email;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("CustomerInfo file problem in customer view");}
				
			}
		}
					
		
		String table_colume[] ={"Serial","Customer Name","Customer Balance","Customer Phone", "Customer Email"};
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,190,966,270);
		table_admin.setRowHeight(20  );
		
		
		c.add(table_admin);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_admin.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 5 );
		tcm.getColumn(1).setPreferredWidth( 10 );
		tcm.getColumn(2).setPreferredWidth( 5 );
		tcm.getColumn(3).setPreferredWidth( 10 );
		tcm.getColumn(4).setPreferredWidth( 110 );
		
		
		/////////////////////Action Listener
		
		//Button Actionlistener
		backButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new adminView();
			}});
			
			//Button Actionlistener
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
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\customerInfo.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
}
	
	
	
	
	
	
	
	