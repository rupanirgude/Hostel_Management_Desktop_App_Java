package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class afterAbout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterAbout frame = new afterAbout();
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
	public afterAbout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAToolMade = new JLabel("A tool made for the hostel admins to manage the hostel ");
		lblAToolMade.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblAToolMade.setBounds(12, 87, 420, 38);
		contentPane.add(lblAToolMade);
		
		JLabel lblEasilyAndMake = new JLabel(" easily and make their work easy!");
		lblEasilyAndMake.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblEasilyAndMake.setBounds(78, 138, 269, 16);
		contentPane.add(lblEasilyAndMake);
		
		JLabel lblV = new JLabel("v6.9 2018-19");
		lblV.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		lblV.setBounds(326, 224, 81, 16);
		contentPane.add(lblV);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setIcon(new ImageIcon(afterAbout.class.getResource("/images/manager.png")));
		lblAbout.setFont(new Font("Segoe UI Light", Font.BOLD, 19));
		lblAbout.setBounds(164, 13, 115, 32);
		contentPane.add(lblAbout);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(156, 181, 97, 25);
		contentPane.add(btnOk);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(afterAbout.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 432, 253);
		contentPane.add(label);
	}
}
