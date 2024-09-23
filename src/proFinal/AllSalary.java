package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class AllSalary extends JFrame {

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
					AllSalary frame = new AllSalary();
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
	public AllSalary() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnShow = new JButton("Show");
		String[] colNames= {"Eid","Name","Salary","Paid","Balance"};
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(100,80,400,341);
		contentPane.add(scrollPane);
		
		table=new JTable(data,colNames);
		
		scrollPane.setViewportView(table);
		try
		{
		 Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
		String q="Select * from salary";
		 PreparedStatement ps1 = con.prepareStatement(q);
		 ResultSet rs=ps1.executeQuery(q);
		 int row=0;
		 while(rs.next())
		 {
			 table.setValueAt(rs.getString("Eid"), row, 0);
			 table.setValueAt(rs.getString("Name"), row, 1);
			 table.setValueAt(rs.getString("Salary"), row, 2);
			 table.setValueAt(rs.getString("Paid"), row, 3);
			 table.setValueAt(rs.getString("Balance"), row, 4);
			 
			 row++;
		 }
		 //JTable 
	
	}
		catch(Exception e2)
		{
			System.out.println(e2);
		}
	}

}
