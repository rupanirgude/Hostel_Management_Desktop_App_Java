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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AfterEmpUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterEmpUpdate frame = new AfterEmpUpdate();
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
	public AfterEmpUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEid = new JLabel("Employee ID");
		lblEid.setIcon(new ImageIcon(AfterEmpUpdate.class.getResource("/images/manager.png")));
		lblEid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEid.setBounds(71, 84, 130, 32);
		contentPane.add(lblEid);
		
		eid = new JTextField();
		eid.setBounds(221, 90, 116, 22);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String o=eid.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				String query="Select * from employee where eid=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,o);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					String Name=rs.getString(2);
                	String Designation=rs.getString(3);
                	String Department=rs.getString(4);
                	String Salary=rs.getString(5);
					String Age=rs.getString(6);
					
					Emp_Update aefn=new Emp_Update(eid.getText(),Name,Designation,Department,Salary,Age);
					aefn.show();
					setVisible(false);
				}
				else
				{
					
						JOptionPane.showMessageDialog(null,"Invalid Details");
					
				}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnSubmit.setBounds(221, 137, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AfterEmpUpdate.class.getResource("/images/house.png")));
		btnNewButton.setBounds(12, 13, 54, 47);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterEmployee ae=new AfterEmployee();
				ae.show();
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterEmpUpdate.class.getResource("/images/back.png")));
		button.setBounds(12, 180, 54, 60);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterEmpUpdate.class.getResource("/images/checked.png")));
		lblNewLabel.setBounds(332, 130, 38, 32);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterEmpUpdate.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 401, 253);
		contentPane.add(label);
	}
}
