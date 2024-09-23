package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AfterFeesButton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterFeesButton frame = new AfterFeesButton();
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
	public AfterFeesButton() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AfterFeesButton.class.getResource("/images/debit-card(1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fupdate ap=new fupdate();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(244, 159, 65, 59);
		contentPane.add(btnNewButton);
		
		JButton btnShow = new JButton("");
		btnShow.setIcon(new ImageIcon(AfterFeesButton.class.getResource("/images/search.png")));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterFeesShow afs=new AfterFeesShow();
				afs.show();
				setVisible(false);
			}
		});
		btnShow.setBounds(244, 268, 65, 59);
		contentPane.add(btnShow);
		
		JLabel lblPay = new JLabel("PAY");
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPay.setBounds(350, 180, 38, 16);
		contentPane.add(lblPay);
		
		JLabel lblShow = new JLabel("SHOW");
		lblShow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblShow.setBounds(343, 294, 56, 16);
		contentPane.add(lblShow);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterFeesButton.class.getResource("/images/house.png")));
		btnNewButton_1.setBounds(12, 13, 56, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AfterFeesButton.class.getResource("/images/back.png")));
		btnNewButton_2.setBounds(12, 384, 56, 54);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterFeesButton.class.getResource("/images/ad.jpg")));
		lblNewLabel.setBounds(0, 0, 644, 466);
		contentPane.add(lblNewLabel);
	}
}
