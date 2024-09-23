package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.AccessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.ImageIcon;

public class fupdate extends JFrame {
	int test;
	private JPanel contentPane;
	private JTextField t1;
	private JLabel lblReceiveAmount;
	private JTextField t2;
	private JButton btnNewButton;
	private JButton btnBack;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fupdate frame = new fupdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fupdate() {
		super("FEE EDIT");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(fupdate.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUsn.setBounds(283, 110, 87, 23);
		contentPane.add(lblUsn);
		
		t1 = new JTextField();
		t1.setBounds(250, 146, 158, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		
		lblReceiveAmount = new JLabel("RECEIVED AMOUNT");
		lblReceiveAmount.setIcon(new ImageIcon(fupdate.class.getResource("/images/credit-card(1).png")));
		lblReceiveAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblReceiveAmount.setBounds(213, 205, 256, 23);
		contentPane.add(lblReceiveAmount);
		
		
		btnNewButton = new JButton("Submit"); 
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try
			{
				int paid;
				String usn=t1.getText();
				paid=Integer.parseInt(t2.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				String  qry="select usn,paid from fees where usn='"+usn+"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery( qry );
				if(rs.next())	
				{
					
				}
				else
				{
						int c[]=new int[2];
						c[3]=5;
				}
				
				int ppaid=rs.getInt(2);
				 //System.out.println(ppaid+"hi");
				
				
				//if(rs.next())
				//{
					
						if(paid+ppaid<=60000)
						{
							 Class.forName("com.mysql.jdbc.Driver");
							 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
							 String query = " update fees set paid=paid+?,balance=fees-paid where usn=?" ;
							 PreparedStatement ps = con.prepareStatement(query);
							 
							 
							 ps.setInt (1,paid);
							
							 ps.setString (2,usn);
							

							 ps.execute();

							 JOptionPane.showMessageDialog(null,"Paid SUCCESSFULLY");
							 con.close();
					
						}
						else
						{
							 int i=10/0;
						}
				//}
			
			
			}
			catch (ArrayIndexOutOfBoundsException z)
			{
				 JOptionPane.showMessageDialog(null,"USN NOT FOUND");
			}
			catch (ArithmeticException x)
			{
				 JOptionPane.showMessageDialog(null,"TOTAL PAID CANT BE MORE THAN 60000");
			}
			
			 catch (Exception e)
			 {
			 
			 
			 JOptionPane.showMessageDialog(null,"USN NOT FOUND");
			 }
			}
		});
		btnNewButton.setBounds(283, 311, 89, 32);
		contentPane.add(btnNewButton);
		
		t2 = new JTextField();
		t2.setBounds(250, 241, 158, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(fupdate.class.getResource("/images/back.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterFeesButton ob1=new AfterFeesButton();
				ob1.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(12, 408, 67, 57);
		contentPane.add(btnBack);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(fupdate.class.getResource("/images/house.png")));
		btnNewButton_1.setBounds(12, 13, 67, 57);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(fupdate.class.getResource("/images/checked.png")));
		lblNewLabel.setBounds(384, 311, 32, 32);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(fupdate.class.getResource("/images/ad.jpg")));
		lblNewLabel_1.setBounds(0, 0, 656, 478);
		contentPane.add(lblNewLabel_1);
	}
	
}
