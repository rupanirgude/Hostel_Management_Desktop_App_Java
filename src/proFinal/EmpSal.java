package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EmpSal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpSal frame = new EmpSal();
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
	public EmpSal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalaryPay sp=new SalaryPay();
				sp.setVisible(true);
				setVisible(false);
			}
		});
		btnPay.setBounds(279, 160, 97, 32);
		contentPane.add(btnPay);
		
		JLabel lblPay = new JLabel("Pay");
		lblPay.setIcon(new ImageIcon(EmpSal.class.getResource("/images/credit-card(1).png")));
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPay.setBounds(80, 155, 127, 32);
		contentPane.add(lblPay);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setIcon(new ImageIcon(EmpSal.class.getResource("/images/search.png")));
		lblShow.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblShow.setBounds(80, 262, 127, 32);
		contentPane.add(lblShow);
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSalary vs=new ViewSalary();
				vs.setVisible(true);
			}
		});
		btnShow.setBounds(279, 262, 97, 32);
		contentPane.add(btnShow);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(EmpSal.class.getResource("/images/house.png")));
		button.setBounds(12, 13, 51, 49);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterEmployee ae=new AfterEmployee();
				ae.show();
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(EmpSal.class.getResource("/images/back.png")));
		button_1.setBounds(12, 404, 51, 49);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EmpSal.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 486, 466);
		contentPane.add(label);
	}

}
