package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ViewSalary extends JFrame {

	private JPanel contentPane;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSalary frame = new ViewSalary();
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
	public ViewSalary() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEid = new JLabel("EID");
		lblEid.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/manager.png")));
		lblEid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEid.setBounds(43, 128, 79, 32);
		contentPane.add(lblEid);
		
		eid = new JTextField();
		eid.setBounds(147, 134, 116, 22);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
	                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
	                 String q="Select * from salary where Eid='"+eid.getText()+"'";
	                 Statement stmt = con.createStatement();
	 				ResultSet rs = stmt.executeQuery( q );
	 				if(rs.next())
	 				{
	 					AfterSalaryEID ase=new AfterSalaryEID(eid.getText(),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	 					ase.setVisible(true);
	 					
	 				}
					}
					catch(Exception e2)
					{
						System.out.println(e2);
					}
			}
		});
		btnSubmit.setBounds(297, 133, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllSalary as=new AllSalary();
				as.setVisible(true);
			}
		});
		btnViewAll.setBounds(147, 253, 97, 25);
		contentPane.add(btnViewAll);
		
		JLabel lblViewSalary = new JLabel("VIEW SALARY");
		lblViewSalary.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/search(1).png")));
		lblViewSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblViewSalary.setBounds(120, 13, 174, 74);
		contentPane.add(lblViewSalary);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/search.png")));
		label.setBounds(90, 241, 45, 37);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpSal es=new EmpSal();
				es.show();
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/back.png")));
		button.setBounds(12, 316, 45, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/house.png")));
		button_1.setBounds(12, 13, 45, 43);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewSalary.class.getResource("/images/ad.jpg")));
		label_1.setBounds(0, 0, 433, 372);
		contentPane.add(label_1);
	}

}
