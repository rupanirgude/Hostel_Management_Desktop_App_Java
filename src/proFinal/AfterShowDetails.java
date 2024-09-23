package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AfterShowDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public Object[][] data=new Object[500][500];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterShowDetails frame = new AfterShowDetails();
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
	public AfterShowDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("Show");
		String[] colNames= {"First Name","Last Name","USN","Contact","Email"};
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(100,80,400,341);
		contentPane.add(scrollPane);
		
		table=new JTable(data,colNames);
		
		scrollPane.setViewportView(table);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				String q="call testrout";
				 PreparedStatement ps1 = con.prepareStatement(q);
				 ResultSet rs=ps1.executeQuery(q);
				 int row=0;
				 while(rs.next())
				 {
					 table.setValueAt(rs.getString("FirstName"), row, 0);
					 table.setValueAt(rs.getString("LastName"), row, 1);
					 table.setValueAt(rs.getString("USN"), row, 2);
					 table.setValueAt(rs.getString("contact"), row, 3);
					 table.setValueAt(rs.getString("email"), row, 4);
					 row++;
				 }
				 //JTable 
			
			}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}	
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShow.setBounds(257, 13, 97, 41);
		contentPane.add(btnShow);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterShowDetails.class.getResource("/images/search(1).png")));
		label.setBounds(181, 0, 64, 67);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AfterShowDetails.class.getResource("/images/house.png")));
		btnNewButton.setBounds(12, 13, 55, 54);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterUpdate au=new AfterUpdate();
				au.show();
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterShowDetails.class.getResource("/images/back.png")));
		button.setBounds(12, 405, 55, 54);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AfterShowDetails.class.getResource("/images/ad.jpg")));
		label_1.setBounds(0, 0, 596, 468);
		contentPane.add(label_1);
	}
}
