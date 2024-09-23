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

public class AfterFeesShow extends JFrame {

	private JPanel contentPane;
	private JTextField usn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterFeesShow frame = new AfterFeesShow();
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
	public AfterFeesShow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(AfterFeesShow.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUsn.setBounds(138, 153, 103, 39);
		contentPane.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(253, 153, 116, 34);
		contentPane.add(usn);
		usn.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                 String q="Select * from fees where USN='"+usn.getText()+"'";
                 Statement stmt = con.createStatement();
 				ResultSet rs = stmt.executeQuery( q );
 				setVisible(false);
 				
 				if(rs.next())
 				{
 					AfterFeesUSN afu=new AfterFeesUSN(usn.getText(),rs.getString(2),rs.getString(4),rs.getString(5));
 					afu.setVisible(true);
 				}
				}
				catch(Exception e2)
				{
					
				}
			}
		});
		btnNewButton.setBounds(403, 155, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllFee saf=new ShowAllFee();
				saf.show();
				setVisible(false);
			}
		});
		btnSubmit.setBounds(253, 265, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblView = new JLabel("View");
		lblView.setIcon(new ImageIcon(AfterFeesShow.class.getResource("/images/search.png")));
		lblView.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblView.setBounds(138, 258, 116, 32);
		contentPane.add(lblView);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterFeesShow.class.getResource("/images/house.png")));
		btnNewButton_1.setBounds(12, 13, 54, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AfterFeesButton afb=new AfterFeesButton();
				afb.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AfterFeesShow.class.getResource("/images/back.png")));
		btnNewButton_2.setBounds(12, 403, 54, 50);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterFeesShow.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 656, 466);
		contentPane.add(label);
	}

}
