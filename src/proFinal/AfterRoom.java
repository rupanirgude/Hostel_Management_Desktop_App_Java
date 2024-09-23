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

public class AfterRoom extends JFrame {

	private JPanel contentPane;
	private JTextField rno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterRoom frame = new AfterRoom();
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
	public AfterRoom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomNo = new JLabel("Room No. :");
		lblRoomNo.setIcon(new ImageIcon(AfterRoom.class.getResource("/images/room-key.png")));
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRoomNo.setBounds(151, 209, 178, 21);
		contentPane.add(lblRoomNo);
		
		rno = new JTextField();
		rno.setBounds(356, 213, 116, 22);
		contentPane.add(rno);
		rno.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                String m=rno.getText();
                
                
                	
                	
                	AfterRoomNo arno=new AfterRoomNo(m);
                	arno.show();
                	setVisible(false);
               
				
			
			}});
		btnSubmit.setBounds(392, 266, 80, 25);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AfterRoom.class.getResource("/images/house.png")));
		btnNewButton.setBounds(12, 13, 53, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHome.setBounds(77, 26, 56, 16);
		contentPane.add(lblHome);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterRoom.class.getResource("/images/back.png")));
		btnNewButton_1.setBounds(12, 415, 53, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGoBack.setBounds(77, 437, 56, 16);
		contentPane.add(lblGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterRoom.class.getResource("/images/ad.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 466);
		contentPane.add(lblNewLabel);
	}
}
