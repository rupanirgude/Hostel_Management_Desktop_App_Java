package proFinal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AfterRoomNo extends JFrame {

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
					AfterRoomNo frame = new AfterRoomNo("54");
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
	public AfterRoomNo(String rn) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(148,24,400,341);
		contentPane.add(scrollPane);
		String[] colNames= {"First Name","Last Name","Room Number"};
		table=new JTable(data,colNames);
		JButton btnNewButton = new JButton("Show");
		scrollPane.setViewportView(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{	table.setVisible(true);
				 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				//String q="select FirstName,LastName,RoomNo from register where RoomNo='"+rn+"'";
				//String  qry="select usn,paid from fees where usn='"+usn+"'";
                 String q="select * from register where RoomNo='"+rn+"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery( q );
				ResultSet qs=rs;
				 int row=0;
				int i=0;
				 while(rs.next())
				 {
					 table.setValueAt(rs.getString("FirstName"), row, 0);
					 table.setValueAt(rs.getString("LastName"), row, 1);
					 table.setValueAt(rs.getString("RoomNo"), row, 2);
					 row++;
					 i++;
				 }
				 if(i==0)
				 {
					 System.out.println("Wrong");
				 }
				 //JTable 
				 }
				
			
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}	
		});
		btnNewButton.setBounds(310, 378, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterRoomNo.class.getResource("/images/house.png")));
		btnNewButton_1.setBounds(12, 13, 53, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterRoom ar=new AfterRoom();
				ar.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AfterRoomNo.class.getResource("/images/back.png")));
		btnNewButton_2.setBounds(12, 385, 53, 58);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterRoomNo.class.getResource("/images/ad.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 466);
		contentPane.add(lblNewLabel);
	}

}
