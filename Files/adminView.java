import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class adminView extends JFrame {
	
	private JTextField userField;
	private JButton logoutButton, customerInformation;
	private JLabel totalUsers, totalOrders;
	private Container c;
	private Cursor cursor;
	
	
	int totalCustomer, totalorder, totalProduct=0, multitotalorder;
	int ProductfileNO;
	
	String product_Id, product_Price, product_name, product_path, product_quantity;
	
	String  order_ID,order_productname, order_userPhone, order_userEmail, order_quantity, order_amount, order_userName;




	adminView() {
		
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
		logoutButton.setBounds(15,18,110,35);
		logoutButton.setCursor(cursor);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(false);
		c.add(logoutButton);
		
		//Customer Information Button
		JButton customerInformation = new JButton();
		customerInformation.setBounds(347,127,255,42);
		customerInformation.setCursor(cursor);
		customerInformation.setFocusPainted(false);
		customerInformation.setBorderPainted(false);
		customerInformation.setContentAreaFilled(false);
		c.add(customerInformation);
		
		
		/////////////////////Action Listener
			
		//Logout Button Actionlistener
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
		
		//Logout Button Actionlistener
		customerInformation.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new CustomerInfo();
			}});
		 
		
		// Getting how many customer
		
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalCustomer= Integer.parseInt(filenumber);
			totalCustomer=totalCustomer-1;
						
		}catch(Exception f)		{System.out.println("User file problem in admin panel");}
		
		//Getting Order Amount
		String orderFileNo="";
		try{
			File otp_File = new File("TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				orderFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalorder= Integer.parseInt(orderFileNo);
			totalorder=totalorder-1;
						
		}catch(Exception f)		{System.out.println("Order file problem in admin panel");} 
		
		
		
		
		
		
		
		
		
		
		
		
			////////////////////////////////////////////////////////////
		
		
		//Total User Label;
		JLabel totalUsers = new JLabel(""+totalCustomer);
		totalUsers.setBounds(172,125,90,60);
		Font totalUsersFont = new Font("Open Sans", Font.BOLD,30);
		totalUsers.setFont(totalUsersFont);
		c.add(totalUsers);
		
		
		//Total orders Label;
		JLabel totalOrders = new JLabel(""+(totalorder+multitotalorder) );
		totalOrders.setBounds(767,125,90,60);
		Font totalOrdersFont = new Font("Open Sans", Font.BOLD,30);
		totalOrders.setFont(totalOrdersFont);
		c.add(totalOrders);
		
	
		
		
		
		
		
		
		
		////////////////////////////////////////////////////////////
		
		
		// Tabel related work;
		
		//Adding label for top left colum1;
		JLabel label_leftcolum1=new JLabel();
		label_leftcolum1.setBounds(10,230,1,20);
		label_leftcolum1.setOpaque(true);
		label_leftcolum1.setBackground(Color.BLACK);
		c.add(label_leftcolum1);
		
		//Adding label for row1;
		
		JLabel label_row=new JLabel();
		label_row.setBounds(10,230,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		c.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,250,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		c.add(label_Row);
		
		//Adding Serial No label;
		JLabel serial_No =new JLabel("Serial No");
		serial_No.setBounds(55,230,100,20);
		c.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(158,230,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		c.add(label_colum1);
		
		//Adding Order ID label;
		JLabel orderId_label =new JLabel("Order Amount");
		orderId_label.setBounds(230,230,100,20);
		c.add(orderId_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(381,230,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		c.add(label_colum2);
		
		//Adding Customer Name label;
		JLabel customerName_label =new JLabel("Product Name");
		customerName_label.setBounds(410,230,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		c.add(customerName_label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(530,230,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		c.add(label_colum3);
		
		//Adding Product Name label;
		JLabel productName_label =new JLabel("Customer Number");
		productName_label.setBounds(550,230,120,20);
		c.add(productName_label);
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(678,230,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		c.add(label_colum4);
		
		//Adding Order amount label;
		JLabel orderAmount_label =new JLabel("Customer Gmail");
		orderAmount_label.setBounds(715,230,100,20);
		c.add(orderAmount_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(827,230,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		c.add(label_colum5);
		
		//Adding Order Quantity label;
		JLabel orderQuantity_label =new JLabel("Order Quantity");
		orderQuantity_label.setBounds(855,230,100,20);
		c.add(orderQuantity_label);
		
		//Adding label for colum6;
		JLabel label_colum6=new JLabel();
		label_colum6.setBounds(975,230,1,20);
		label_colum6.setOpaque(true);
		label_colum6.setBackground(Color.BLACK);
		c.add(label_colum6);
		
		//for table;
		String order_data[][] = new String [totalorder][6];
		int temp=totalorder;
		
		 for(int row=0; row<totalorder; row++)
		{
			for(int col=0; col<6; col++)
			{
					String User_Information_File_Path="TXT FILES\\Order_Info\\Order-"+temp+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							order_ID=scanFile.next();
							order_productname=scanFile.next();
							order_userName=scanFile.next();
							order_userPhone=scanFile.next();
							order_userEmail=scanFile.next();
							order_quantity=scanFile.next();
							order_amount=scanFile.next();
					
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						/* else if(col==1){
							order_data[row][col]=order_ID;
						} */
						else if(col==1){
							order_data[row][col]=order_amount;
						}
						else if(col==2){
							order_data[row][col]=order_productname;
						}
						else if(col==3){
							order_data[row][col]=order_userPhone;
						}
						else if(col==4){
							order_data[row][col]=order_userEmail;
						}
						else if(col==5){
							order_data[row][col]=order_quantity;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("order file problem in admin view");}
			
				
			}
			temp--;
		}
				
		
		
		
		
		String table_colume[] ={"Serial","Order No","Customer Name ","Product Name","Product Price","Order Quantity"};
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,250,966,300);
		table_admin.setRowHeight(20  );	
		c.add(table_admin);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_admin.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 10 );
		tcm.getColumn(1).setPreferredWidth( 90 );
		tcm.getColumn(2).setPreferredWidth( 10 );
		tcm.getColumn(3).setPreferredWidth( 10 );
		tcm.getColumn(4).setPreferredWidth( 10 );
		tcm.getColumn(5).setPreferredWidth( 10 ); 
		
		
		
		
		
		
		// Set Background Image
		
		ImageIcon Newpass_Background = new ImageIcon("Images\\adminPanel.png");
        
		Image img = Newpass_Background.getImage();
        Image temp_img = img.getScaledInstance(986,563,Image.SCALE_SMOOTH);
        Newpass_Background = new ImageIcon(temp_img);
	
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0, 0, 986, 563);
		c.add(bg_label);
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
}