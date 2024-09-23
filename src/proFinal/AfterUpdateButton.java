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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AfterUpdateButton extends JFrame {

	private JPanel contentPane;
	private JTextField usn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterUpdateButton frame = new AfterUpdateButton("sa");
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
	public AfterUpdateButton(String a) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(AfterUpdateButton.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsn.setBounds(182, 173, 91, 32);
		contentPane.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(283, 179, 116, 22);
		contentPane.add(usn);
		usn.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String o=usn.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
				String query="Select * from register where usn=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,o);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					String FirstName=rs.getString(1);
                	String LastName=rs.getString(2);
                	String USN=rs.getString(3);
                	String DOB=rs.getString(4);
					String CourseId=rs.getString(5);
					String Contact=rs.getString(6);
					String Email=rs.getString(7);
					String PName=rs.getString(8);
					String PLName=rs.getString(9);
					String PContact=rs.getString(10);
					String RoomNo=rs.getString(11);
					AfterStuUpdate ar1=new AfterStuUpdate(FirstName,LastName,USN,CourseId,Contact,Email,PContact,RoomNo);
					ar1.show();
				}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(283, 242, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterUpdateButton.class.getResource("/images/checked.png")));
		label.setBounds(403, 235, 37, 32);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterUpdateButton.class.getResource("/images/house.png")));
		btnNewButton_1.setBounds(12, 13, 47, 36);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterUpdate au=new AfterUpdate();
				au.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterUpdateButton.class.getResource("/images/back.png")));
		button.setBounds(12, 417, 47, 36);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AfterUpdateButton.class.getResource("/images/ad.jpg")));
		label_1.setBounds(0, 0, 644, 466);
		contentPane.add(label_1);
	}

}
