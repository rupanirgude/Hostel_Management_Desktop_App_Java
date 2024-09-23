package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AfterLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLogin frame = new AfterLogin("a");
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
	public AfterLogin(String am) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shubh\\Downloads\\avatar.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String wel="Welcome "+am;
		setTitle(wel);
		
		JLabel lblRegsiter = new JLabel("Regsiter");
		lblRegsiter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegsiter.setBounds(33, 147, 76, 32);
		contentPane.add(lblRegsiter);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFees.setBounds(455, 155, 56, 16);
		contentPane.add(lblFees);
		
		JLabel lblRoom = new JLabel("Room Status");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRoom.setBounds(222, 155, 112, 16);
		contentPane.add(lblRoom);
		
		JButton btnSubmit_1 = new JButton("");
		btnSubmit_1.setForeground(SystemColor.desktop);
		btnSubmit_1.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/desk(1).png")));
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterRoom arm=new AfterRoom();
				arm.setVisible(true);
			}
			
		});
		btnSubmit_1.setBounds(252, 13, 122, 135);
		contentPane.add(btnSubmit_1);
		
		JLabel lblUpdateshow = new JLabel("Update/Show");
		lblUpdateshow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdateshow.setBounds(12, 428, 112, 16);
		contentPane.add(lblUpdateshow);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterRegister ar = new AfterRegister();
				ar.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/clipboard.png")));
		button.setBounds(12, 13, 112, 135);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(453, 13, 135, 135);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/pay-per-click.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterUpdate au=new AfterUpdate();
				au.show();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/content.png")));
		btnNewButton_1.setBounds(12, 278, 112, 135);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterEmployee ae=new AfterEmployee();
				ae.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/collaboration(2).png")));
		btnNewButton_3.setBounds(252, 278, 122, 135);
		contentPane.add(btnNewButton_3);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployees.setBounds(222, 429, 106, 16);
		contentPane.add(lblEmployees);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afterAbout abt=new afterAbout();
				abt.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/question.png")));
		btnNewButton_2.setBounds(464, 278, 135, 135);
		contentPane.add(btnNewButton_2);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAbout.setBounds(452, 428, 69, 16);
		contentPane.add(lblAbout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterLogin.class.getResource("/images/ad.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 466);
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterFeesButton af=new AfterFeesButton();
				af.show();
			}
			
		});
	}
}
