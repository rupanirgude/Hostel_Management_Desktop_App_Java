package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class AfterEmployee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterEmployee frame = new AfterEmployee();
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
	public AfterEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdd.setBounds(48, 141, 56, 25);
		contentPane.add(lblAdd);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdate.setBounds(214, 141, 69, 25);
		contentPane.add(lblUpdate);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(401, 141, 56, 25);
		contentPane.add(lblSalary);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/user.png")));
		btnNewButton.setBounds(35, 179, 82, 82);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/contract.png")));
		btnNewButton_1.setBounds(215, 179, 82, 82);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/hand.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpSal es=new EmpSal();
				es.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(395, 179, 82, 82);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/house.png")));
		button.setBounds(12, 13, 56, 57);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/back.png")));
		button_1.setBounds(12, 399, 56, 57);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterEmployee.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 522, 469);
		contentPane.add(label);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterEmpUpdate aeu=new AfterEmpUpdate();
				aeu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterEmpAdd aeA=new AfterEmpAdd();
				aeA.setVisible(true);
				setVisible(false);
			}
		});
	}
}
