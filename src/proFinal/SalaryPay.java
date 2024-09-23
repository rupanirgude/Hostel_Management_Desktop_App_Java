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

public class SalaryPay extends JFrame {
	int test;
	private JPanel contentPane;
	private JTextField t1;
	private JLabel lblReceiveAmount;
	private JTextField t2;
	private JButton btnNewButton;
	private JButton btnBack;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryPay frame = new SalaryPay();
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
	public SalaryPay() {
		super("PAY");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 75, 488, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsn = new JLabel("EID");
		lblUsn.setIcon(new ImageIcon(SalaryPay.class.getResource("/images/manager.png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsn.setBounds(71, 86, 93, 32);
		contentPane.add(lblUsn);
		
		t1 = new JTextField();
		t1.setBounds(218, 92, 158, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		
		lblReceiveAmount = new JLabel("Amount");
		lblReceiveAmount.setIcon(new ImageIcon(SalaryPay.class.getResource("/images/debit-card(1).png")));
		lblReceiveAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReceiveAmount.setBounds(71, 133, 114, 39);
		contentPane.add(lblReceiveAmount);
		
		
		btnNewButton = new JButton("Submit"); 
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try
			{
				int paid;
				String eid=t1.getText();
				paid=Integer.parseInt(t2.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				String  qry="select Eid,paid from Salary where Eid='"+eid+"'";
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
				
				String  q4="select Salary from salary where Eid='"+eid+"'";
				Statement stmt1 = con.createStatement();
				ResultSet rs2 = stmt.executeQuery( q4 );
				rs2.next();
				String sal=rs2.getString(1);
				int a=Integer.parseInt(sal);
				System.out.println(a);
				System.out.println(paid);
				System.out.println(ppaid);
				//if(rs.next())
				//{
					
						if(paid+ppaid<=a)
						{
							 Class.forName("com.mysql.jdbc.Driver");
							 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
							 String query = " update Salary set paid=paid+?,balance=Salary-paid where eid=?" ;
							 PreparedStatement ps = con.prepareStatement(query);
							 
							 
							 ps.setInt (1,paid);
							
							 ps.setString (2,eid);
							

							 ps.execute();

							 JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
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
				 JOptionPane.showMessageDialog(null,z);
			}
			catch (ArithmeticException x)
			{
				 JOptionPane.showMessageDialog(null,"TOTAL PAID CANT BE MORE THAN 60000");
			}
			
			 catch (Exception e)
			 {
			 
			 
			 JOptionPane.showMessageDialog(null,e);
			 }
			}
		});
		btnNewButton.setBounds(215, 194, 89, 23);
		contentPane.add(btnNewButton);
		
		t2 = new JTextField();
		t2.setBounds(218, 142, 158, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(SalaryPay.class.getResource("/images/back.png")));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpSal ob1=new EmpSal();
				ob1.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(12, 222, 48, 36);
		contentPane.add(btnBack);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(SalaryPay.class.getResource("/images/house.png")));
		button.setBounds(12, 13, 48, 36);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(SalaryPay.class.getResource("/images/ad.jpg")));
		label.setBounds(3, 0, 479, 271);
		contentPane.add(label);
	}
	
}
