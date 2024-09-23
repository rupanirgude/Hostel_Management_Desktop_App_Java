package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DeleteDialog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDialog frame = new DeleteDialog("");
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
	public DeleteDialog(String USN) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Do you want to delete this record?");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\dbms_pro_img\\warning.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 38, 298, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(38, 124, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Yes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					String sql1="SELECT COUNT(*) AS total FROM register WHERE USN =?";
					
					PreparedStatement ps3 = con.prepareStatement(sql1);
					ps3.setString(1, USN);
					ResultSet rs=ps3.executeQuery();
					if(rs.next())
					{
						int c= rs.getInt("total");
						System.out.println(c);
						if(c>=1)
						{
							String sql="DELETE FROM register WHERE USN=?";
			                PreparedStatement ps4 = con.prepareStatement(sql);
			                ps4.setString(1, USN);
			                ps4.executeUpdate();
			                String sq="DELETE FROM fees WHERE USN=?";
			                PreparedStatement ps2 = con.prepareStatement(sq);
			                ps2.setString(1, USN);
			                ps2.executeUpdate();
			                setVisible(false);
			                AfterStuDelete asd=new AfterStuDelete();
			                asd.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Unsuccessful");
						}
					}
	                
	                
				}
				catch(Exception e1)
				{
					System.out.println("ded"+e1);
				}
				
			}
		});
		btnNewButton_1.setBounds(213, 124, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}
